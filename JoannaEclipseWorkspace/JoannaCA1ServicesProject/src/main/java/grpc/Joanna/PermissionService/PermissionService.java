package grpc.Joanna.PermissionService;

import java.util.ArrayList;
import java.util.List;

import grpc.Joanna.PermissionService.PermissionServiceGrpc.PermissionServiceImplBase;
import io.grpc.stub.StreamObserver;

// gRPC service implementation for Permission service 
public class PermissionService extends PermissionServiceImplBase {
	
	// a simple list storing all access logs to simulate some kind of (virtual/pseudo) database
	private List<AccessLogEntryData> allAccessLogs = new ArrayList<>();
	private List<PermissionData> allPermissions= new ArrayList<>();
	
	// helper function to know if a doctor has access
	private boolean hasAccess(String userID, String PatientID) {

		for(int i = 0; i < this.allPermissions.size(); i++) {
			PermissionData data = this.allPermissions.get(i);
			// checking if it's an entry for the requested patient
			if(data.IsMatching(userID, PatientID)) {
				return true;
			}
		}
		return false;
	}
	
	// GRPC method implementation for giving a doctor access to a patient's data. Unary service type.
	@Override
	public void giveDataAccess(AccessInfo request, StreamObserver<RequestResult> responseObserver) {
		// Console info
		System.out.println("[Server][PermissionService] - Received access request for " + request.getDoctorID() + " to " + request.getPatientID() + "'s data.");
		boolean hasAlreadyAccess = this.hasAccess(request.getDoctorID(), request.getPatientID());
		String message = "";
		if(hasAlreadyAccess) {
			message = "Error: doctor has already access";
		}
		// generate reply
		RequestResult reply = RequestResult.newBuilder().setSuccess(hasAlreadyAccess == false).setNonSuccessHint(message).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}
	
	// GRPC method implementation for removing access for a doctor to a patient's data. Unary service type.
	@Override
	public void removeDataAccess(AccessInfo request, StreamObserver<RequestResult> responseObserver) {
		// Console info
		System.out.println("[Server][PermissionService] - Received access removal request for " + request.getDoctorID() + " to " + request.getPatientID() + "'s data.");
		boolean hassAccess = this.hasAccess(request.getDoctorID(), request.getPatientID());
		String message = "";
		if(hassAccess == false) {
			message = "Error: doctor had already no access";
		}
		// generate reply
		RequestResult reply = RequestResult.newBuilder().setSuccess(hassAccess).setNonSuccessHint(message).build();
		// send reply
		responseObserver.onNext(reply);
		// terminate reaction
		responseObserver.onCompleted();
	}
	
	// GRPC method implementation to list all access logs for a given patient. Server side streaming service.
	@Override
	public void getAccessHistory(RequestLogHistoryInfo request, StreamObserver<AccessLogEntry> responseObserver) {
		//retrieve input
		String patientID = request.getPatientID();
		System.out.println("[Server][PermissionService] - Received request to share access logs for: " + request.getPatientID());
		// going through the local "virtual database" to find matching logs for the given patient ID
		for(int i = 0; i < this.allAccessLogs.size(); i++) {
			AccessLogEntryData data = this.allAccessLogs.get(i);
			// checking if it's an entry for the requested patient
			if(data.getTargetPatientID().equals(patientID)) {
				System.out.println("[Server][PermissionService] => Found a log entry: " + data ); // todo
				// generate a reply
				AccessLogEntry reply = data.createAccessLogEntryGRPCObject();
				// send it
				responseObserver.onNext(reply);
			}
		}
		// finished sending them all. End response stream
		responseObserver.onCompleted();
		System.out.println("[Server][PatientDataService] => completed get prescriptions request");
	}
}



