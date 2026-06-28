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

		// create Transaction obejct from session object
		Transaction trx = null;
		try(SessionFactory factory = cfgs.buildSessionFactory();
				Session session = factory.openSession();) {
			// begin transaction
			trx = session.beginTransaction();

			// perform object based persistance operation
			// prepare the object
			Product p1 = new Product();
			p1.setPname("mobile");
			p1.setPrice(50000.0f);
			p1.setQty(2);

			// persistance operation
			session.save(p1);
			trx.commit();
			System.out.println("object is saved");
		} catch (HibernateException he) {
			he.printStackTrace();
			if(trx!=null && trx.getRollbackOnly() && trx.getStatus() != null) {
				trx.rollback();
				System.out.println("Object is not saved ");
			}
		} 
	}

}
