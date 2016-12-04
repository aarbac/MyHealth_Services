import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SearchbySpecialty implements SearchStrategy
{
	public int Search(String input)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Doctor> result = (List<Doctor>) session.createQuery("from Doctor").list();
		session.close();
		sessionFactory.close();
		int docfound = 0;
		
		for(int i =0; i< result.size();i++)
		{
			System.out.println("Specialization:" + result.get(i).getSpecialization());
			if(result.get(i).getSpecialization().equals(input))
			{
				System.out.println("Doctor Found");
				docfound = result.get(i).getDocId();
				break;
			}
		}
		
		return docfound;
	}
}
