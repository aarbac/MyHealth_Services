
public class Driver {

	public static void main(String[] args) 
	{
		//Person aaresh = new Person ("Aaresh Bachana", 5);
		//System.out.println(aaresh.getName());
		//System.out.println(aaresh);
		
		Faculty liz = new Faculty();
		//liz.printPhonenumber();
		
		Student CookieMonster = new Student("Cookie Monster", 5, 3.0);
		System.out.println(CookieMonster.getName());
		System.out.println(CookieMonster);
		
		Person[] people = new Person[3];
		people[0] = liz;
		people[1] = CookieMonster;
		people[2] = new Student("Sassy", 21, 3.97);
		
		for(int i = 0; i < people.length; i++)
		{
			System.out.println(people[i].getName());
			
			if(people[i] instanceof Student) //can be used to check whether it is an instance of a certain class
			{
				Student s = (Student) people[i];
				System.out.println(s.getGpa());
			}
		}
		
		Faculty Tim = new Faculty();
		
		Grader[] graders = new Grader[2];
		graders[0] = liz;
		graders[1] = Tim;
	}

}
