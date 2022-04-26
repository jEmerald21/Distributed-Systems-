package grpc.Joanna.GUIApplication;

//UI imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

//general gRPC imports
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.Joanna.PatientDataService.DoctorNote;
import grpc.Joanna.PatientDataService.LabResult;
//gRPC imports for the service used
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc;
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceBlockingStub;
import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceStub;
import grpc.Joanna.PatientDataService.Prescription;

@SuppressWarnings("serial")
public class PatientDataPanelUI extends JPanel implements ActionListener {

	// private fields / variables
	private JTextField doctorID;
	private JTextField patientID;
	private JFormattedTextField date;
	private ServiceDiscoveryInfo discoveryInfo;
	private Font headerFont;
	JTextArea console;
	JTextArea prescriptionText;
	JTextArea doctorNotesText;
	private JButton submitPrescription;
	private JButton submitDoctorNotes; 
	
	// constructor
	public PatientDataPanelUI(ServiceDiscoveryInfo discoveryInfo) {
		super();

		this.discoveryInfo = discoveryInfo; // service address info
		this.buildUI(); // UI creation
		
		// implementation of ActionListener interface for reaction to submit buttons
		public void actionPerformed (ActionEvent ae){
	        if(ae.getSource() == this.submitPrescription){
	        	print("Prescription Submission started ...");
	        	submitPrescription();
	        }
	        else if(ae.getSource() == this.submitDoctorNotes){
	        	print("Doctor Notes Submission started ...");
	        	submitDoctorNote();
	        }
	        // todo more ...
		}
		
/////////////////////////////////////////////////////////////////////////////////
// service client & submission of prescription
public void submitPrescription() {

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

		Prescription request = Prescription.newBuilder()
		.setDoctorID(this.doctorID.getText())
		.setPatientID(this.patientID.getText())
		.setPrescriptionText(this.prescriptionText.getText())
		.build();

		grpc.Joanna.PatientDataService.RequestResult response = blockingStub.addPrescription(request);

		print("Prescription Submission successful? " + response.getSuccess() + ". " + response.getNonSuccessHint());
		this.prescriptionText.setText("");
	}
}

		
//service client & submission of lab result
	public void submitDoctorNote() {
		
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
					.setNotes(this.doctorNotesText.getText())
					//.setDiagnosis(host)
					//.setRecommendations(host)
					.build();

			grpc.Joanna.PatientDataService.RequestResult response = blockingStub.addDoctorNotes(request);

			print("Doctor Notes Submission successful? " + response.getSuccess() + ". " + response.getNonSuccessHint());
			this.doctorNotesText.setText("");
		}
}
	
