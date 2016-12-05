import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBHandler {
	
	public String getdoctorbyid(int _docId)
	{
		String S = "No Match";
		Session session = startsession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Doctor> result = (List<Doctor>) session.createQuery("from Doctor").list();
		for(int i = 0; i< result.size();i++)
		{
			if(result.get(i).getDocId() == _docId)
			{
				S = result.get(i).getFirstname() + " " + result.get(i).getLastname();				
			}
		}
		
		return S;
	}
	
	public String getpatientbyid(int _patId)
	{
		Session session = startsession();
		String S = "No Match";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Patient> result = (List<Patient>) session.createQuery("from Patient").list();
		for(int i = 0; i< result.size();i++)
		{
			if(result.get(i).getPersonId() == _patId)
			{
				S = result.get(i).getFirstname() + " " + result.get(i).getLastname();			
			}
		}
		
		return S;
	}
	
	public Session startsession()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session ses = sessionFactory.openSession();
		ses.beginTransaction();
		return ses;
	}
	public void stopsession(Session ses)
	{
		ses.close();
	}

}
