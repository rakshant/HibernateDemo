package nov20.com.rakshant.HQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmployeeTest {

	public static void main(String[] args) {
		Configuration configure=new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configure.buildSessionFactory();
		
		
		System.out.println("Total salary of all employees-");		
		Session session=sessionFactory.openSession();
		Query query=session.getNamedQuery("totalsalaryofuser");
		List<Double> salarySum = query.list();
		Iterator<Double> iterator_1=salarySum.iterator();
		while(iterator_1.hasNext()){
			System.out.println(iterator_1.next());			
		}
		session.beginTransaction().commit();
		
		
		System.out.println("Average salary of employees-");		
		query=session.getNamedQuery("salaryAavg");
		List<Double> averageSalary = query.list();
		Iterator<Double> iterator_2=averageSalary.iterator();
		while(iterator_2.hasNext()){
			System.out.println(iterator_2.next());			
		}
		session.beginTransaction().commit();
		
		
		System.out.println("Employees ordered by their salary by HQL-");
		query=session.getNamedQuery("orderbysalary");
		List<String> empList = query.list();
		Iterator<String> iterator_3=empList.iterator();
		while(iterator_3.hasNext()){
			System.out.println(iterator_3.next());			
		}
		session.beginTransaction().commit();
		
		
		System.out.println("Employees ordered by their salary by Criteria-");
		Criteria criteria_1 = session.createCriteria(Employee.class);
		criteria_1.addOrder(Order.desc("sal"));
		List<String> empListDesc = criteria_1.list();		
		Iterator<String> iterator_4=empList.iterator();
		while(iterator_4.hasNext()){
			System.out.println(iterator_4.next());			
		}
		session.beginTransaction().commit();
		
		
		
		System.out.println("Employees having salary more than 10,000-");
		Criteria criteria_2 = session.createCriteria(Employee.class);
		criteria_2.add(Restrictions.gt("sal", 2000.0));
		//System.out.println(criteria_2.list());
		List<Employee> empWithHighSalary = criteria_2.list();		
		Iterator<Employee>  iterator_5=empWithHighSalary.iterator();
		while(iterator_5.hasNext()){
			System.out.println(iterator_5.next().getName());			
		}
		session.beginTransaction().commit();
		
		System.out.println("Employees group by city-");
		query=session.getNamedQuery("groupbycity");
		System.out.println(query);
		List<Double> empCity = query.list();
		Iterator<Double> iterator_6=empCity.iterator();
		while(iterator_6.hasNext()){
			System.out.println(iterator_6.next());			
		}
		session.beginTransaction().commit();
		
		
		
		
		
		
		
		
		
	}

}
