package grpc.Joanna.GUIApplication;

// simple address info class to make storing and retrieving these two informations as combo easier
public class ServiceAddress {
	
	public String hostAddress; // service server address
	public int port; // service server port
	public boolean available; // indicator if the service is known or not
	
	public ServiceAddress(String address, int port) {
		this.hostAddress = address;
		this.port = port;
		this.available = !address.equals(""); // With ! inverting the result of the comparison. Not available if address string is empty
	}
}
