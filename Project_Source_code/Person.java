import javax.persistence.Column;
//import javax.annotation.Generated;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	@Column(name="FirstName")
	String firstname;
	String lastname;
	String age;
	String gender;
	String phoneNo;
	String location;
	String securityAnswer;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
}
