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

@SuppressWarnings("serial")
public class PatientDataPanelUI extends JPanel implements ActionListener {

	// private fields / variables
	private JTextField doctorID;
	private JTextField patientID;
	private JFormattedTextField date;
	private ServiceAddressRegistry discoveryInfo;
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
		super();
		this.discoveryInfo = addressInfo; // service address info
		this.buildUI(); // UI creation
	}

	/////////////////////////////////////////////////////////////////////////////////
	// implementation of ActionListener interface for reaction to submit buttons
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
        // todo more ...
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// service client & submission of prescription
	private void submitPrescription() {
		
		// checking if we know the address of the service
		ServiceAddress address = discoveryInfo.getPatientDataInfo();
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
			//PatientDataServiceStub asyncStub = PatientDataServiceGrpc.newStub(channel);
			
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
	// service client & submission of lab result
	private void submitDoctorNote() {
		
		// checking if we know the address of the service
		ServiceAddress address = discoveryInfo.getPatientDataInfo();
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
											//.setDiagnosis(host)
											//.setRecommendations(host)
											.build();

			grpc.Joanna.PatientDataService.RequestResult response = blockingStub.addDoctorNotes(request);
			
			print("Doctor Notes Submission successful? " + response.getSuccess() + ". " + response.getNonSuccessHint());
			this.doctorNotesTextfield.setText("");
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// service client & submission to retrieve the list of existing prescriptions from ther server
	private void refreshPrescriptionsList() {
		
		// checking if we know the address of the service
		ServiceAddress address = discoveryInfo.getPatientDataInfo();
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
	
	
	private void submitLabResults() {
		// checking if we know the address of the service
		ServiceAddress address = discoveryInfo.getPatientDataInfo();
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
			
//			// client side streaming
//			//PatientDataServiceBlockingStub blockingRPCStub = PatientDataServiceGrpc.newBlockingStub(channel);
//			PatientDataServiceFutureStub asyncRPCStub = PatientDataServiceGrpc.newFutureStub(channel);
//		    StreamObserver<RequestResult> responseObserver = new StreamObserver<RequestResult>() {
//		        @Override
//		        public void onNext(RequestResult result) {
//		            print("");
//		        }
//
//		        @Override
//		        public void onCompleted() {
//		            print("Finished clientSideStreamingGetStatisticsOfStocks");
//		        }
//
//				@Override
//				public void onError(Throwable t) {
//					// TODO Auto-generated method stub
//					
//				}

		        // Override OnError ...
//		    };
//		    
//		    StreamObserver<LabResult> requestObserver = asyncRPCStub.AddLabResults(responseObserver);
//		    try {
////		        for (LabResult stock : stocks) {
////		            print("REQUEST: {0}, {1}", stock.getTickerSymbol(), stock.getCompanyName());
////		            requestObserver.onNext(stock);
////		        }
//		    } catch (RuntimeException e) {
//		        requestObserver.onError(e);
//		        throw e;
			
//		    }
//			requestObserver.onCompleted();		    			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// UI creation
	private void buildUI() {
		this.setBackground(new Color(80,163,233));
		this.headerFont = new Font("Tahoma", Font.PLAIN, 20);
		Font formFont = new Font("Tahoma", Font.PLAIN, 15);
		
		BoxLayout topdownBox = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(topdownBox);
		
		////////////////////////////////////////////
		// global input form
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
        
		////////////////////////////////////////////
        // get-prescription section
		// header
        this.add(UITools.CreateSectionDivder("Retrieve ExistingPrescriptions:", new Color(50,133,203)));
        // form section
        JPanel getPrescriptionSection = new JPanel();
        getPrescriptionSection.setBackground(new Color(80,163,233));
        
        // add "refresh" button to get prescriptions from the server
        // submit prescription
        this.getPrescriptionsButton = new JButton("Refresh 'Prescriptions History'");
        this.getPrescriptionsButton.addActionListener(this); // tells the button to call the action performed method on this class
        this.add(getPrescriptionsButton);
 
		//Using JTable to display the services to track for discovery and their status
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
           


		////////////////////////////////////////////
        // add console section
        this.add(UITools.CreateSectionDivder("Console:",  new Color(50,133,203)));
		this.consoleTextfield = UITools.CreateAndAddConsoleWindow(this, "");
		this.add(UITools.CreateSectionDivder(" ", new Color(80,163,233)));
		//this.add(UITools.CreateSpacerBar(10, new Color(150,150,213)));
	}
	
	
	// add text to the in-app simulated console and also to the main console
	public void print(String text) {
		this.consoleTextfield.append(text + "\n");
		this.consoleTextfield.setCaretPosition(this.consoleTextfield.getText().length());
		System.out.println("[PatientDataPanelUI]: " + text);
	}
}
