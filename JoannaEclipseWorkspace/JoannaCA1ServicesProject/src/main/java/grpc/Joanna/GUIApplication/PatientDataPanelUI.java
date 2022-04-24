package grpc.Joanna.GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

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

@SuppressWarnings("serial")
public class PatientDataPanelUI extends JPanel {

	private JTextField doctorID;
	private JTextField patientID;
	private JFormattedTextField date;
	
	public PatientDataPanelUI() {
		super();

		Font headerFont = new Font("Tahoma", Font.PLAIN, 20);
		Font formFont = new Font("Tahoma", Font.PLAIN, 15);
		
		BoxLayout topdownBox = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(topdownBox);
		
		////////////////////////////////////////////
		// globals
		JPanel globalsSection = new JPanel();
		BoxLayout globalsLayout = new BoxLayout(globalsSection, BoxLayout.X_AXIS);
		globalsSection.setBackground(new Color(150,150,150));
		globalsSection.setLayout(globalsLayout);
		// header
        JLabel globalsHeader = new JLabel("Global Settings:  ");
        globalsHeader.setFont(headerFont);
        globalsSection.add(globalsHeader);
        // doctor ID
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        doctorIDLabel.setFont(formFont);
        globalsSection.add(doctorIDLabel);
        doctorID = new JTextField("SomeDoctorID");
        doctorID.setFont(formFont);
        globalsSection.add(doctorID);
        // patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setFont(formFont);
        globalsSection.add(patientIDLabel);
        patientID = new JTextField("SomePatientID");
        patientID.setFont(formFont);
        globalsSection.add(patientID);
        // date
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(formFont);
        globalsSection.add(dateLabel);
        JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        date.setValue(new java.util.Date()); // today
        date.setFont(formFont);
        globalsSection.add(date);
        // add section to this panel
        this.add(globalsSection);
        
		////////////////////////////////////////////
        // add prescription section
		// header
        JPanel prescriptionSection = new JPanel();
        prescriptionSection.setBackground(new Color(80,163,233));
        JLabel prescriptionHeader = new JLabel("Add Prescription:  ");
        prescriptionHeader.setFont(headerFont);
        prescriptionHeader.setHorizontalAlignment(SwingConstants.LEFT);
        prescriptionHeader.setVerticalAlignment(SwingConstants.TOP);
        prescriptionSection.add(prescriptionHeader);
        // prescription
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
        JButton submitlabesult = new JButton("Submit notes");
        noteSection.add(submitlabesult);
        // add section to service UI panel
        this.add(noteSection);


        
		////////////////////////////////////////////
		// dummy test TODO remove this
        for(int i = 0; i < 10; i++) {
			JPanel dummySection = new JPanel();
			BoxLayout precriptionLayout = new BoxLayout(dummySection, BoxLayout.X_AXIS);
			globalsSection.setLayout(globalsLayout);
	        JLabel dummyHeader = new JLabel("Section " + i);
	        dummyHeader.setFont(headerFont);
	        dummySection.add(dummyHeader);
	        // doctor ID
	        JLabel label2 = new JLabel("Label:");
	        label2.setFont(formFont);
	        dummySection.add(label2);
	        JTextField text1 = new JTextField("BlahText");
	        text1.setFont(formFont);
	        dummySection.add(text1);
	        // patient ID
	        JLabel patientIDLabel2 = new JLabel("Label2 ID:");
	        patientIDLabel2.setFont(formFont);
	        dummySection.add(patientIDLabel2);
	        JTextField patientID2 = new JTextField("SomePatientID2");
	        patientID2.setFont(formFont);
	        dummySection.add(patientID2);
	        // date
	
	        // add section to this panel
	        this.add(dummySection);
        }

		
	}
	
	public void PatientDataPanelUI2() {
		
		//super();
		// fixed layouting based on this: https://www.javaguides.net/2019/07/registration-form-using-java-swing-jdbc-mysql-example-tutorial.html
		this.setLayout(null);

		// Doctor ID and User ID fields than
		
		// re-used aspects
		Font headerFont = new Font("Tahoma", Font.PLAIN, 20);
		Font formFont = new Font("Tahoma", Font.PLAIN, 15);
		
		int standardHeight = 30;
		int standardLabelWidth= 80;
		int standardTextInputWidth = 150;
		
		////////////////////////////////////////////////////////////////
		// header: Global Settings
        JLabel header = new JLabel("Global Settings");
        header.setFont(headerFont);
        header.setBounds(10, 0, 325, 50);
        this.add(header);

        ////////////////////////////////////////////////////////////////
        // ROW 1
        // doctor ID
        JLabel doctorIDLabel = new JLabel("Doctor ID:");
        doctorIDLabel.setFont(formFont);
        doctorIDLabel.setBounds(10, 40, standardLabelWidth, standardHeight);
        this.add(doctorIDLabel);
        doctorID = new JTextField("SomeDoctorID");
        doctorID.setFont(formFont);
        doctorID.setBounds(80, 40, standardTextInputWidth, standardHeight);
        this.add(doctorID);
        
        // patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setFont(formFont);
        patientIDLabel.setBounds(250, 40, standardLabelWidth, standardHeight);
        this.add(patientIDLabel);
        patientID = new JTextField("SomePatientID");
        patientID.setFont(formFont);
        patientID.setBounds(320, 40, standardTextInputWidth, standardHeight);
        this.add(patientID);
        
        // date
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(formFont);
        dateLabel.setBounds(500, 40, standardLabelWidth, standardHeight);
        this.add(dateLabel);
        JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        date.setValue(new java.util.Date()); // today
        date.setFont(formFont);
        date.setBounds(540, 40, standardTextInputWidth, standardHeight);
        this.add(date);        
        

	}
	

}
