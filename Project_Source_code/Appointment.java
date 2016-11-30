import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Appointment implements ActionListener {
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
	private JButton selectSlot;
	JLabel DocSearch;
	int DOCID;
	Font newFont;
	String[] options = new String[1024];

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
		DocSearch = new JLabel();
		DocSearch.setText("Enter the Doctor name");
		DocSearch.setBounds(25, 100, 250, 25);
		Font currentFont = DocSearch.getFont();
		newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
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
		searchButton.addActionListener(this);
		A.setVisible(true);
		System.out.println("AAAAAAA");
    }
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == searchButton){
			String docinput=textFieldinputsearch.getText();
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Doctor> result = (List<Doctor>) session.createQuery("from Doctor").list();
			session.close();
			sessionFactory.close();
			int match = 0;
		
			for(int i =0; i< result.size();i++)
			{
				if(result.get(i).getFirstname().equals(docinput))
				{
					match = 1;
					DOCID = result.get(i).getDocId();
					System.out.println(DOCID);
					this.updateView(DOCID);
					break;
					
				}
			}
			if(match == 0)
			{
				JOptionPane.showMessageDialog(A,"No entry Found");
			}
			
			
		}
	}
	
	void updateView(int _docID)
    {
	 
	 	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Slots> result = (List<Slots>) session.createQuery("from Slots").list();
		session.close();
		sessionFactory.close();
		int k = 0;
		for(int i = 0; i< result.size();i++)
		{
			if(result.get(i).getDocId() == _docID)
			{
				options[k]= (result.get(i).getDay() + " " + result.get(i).getStart_time() + " - " + result.get(i).getEnd_time());
				k++;
				System.out.println("k");
				
			}
		}
		System.out.println("Done");
//Available Slots
		JLabel SlotInfo = new JLabel();
		SlotInfo.setText("Available Slots");
		SlotInfo.setBounds(30, 300, 200, 30);
		Font currentFont = SlotInfo.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		panel.add(SlotInfo);
		SlotInfo.setFont(newFont);
		
		JComboBox<String> list = new JComboBox<String>(options);
		list.setBounds(250, 300, 200, 30);
		list.setFont(newFont);
		panel.add(list);
		System.out.println("Done2");
		
		
	 	selectSlot = new JButton("Book Appointment");
		panel.add(selectSlot);
		selectSlot.setBounds(300, 500, 250, 30);
		panel.add(selectSlot);
		selectSlot.setFont(newFont);
		selectSlot.addActionListener(this);
    }
}


