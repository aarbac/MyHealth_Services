import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoginInfo")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ProfileID;
	@Column(name = "Username")
	private String username_input;
	@Column(name = "Password")
	private String password_input;
	
	public String getUsername_input() {
		return username_input;
	}
	public void setUsername_input(String username_input) {
		this.username_input = username_input;
	}
	public String getPassword_input() {
		return password_input;
	}
	public void setPassword_input(String password_input) {
		this.password_input = password_input;
	}
	public int checkValidity(String _username_input, String _password_input)
	{
		return 1;
	
	}
	
	public int login(String _username_input, String _password_input)
	{
		return 1;
	}
	
	public void createProfile(Person P)
	{
		
	}
}
