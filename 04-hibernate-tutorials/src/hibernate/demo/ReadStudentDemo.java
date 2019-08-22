 package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("isa", "kulaksiz", "isa@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			System.out.println("session.beginTransaction()");
			
			// save the student object
			System.out.println("Saving the student..."+tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("session.getTransaction().commit()");
			
			
			
			//My New Code
			
			//find out the student's id: primary key
			System.out.println("Saved student.Generated id: "+tempStudent.getId());
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: "+myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			
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
