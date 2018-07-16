package nov20.com.rakshant.manytomanymapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyTest {

	public static void main(String[] args) {

		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Create-
		Employee_3 employee_1 = new Employee_3("Alex");
		Employee_3 employee_2 = new Employee_3("John");

		Project project_1 = new Project("Java");

		ArrayList<Employee_3> employee = new ArrayList<Employee_3>();
		employee.add(employee_1);
		employee.add(employee_2);
		project_1.setEmpl(employee);
		session.save(project_1);
		session.beginTransaction().commit();

		// Update-
		Project project_2 = new Project("Java");
		project_2 = session.load(Project.class, project_1.getProjectID());
		project_2.setProjectName("Dot_Net");
		session.beginTransaction().commit();

		// Read-
		Query query = session.createQuery("from Project p");
		List<Project> results = query.list();
		Iterator<Project> iterator = results.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getProjectID() + "\t");
			System.out.print(iterator.next().getProjectName() + "\t");

			List<Employee_3> empSet = iterator.next().getEmpl();
			Iterator<Employee_3> itr = empSet.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next().getEmployeeId());
				System.out.println(itr.next().getName());
			}
			System.out.println("--------------------");
		}

		// delete-
		project_2 = session.load(Project.class, project_1.getProjectID());
		session.delete(project_2);
		session.beginTransaction().commit();

	}
}
