package grpc.Joanna.PermissionService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.google.protobuf.Timestamp;

// handwritten data class to be used to simulate the "virtual" database. this class are the data entries into the array
// in order to not store the GRPC messages directly
public class AccessLogEntryData {	
	
	LocalDate date;
	String accessType;
	String operationType;
	String targetPatientID;
	String accessorID;

	// constructor
	public AccessLogEntryData(AccessLogEntry grpcData) {
		this.setFrom(grpcData);
	}
	
	// conversion helper. Filling the data based on the gRPC Prescription message
	public void setFrom(AccessLogEntry grpcData) {
		this.accessType = grpcData.getAccessType();
		this.operationType = grpcData.getOperationType();
		this.targetPatientID = grpcData.getTargetPatientID();
		this.accessorID = grpcData.getAccessorID();
		Timestamp ts = grpcData.getDate();
		this.date = Instant.ofEpochSecond(ts.getSeconds(),ts.getNanos()).atZone(ZoneId.of("Europe/London")).toLocalDate();
	}
	
	// getters for the data fields of this class
	public String getAccessType() {
		return this.accessType;
	}
	
	public String getOperationType() {
		return this.operationType;
	}
	
	public String getTargetPatientID() {
		return this.targetPatientID;
	}
	
	public String getAccessorID() {
		return this.accessorID;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	// creates a gRPC message based on the stored information. This is in getPrescriptions RPC of the PartientDataService
	public AccessLogEntry createAccessLogEntryGRPCObject() {
		AccessLogEntry grpcPRescription = AccessLogEntry.newBuilder()
		.setAccessType(this.accessType)
		.setOperationType(this.operationType)
		.setTargetPatientID(this.targetPatientID)
		.setAccessorID(this.accessorID)
		//.setDate(null)
		.build();
		return grpcPRescription;
	}
	
    @Override
    public String toString() {
		return "Access to" + this.getTargetPatientID() + " by " + this.accessorID + " type: " + this.accessType + " operation: " + this.operationType;
	}
}
