
public class Mcd 
{
	static int num_sold;
	String address;
	
	public Mcd(String _address)
	{
		address = _address;
		num_sold = 0;
	}
	
	public void sold_one()
	{
		num_sold++;
	}
}
