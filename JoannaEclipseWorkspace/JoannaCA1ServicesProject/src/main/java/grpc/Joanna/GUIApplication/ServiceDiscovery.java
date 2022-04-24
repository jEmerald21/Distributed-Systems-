package grpc.Joanna.GUIApplication;

import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class ServiceDiscovery implements ServiceListener{
	
	MainWindowGUI gui;
	DiscoveryPanelUI discoveryUI;

	// react to services that have been discovered
	public void serviceAdded(ServiceEvent event) {
		ServiceInfo serviceInfo = event.getInfo();
		discoveryUI.logInfo("Service added: " + serviceInfo.getName());
	}

	// react to services that are no longer available
	public void serviceRemoved(ServiceEvent event) {
		ServiceInfo serviceInfo = event.getInfo();
		discoveryUI.logInfo("Service Removed: " + serviceInfo.getName());
		
		// PatentData Service
		if(serviceInfo.getName().compareTo("PatientDataService") == 0) {
			discoveryUI.disablePatientDataService();;
		}
		
		// Permission Service
		if(serviceInfo.getName().compareTo("PermissonService") == 0) {
			discoveryUI.disablePermissionsService();
		}
		
		// Support Service
		if(serviceInfo.getName().compareTo("SupportService") == 0) {
			discoveryUI.disableSupportService();
		}
		
		// String Echo Service
		if(serviceInfo.getName().compareTo("StringEchoService") == 0) {
			discoveryUI.disableStringEchoService();
		}
	}

	// react to services detail that have been shared for a recently started service
	@SuppressWarnings("deprecation")
	public void serviceResolved(ServiceEvent event) {
		
		ServiceInfo serviceInfo = event.getInfo();
		discoveryUI.logInfo("==> host " + serviceInfo.getHostAddress());
		discoveryUI.logInfo("==> port " + serviceInfo.getPort());
		discoveryUI.logInfo("==> type " + serviceInfo.getType());
		discoveryUI.logInfo("==> name " + serviceInfo.getName());
		discoveryUI.logInfo("==> Computername " + serviceInfo.getServer());
		discoveryUI.logInfo("==> desc/properties " + serviceInfo.getNiceTextString());
		
		// Handle PatentData Service
		if(serviceInfo.getName().compareTo("PatientDataService") == 0) {
			discoveryUI.enablePatientDataService(serviceInfo.getHostAddress(), serviceInfo.getPort());
		}
		
		// Handle Permissions Service
		if(serviceInfo.getName().compareTo("PermissionService") == 0) {
			discoveryUI.enablePermissionsService(serviceInfo.getHostAddress(), serviceInfo.getPort());
		}
		
		// Handle Support Service
		if(serviceInfo.getName().compareTo("SupportService") == 0) {
			discoveryUI.enableSupportService(serviceInfo.getHostAddress(), serviceInfo.getPort());
		}
		
		// Handle String Echo Service
		if(serviceInfo.getName().compareTo("StringEchoService") == 0) {
			discoveryUI.enableStringEchoService(serviceInfo.getHostAddress(), serviceInfo.getPort());
		}
	}

	public void start(MainWindowGUI gui) {
		
		// reference to the gui
		this.gui = gui;
		this.discoveryUI = this.gui.getDiscoveryUI();

		try {
			// start jmDNS discovery
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//need to listen for services added/removed etc.
			jmdns.addServiceListener("_grpc._tcp.local.", this);
			
			// show start info to user
			discoveryUI.logInfo("JmDNS service discovery started");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}