/////////////////////////////////////////////////////////////////////////////////
// UI creation
private void buildUI() {
	this.headerFont = new Font("Tahoma", Font.PLAIN, 20);
	Font formFont = new Font("Tahoma", Font.PLAIN, 15);

	BoxLayout topdownBox = new BoxLayout(this, BoxLayout.Y_AXIS);
	this.setLayout(topdownBox);
	
	////////////////////////////////////////////
	// globals header
	this.add(UITools.CreateSectionDivder("Globals:", new Color(120,120,120)));
	// form
	JPanel globalsFormSection = new JPanel();
	BoxLayout globalsLayout = new BoxLayout(globalsFormSection, BoxLayout.X_AXIS);
	globalsFormSection.setBackground(new Color(150,150,150));
	globalsFormSection.setLayout(globalsLayout);	
	
		////////////////////////////////////////////
		
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
        
        // add section to this panel
        this.add(globalsFormSection);
        this.add(UITools.CreateSpacerBar(20, new Color(150,150,150)));
        
		////////////////////////////////////////////
        // add prescription section
		// header
        this.add(UITools.CreateSectionDivder("Add Prescription:", new Color(50,133,203)));
		// form section
        JPanel prescriptionSection = new JPanel();
        prescriptionSection.setBackground(new Color(80,163,233));
        JLabel prescriptionHeader = new JLabel("Add Prescription:  ");
        prescriptionHeader.setFont(headerFont);
        prescriptionHeader.setHorizontalAlignment(SwingConstants.LEFT);
        prescriptionHeader.setVerticalAlignment(SwingConstants.TOP);
        prescriptionSection.add(prescriptionHeader);
        
        // prescription label
        JLabel prescriptionLabel = new JLabel("Prescription:");
        prescriptionLabel.setFont(formFont);
        prescriptionSection.add(prescriptionLabel);
        JTextArea diagnosisText = new JTextArea("prescription...");
        diagnosisText.setFont(formFont);
        diagnosisText.setRows(3);
        diagnosisText.setColumns(20);
        diagnosisText.setAlignmentY(CENTER_ALIGNMENT);
        prescriptionSection.add(diagnosisText);
        
        // submit prescription
        JButton submitPrescription = new JButton("Submit Prescription");
        prescriptionSection.add(submitPrescription);
        
        // add section to service UI panel
        this.add(prescriptionSection);
        
		////////////////////////////////////////////
        // add Note section
		// header
        JPanel noteSection = new JPanel();
        noteSection.setBackground(new Color(150,150,213));
        JLabel noteHeader = new JLabel("Add note:  ");
        noteHeader.setFont(headerFont);
        noteHeader.setHorizontalAlignment(SwingConstants.LEFT);
        noteHeader.setVerticalAlignment(SwingConstants.TOP);
        noteSection.add(noteHeader);
        
        // diagnosis
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        diagnosisLabel.setFont(formFont);
        noteSection.add(diagnosisLabel);
        JTextArea notesDiagnosisText = new JTextArea("diagnosis");
        notesDiagnosisText.setFont(formFont);
        notesDiagnosisText.setRows(3);
        notesDiagnosisText.setColumns(8);
        notesDiagnosisText.setAlignmentY(CENTER_ALIGNMENT);
        noteSection.add(notesDiagnosisText);
        
        // recommendations
        JLabel recommendationsLabel = new JLabel("Recommendations:");
        recommendationsLabel.setFont(formFont);
        noteSection.add(recommendationsLabel);
        JTextArea recommendationsText = new JTextArea("recommendations");
        recommendationsText.setFont(formFont);
        recommendationsText.setRows(3);
        recommendationsText.setColumns(8);
        noteSection.add(recommendationsText);
        
        // notes
        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setFont(formFont);
        noteSection.add(notesLabel);
        JTextArea notesText = new JTextArea("notes");
        notesText.setFont(formFont);
        notesText.setRows(3);
        notesText.setColumns(8);
        noteSection.add(notesText);
        
        // submit prescription
        this.submitPrescription = new JButton("Submit Prescription");
        this.submitPrescription.addActionListener(this); // tells the button to call the action performed method on this class
        // add section to service UI panel
        this.add(prescriptionSection);
        this.add(UITools.CreateSpacerBar(30, new Color(80,163,233)));
     

        
		////////////////////////////////////////////
        // get-prescription section
		// header
        this.add(UITools.CreateSectionDivder("List Current Prescriptions:", new Color(195,178,158)));
        // form section
        JPanel getPrescriptionSection = new JPanel();
        getPrescriptionSection.setBackground(new Color(80,163,233));
 
		//Using JTable to display the services to track for discovery and their status
        // Preparing the column names of the JTable
        String[] columnNames = { "Date", "Prescripton", "PatientID", "DoctorID" };
        
	    // Preparing the data to be displayed inside the JTable
        String[][] data = {
            { "-", "-", "-", "-" },
            { "-", "-", "-", "-" },
            { "-", "-", "-", "-" },
            { "-", "-", "-", "-" },
        };
 
        // creation and configuration of JTable
        JTable prescriptionsTable = new JTable(data, columnNames);
        prescriptionsTable.getShowHorizontalLines(); // table styling
        prescriptionsTable.setBackground(new Color(253,235,211)); // table styling
        prescriptionsTable.getTableHeader().setOpaque(false); // column header styling
        prescriptionsTable.getTableHeader().setBackground(new Color(192,179,160)); // column header styling
        prescriptionsTable.setDefaultEditor(Object.class, null); // disable cell editing
 
        // adding it to a JScrollPane in case this is needed.
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(800, 450)); // resizing to fill use more of the available window space
        scrollPane.setViewportView(prescriptionsTable);
        this.add(scrollPane);
        
        this.add(UITools.CreateSpacerBar(30, new Color(50,133,203)));
           
        
        // add Note section
		// header
        this.add(UITools.CreateSectionDivder("Add a note:", new Color(120,120,193)));
        // form
        JPanel noteSection = new JPanel();
        noteSection.setBackground(new Color(150,150,213));
        JLabel diagnosisLabel = new JLabel("Diagnosis:");
        diagnosisLabel.setFont(formFont);
        noteSection.add(diagnosisLabel);
        JTextArea notesDiagnosisText = new JTextArea("diagnosis");
        notesDiagnosisText.setFont(formFont);
        notesDiagnosisText.setRows(3);
        notesDiagnosisText.setColumns(8);
        notesDiagnosisText.setAlignmentY(CENTER_ALIGNMENT);
        noteSection.add(notesDiagnosisText);
     
     // recommendations
        JLabel recommendationsLabel = new JLabel("Recommendations:");
        recommendationsLabel.setFont(formFont);
        noteSection.add(recommendationsLabel);
        JTextArea recommendationsText = new JTextArea("recommendations");
        recommendationsText.setFont(formFont);
        recommendationsText.setRows(3);
        recommendationsText.setColumns(8);
        noteSection.add(recommendationsText);
        // notes
        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setFont(formFont);
        noteSection.add(notesLabel);
        this.doctorNotesText = new JTextArea("notes");
        this.doctorNotesText.setFont(formFont);
        this.doctorNotesText.setRows(3);
        this.doctorNotesText.setColumns(8);
        noteSection.add(this.doctorNotesText);
        // submit prescription
        this.submitDoctorNotes = new JButton("Submit notes");
        this.submitDoctorNotes.addActionListener(this); // tells the button to call the action performed method on this class
        noteSection.add(submitDoctorNotes);
        // add section to service UI panel
        this.add(noteSection);
        this.add(UITools.CreateSpacerBar(30, new Color(150,150,213)));
	 
	
	public void PatientDataPanelUI2() {
		
		//?
       
        
////////////////////////////////////////////
	// add console section
	this.add(UITools.CreateSectionDivder("Console:", new Color(180,180,180)));
	this.console = UITools.CreateAndAddConsoleWindow(this, "");
	}
	
	
	// add text to the in-app simulated console and also to the main console
	public void print(String text) {
	this.console.append(text + "\n");
	System.out.println("[PatientDataPanelUI]: " + text);
	}

	}
	

}
