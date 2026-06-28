package com.akshay.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akshay.entity.Student;

public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
     SessionFactory factory = new Configuration()
	  			.configure("com/akshay/cfgs/hibernate.cfg.xml")
	  			.buildSessionFactory();
      Session session = factory.openSession();
      
      Transaction trx = null;
      try(factory;session){
    	  trx = session.beginTransaction();
    	  
    	  Student s = new Student();
    	  s.setName("Yash");
    	  s.setAddress("Vardha");
    	  
    	  Integer generatedIdValue = (Integer)session.save(s);
    	  trx.commit();
    	  System.out.println("Student object save successfully");
    	  System.out.println("Your roll no is: " + generatedIdValue);
      }
      catch(HibernateException e) {
    	  e.printStackTrace();
    	  if(trx != null && trx.getRollbackOnly() && trx.getStatus() != null) {
    		  trx.rollback();
    		  System.out.println("Student object save failed !!!");
    	  }
      }
    }
}
