import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//Hibernate Libraries
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Table(name = "DoctorSchedule")
public class Schedule implements ActionListener{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ScheduleID;
	JTextField textFieldStarttime = new JTextField(15);
	JTextField textFieldStarttime2 = new JTextField(15);
	JTextField textFieldEndtime = new JTextField(15);
	JTextField textFieldEndtime2 = new JTextField(15);
	String[] dayoptions = new String[32];
	JComboBox<String> daylist;
	String[] monthoptions = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	JComboBox<String> monthlist = new JComboBox<String>(monthoptions);
	String[] yearoptions = {"2016","2017"};
	JComboBox<String> yearlist = new JComboBox<String>(yearoptions);
	JButton add;
	private JFrame s;
	private JPanel panel;
	int CurrDoc;
	public void scheduleGui(int _DoctorID)
	{
		CurrDoc = _DoctorID;
		s = new JFrame("MyHealth----->Create Schedule");
		s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		s.setSize(600, 600);
		
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
		s.add(panel);
		
//WEEK 1	
		JLabel Week1 = new JLabel();
		Week1.setText("Day");
		Week1.setBounds(100, 100, 150, 25);
		Font currentFont = Week1.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		panel.add(Week1);
		Week1.setFont(newFont);

//Add to schedule
		add = new JButton("Add to Schedule");
		panel.add(add);
		add.setBounds(300, 500, 200, 25);
		panel.add(add);
		add.setFont(newFont);
//Start Time
		JLabel StartTime = new JLabel();
		StartTime.setText("START TIME");
		StartTime.setBounds(50, 300, 150, 25);
		panel.add(StartTime);
		StartTime.setFont(newFont);
		
		
//END TIME	
		JLabel EndTime = new JLabel();
		EndTime.setText("END TIME");
		EndTime.setBounds(50, 400, 150, 25);
		panel.add(EndTime);
		EndTime.setFont(newFont);
		
//Start Time Entry
		textFieldStarttime.setBounds(250, 300, 150, 30);
		textFieldStarttime.setFont(newFont);
		panel.add(textFieldStarttime);
		
//End Time Entry
		textFieldEndtime.setBounds(250, 400, 150, 30);
		textFieldEndtime.setFont(newFont);
		panel.add(textFieldEndtime);
		
		
//Day Drop Down
		for(int i=1; i<dayoptions.length;i++)
		{
			dayoptions[i] = Integer.toString(i);
		}
		daylist = new JComboBox<String>(dayoptions);
		daylist.setBounds(25, 150, 75, 30);
		daylist.setFont(newFont);
		panel.add(daylist);
	
		monthlist.setBounds(125, 150, 75, 30);
		monthlist.setFont(newFont);
		panel.add(monthlist);
		
		yearlist.setBounds(225, 150, 100, 30);
		yearlist.setFont(newFont);
		panel.add(yearlist);
		
		add.addActionListener(this);
		s.setVisible(true);
		System.out.println("AAAAAAA");
		
		
	}
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == add){
			System.out.println("kjbdksbdk");
			Slots S = new Slots();
			S.setStart_time(textFieldStarttime.getText());
			S.setEnd_time(textFieldEndtime.getText());
			S.setDay(daylist.getSelectedItem().toString() + "-" + monthlist.getSelectedItem().toString() + "-" + yearlist.getSelectedItem().toString()  );
			S.setDocId(CurrDoc);
//Test if working
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(S);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		}
			
		}
}
