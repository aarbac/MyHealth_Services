
public class StaticExample 
{
	public static void main(String[] args) 
	{
		Mcd baseline = new Mcd("Baseline");
		Mcd twenty8 = new Mcd("Twenty Eight (28th)");
		Mcd DIA = new Mcd("DIA");
		
		baseline.sold_one();
		baseline.sold_one();
		DIA.sold_one();
	
		System.out.println(Mcd.num_sold);
		System.out.println(DIA.num_sold);
	}

}
