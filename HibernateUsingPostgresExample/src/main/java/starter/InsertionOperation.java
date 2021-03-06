package starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class InsertionOperation {

	public static void main(String[] args) {
		Student st1=new Student("Piyush", "Pareek", 10);
		Student st2=new Student("Shivam", "Kumar", 20);
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		//save return type is always primary key
		Integer pk=(Integer) session.save(st1); 
		System.out.println("Pk="+pk);
		
		//persist never gives any pk as return type
		session.persist(st2);
		
		t.commit();
		session.close();
		sf.close();
		System.out.println("Transaction Complete");

	}

}
