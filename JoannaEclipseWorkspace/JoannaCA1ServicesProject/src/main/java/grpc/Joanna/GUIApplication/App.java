package grpc.Joanna.GUIApplication;

// main application for discovery service and service UI
public class App {
	
	public static void main(String[] args) {

		// create UI
		MainWindowGUI ui = new MainWindowGUI();
		ui.Build();
		
		// create jmDNS service discovery
		ServiceDiscovery discovery = new ServiceDiscovery();
		// starting the discovery and giving it direct access to the UI
		discovery.start(ui);
	}
}
