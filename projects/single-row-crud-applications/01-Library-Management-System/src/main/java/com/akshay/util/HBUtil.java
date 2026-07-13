package com.akshay.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class is a utility class , and singleton class
 */
public final class HBUtil {
	
	private static final SessionFactory FACTORY;
	
	private HBUtil() {}
	
	static {
		try {
			// load hibernate configuration file and build session factory
			FACTORY = new Configuration().configure("com/akshay/cfgs/hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Session getSession() {
		return FACTORY.openSession();
	}
	
	/**
	 * This method close the session factory object
	 */
	public static void shutdown() {
		if(FACTORY != null && !FACTORY.isClosed()) {
			FACTORY.close();
		}
	}

}
