package grpc.Joanna.PatientDataService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Timestamp;

import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceImplBase;
import io.grpc.stub.StreamObserver;

// this is a simple string echo service to help making sure all the basics work 
public class PatientDataService extends PatientDataServiceImplBase {
	
	// a simple list storing all prescriptions received to simulate some kind of (virtual/pseudo) database
	private List<PrescriptionData> allPrescriptions = new ArrayList<>();
	
	// GRPC method implementation for storing prescriptions received
	@Override
	public void addPrescription(Prescription request, StreamObserver<RequestResult> responseObserver) {
		// Console info
		System.out.println("[Server][PatientDataService] - Received new prescription from: " + request.getDoctorID() + " for " + request.getPatientID());
		this.allPrescriptions.add(new PrescriptionData(request));
		// generate reply
		RequestResult reply = RequestResult.newBuilder().setSuccess(true).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}
	
	// GRPC method implementation for giving all known prescriptions for a given patentID
	@Override
	public void getPrescriptions(GetPrescriptionInfo request, StreamObserver<Prescription> responseObserver) {
		//retrieve input
		String patientID = request.getPatientID();
		System.out.println("[Server][PatientDataService] - Received request to send prescriptions for: " + request.getPatientID());
		// going through the local "virtual database" to find matching prescriptions for the given patient ID
		for(int i = 0; i < this.allPrescriptions.size(); i++) {
			PrescriptionData data = this.allPrescriptions.get(i);
			// checking if it's an entry for the requested patient
			if(data.getPatientID() == patientID) {
				// generate a reply
				Prescription reply = data.createPrescriptionGRPCObject();
				// send it
				responseObserver.onNext(reply);
			}
		}
		// finished sending them all. End response stream
		responseObserver.onCompleted();
	}
	
	// GRPC method implementation for adding doctor notes to a patient file
	@Override
	public void addDoctorNotes(DoctorNote request, StreamObserver<RequestResult> responseObserver) {
		// Console info
		System.out.println("[Server][PatientDataService] - Received new doctor note from: " + request.getDoctorID() + " for " + request.getPatientID());
		// generate reply
		RequestResult reply = RequestResult.newBuilder().setSuccess(true).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}
	
	public void addLabResults (StreamObserver<LabResult> receiveObserver, StreamObserver<Prescription> responseObserver) {
		
	}
}



