package grpc.Joanna.GUIApplication;

// a class used across service discovery and classes to share service host information 
public class ServiceAddressRegistry {
	
	// Patient Data Service
	private ServiceAddress patientData = new ServiceAddress("", 0);
	public void setPatientDataInfo(ServiceAddress info) {
		this.patientData = info;
	}
	public ServiceAddress getPatientDataInfo() {
		return this.patientData;
	}
	
	// Permission Service
	private ServiceAddress permissions = new ServiceAddress("", 0);;
	public void setPermissionsInfo(ServiceAddress info) {
		this.permissions = info;
	}
	public ServiceAddress getPermissionsInfo() {
		return this.permissions;
	}
	
	// Support Service
	private ServiceAddress support = new ServiceAddress("", 0);;
	public void setSupportInfo(ServiceAddress info) {
		this.support = info;
	}
	public ServiceAddress getSupport() {
		return this.support;
	}
	
	// Support Service
	private ServiceAddress echo = new ServiceAddress("", 0);;
	public void setEchoInfo(ServiceAddress info) {
		this.echo = info;
	}
	public ServiceAddress getEcho() {
		return this.echo;
	}


}

