/**
 * 
 */

/**
 * @author Aaresh Bachana
 */

public abstract class Person 
{
	/**
	 * @param args
	 */
	private String name;
	private int fav_number;
	
	public Person()
	{
		//name = "Aaresh Bachana";
		//fav_number = 7;
		this("unknown", 0);
	}
	
	public Person(String _name, int _fav_number)
	{
		this.name = _name;
		this.fav_number = _fav_number;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getFav_number() 
	{
		return fav_number;
	}

	public void setFav_number(int fav_number) 
	{
		this.fav_number = fav_number;
	}
	
	public String toString()
	{
		return name + " || Favorite Number: " + getFav_number();
	}

	//Abstract method code needs to be implemented in all child classes
	public abstract String getPhonenumber();
}
