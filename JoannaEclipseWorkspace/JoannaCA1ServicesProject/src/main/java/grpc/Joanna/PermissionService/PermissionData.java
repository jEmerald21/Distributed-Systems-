package grpc.Joanna.PermissionService;

// handwritten data class to be used to simulate the "virtual" database. this class are the data entries into the array
// in order to not store the GRPC messages directly
public class PermissionData {	
	
	// fields
	String targetPatientID;
	String userID;

	// constructor
	public PermissionData(String targetPatientID, String userID) {
		this.targetPatientID = targetPatientID;
		this.userID = userID;
	}
	
	// getters
	public String getTargetPatientID() {
		return this.targetPatientID;
	}
	
	public String getUserId() {
		return this.userID;
	}
	
	public boolean IsMatching(String userID, String targetPatientID) {
	 return this.userID.equals(targetPatientID) && this.userID.equals(userID);
	}
	
    @Override
    public String toString() {
		return "Permission for " + this.userID + " to acces the data from " + this.getTargetPatientID() ;
	}
}
