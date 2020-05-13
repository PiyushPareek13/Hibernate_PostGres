package starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class FetchingOperation {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Student stu=(Student)session.get(Student.class, 1);
		System.out.println("Id="+stu.getId());
		System.out.println("First Name="+stu.getFname());
		
		Student stu2=(Student)session.load(Student.class, 2);
		System.out.println("ID="+stu2.getId());
		System.out.println("First Name="+stu2.getFname());
		session.close();
		sf.close();
		System.out.println("Transaction Complete");


	}

}
