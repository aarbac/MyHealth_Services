
public class Student extends Person
{
	private double gpa;
	
	public Student() //no return type for constructors
	{
		gpa = 0;
	}
	
	//Overloading is in the same class, Overriding is in different classes
	public Student(String name, int fav_number, double gpa)
	{
		//Private members of parent class are not visible to child classes
		super(name, fav_number);
		this.gpa = gpa;
	}
	
	public String getPhonenumber()
	{
		return "303-000-6789";
	}

	public double getGpa() 
	{
		return gpa;
	}

	public void setGpa(double gpa) 
	{
		this.gpa = gpa;
	}
}
