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

public class AppointmentGui implements ActionListener {
	
	private JFrame A;
	private JPanel panel;
	JTextField textFieldinputsearch = new JTextField(15);
	private JButton searchButton;
	private JButton selectSlot;
	JLabel DocSearch;

	Font newFont;
	int[] slotsArr = new int[1024];
	String[] options = new String[1024];
	JComboBox<String> list;
	Appointment Appt = new Appointment();
    void appointmentGui(int _patID)
    {
    	Appt.setPatientID(_patID);
    	A = new JFrame("MyHealth----->Make Appointment");
		A.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		if(ae.getSource() == searchButton)
		{
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
					System.out.println("Doctor Found");
					Appt.setDOCID(result.get(i).getDocId());
					this.updateView(Appt.getDOCID(), Appt.getPatientID());
					break;
					
				}
			}
			if(match == 0)
			{
				JOptionPane.showMessageDialog(A,"No entry Found");
			}
			
			
		}
		if(ae.getSource() == selectSlot)
		{
			Appt.setAppointmentDetails(list.getSelectedItem().toString());
			int n = list.getSelectedIndex();
			Appt.setSlotnum(slotsArr[n]);
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();	
			session.save(Appt);
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Slots> result = (List<Slots>) session.createQuery("from Slots").list();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getSlotNum() == Appt.getSlotnum())
				{
					session.delete(result.get(i));
					
				}
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			JOptionPane.showMessageDialog(A,"Appointment Booked successfully");
			A.dispose();
		}
	}
	
	void updateView(int _docID, int patID)
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
				slotsArr[k] = result.get(i).getSlotNum();
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
		list = new JComboBox<String>(options);
		list.setBounds(200, 300, 300, 30);
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


