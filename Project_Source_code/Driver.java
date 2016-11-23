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
//import java.io.IOException;
//import javax.imageio.ImageIO;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();

	}

}

class GUI implements ActionListener {
	
	private JFrame f;
	private JTextField textFieldusrname;
	private JTextField textFieldpsswrd;
	private JLabel jlabelusrname;
	private JLabel jlabelpsswrd;
	private JLabel jlabelmsg;
	private JPanel panel;
	JButton Createbutton;
	JButton Loginbutton;
	JButton Forgotbutton;
	JButton CreatebuttonP;
	JTextField textFieldUserName = new JTextField(15);
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
		JTextField textFieldFirstName = new JTextField(15);
		textFieldFirstName.setBounds(550, 350, 200, 30);
		textFieldFirstName.setFont(newFont);
		panel.add(textFieldFirstName);		
//Last Name
		JLabel LastName = new JLabel();
		LastName.setText("Last Name");
		LastName.setBounds(300, 400, 200, 30);
		panel.add(LastName);
		LastName.setFont(newFont);
		JTextField textFieldLastName = new JTextField(15);
		textFieldLastName.setBounds(550, 400, 200, 30);
		textFieldLastName.setFont(newFont);
		panel.add(textFieldLastName);		
//Blood Group
		JLabel BG = new JLabel();
		BG.setText("Blood Group");
		BG.setBounds(300, 450, 200, 30);
		panel.add(BG);
		BG.setFont(newFont);
		JTextField textFieldBG = new JTextField(15);
		textFieldBG.setBounds(550, 450, 200, 30);
		textFieldBG.setFont(newFont);
		panel.add(textFieldBG);		
//Age
		JLabel Age = new JLabel();
		Age.setText("Age");
		Age.setBounds(300, 500, 200, 30);
		panel.add(Age);
		Age.setFont(newFont);
		JTextField textFieldAge = new JTextField(15);
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
		String[] options = {"Male","Female","Other"};
		JComboBox<String> list = new JComboBox<String>(options);
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
		JTextField textFieldPassword = new JTextField(15);
		textFieldPassword.setBounds(550, 650, 200, 30);
		textFieldPassword.setFont(newFont);
		panel.add(textFieldPassword);
//Re-Enter Password
		JLabel RPassword = new JLabel();
		RPassword.setText("Re-enter Password");
		RPassword.setBounds(300, 700, 200, 30);
		panel.add(RPassword);
		RPassword.setFont(newFont);
		JTextField textFieldRPassword = new JTextField(15);
		textFieldRPassword.setBounds(550, 700, 200, 30);
		textFieldRPassword.setFont(newFont);
		panel.add(textFieldRPassword);
//Phone Number
		JLabel phoneNum = new JLabel();
		phoneNum.setText("Phone Number");
		phoneNum.setBounds(300, 750, 200, 30);
		panel.add(phoneNum);
		phoneNum.setFont(newFont);
		JTextField textFieldphoneNum = new JTextField(15);
		textFieldphoneNum.setBounds(550, 750, 200, 30);
		textFieldphoneNum.setFont(newFont);
		panel.add(textFieldphoneNum);
//Address
		JLabel address = new JLabel();
		address.setText("Address");
		address.setBounds(300, 800, 200, 30);
		panel.add(address);
		address.setFont(newFont);
		JTextField textFieldAddress = new JTextField(50);
		textFieldAddress.setBounds(550, 800, 250, 50);
		textFieldAddress.setFont(newFont);
		panel.add(textFieldAddress);

		// Patient Check Box
		JCheckBox checkboxpatient = new JCheckBox("Patient");
		checkboxpatient.setBounds(250, 300, 200, 30);
		checkboxpatient.setFont(newFont);
		panel.add(checkboxpatient);

		// Doctor Check Box
		JCheckBox checkboxdoctor = new JCheckBox("Doctor");
		checkboxdoctor.setBounds(450, 300, 200, 30);
		checkboxdoctor.setFont(newFont);
		panel.add(checkboxdoctor);
		
		// Clerk Check Box
		JCheckBox checkboxclerk = new JCheckBox("Clerk");
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
		
		f.setVisible(true);
		
	}

	public GUI(){
		
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
		Forgotbutton.setBounds(550, 700, 200, 30);
		Forgotbutton.setFont(newFont);
		panel.add(Forgotbutton);   
		Createbutton.addActionListener(this);
		Loginbutton.addActionListener(this);
		f.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getSource() == Createbutton){
			
			f.dispose();
			this.createProfileGui();
			
		}
		
		else if(ae.getSource() == CreatebuttonP){
			
			f.dispose();
			Person P;
			Profile Pr = new Profile();
			Pr.setUsername_input(textFieldUserName.getText());
			
			
			//this.HomePageGui();
			
		}
		
		else if (ae.getSource() == Loginbutton){
			
			String usrname=textFieldusrname.getText();
			String psswrd=textFieldpsswrd.getText();
			if (usrname.equals("Anish") && psswrd.equals("csci5448")) {
				System.out.println("Welcome to MyHealth");
			  // Profile p=new Profile();
			  // p.show
			   //JLabel label = new JLabel("Welcome:"+value1);
			   //page.getContentPane().add(label);
			}
			else{	
			   System.out.println("enter the valid username and password");
			  // JOptionPane.showMessageDialog(this,"Incorrect login or password",
			   //"Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	   
    }
}