package grpc.Joanna.GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public final class UITools {
	
	final static Font formFont = new Font("Tahoma", Font.PLAIN, 15);
	
	private UITools() {}; 
	
	
	// helper function to create a header panel with a title on the left side
	public static JPanel CreateSectionDivder(String title, Color color) {
        JPanel sectionPanel = new JPanel();
        
		sectionPanel.setLayout(new GridBagLayout());
        sectionPanel.setBackground(color);
        
        JLabel label= new JLabel(title);
        label.setFont(formFont);
        
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
        cons.gridx = 0;
        
        sectionPanel.add(label, cons);

        return sectionPanel;
	}
	
	// helper function to create a header panel with a title on the left side
	public static JPanel CreateSpacerBar(int size, Color color) {
        JPanel sectionPanel = new JPanel();
        
		sectionPanel.setLayout(new GridBagLayout());
        sectionPanel.setBackground(color);
        
        JLabel label= new JLabel(" ");
        label.setFont(new Font("Tahoma", Font.PLAIN, size));
        
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
        cons.gridx = 0;
        
        sectionPanel.add(label, cons);

        return sectionPanel;
	}
	
	public static JTextArea CreateAndAddConsoleWindow(JPanel parent, String initialText) {
		JPanel consolePanel = new JPanel();
		JTextArea textArea = new JTextArea (" " + initialText + "\n");
		textArea.setColumns(78);
		textArea.setRows(15);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); // forcing the text area to automatically scroll down. As described here: https://stackoverflow.com/questions/9000649/automatically-scroll-to-the-bottom-of-a-text-area
		JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// adding components to the console panel
		consolePanel.add(scroll);
		parent.add(consolePanel);
		return textArea;
	}

}
