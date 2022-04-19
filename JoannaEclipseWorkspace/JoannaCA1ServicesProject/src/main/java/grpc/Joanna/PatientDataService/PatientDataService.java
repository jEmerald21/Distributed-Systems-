package grpc.Joanna.PatientDataService;

import java.util.ArrayList;
import java.util.List;

import grpc.Joanna.PatientDataService.PatientDataServiceGrpc.PatientDataServiceImplBase;
import io.grpc.stub.StreamObserver;

// GRPC service implementation for PatentData 
public class PatientDataService extends PatientDataServiceImplBase {
	
	// a simple list storing all prescriptions received to simulate some kind of (virtual/pseudo) database
	private List<PrescriptionData> allPrescriptions = new ArrayList<>();
	
	// GRPC method implementation for storing prescriptions received. Unary service type.
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
	
	// GRPC method implementation for giving all known prescriptions for a given patentID. Server side streaming service.
	@Override
	public void getPrescriptions(GetPrescriptionInfo request, StreamObserver<Prescription> responseObserver) {
		//retrieve input
		String patientID = request.getPatientID();
		System.out.println("[Server][PatientDataService] - Received request to send prescriptions for: " + request.getPatientID());
		// going through the local "virtual database" to find matching prescriptions for the given patient ID
		for(int i = 0; i < this.allPrescriptions.size(); i++) {
			PrescriptionData data = this.allPrescriptions.get(i);
			// checking if it's an entry for the requested patient
			if(data.getPatientID().equals(patientID)) {
				System.out.println("[Server][PatientDataService] => Found a prescription: " + data.getPrescriptionText());
				// generate a reply
				Prescription reply = data.createPrescriptionGRPCObject();
				// send it
				responseObserver.onNext(reply);
			}
		}
		// finished sending them all. End response stream
		responseObserver.onCompleted();
		System.out.println("[Server][PatientDataService] => completed get prescriptions request");
	}
	
	// GRPC method implementation for adding doctor notes to a patient file. Unary service call.
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
	
	// GRPC method implementation for adding a series of lab results. Client side streaming
	@Override
	public StreamObserver<LabResult> addLabResults(StreamObserver<RequestResult> responseObserver) {
		// client stream handler
		return new StreamObserver<LabResult>()  {
			@Override
			public void onNext(LabResult labResult) {
				// console info
				System.out.println("[Server][PatientDataService] - Received new lab result for " + labResult.getPatientID());
			}

			@Override
			public void onError(Throwable t) {
				// log error
				System.out.println("[Server][PatientDataService] ==> Error while receiving Lab Result: " + t.getMessage() );
			}

			@Override
			public void onCompleted() {
				System.out.println("[Server][PatientDataService] ==> completed receiving lab results for patient.");
				// send completion reply
				RequestResult reply = RequestResult.newBuilder().setSuccess(true).build();
				responseObserver.onNext(reply);
				// complete
				responseObserver.onCompleted();
				
			}
		};
	}
}



