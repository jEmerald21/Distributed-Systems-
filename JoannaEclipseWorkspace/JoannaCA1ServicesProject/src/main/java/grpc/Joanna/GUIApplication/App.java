package grpc.Joanna.GUIApplication;


// Main application for JmDNS based service discovery and service interaction UI
public class App {
	
	// static main method 
	public static void main(String[] args) {
		
		// create a place where the discovery components can share service address informations
		ServiceAddressRegistry serviceInfo = new ServiceAddressRegistry();

		// create UI
		MainWindowGUI ui = new MainWindowGUI(serviceInfo); // using class constructor to pass over object reference to serviceInfo so it can use it
		ui.Build();
		
		// create jmDNS service discovery
		ServiceDiscovery discovery = new ServiceDiscovery();
		
		// starting the discovery and giving it direct access to the UI and the service info
		discovery.start(ui, serviceInfo);
	}
}