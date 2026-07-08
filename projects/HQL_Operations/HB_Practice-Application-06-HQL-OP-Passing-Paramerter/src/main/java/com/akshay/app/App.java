package com.akshay.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.akshay.entity.Product;
import com.akshay.util.HBUtil;

// ordinal parameter and name parameter 

public class App {
    public static void main(String[] args) {
    	SessionFactory factory = HBUtil.getSessionFactory();
    	Session session = HBUtil.getSession();
    	
    	try(factory;session){
    		// approach 1: ordinal parameter
//    		// prepare query using ordinal parameter
//    		Query<Product> query = session.createQuery("from Product where pid=?1",Product.class);
//    		// set paarameter
//    		query.setParameter(1, 2);// 1 is this (?1)position and 2 is id ( whose id 2 is fetch)
//    		
//    		// process query
//    		List<Product> list = query.getResultList();
//    		list.forEach(System.out::println);
    		
    		// OR
    		// shorthand - method chaining 
//    		List<Product> list = session.createQuery("from Product where pid=?1",Product.class)
//    				              .setParameter(1, 2)
//    				              .getResultList();
//    		list.forEach(System.out::println);
    		
    		// OR 
    		// as only one id record matching is fetching can use getSingleResult() 
//    		Product p = session.createQuery("from Product where pid=?1",Product.class)
//    					.setParameter(1, 2)
//    					.getSingleResult();
//    		System.out.println(p);
    		
    		// Appraoch 2 : name parameter
    		// prepare query using ordinal parameter
//    		Query<Product> query = session.createQuery("from Product where pid=:id",Product.class);
//    		// set paarameter
//    		query.setParameter("id", 2);// "id" is named parameter 2 is id value which record fetching
//    		
//    		// process query
//    		List<Product> list = query.getResultList();
//    		list.forEach(System.out::println);
    		
    		// OR
    		// shorthand - method chaining 
//    		List<Product> list = session.createQuery("from Product where pid=:id",Product.class)
//    				              .setParameter("id", 2)
//    				              .getResultList();
//    		list.forEach(System.out::println);
    		
       		// OR 
    		// as only one id record matching is fetching can use getSingleResult() 
    		Product p = session.createQuery("from Product where pid=:id",Product.class)
    					.setParameter("id", 2)
    					.getSingleResult();
    		System.out.println(p);	
    				
    	}
    	catch(HibernateException e) {
    		e.printStackTrace();
    	}
        
    }
}
