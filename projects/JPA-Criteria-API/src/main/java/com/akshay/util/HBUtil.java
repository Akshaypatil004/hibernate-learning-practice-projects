package com.akshay.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HBUtil {
	
	private static final SessionFactory factory;
	
	private HBUtil() {}
	
	static {
		factory = new Configuration()
				.configure("com/akshay/cfgs/hibernate.cfg.xml")
				.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession() {
		Session session = null;
		if(factory != null) {
			session = factory.openSession();
		}
		return session;
	}

}
