package nov20.com.rakshant.onetomanymapping;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyTest {

	public static void main(String[] args) {

		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Create-
		Employees_2 employee_1 = new Employees_2("Alex");
		Employees_2 employee_2 = new Employees_2("John");
		Department dept_1 = new Department("Finance");
		Set<Employees_2> employees = new HashSet<Employees_2>();
		employees.add(employee_1);
		employees.add(employee_2);
		dept_1.setEmployees(employees);
		session.save(dept_1);
		session.beginTransaction().commit();

		// update-
		Department dept_2 = new Department("Finance");
		dept_2 = session.load(Department.class, dept_1.getDeptId());
		dept_2.setDeptName("HR");
		session.beginTransaction().commit();

		// Read-
		Query query = session.createQuery("from Department dept");
		List<Department> results = query.list();
		Iterator<Department> iterator = results.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getDeptId() + "\t");
			System.out.print(iterator.next().getDeptName() + "\t");

			Set<Employees_2> empSet = iterator.next().getEmployees();
			Iterator<Employees_2> itr = empSet.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
			System.out.println("--------------------");
		}

		// Delete-
		dept_2 = session.load(Department.class, dept_1.getDeptId());
		session.delete(dept_2);
		session.beginTransaction().commit();

	}
}
