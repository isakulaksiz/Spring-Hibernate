package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		 SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		 Session session = factory.getCurrentSession();
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			System.out.println("session.beginTransaction()");
			
			// save the student object
			System.out.println("Saving the student..."+tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("session.getTransaction().commit()");
			System.out.println("Done!");
			
			
		}
		finally {
			System.out.println("factory.close()");
			//session.flush();
			//session.close();
			factory.close();
		}
	}

}
