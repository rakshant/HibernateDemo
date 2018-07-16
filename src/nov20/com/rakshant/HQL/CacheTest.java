package nov20.com.rakshant.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheTest {

	public static void main(String[] args) {
		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();

		System.out.println("Total salary of all employees-");

		Employee emp = new Employee();
		Session session_1 = sessionFactory.openSession();
		emp = session_1.load(Employee.class, 1L);
		System.out.println(emp.getName());
		session_1.close();

		Session session_2 = sessionFactory.openSession();
		Employee emp_2 = new Employee();
		emp_2 = session_2.load(Employee.class, 1L);
		System.out.println(emp_2.getName());
		session_2.close();
	}
}
