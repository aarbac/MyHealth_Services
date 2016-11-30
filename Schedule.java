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
	String[] options = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
	JComboBox<String> list = new JComboBox<String>(options);
	JButton add;
	private JFrame s;
	private JPanel panel;
	int CurrDoc;
	public void scheduleGui(int _DoctorID)
	{
		CurrDoc = _DoctorID;
		s = new JFrame("MyHealth----->Create Schedule");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(600, 600);
		
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
		s.add(panel);
		
//WEEK 1	
		JLabel Week1 = new JLabel();
		Week1.setText("WEEK 1");
		Week1.setBounds(100, 100, 150, 25);
		Font currentFont = Week1.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		panel.add(Week1);
		Week1.setFont(newFont);
//WEEK 2		
		JLabel Week2 = new JLabel();
		Week2.setText("WEEK 2");
		Week2.setBounds(100, 300, 150, 25);
		panel.add(Week2);
		Week2.setFont(newFont);
//Add to schedule
		add = new JButton("Add to Schedule");
		panel.add(add);
		add.setBounds(300, 500, 200, 25);
		panel.add(add);
		add.setFont(newFont);
//Start Time
		JLabel StartTime = new JLabel();
		StartTime.setText("START TIME");
		StartTime.setBounds(250, 100, 150, 25);
		panel.add(StartTime);
		StartTime.setFont(newFont);
		
		JLabel StartTime2 = new JLabel();
		StartTime2.setText("START TIME");
		StartTime2.setBounds(250, 300, 150, 25);
		panel.add(StartTime2);
		StartTime2.setFont(newFont);
		
//END TIME	
		JLabel EndTime = new JLabel();
		EndTime.setText("END TIME");
		EndTime.setBounds(400, 100, 150, 25);
		panel.add(EndTime);
		EndTime.setFont(newFont);
		
		JLabel EndTime2 = new JLabel();
		EndTime2.setText("END TIME");
		EndTime2.setBounds(400, 300, 150, 25);
		panel.add(EndTime2);
		EndTime2.setFont(newFont);
//Start Time Entry
		textFieldStarttime.setBounds(250, 150, 125, 30);
		textFieldStarttime.setFont(newFont);
		panel.add(textFieldStarttime);
		
//End Time Entry
		textFieldEndtime.setBounds(400, 150, 125, 30);
		textFieldEndtime.setFont(newFont);
		panel.add(textFieldEndtime);
		
//Start Time Entry2
		textFieldStarttime2.setBounds(250, 350, 125, 30);
		textFieldStarttime2.setFont(newFont);
		panel.add(textFieldStarttime2);
		
//End Time Entry2
		textFieldEndtime2.setBounds(400, 350, 125, 30);
		textFieldEndtime2.setFont(newFont);
		panel.add(textFieldEndtime2);
		
//Day Drop Down
		
		list.setBounds(100, 150, 100, 30);
		list.setFont(newFont);
		panel.add(list);
		
//Day Drop Down
		JComboBox<String> list2 = new JComboBox<String>(options);
		list2.setBounds(100, 350, 100, 30);
		list2.setFont(newFont);
		panel.add(list2);
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
			S.setDay(list.getSelectedItem().toString());
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
