import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHandler {
	
	public String getdoctorbyid(int _docId)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//int docfound = 0;
		String S = "No Match";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Doctor> result = (List<Doctor>) session.createQuery("from Doctor").list();
		for(int i = 0; i< result.size();i++)
		{
			if(result.get(i).getDocId() == _docId)
			{
				//docfound = 1;
				S = result.get(i).getFirstname() + " " + result.get(i).getLastname();
				
				
			}
		}
		
		return S;
	}
	
	public String getpatientbyid(int _patId)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//int docfound = 0;
		String S = "No Match";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Patient> result = (List<Patient>) session.createQuery("from Patient").list();
		for(int i = 0; i< result.size();i++)
		{
			if(result.get(i).getPersonId() == _patId)
			{
				//docfound = 1;
				S = result.get(i).getFirstname() + " " + result.get(i).getLastname();
				
				
			}
		}
		
		return S;
	}

}
