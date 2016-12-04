/**CSCI 5448: MyHealth
 * 
 */

/**
 * @authors Anish Churi, Aaresh Bachana, Harshil Sheth
 *
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
//import java.io.IOException;
//import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

//Hibernate Libraries
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
//import org.hibernate.query.Query;

public class Driver {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreditCards C = new CreditCards();
		C.setCardNum("1234123412341234");
		C.setCardName("Harshil Sheth");
		C.setCVV("123");
		C.setAddress("asdgjsavdjhvb");
		C.setExpirydate("Jan 2019");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(C);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		new GUI();
		//ArrayList<Person> library = new ArrayList<Person>();


	}
	

}

class GUI implements ActionListener {
	
	//GUI g = new GUI();
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


	// this would save all the Media objects into the database

	ArrayList<Person> library = new ArrayList<Person>();
	private JFrame f;
	JFrame jbill;
	private JTextField textFieldusrname;
	private JTextField textFieldpsswrd;
	private JLabel jlabelusrname;
	private JLabel jlabelpsswrd;
	private JLabel jlabelmsg;
	private JPanel panel;
	private JLabel DocSearch;
	JButton PayBill;
	JTextField textFieldDocName = new JTextField(15);
	JButton Createbutton;
	JButton Loginbutton;
	JButton Forgotbutton;
	JButton CreatebuttonP;
	JButton Appointment;
	JButton sch;
	JButton subres;
	JButton subbill;
	JButton ReqTest;
	JButton viewBill;
	JButton selectTest;
	JButton viewMessages;
	JButton Approve;
	JButton Approvebill;
	JButton viewAppt;
	JButton Logout;
	JTextField textFieldcardNum;
	JTextField textFieldTestinput = new JTextField(15);
	JTextField textFieldDocIDinput = new JTextField(15);
	JTextField textFieldPatIDinput = new JTextField(15);
	JTextField textFieldUserName = new JTextField(15);
	JTextField textFieldFirstName = new JTextField(15);
	JTextField textFieldLastName = new JTextField(15);
	JTextField textFieldBG = new JTextField(15);
	JTextField textFieldAge = new JTextField(15);
	JTextField textFieldPassword = new JPasswordField(15);
	JTextField textFieldRPassword = new JPasswordField(15);
	JTextField textFieldphoneNum = new JTextField(15);
	JTextField textFieldAddress = new JTextField(50);
	JCheckBox checkboxpatient = new JCheckBox("Patient");
	JCheckBox checkboxdoctor = new JCheckBox("Doctor");
	JCheckBox checkboxclerk = new JCheckBox("Clerk");
	String[] options = {"Male","Female","Other"};
	JComboBox<String> list = new JComboBox<String>(options);
	String[] Testoptions = {"Blood Test","MRI Scan","Ultrasound","X-Ray","Skin Test"};
	JComboBox<String> testlist= new JComboBox<String>(Testoptions);
	Font newFont;
	int CurrentID;
	int billId;
	public void HomePageGui(int PersonID, String _usertype)
	{
		CurrentID = PersonID;
		f  = new JFrame("MyHealth----->Welcome to MyHealth Service");
	//	f  = new JFrame("MyHealth----->Create Profile");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
		f.add(panel);
		JLabel label = new JLabel();
		Image background = new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
		Image scaledImage = background.getScaledInstance(1000, 400,Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(scaledImage));
		label.setBounds(0, 0, 1000, 300);
		panel.add(label);
		//Appointment	
		if(_usertype.equals("Patient"))
		{	
			JLabel Appt = new JLabel();
			Appt.setText("Book Appointment");
			Appt.setBounds(100, 325, 200, 25);
			Font currentFont = Appt.getFont();
			newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
			panel.add(Appt);
			Appt.setFont(newFont);
			Appointment= new JButton();
			Appointment.setBounds(300,325, 30,25);
		//	Appointment.setHorizontalTextPosition(SwingConstants.RIGHT);
		//	Appointment.setIconTextGap(4);
		//	panel.add(Appointment);
			Image appt = new ImageIcon(this.getClass().getResource("/Appt.png")).getImage();
			Image scaledappt = appt.getScaledInstance(25, 25,Image.SCALE_SMOOTH);
			Appointment.setIcon(new ImageIcon(scaledappt) );
			panel.add(Appointment);
//Request Test
			ReqTest= new JButton("Request Test");
			ReqTest.setBounds(25,525, 250,25);
			ReqTest.setFont(newFont);
			panel.add(ReqTest);
//View Bill
			viewBill= new JButton("View Bills");
			viewBill.setBounds(25,625, 250,25);
			viewBill.setFont(newFont);
			panel.add(viewBill);
			Appointment.addActionListener(this);
			ReqTest.addActionListener(this);
			viewBill.addActionListener(this);
		}	
		//Messages
		viewMessages = new JButton("Messages");
		viewMessages.setBounds(750,325, 200,25);
		newFont = viewMessages.getFont().deriveFont(viewMessages.getFont().getSize() * 1.4F);
		viewMessages.setFont(newFont);
		panel.add(viewMessages);
	//Home Button
		JButton home= new JButton();
		home.setBounds(50,325, 30,25);
	//	Appointment.setHorizontalTextPosition(SwingConstants.RIGHT);
	//	Appointment.setIconTextGap(4);
		//Logout
		Logout= new JButton("Logout");
		Logout.setBounds(800,800, 150,25);
		Logout.setFont(newFont);
		panel.add(Logout);
		Logout.addActionListener(this);
		Image homeicon = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		Image scaledhome = homeicon.getScaledInstance(25, 25,Image.SCALE_SMOOTH);
		home.setIcon(new ImageIcon(scaledhome) );
		panel.add(home);
		//Create schedule Button
		if(_usertype.equals("Doctor"))
		{	
			sch= new JButton("Create Schedule");
			sch.setBounds(100,325, 200,25);
			sch.setFont(newFont);
			panel.add(sch);
			sch.addActionListener(this);
			Approve= new JButton("Approve Test");
			Approve.setBounds(25,525, 250,25);
			Approve.setFont(newFont);
			panel.add(Approve);
			Approve.addActionListener(this);
			Approvebill= new JButton("Approve Bills");
			Approvebill.setBounds(25,625, 250,25);
			Approvebill.setFont(newFont);
			panel.add(Approvebill);
			Approvebill.addActionListener(this);
			
		}
		if(!_usertype.equals("Clerk"))
		{
			viewAppt= new JButton("View Appointments");
			viewAppt.setBounds(25,425, 250,25);
			viewAppt.setFont(newFont);
			panel.add(viewAppt);
			viewAppt.addActionListener(this);
			
		}
		//Create Submit Buttons
		if(_usertype.equals("Clerk"))
		{	
			subres= new JButton("Submit Results");
			subres.setBounds(200,325, 200,25);
			subres.setFont(newFont);
			panel.add(subres);
			subres.addActionListener(this);
			subbill= new JButton("Submit Bills");
			subbill.setBounds(425,325, 200,25);
			subbill.setFont(newFont);
			panel.add(subbill);
			subbill.addActionListener(this);
			
			JLabel PatientID = new JLabel();
			PatientID.setText("Enter Patient ID");
			PatientID.setBounds(300, 500, 200, 30);
			panel.add(PatientID);
			PatientID.setFont(newFont);
			textFieldPatIDinput.setBounds(475, 500, 200, 30);
			textFieldPatIDinput.setFont(newFont);
			panel.add(textFieldPatIDinput);
			
			JLabel DoctorID = new JLabel();
			DoctorID.setText("Enter Doctor ID");
			DoctorID.setBounds(300, 600, 200, 30);
			panel.add(DoctorID);
			DoctorID.setFont(newFont);
			textFieldDocIDinput.setBounds(475, 600, 200, 30);
			textFieldDocIDinput.setFont(newFont);
			panel.add(textFieldDocIDinput);
			
			JLabel Testtype = new JLabel();
			Testtype.setText("Enter Test type");
			Testtype.setBounds(300, 700, 200, 30);
			panel.add(Testtype);
			Testtype.setFont(newFont);
			testlist.setBounds(475, 700, 200, 30);
			testlist.setFont(newFont);
			panel.add(testlist);
		}
	//	Appointment.setHorizontalTextPosition(SwingConstants.RIGHT);
	//	Appointment.setIconTextGap(4);
		f.setVisible(true);


//		viewBill.addActionListener(this);
		viewMessages.addActionListener(this);
		
		
	}
	
	public void createProfileGui()
	{
		f  = new JFrame("MyHealth----->Create Profile");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
		f.add(panel);
		JLabel label = new JLabel();
		Image background = new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
		Image scaledImage = background.getScaledInstance(1000, 400,Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(scaledImage));
		label.setBounds(0, 0, 1000, 300);
		panel.add(label);			
//First Name		
		JLabel FirstName = new JLabel();
		FirstName.setText("First Name");
		FirstName.setBounds(300, 350, 200, 30);
		Font currentFont = FirstName.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		panel.add(FirstName);
		FirstName.setFont(newFont);
		
		textFieldFirstName.setBounds(550, 350, 200, 30);
		textFieldFirstName.setFont(newFont);
		panel.add(textFieldFirstName);		
//Last Name
		JLabel LastName = new JLabel();
		LastName.setText("Last Name");
		LastName.setBounds(300, 400, 200, 30);
		panel.add(LastName);
		LastName.setFont(newFont);

		textFieldLastName.setBounds(550, 400, 200, 30);
		textFieldLastName.setFont(newFont);
		panel.add(textFieldLastName);		
//Blood Group
		JLabel BG = new JLabel();
		BG.setText("Blood Group");
		BG.setBounds(300, 450, 200, 30);
		panel.add(BG);
		BG.setFont(newFont);
		
		textFieldBG.setBounds(550, 450, 200, 30);
		textFieldBG.setFont(newFont);
		panel.add(textFieldBG);		
//Age
		JLabel Age = new JLabel();
		Age.setText("Age");
		Age.setBounds(300, 500, 200, 30);
		panel.add(Age);
		Age.setFont(newFont);
		
		textFieldAge.setBounds(550, 500, 200, 30);
		textFieldAge.setFont(newFont);
		panel.add(textFieldAge);
//Gender
		JLabel Gender = new JLabel();
		Gender.setText("Gender");
		Gender.setBounds(300, 550, 200, 30);
		panel.add(Gender);
		Gender.setFont(newFont);
//		JTextField textFieldGender = new JTextField(15);
//		textFieldGender.setBounds(550, 550, 200, 30);
//		textFieldGender.setFont(newFont);
//		panel.add(textFieldGender);


		list.setBounds(550, 550, 200, 30);
		list.setFont(newFont);
		panel.add(list);
//UserName
		JLabel UserName = new JLabel();
		UserName.setText("Username");
		UserName.setBounds(300, 600, 200, 30);
		panel.add(UserName);
		UserName.setFont(newFont);
		
		textFieldUserName.setBounds(550, 600, 200, 30);
		textFieldUserName.setFont(newFont);
		panel.add(textFieldUserName);
//Password
		JLabel Password = new JLabel();
		Password.setText("Password");
		Password.setBounds(300, 650, 200, 30);
		panel.add(Password);
		Password.setFont(newFont);
		
		textFieldPassword.setBounds(550, 650, 200, 30);
		textFieldPassword.setFont(newFont);
		panel.add(textFieldPassword);
//Re-Enter Password
		JLabel RPassword = new JLabel();
		RPassword.setText("Re-enter Password");
		RPassword.setBounds(300, 700, 200, 30);
		panel.add(RPassword);
		RPassword.setFont(newFont);
	
		textFieldRPassword.setBounds(550, 700, 200, 30);
		textFieldRPassword.setFont(newFont);
		panel.add(textFieldRPassword);
//Phone Number
		JLabel phoneNum = new JLabel();
		phoneNum.setText("Phone Number");
		phoneNum.setBounds(300, 750, 200, 30);
		panel.add(phoneNum);
		phoneNum.setFont(newFont);

		textFieldphoneNum.setBounds(550, 750, 200, 30);
		textFieldphoneNum.setFont(newFont);
		panel.add(textFieldphoneNum);
//Address
		JLabel address = new JLabel();
		address.setText("Address");
		address.setBounds(300, 800, 200, 30);
		panel.add(address);
		address.setFont(newFont);
		
		textFieldAddress.setBounds(550, 800, 250, 50);
		textFieldAddress.setFont(newFont);
		panel.add(textFieldAddress);

		// Patient Check Box

		checkboxpatient.setBounds(250, 300, 200, 30);
		checkboxpatient.setFont(newFont);
		panel.add(checkboxpatient);

		// Doctor Check Box

		checkboxdoctor.setBounds(450, 300, 200, 30);
		checkboxdoctor.setFont(newFont);
		panel.add(checkboxdoctor);
		
		// Clerk Check Box
		checkboxclerk = new JCheckBox("Clerk");
		checkboxclerk.setBounds(650, 300, 200, 30);
		checkboxclerk.setFont(newFont);
		panel.add(checkboxclerk);
		
		// Terms Check Box
		JCheckBox checkboxterms = new JCheckBox("I agree to the terms and conditions");
		checkboxterms.setBounds(50, 875, 400, 30);
		checkboxterms.setFont(newFont);
		panel.add(checkboxterms);
		
		CreatebuttonP = new JButton("Create Profile");
		CreatebuttonP.setBounds(550, 875, 200, 30);
		CreatebuttonP.setFont(newFont);
		panel.add(CreatebuttonP);
		CreatebuttonP.addActionListener(this);
		f.setVisible(true);
		
		
	}
	
	public void loginPage()
	{
		f = new JFrame("MyHealth");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
		panel=new JPanel();
		panel.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
		//GroupLayout layout = new GroupLayout( panel );
		panel.setLayout( null );
	    //layout.setAutoCreateGaps( true );
		f.add(panel);
		JLabel label = new JLabel();
		Image background = new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
		Image scaledImage = background.getScaledInstance(1000, 400,Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(scaledImage));
		label.setBounds(0, 0, 1000, 300);
		panel.add(label);
		
		jlabelusrname = new JLabel();
		jlabelusrname.setText("Enter User Name");
		jlabelusrname.setBounds(300, 400, 200, 30);
		Font currentFont = jlabelusrname.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		jlabelusrname.setFont(newFont);
		panel.add(jlabelusrname);
		
		textFieldusrname = new JTextField(15);
		textFieldusrname.setBounds(550, 400, 200, 30);
		textFieldusrname.setFont(newFont);
		panel.add(textFieldusrname);
		
		jlabelpsswrd = new JLabel();
		jlabelpsswrd.setText("Enter Password");
		jlabelpsswrd.setBounds(300, 500, 200, 30);
		jlabelpsswrd.setFont(newFont);
		panel.add(jlabelpsswrd);
		
		jlabelmsg = new JLabel();
		jlabelmsg.setText("Sign in to Continue to MyHealth Services");
		jlabelmsg.setBounds(350, 350, 400, 30);
		jlabelmsg.setFont(newFont);
		panel.add(jlabelmsg);

		textFieldpsswrd = new JPasswordField(15);
		textFieldpsswrd.setBounds(550, 500, 200, 30);
		textFieldpsswrd.setFont(newFont);
		panel.add(textFieldpsswrd);
		
		
		Loginbutton = new JButton("Login");
		Loginbutton.setBounds(300, 600, 200, 30);
		Loginbutton.setFont(newFont);
		panel.add(Loginbutton);
		
		
		Createbutton = new JButton("Create Profile");
		Createbutton.setBounds(550, 600, 200, 30);
		Createbutton.setFont(newFont);
		panel.add(Createbutton);
		
		
		Forgotbutton = new JButton("Forgot Password?");
		Forgotbutton.setBounds(550, 700, 250, 30);
		Forgotbutton.setFont(newFont);
		panel.add(Forgotbutton);   
		Createbutton.addActionListener(this);
		Loginbutton.addActionListener(this);
		f.setVisible(true);
	}	
	public GUI(){
		
		this.loginPage();
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == Createbutton){
			
			f.dispose();
			this.createProfileGui();
			
		}
		if(ae.getSource() == Logout){
			
			f.dispose();
			this.loginPage();
			
		}
		if(ae.getSource() == viewAppt){
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			int noAppts = 0;
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Appointment> result = (List<Appointment>) session.createQuery("from Appointment").list();
			session.close();
			sessionFactory.close();	
			DBHandler Db = new DBHandler();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getDOCID() == CurrentID)
				{
					noAppts = 1;
					String S = "Appointment with Patient: " + Db.getpatientbyid(result.get(i).getPatientID()) + " on " + result.get(i).AppointmentDetails ;
					JOptionPane.showMessageDialog(f,S);
		
				}
				if(result.get(i).getPatientID() == CurrentID)
				{
					noAppts = 1;
					String S = "Appointment with Doctor: " + Db.getdoctorbyid(result.get(i).getDOCID()) + " on " + result.get(i).AppointmentDetails ;
					JOptionPane.showMessageDialog(f,S);
				}
			}
			if(noAppts == 0)
			{
				noAppts = 1;
				JOptionPane.showMessageDialog(f,"You have no appointments");
			}
	
			
		}
		if(ae.getSource() == PayBill){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			int cardValid = 0;
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<CreditCards> result = (List<CreditCards>) session.createQuery("from CreditCards").list();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getCardNum().equals(textFieldcardNum.getText()))
				{
					cardValid = 1;
					break;
				}
			}	
			if(cardValid == 1 )
			{	
				System.out.println("Match ");
				String Ses = "update Bills set BPaid = 'Yes' " + "where BillId = " + billId;
				@SuppressWarnings("rawtypes")
				Query query = session.createQuery(Ses);
				query.executeUpdate();	
				String Ses2 = "update Bills set BStatus = 'Bills Paid' " + "where BillId = " + billId;
				@SuppressWarnings("rawtypes")
				Query query2 = session.createQuery(Ses2);
				query2.executeUpdate();
				JOptionPane.showMessageDialog(jbill,"Thank You for the Payment");
				jbill.dispose();
				

			}
			if(cardValid == 0)
			{
				JOptionPane.showMessageDialog(jbill,"Invalid Card Details");
				jbill.dispose();
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();	
			
		}
		if(ae.getSource() == viewBill){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Bills> result = (List<Bills>) session.createQuery("from Bills").list();
			int match = 0;
			String S;
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getBPatId() == (CurrentID))
				{
					
					
					if(result.get(i).getBApproval().equals("Approved") && result.get(i).getBPaid().equals("No") )
					{
						match = 1;
						S = "Amount " + result.get(i).getBAmount() + " for test: " + result.get(i).getTestType() + " pending for Payment" ;
						int n = JOptionPane.showConfirmDialog(
							    f, S,"Pay Now??", 
							    JOptionPane.YES_NO_OPTION);
						System.out.println(n);
						if(n == 0)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							jbill = new JFrame("Payment Page");
							jbill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jbill.setSize(600, 600);
							JPanel panelbill = new JPanel();
							panelbill.setBorder( BorderFactory.createEmptyBorder( 10, 10, 10, 10 ) );
							//GroupLayout layout = new GroupLayout( panel );
							panelbill.setLayout( null );
							jbill.add(panelbill);
							JLabel JcardNum = new JLabel();
							JcardNum.setText("Enter Card Number");
							JcardNum.setBounds(10, 100, 200, 30);
							JcardNum.setFont(newFont);
							panelbill.add(JcardNum); 
							textFieldcardNum = new JTextField(15);
							textFieldcardNum.setBounds(350, 100, 200, 30);
							textFieldcardNum.setFont(newFont);
							panelbill.add(textFieldcardNum);
							
							JLabel JcardName = new JLabel();
							JcardName.setText("Enter Name on Card");
							JcardName.setBounds(10, 200, 200, 30);
							JcardName.setFont(newFont);
							panelbill.add(JcardName); 
							JTextField textFieldcardName = new JTextField(15);
							textFieldcardName.setBounds(350, 200, 200, 30);
							textFieldcardName.setFont(newFont);
							panelbill.add(textFieldcardName);
							
							JLabel Jcardcvv = new JLabel();
							Jcardcvv.setText("CVV");
							Jcardcvv.setBounds(10, 300, 200, 30);
							Jcardcvv.setFont(newFont);
							panelbill.add(Jcardcvv); 
							JTextField textFieldcardcvv = new JTextField(15);
							textFieldcardcvv.setBounds(350, 300, 200, 30);
							textFieldcardcvv.setFont(newFont);
							panelbill.add(textFieldcardcvv);
							
							JLabel Jcardexpiry = new JLabel();
							Jcardexpiry.setText("Card Expiry Date");
							Jcardexpiry.setBounds(10, 400, 200, 30);
							Jcardexpiry.setFont(newFont);
							panelbill.add(Jcardexpiry); 
							JTextField textFieldcardexpiry = new JTextField(15);
							textFieldcardexpiry.setBounds(350, 400, 200, 30);
							textFieldcardexpiry.setFont(newFont);
							panelbill.add(textFieldcardexpiry);
							PayBill = new JButton("Pay Bill");
							PayBill.setBounds(250, 500, 200, 30);
							PayBill.setFont(newFont);
							PayBill.addActionListener(this);
							panelbill.add(PayBill);
							jbill.setVisible(true);
							billId = i+1;
//							tx.commit();
							
						}
						else if(n == 1)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							String Ses = "update Bills set BApproval = 'Denied' " + "where BillId = " + (i+1);
							@SuppressWarnings("rawtypes")
							Query query = session.createQuery(Ses);
							query.executeUpdate();
							
//							tx.commit();
							
						}
						
					}
					
					

					//break;
					
				}
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();	
			if(match ==0)
			{
				JOptionPane.showMessageDialog(f,"You have no Pending Bills");
			}
			
		}
		if(ae.getSource() == Approvebill){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Bills> result = (List<Bills>) session.createQuery("from Bills").list();
			int match = 0;
			String S;
			DBHandler Db = new DBHandler();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getBDocId() == (CurrentID))
				{
					match = 1;
					
					if(result.get(i).getBApproval().equals("No"))
					{
						S = "Amount " + result.get(i).getBAmount() + " for Patient: " + Db.getpatientbyid(result.get(i).getBPatId()) + " pending for Approval" ;
						int n = JOptionPane.showConfirmDialog(
							    f, S,"Approve?", 
							    JOptionPane.YES_NO_OPTION);
						System.out.println(n);
						if(n == 0)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							String Ses = "update Bills set BApproval = 'Approved' " + "where BillId = " + (i+1);
							@SuppressWarnings("rawtypes")
							Query query = session.createQuery(Ses);
							query.executeUpdate();							
//							tx.commit();
							
						}
						else if(n == 1)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							String Ses = "update Bills set BApproval = 'Denied' " + "where BillId = " + (i+1);
							@SuppressWarnings("rawtypes")
							Query query = session.createQuery(Ses);
							query.executeUpdate();
							
//							tx.commit();
							
						}
						
					}
					
					

					//break;
					
				}
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();	

			
			
		}
		if(ae.getSource() == subres){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Records result = new Records();
			result.setRApproval("NA");
			result.setRDocId(Integer.parseInt(textFieldDocIDinput.getText()));
			result.setRPatId(Integer.parseInt(textFieldPatIDinput.getText()));
			result.setRType("Results");
			result.setRtestname(testlist.getSelectedItem().toString());
			result.setStatus("Results Uploaded");
			session.save(result);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
		if(ae.getSource() == subbill){
			Double Amount = new Double("20.75f");
			DecimalFormat df =new DecimalFormat("#.##");
			Amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount"));
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Bills bills = new Bills();
			bills.setBApproval("No");
			bills.setBDocId(Integer.parseInt(textFieldDocIDinput.getText()));
			bills.setBPatId(Integer.parseInt(textFieldPatIDinput.getText()));
			bills.setTestType(testlist.getSelectedItem().toString());
			bills.setBStatus("Bills Uploaded");
			bills.setBPaid("No");
			bills.setBAmount(Double.parseDouble(df.format(Amount)));
			session.save(bills);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
		
		if(ae.getSource() == Approve){
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Records> result = (List<Records>) session.createQuery("from Records").list();
			int match = 0;
			String S;
			DBHandler Db = new DBHandler();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getRDocId() == (CurrentID))
				{
					match = 1;
					S = result.get(i).getRType() + ":" + result.get(i).getRtestname() + " " + result.get(i).getStatus() + " for Patient " + Db.getpatientbyid(result.get(i).getRPatId()) ;
					if(result.get(i).getRApproval().equals("No"))
					{
						int n = JOptionPane.showConfirmDialog(
							    f, S,"Approve?", 
							    JOptionPane.YES_NO_OPTION);
						System.out.println(n);
						if(n == 0)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							String Ses = "update Records set RApproval = 'Yes' " + "where RecordId = " + (i+1);
							Query query = session.createQuery(Ses);
							query.executeUpdate();
							Ses = "update Records set Status = 'Approved' " + "where RecordId = " + (i+1);
							query = session.createQuery(Ses);
							query.executeUpdate();
							
//							tx.commit();
							
						}
						else if(n == 1)
						{
							//result.get(i).setRApproval("Yes");
							//session.update(result.get(i));
//							Transaction tx = session.beginTransaction();
							String Ses = "update Records set RApproval = 'No' " + "where RecordId = " + (i+1);
							Query query = session.createQuery(Ses);
							query.executeUpdate();
							Ses = "update Records set Status = 'Denied' " + "where RecordId = " + (i+1);
							query = session.createQuery(Ses);
							query.executeUpdate();
							
//							tx.commit();
							
						}
						
					}
					//break;
					
				}
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();	

			 			
		}

		else if(ae.getSource() == viewMessages){
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Records> result = (List<Records>) session.createQuery("from Records").list();
			session.close();
			sessionFactory.close();
			int match =0;
			String S;
			DBHandler Db = new DBHandler();
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getRPatId()== (CurrentID))
				{
					match = 1;
					S = result.get(i).getRType() + ":" + result.get(i).getRtestname() + " " + result.get(i).getStatus() ;
					JOptionPane.showMessageDialog(f,S);
					
					//break;
					
				}
			}
			
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getRDocId()== (CurrentID))
				{
					match = 1;
					S = result.get(i).getRType() + ":" + result.get(i).getRtestname() + " " + result.get(i).getStatus() + " for Patient " + Db.getpatientbyid(result.get(i).getRPatId()) ;
					JOptionPane.showMessageDialog(f,S);

					//break;
					
				}
			}
		
			if(match == 0)
			{
				JOptionPane.showMessageDialog(f,"You have No Messages");
			}
			
		}
		
		else if(ae.getSource() == ReqTest){
			
			DocSearch = new JLabel();
			DocSearch.setText("Enter the Doctor name");
			DocSearch.setBounds(300, 450, 250, 25);
			Font currentFont = DocSearch.getFont();
			newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
			panel.add(DocSearch);
			DocSearch.setFont(newFont);		
			textFieldDocName.setBounds(550, 450, 200, 30);
			textFieldDocName.setFont(newFont);
			panel.add(textFieldDocName);
			selectTest = new JButton("Select Test");
			selectTest.setBounds(550,600, 200,30);
			selectTest.setFont(newFont);
			panel.add(selectTest);
			JLabel tests = new JLabel();
			tests.setText("Test Options");
			tests.setBounds(300, 550, 200, 30);
			panel.add(tests);
			tests.setFont(newFont);
			testlist.setBounds(550, 550, 200, 30);
			testlist.setFont(newFont);
			panel.add(testlist);
			f.setVisible(true);
			selectTest.addActionListener(this);
			
			
		}
		else if(ae.getSource() == selectTest){
			Records R = new Records();
			String docinput=textFieldDocName.getText();
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Doctor> result = (List<Doctor>) session.createQuery("from Doctor").list();

			int match = 0;
		
			for(int i = 0; i< result.size();i++)
			{
				if(result.get(i).getFirstname().equals(docinput))
				{
					match = 1;
					System.out.println("Doctor Found");
					R.setRDocId(result.get(i).getDocId());
					R.setRPatId(CurrentID);
					R.setRType("Test");
					R.setRApproval("No");
					R.setStatus("Pending for Approval");
					R.setRtestname(testlist.getSelectedItem().toString());
					session.save(R);
//					Appt.setDOCID(result.get(i).getDocId());
//					this.updateView(Appt.getDOCID(), Appt.getPatientID());
					break;
					
				}
			}
			session.close();
			sessionFactory.close();
			if(match == 0)
			{
				JOptionPane.showMessageDialog(f,"No entry Found");
			}

			
		}
		else if(ae.getSource() == Appointment){
			
			System.out.println("wdgjwahyugwyqgdvjkabd");
			AppointmentGui Ap = new AppointmentGui();
			Ap.appointmentGui(CurrentID);

			
		}
		else if(ae.getSource() == sch){
			
			System.out.println("djskfkdhfk");
			Schedule sc = new Schedule( );
			sc.scheduleGui(CurrentID);
			
		}
		
		else if(ae.getSource() == CreatebuttonP){
			
			//f.dispose();
			
			String Type= "Unknown";
			Person P;
			if(checkboxpatient.isSelected())
			{
				Type = "Patient";
				P = new Patient();
				library.add(P);
				P.setFirstname(textFieldFirstName.getText());
				P.setLastname(textFieldLastName.getText());
				P.setAge(textFieldAge.getText());
				P.setLocation(textFieldAddress.getText());
				P.setPhoneNo(textFieldphoneNum.getText());
				//P.setSecurityAnswer(securityAnswer);
				P.setGender(list.getSelectedItem().toString());
				System.out.println(P.getGender());
				System.out.println(P.getFirstname());
			}
			else if(checkboxdoctor.isSelected())
			{
				Type = "Doctor";
				P = new Doctor();
				library.add(P);
				P.setSpecialization((JOptionPane.showInputDialog("Enter Specialization")));
				P.setFirstname(textFieldFirstName.getText());
				P.setLastname(textFieldLastName.getText());
				P.setAge(textFieldAge.getText());
				P.setLocation(textFieldAddress.getText());
				P.setPhoneNo(textFieldphoneNum.getText());
				//P.setSecurityAnswer(securityAnswer);
				P.setGender(list.getSelectedItem().toString());
				System.out.println(P.getGender());
				System.out.println(P.getFirstname());
			}
			else if(checkboxclerk.isSelected())
			{
				Type = "Clerk";
				P = new Clerk();
				library.add(P);
				P.setFirstname(textFieldFirstName.getText());
				P.setLastname(textFieldLastName.getText());
				P.setAge(textFieldAge.getText());
				P.setLocation(textFieldAddress.getText());
				P.setPhoneNo(textFieldphoneNum.getText());
				//P.setSecurityAnswer(securityAnswer);
				P.setGender(list.getSelectedItem().toString());
				System.out.println(P.getGender());
				System.out.println(P.getFirstname());
			}
			Profile Pr = new Profile();
			Pr.setUsername_input(textFieldUserName.getText());
			Pr.setPassword_input(textFieldPassword.getText());
			Pr.setUsertype(Type);
//Test if working
			
			System.out.println(Pr.getUsername_input());
			System.out.println(Pr.getPassword_input());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for(int i =0; i< library.size();i++)
			{
				session.save(library.get(i));
			}
			session.save(Pr);
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			f.dispose();
			//this.createProfileGui();
			this.HomePageGui(Pr.getProfileID(), Type );
			
		}
		
		else if (ae.getSource() == Loginbutton){
			
			String usrname=textFieldusrname.getText();
			String psswrd=textFieldpsswrd.getText();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Profile> result = (List<Profile>) session.createQuery("from Profile").list();
			int match =0;
			for(int i =0; i< result.size();i++)
			{
				if(result.get(i).getUsername_input().equals(usrname))
				{
					match = 1;
					if(result.get(i).getPassword_input().equals(psswrd))
					{
						f.dispose();
						//this.createProfileGui();
						
						this.HomePageGui(result.get(i).getProfileID(),result.get(i).getUsertype());
						System.out.println("Welcome to MyHealth");
					}
					else
					{
						JOptionPane.showMessageDialog(f,"Invalid Username and Password");
						System.out.println("Error1");
					}
					
				}
			}	
				if(match == 0)
				{
					System.out.println("Error2");
					JOptionPane.showMessageDialog(f,"Invalid Username and Password");
				}
			
			
		}
	   
    }
}