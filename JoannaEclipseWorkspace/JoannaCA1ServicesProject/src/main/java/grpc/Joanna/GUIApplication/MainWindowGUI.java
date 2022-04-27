package grpc.Joanna.GUIApplication;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;

// this is the main window of the app with different panels for each tab
public class MainWindowGUI {
	
	private DiscoveryPanelUI discoveryUI;
	private PatientDataPanelUI patientDataPanel;
	private ServiceAddressRegistry discoveryInfo;
	
	// constructor
	public MainWindowGUI(ServiceAddressRegistry info) {
		this.discoveryInfo = info;
	}
	
	// build the main UI
	public void Build() {

		// basic window creation in custom method of this class
		JFrame window = createWindow();
 
        // creation of the tabs & tabbed pages
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
        tabbedPane.setBorder(null);
        
        // panel pages of the tabed view
        discoveryUI = new DiscoveryPanelUI(); // new JPanel(new BorderLayout());
        discoveryUI.setBackground(new Color(192,179,160));
        tabbedPane.addTab("Service Discovery", discoveryUI);
        tabbedPane.setBackgroundAt(0, new Color(253,235,211)); // tab button colour
        //this.populateDiscoveryPanel(discoveryPanel);
        
        patientDataPanel = new PatientDataPanelUI(discoveryInfo); // passing reference to service discovery info class instance
        patientDataPanel.setBackground(new Color(38,78,112));
        tabbedPane.addTab("Patient Data", patientDataPanel);
        tabbedPane.setBackgroundAt(1, new Color(80,163,233)); // tab button color
        
        JPanel permissionsPanel = new JPanel();
        permissionsPanel.setBackground(new Color(103,145,134));
        tabbedPane.addTab("Access Permissions", permissionsPanel);
        tabbedPane.setBackgroundAt(2, new Color(145,200,186)); // tab button colour
        
        JPanel supportPanel = new JPanel();
        supportPanel.setBackground(new Color(255,255,153));
        tabbedPane.addTab("Support", supportPanel);
        tabbedPane.setBackgroundAt(3, new Color(255,255,230)); // tab button colour
        
        JPanel echoPanel = new JPanel();
        echoPanel.setBackground(Color.PINK);
        tabbedPane.addTab("String Echo", echoPanel);
        tabbedPane.setBackgroundAt(4, Color.pink);  
 
        
        // add JTabbedPane to window 
        window.add(tabbedPane);
        // show window
        window.setVisible(true);
	}
	
	public JFrame createWindow() {
	    // GUI window 
		JFrame window = new JFrame("Joanna's Services Control GUI");
        int width = 980;
        int height = 725;
        // set size
        window.setSize(width,height);
        // center
        window.setLocationRelativeTo(null);
        window.pack();
        // revert size as it got undone when using .pack()
        window.setSize(width,height);
        // make sure the app also closes when the window is closed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // change background color
        window.getContentPane().setBackground( Color.DARK_GRAY );
        return window;
	}
	
	// getters for private fields, the UI for each topic
	public DiscoveryPanelUI getDiscoveryUI() {
		return this.discoveryUI;
	}
}
