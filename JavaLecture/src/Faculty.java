
public class Faculty extends Person implements Grader
{
	private String dept;

	public String getDept() 
	{
		return dept;
	}

	public void setDept(String dept) 
	{
		this.dept = dept;
	}
	
	/*
	 * @brief Overriding method because abstract method is in the Parent class
	 */
	public String getPhonenumber()
	{
		return "720-000-1234";
	}
	
	public void printPhonenumber()
	{
		System.out.println("Phone Number: " + this.getPhonenumber());
	}
	
	public double gradeAssignment(String _ques, String _ans)
	{
		return 100.0;
	}
}
