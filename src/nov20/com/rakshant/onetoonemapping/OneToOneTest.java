package nov20.com.rakshant.onetoonemapping;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneTest {

	public static void main(String[] args) {

		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Create-
		Employees employee_1 = new Employees("Alex");
		Profile profile = new Profile("java");
		employee_1.setProfile(profile);
		session.save(employee_1);
		session.beginTransaction().commit();

		// Update-		
		Employees employee_2 = new Employees("Alex");
		employee_2 = session.load(Employees.class,employee_1.getEmployeeId());
		employee_2.setName("John");
		session.beginTransaction().commit();
		
		//Read-		
		Query query = session.createQuery("from Employees emp");
		List<Employees> results = query.list();
		Iterator<Employees> iterator = results.iterator();
		while (iterator.hasNext()) {
			Employees next = iterator.next();
			System.out.print(next.getEmployeeId()+"\t");
			System.out.print(next.getName()+"\t");
			System.out.println(next.getProfile().getExpertize());
			System.out.println("--------------------");
		}
		
		
		//Delete-		
		employee_1 = session.load(Employees.class,employee_1.getEmployeeId());
		session.delete(employee_1);
		session.beginTransaction().commit();
	}
}
