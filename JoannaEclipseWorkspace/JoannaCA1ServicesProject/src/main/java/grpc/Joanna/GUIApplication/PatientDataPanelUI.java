package grpc.Joanna.GUIApplication;

import java.awt.BorderLayout;
// UI imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

// general gRPC imports
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import grpc.Joanna.PatientDataService.DoctorNote;
import grpc.Joanna.PatientDataService.GetPrescriptionInfo;
import grpc.Joanna.PatientDataService.LabResult;
// gRPC imports for the service used
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc;
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceBlockingStub;
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceFutureStub;
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceStub;
import grpc.Joanna.PatientDataService.Prescription;
import grpc.Joanna.PatientDataService.RequestResult;

// UI to interact with the Patient Data Service
@SuppressWarnings("serial")
public class PatientDataPanelUI extends JPanel implements ActionListener {

	// private fields / variables
	private JTextField doctorID;
	private JTextField patientID;
	private JFormattedTextField date;
	private ServiceAddressRegistry serviceAddressRegistry;
	private Font headerFont;
	JTextArea consoleTextfield;
	JTextArea prescriptionTextfield;
	JTextArea doctorNotesTextfield;
	JTable prescriptionsTable;
	JTable labResultsTable;
	private JButton submitPrescriptionButton;
	private JButton submitDoctorNotesButton;
	private JButton submitLabResultsButton;
	private JButton getPrescriptionsButton;
	
	/////////////////////////////////////////////////////////////////////////////////
	// constructor
	public PatientDataPanelUI(ServiceAddressRegistry addressInfo) {
		super(); // calling the constructor of the parent class JPanel
		this.serviceAddressRegistry = addressInfo; // holds the known service addresses
		this.buildUI(); // UI creation
	}

