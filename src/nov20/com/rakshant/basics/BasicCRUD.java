package nov20.com.rakshant.basics;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BasicCRUD {

	public static void main(String[] args) {

		Configuration configure = new Configuration();
		configure.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();

		// Create-
		Session session = sessionFactory.openSession();
		Transaction transact = session.beginTransaction();
		Student student = new Student("Alex", 9525212);
		session.save(student);
		System.out.println("Saved");
		transact.commit();

		// Update-
		student = session.load(Student.class, student.getId());
		student.setRollNo(1212);
		session.beginTransaction().commit();

		// Read-
		Query query_1 = session.createQuery("from Student");
		List<Student> results = query_1.list();
		Iterator<Student> iterator = results.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getId()+"\t");
			System.out.print(iterator.next().getName()+"\t");
			System.out.println(iterator.next().getRollNo());
			System.out.println("--------------------");
		}
		session.beginTransaction().commit();

		// delete-

		student = session.load(Student.class, student.getId());
		session.delete(student);
		session.beginTransaction().commit();

	}

}
