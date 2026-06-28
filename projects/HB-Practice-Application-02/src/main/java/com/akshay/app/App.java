package com.akshay.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akshay.entity.Employee;

public class App {
    public static void main(String[] args) {
        // bootstrap/activate hibernate
    	Configuration cfg = new Configuration();
    	//pass the hb cfg file location to locate 
    	cfg.configure("com/akshay/cfgs/hibernate.cfg.xml");
    	
    	// create session factory obeject from cfg
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	// create session object from factory
    	Session session = factory.openSession();
    	
    	// create transaction object
    	Transaction trx = null;
    	
    	try {
    		// beging transaction
    		trx = session.beginTransaction();
    		
    		// prepare object for object based persistence operation
    		Employee emp = new Employee();
    		emp.setEname("Akshay");
    		emp.setSalary(100000.0f);
    		emp.setDesg("Developer");
    		
    		// perform persistence operation
    		session.save(emp);
    		
    		trx.commit();
    		
    		System.out.println("Employee data is registration successfull!");
    		
    	}
    	catch(HibernateException e) {
    		e.printStackTrace();
    		trx.rollback();
    		
    	}
    	finally {
    		session.close();
    		factory.close();
    	}
    	
    }
}