	/////////////////////////////////////////////////////////////////////////////////
	// implementation of ActionListener interface for reaction to various submit buttons in the UI
	public void actionPerformed (ActionEvent eventDetails){
        if(eventDetails.getSource() == this.submitPrescriptionButton){
        	print("Prescription Submission started ...");
        	submitPrescription();
        }
        else if(eventDetails.getSource() == this.submitDoctorNotesButton){
        	print("Doctor Notes Submission started ...");
        	submitDoctorNote();
        } else if(eventDetails.getSource() == this.getPrescriptionsButton){
        	print("Doctor Notes Submission started ...");
        	this.refreshPrescriptionsList();
        } else if(eventDetails.getSource() == this.submitLabResultsButton){
	    	print("Lab Results Submission started ...");
	    	this.submitLabResults();
	    }
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// service client & submission of prescription. Unary gRPC messaging
	private void submitPrescription() {
		
		// checking if we know the address of the service
		ServiceAddress address = serviceAddressRegistry.getPatientDataInfo();
		if(address.available == false) {
			print("... ERROR: PatientData Service address is not known! Aborting!");
		} 
		else {
			// preparing the communication to the service server
			String host = address.hostAddress;
			int port = address.port;
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();
			// using gRPC "stubs" that were generated from the proto files using the proto compiler
			PatientDataServiceBlockingStub blockingRPCStub = PatientDataServiceGrpc.newBlockingStub(channel);			
			Prescription request = Prescription.newBuilder()
											.setDoctorID(this.doctorID.getText())
											.setPatientID(this.patientID.getText())
											.setPrescriptionText(this.prescriptionTextfield.getText())
											.build();

			grpc.Joanna.PatientDataService.RequestResult response = blockingRPCStub.addPrescription(request);
			
			print("Prescription Submission successful? " + response.getSuccess() + ". " + response.getNonSuccessHint());
			this.prescriptionTextfield.setText("");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// service client & submission of lab result. Unary gRPC messaging
	private void submitDoctorNote() {
		
		// checking if we know the address of the service
		ServiceAddress address = serviceAddressRegistry.getPatientDataInfo();
		if(address.available == false) {
			print("... ERROR: PatientData Service address is not known! Aborting!");
		} 
		else {
			// preparing the communication to the service server
			String host = address.hostAddress;
			int port = address.port;
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();
			// using gRPC "stubs" that were generated from the proto files using the proto compiler
			PatientDataServiceBlockingStub blockingStub = PatientDataServiceGrpc.newBlockingStub(channel);
			PatientDataServiceStub asyncStub = PatientDataServiceGrpc.newStub(channel);
			
			DoctorNote request = DoctorNote.newBuilder()
											.setDoctorID(this.doctorID.getText())
											.setPatientID(this.patientID.getText())
											.setNotes(this.doctorNotesTextfield.getText())
											.build();

			grpc.Joanna.PatientDataService.RequestResult response = blockingStub.addDoctorNotes(request);
			
			print("Doctor Notes Submission successful? " + response.getSuccess() + ". " + response.getNonSuccessHint());
			this.doctorNotesTextfield.setText("");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// service client & submission to retrieve the list of existing prescriptions from the server via server-side streaming
	private void refreshPrescriptionsList() {
		
		// checking if we know the address of the service
		ServiceAddress address = serviceAddressRegistry.getPatientDataInfo();
		if(address.available == false) {
			print("... ERROR: PatientData Service address is not known! Aborting!");
		} 
		else {
			// preparing the communication to the service server
			String host = address.hostAddress;
			int port = address.port;
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();
			// using gRPC "stubs" that were generated from the proto files using the proto compiler
			PatientDataServiceBlockingStub blockingStub = PatientDataServiceGrpc.newBlockingStub(channel);
			PatientDataServiceStub asyncStub = PatientDataServiceGrpc.newStub(channel);
			
			
			GetPrescriptionInfo request = GetPrescriptionInfo.newBuilder()
										.setPatientID(this.patientID.getText())
										.build();
			
			// handling server side streaming
			// implementation reference taken from here: https://www.baeldung.com/java-grpc-streaming
			int rowindex = 0;
		    Iterator<Prescription> prescriptions;
		    try {
		        print("Requesting prescriptions list ...");
		        prescriptions = blockingStub.getPrescriptions(request);
		        for (int i = 1; prescriptions.hasNext(); i++) {
		            Prescription prescription = prescriptions.next();
		            // set row data
		            TableModel tableContent2 = prescriptionsTable.getModel();
//					tableContent2.setValueAt(prescription.getDate(), 			rowindex, 0);
					tableContent2.setValueAt(prescription.getPrescriptionText(), rowindex, 1);
					tableContent2.setValueAt(prescription.getPatientID(), 		rowindex, 2);
					tableContent2.setValueAt(prescription.getDoctorID(), 		rowindex, 3);
		            print("==> found" + prescription.getPrescriptionText() );
		            rowindex++;
		        }
		    } catch (Exception e) {
		        print("RPC failure: " + e.toString()); 
		    }			
			print("Getting prescriptions completed");
		}
	}
	
	// client side streaming of the list of entered lab results
	private void submitLabResults() {
		// checking if we know the address of the service
		ServiceAddress address = serviceAddressRegistry.getPatientDataInfo();
		if(address.available == false) {
			print("... ERROR: PatientData Service address is not known! Aborting!");
		} 
		else {
			// preparing the communication to the service server
			String host = address.hostAddress;
			int port = address.port;
			ManagedChannel channel = ManagedChannelBuilder
					.forAddress(host, port)
					.usePlaintext()
					.build();
			
			// client side streaming
			PatientDataServiceStub rpcStub = PatientDataServiceGrpc.newStub(channel);
		    StreamObserver<RequestResult> responseObserver = new StreamObserver<RequestResult>() {
		        @Override
		        public void onNext(RequestResult result) {
		            print("  .... Server received the lab result data.");
		        }

		        @Override
		        public void onCompleted() {
		            print("Completed sending Lab Results");
		        }

				@Override
				public void onError(Throwable t) {
					print("Error in sending Lab Result: " + t.getMessage());
					
				}
		    };
		    
		    StreamObserver<LabResult> requestObserver = rpcStub.addLabResults(responseObserver);
		    try {
		    	// get the table content
	            TableModel resultsTable = this.labResultsTable.getModel();
	            // iterate through the table row by row
	            for(int i = 0; i < resultsTable.getRowCount(); i++) {
	            	// retrieve the data from the row
	            	String labType = resultsTable.getValueAt(i, 0).toString();
	            	String labResult = resultsTable.getValueAt(i, 1).toString();
	            	String labDiagnosis= resultsTable.getValueAt(i, 2).toString();
	            	// only accept lines that have at least one cell with content
	            	if(labType.isEmpty() == false || labResult.isEmpty() == false || labDiagnosis.isEmpty() == false) {
	            		LabResult resultMsg = LabResult.newBuilder()
	            							 .setLabType(labType)
	            							 .setResults(labResult)
	            							 .setDiagnosis(labDiagnosis)
	            							 .build();
	            		requestObserver.onNext(resultMsg);
	            		print("Sending Lab Result: " + labType + ", " + labResult);
	            	}
		        }
		    } catch (RuntimeException e) {
		        requestObserver.onError(e);
		        print("Error during sening labs results: " + e.getMessage());
		        throw e;
		    }
			requestObserver.onCompleted();		    			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// UI creation of the tab / panel
	private void buildUI() {
		this.setBackground(new Color(80,163,233));
		this.headerFont = new Font("Tahoma", Font.PLAIN, 20);
		Font formFont = new Font("Tahoma", Font.PLAIN, 15);
		
		// layout usage of horizontal blocks from top to down
		BoxLayout topdownBox = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(topdownBox);
		
		////////////////////////////////////////////
		// global input fields needed for many gRPC calls
		this.add(UITools.CreateSectionDivder("Globals:", new Color(50,133,203)));
		// section header
		JPanel globalsFormSection = new JPanel();
		BoxLayout globalsLayout = new BoxLayout(globalsFormSection, BoxLayout.X_AXIS);
		globalsFormSection.setBackground(new Color(80,163,233));
		globalsFormSection.setLayout(globalsLayout);
        // doctor ID
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        doctorIDLabel.setFont(formFont);
        globalsFormSection.add(doctorIDLabel);
        doctorID = new JTextField("SomeDoctorID");
        doctorID.setFont(formFont);
        globalsFormSection.add(doctorID);
        // patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setFont(formFont);
        globalsFormSection.add(patientIDLabel);
        patientID = new JTextField("SomePatientID");
        patientID.setFont(formFont);
        globalsFormSection.add(patientID);
        // date
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(formFont);
        globalsFormSection.add(dateLabel);
        JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        date.setValue(new java.util.Date()); // today
        date.setFont(formFont);
        globalsFormSection.add(date);
        // add section form to this panel
        this.add(globalsFormSection);
        this.add(UITools.CreateSpacerBar(10, new Color(80,163,233)));
        
		////////////////////////////////////////////
        // add-prescription section
		// header
		this.add(UITools.CreateSectionDivder("Add Prescription:", new Color(50,133,203)));
		// form section
        JPanel prescriptionSection = new JPanel();
        prescriptionSection.setBackground(new Color(80,163,233));
        // prescription label
        JLabel prescriptionLabel = new JLabel("Prescription text:");
        prescriptionLabel.setFont(formFont);
        prescriptionSection.add(prescriptionLabel);
        this.prescriptionTextfield = new JTextArea("prescription...");
        prescriptionTextfield.setFont(formFont);
        prescriptionTextfield.setRows(3);
        prescriptionTextfield.setColumns(40);
        prescriptionTextfield.setAlignmentY(CENTER_ALIGNMENT);
        prescriptionSection.add(prescriptionTextfield);
        // submit prescription
        this.submitPrescriptionButton = new JButton("Submit Prescription");
        this.submitPrescriptionButton.addActionListener(this); // tells the button to call the action performed method on this class
        prescriptionSection.add(submitPrescriptionButton);
        // add section to service UI panel
        this.add(prescriptionSection);
        this.add(UITools.CreateSpacerBar(10, new Color(80,163,233)));
        
		////////////////////////////////////////////
        // add Note section
		// header
        this.add(UITools.CreateSectionDivder("Add a Doctor Note:",  new Color(50,133,203)));
        // form
        int textFieldWidth = 14; // used further down to set the width of text areas
        int textFieldHeight = 4; // used further down to set the height of text areas
        JPanel noteSection = new JPanel();
        noteSection.setBackground(new Color(80,163,233));
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        diagnosisLabel.setFont(formFont);
        noteSection.add(diagnosisLabel);
        JTextArea notesDiagnosisText = new JTextArea("diagnosis");
        notesDiagnosisText.setFont(formFont);
        notesDiagnosisText.setRows(textFieldHeight);
        notesDiagnosisText.setColumns(textFieldWidth);
        notesDiagnosisText.setAlignmentY(CENTER_ALIGNMENT);
        noteSection.add(notesDiagnosisText);
        // recommendations
        JLabel recommendationsLabel = new JLabel("Recommendations:");
        recommendationsLabel.setFont(formFont);
        noteSection.add(recommendationsLabel);
        JTextArea recommendationsText = new JTextArea("recommendations");
        recommendationsText.setFont(formFont);
        recommendationsText.setRows(textFieldHeight);
        recommendationsText.setColumns(textFieldWidth);
        noteSection.add(recommendationsText);
        // notes
        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setFont(formFont);
        noteSection.add(notesLabel);
        this.doctorNotesTextfield = new JTextArea("notes");
        this.doctorNotesTextfield.setFont(formFont);
        this.doctorNotesTextfield.setRows(textFieldHeight);
        this.doctorNotesTextfield.setColumns(textFieldWidth);
        noteSection.add(this.doctorNotesTextfield);
        // submit prescription
        this.submitDoctorNotesButton = new JButton("Submit notes");
        this.submitDoctorNotesButton.addActionListener(this); // tells the button to call the action performed method on this class
        noteSection.add(submitDoctorNotesButton);
        // add section to service UI panel
        this.add(noteSection);
        this.add(UITools.CreateSpacerBar(10, new Color(80,163,233)));
        
        
		////////////////////////////////////////////
        // Register lab results
		// header
        this.add(UITools.CreateSectionDivder("Submit Lab Results:", new Color(50,133,203)));
        // form section
        JPanel addLabResultsSection = new JPanel();
        addLabResultsSection.setBackground(new Color(80,163,233));
        
		//Using JTable to display the services to track for discovery and their status
        // Preparing the column names of the JTable
        String[] columnNamesLabResults = { "Type", "Results", "Diagnosis"};
        
	    // Preparing the row data for displaying inside the JTable
        String[][] dataLabResults = {
            { "", "", "" },
            { "", "", "" },
            { "", "", "" },
        };
 
        // creation and configuration of JTable
        labResultsTable = new JTable(dataLabResults, columnNamesLabResults);
        labResultsTable.getShowHorizontalLines(); // table styling
        labResultsTable.setBackground(new Color(153,190,255)); // table styling
        labResultsTable.getTableHeader().setOpaque(false); // column header styling
        labResultsTable.getTableHeader().setBackground(new Color(192,179,160)); // column header styling
       // prescriptionsTable.setDefaultEditor(Object.class, null); // disable cell editing
 
        // adding it to a JScrollPane in case this is needed.
        JScrollPane scrollPaneLabResults = new JScrollPane();
        scrollPaneLabResults.setPreferredSize(new Dimension(800, 350)); // resizing to fill use more of the available window space
        scrollPaneLabResults.setViewportView(labResultsTable);
        this.add(scrollPaneLabResults, BorderLayout.CENTER);
        // submit lab results via client side streaming
        this.submitLabResultsButton = new JButton("Submit New Lab Results");
        this.submitLabResultsButton.addActionListener(this); // tells the button to call the action performed method on this class
        this.add(submitLabResultsButton);
        this.add(UITools.CreateSpacerBar(10, new Color(80,163,233)));
        
        /////////////////////////////////////////////////////////////////////////
        // get-prescription section
		// header
        this.add(UITools.CreateSectionDivder("Retrieve ExistingPrescriptions:", new Color(50,133,203)));
        // form section
        JPanel getPrescriptionSection = new JPanel();
        getPrescriptionSection.setBackground(new Color(80,163,233));
        
        // add "refresh" button to get prescriptions from the server
        this.getPrescriptionsButton = new JButton("Refresh 'Prescriptions History'");
        this.getPrescriptionsButton.addActionListener(this); // tells the button to call the action performed method on this class
        this.add(getPrescriptionsButton);
 
		// Using JTable to display the services to track for discovery and their status
        // Preparing the column names of the JTable
        String[] columnNames = { "Date", "Prescripton", "PatientID", "DoctorID" };
        
	    // Preparing the row data for displaying inside the JTable
        String[][] data = {
            { "", "", "", "" },
            { "", "", "", "" },
            { "", "", "", "" },
            { "", "", "", "" },
            { "", "", "", "" }
        };
 
        // creation and configuration of JTable
        prescriptionsTable = new JTable(data, columnNames);
        prescriptionsTable.getShowHorizontalLines(); // table styling
        prescriptionsTable.setBackground(new Color(153,190,255)); // table styling
        prescriptionsTable.getTableHeader().setOpaque(false); // column header styling
        prescriptionsTable.getTableHeader().setBackground(new Color(192,179,160)); // column header styling
        prescriptionsTable.setDefaultEditor(Object.class, null); // disable cell editing
 
        // adding it to a JScrollPane in case this is needed.
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(800, 350)); // resizing to fill use more of the available window space
        scrollPane.setViewportView(prescriptionsTable);
        this.add(scrollPane);
        this.add(UITools.CreateSpacerBar(10, new Color(80,163,233)));


		/////////////////////////////////////////////////////////////////////////
        // add console section
        this.add(UITools.CreateSectionDivder("Console:",  new Color(50,133,203)));
		this.consoleTextfield = UITools.CreateAndAddConsoleWindow(this, "");
		//this.add(UITools.CreateSectionDivder(" ", new Color(80,163,233)));
	}
	
	
	// add text to the in-app simulated console and also print to the main console
	public void print(String text) {
		this.consoleTextfield.append(text + "\n");
		this.consoleTextfield.setCaretPosition(this.consoleTextfield.getText().length()); // scroll to bottom
		System.out.println("[PatientDataPanelUI]: " + text);
	}
}
