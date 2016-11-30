import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Appointment {
	int appointmentID;
	int slotnum;
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getSlotnum() {
		return slotnum;
	}
	public void setSlotnum(int slotnum) {
		this.slotnum = slotnum;
	}
	private JFrame A;
	private JPanel panel;
	JTextField textFieldinputsearch = new JTextField(15);
	private JButton searchButton;
    void appointmentGui()
    {
    	A = new JFrame("MyHealth----->Make Appointment");
		A.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		A.setSize(600, 600);
		
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
		A.add(panel);
//WEEK 1	
		JLabel DocSearch = new JLabel();
		DocSearch.setText("Enter the Doctor name");
		DocSearch.setBounds(25, 100, 250, 25);
		Font currentFont = DocSearch.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		panel.add(DocSearch);
		DocSearch.setFont(newFont);
//WEEK 2		
		//Start Time Entry
		textFieldinputsearch.setBounds(275, 100, 125, 30);
		textFieldinputsearch.setFont(newFont);
		panel.add(textFieldinputsearch);
		
//Add to schedule
		searchButton = new JButton("Search");
		panel.add(searchButton);
		searchButton.setBounds(425, 100, 125, 30);
		panel.add(searchButton);
		searchButton.setFont(newFont);
		A.setVisible(true);
		System.out.println("AAAAAAA");
    }
}


