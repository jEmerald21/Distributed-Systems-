package grpc.Joanna.PatientDataService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.google.protobuf.Timestamp;

// handwritten data class to be used to simulate the "virtual" database. this class are the data entries into the array
// in order to not store the GRPC messages directly
public class PrescriptionData {
	
	// fields
	String doctorID;
	String patientID;
	String prescriptionText;
	LocalDate date;

	// constructor
	public PrescriptionData(Prescription grpcData) {
		this.setFrom(grpcData);
	}
	
	// conversion helper. Filling the data based on the gRPC Prescription message
	public void setFrom(Prescription grpcData) {
		this.doctorID = grpcData.getDoctorID();
		this.patientID = grpcData.getPatientID();
		this.prescriptionText = grpcData.getPrescriptionText();
		Timestamp ts = grpcData.getDate();
		this.date = Instant.ofEpochSecond(ts.getSeconds(),ts.getNanos()).atZone(ZoneId.of("Europe/London")).toLocalDate();
	}
	
	// getters for the data fields of this class
	public String getDoctorID() {
		return this.doctorID;
	}
	
	public String getPatientID() {
		return this.patientID;
	}
	
	public String getPrescriptionText() {
		return this.prescriptionText;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	// creates a gRPC message based on the stored information. This is in getPrescriptions RPC of the PartientDataService
	public Prescription createPrescriptionGRPCObject() {
		Prescription grpcPRescription = Prescription.newBuilder()
		.setDoctorID(this.doctorID)
		.setPatientID(this.patientID)
		.setPrescriptionText(this.prescriptionText)
		//.setDate()
		.build();
		return grpcPRescription;
	}
}
