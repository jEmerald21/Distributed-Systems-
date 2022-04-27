package grpc.Joanna.GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class DiscoveryPanelUI extends JPanel {
	
	private static final int ALWAYS_UPDATE = 0;
	// class private fields
	private JTextArea textArea;
	private JTable table;
	private boolean initialisation = true;

	// constructor that also build the entire UI of this panel
	public DiscoveryPanelUI() {
	    super();
		
	    //////////////////////////////////////////////////////////////////////////////////
		// service info panel
		JPanel topPanel = new JPanel();
		
		//Using JTable to display the services to track for discovery and their status
	    // Preparing the data to be displayed inside the JTable
        String[][] data = {
            { "PatientDataService", "?", "?", "Offline" },
            { "PermissionService", "?", "?", "Offline" },
            { "SupportService", "?", "?", "Offline" },
            { "StringEchoService", "?", "?", "Offline" },
        };
 
        // Preparing the column names of the JTable
        String[] columnNames = { "Name", "Address", "Port", "Status" };
 
        // creation and configuration of JTable
        table = new JTable(data, columnNames);
        table.getShowHorizontalLines(); // table styling
        table.setBackground(new Color(253,235,211)); // table styling
        table.getTableHeader().setOpaque(false); // column header styling
        table.getTableHeader().setBackground(new Color(192,179,160)); // column header styling
        table.setDefaultEditor(Object.class, null); // disable cell editing
 
        // adding it to a JScrollPane in case this is needed.
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(800, 450)); // resizing to fill use more of the available window space
        scrollPane.setViewportView(table);
        topPanel.add(scrollPane);
        

        //////////////////////////////////////////////////////////////////////////////////
        // creating a console-like output window to print text into
		JPanel bottomPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Info Console:");
		this.textArea = new JTextArea ("IMPORTANT: Please start this app first and then only the service apps ...\n");
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(ALWAYS_UPDATE); // forcing the text area to automatically scroll down. As described here: https://stackoverflow.com/questions/9000649/automatically-scroll-to-the-bottom-of-a-text-area
		JScrollPane scroll = new JScrollPane (this.textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// adding components to the console panel
		bottomPanel.add(label, BorderLayout.NORTH);
		bottomPanel.add(scroll, BorderLayout.CENTER);
		
		//////////////////////////////////////////////////////////////////////////////////
        // create a split pane to separate the table and the console window
        JSplitPane splitter = new JSplitPane(SwingConstants.HORIZONTAL, topPanel, bottomPanel);
        // moving the splitter further up by default as described on stackoverflow: https://stackoverflow.com/questions/2311449/jsplitpane-splitting-50-precisely
        splitter.setAlignmentX(0.5f);
		this.addComponentListener(new ComponentAdapter(){
		    @Override
		    public void componentResized(ComponentEvent e) {
		        if(initialisation ){
		        	splitter.setDividerLocation(0.3);
		            initialisation  = false;
		        }
		    }
		});
		// adding the splitter to this panel
		this.add(splitter);
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	// logging into the pseudo console window
	public void logInfo(String newInfo) {
		String text = this.textArea.getText();
		text += "\n" + newInfo;
		this.textArea.setText(text);
		System.out.println(newInfo);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	// allowing the discovery class to set service information upon discovery
	public void enablePatientDataService(String address, int port) {
		TableModel model = this.table.getModel(); 
		model.setValueAt(address, 0, 1);
		model.setValueAt(String.valueOf(port) , 0, 2);
		model.setValueAt("Online" , 0, 3);
	}
	
	//allowing the discovery class to update the service information
	public void disablePatientDataService() {
		TableModel model = this.table.getModel(); 
		model.setValueAt("?", 0, 1);
		model.setValueAt("?" , 0, 2);
		model.setValueAt("Offline" , 0, 3);		
	}
	
	// permissions
	public void enablePermissionsService(String address, int port) {
		TableModel model = this.table.getModel(); 
		model.setValueAt(address, 1, 1);
		model.setValueAt(String.valueOf(port), 1, 2);
		model.setValueAt("Online", 1, 3);
	}
	
	//allowing the discovery class to update the service information
	public void disablePermissionsService() {
		TableModel model = this.table.getModel(); 
		model.setValueAt("?", 1, 1);
		model.setValueAt("?" , 1, 2);
		model.setValueAt("Offline" , 1, 3);		
	}
	
	// support
	public void enableSupportService(String address, int port) {
		TableModel model = this.table.getModel(); 
		model.setValueAt(address, 2, 1);
		model.setValueAt(String.valueOf(port), 2, 2);
		model.setValueAt("Online", 2, 3);
	}
	
	public void disableSupportService() {
		TableModel model = this.table.getModel(); 
		model.setValueAt("?", 2, 1);
		model.setValueAt("?" , 2, 2);
		model.setValueAt("Offline" , 2, 3);		
	}
	
	// echo string
	public void enableStringEchoService(String address, int port) {
		TableModel model = this.table.getModel(); 
		model.setValueAt(address, 3, 1);
		model.setValueAt(String.valueOf(port), 3, 2);
		model.setValueAt("Online", 3, 3);
	}
	
	public void disableStringEchoService() {
		TableModel model = this.table.getModel(); 
		model.setValueAt("?", 3, 1);
		model.setValueAt("?" , 3, 2);
		model.setValueAt("Offline" , 3, 3);		
	}
}
