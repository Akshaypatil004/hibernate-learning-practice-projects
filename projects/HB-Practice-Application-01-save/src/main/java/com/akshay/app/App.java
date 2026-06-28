package com.akshay.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.akshay.entity.Product;

public class App {
	public static void main(String[] args) {
		// bootstrap / activate the hibernate
		Configuration cfgs = new Configuration();
		// pass the cfgs file
		cfgs.configure("com/akshay/cfgs/hibernate.cfg.xml");
		
		// create session factory object using configuration object
		SessionFactory factory = cfgs.buildSessionFactory();
		
		// create session object through factory
		Session session = factory.openSession();
		
		// create Transaction obejct from session object
		Transaction trx = null;
		try {
			// begin transaction
			trx = session.beginTransaction();
			
			// perform object based persistance operation
			// prepare the object
			Product p1 = new Product();
//			p1.setPid(105);
			p1.setPname("mobile");
			p1.setPrice(50000.0f);
			p1.setQty(2);
			
			// persistance operation
			session.save(p1);
			
			trx.commit();
			System.out.println("Object save to database successfully !");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			trx.rollback();
			System.out.println("Object rollback! data is not inserted");
		}
	}

}
