package com.akshay.app;
//get/retrieve  all product record from db and and display it

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.akshay.entity.Product;
import com.akshay.util.HBUtil;

public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        // get the session factory and session object
    	SessionFactory factory = HBUtil.getSessionFactory();
    	Session session  = HBUtil.getSession();
    	
    	try(factory;session){
    		// for all data retrieve use HQL/JPQL support - one query object represent db record , to process it list is used
    		
    		// approach 1: 
//    		Query query = session.createQuery("from Product"); 
//    		List<Product> allProductData = query.list();
//    		// display all product data
//    		allProductData.forEach(System.out::println);
//    		System.out.println("---------------------------");    		
//    		
    		/**
    		 * for get only one record  - below will only execute if only one record in db table other throws exception
    		 * need to type cast . 
    		 */
//    		Product prod = (Product) query.getSingleResult();
//    		System.out.println("---------------------------");
    		
    		// OR 
//    		Product prod = (Product)query.getSingleResultOrNull();
//    		System.out.println(prod);
//    		System.out.println("---------------------------"); 
    		
    		// approach 2:
//    		Query<Product> result = session.createQuery("from Product");
//    		List<Product> list = result.list();
//    		list.forEach(System.out::println);
    		
    		/** above to version are not a good practice 
    		 * Query result = session.createQuery("from Product");  -> this is deprecate now (older style version 4.x and 5.x)
    		 * && Query<Product> result = session.createQuery("from Product"); // this is type safe but half 
    		 * correct and modern version (hibernate version 6.5.x (above )and latest)
    		 *  */
    		
    		// approach 3:
//    		Query<Product> result = session.createQuery("from Product",Product.class);
//    		List<Product> list = result.getResultList();
//    		list.forEach(System.out::println);
    		
    		// OR
//    		Query<Product> query = session.createQuery("from Product",Product.class);
//    		List<Product> list = query.list();
//    		list.forEach(System.out::println);
    		
    		// OR ( more good way directly work with list instead of separated line, single line code - BEST PRACITICE)
    		List<Product> listOfProduct = session.createQuery("from Product",Product.class)
    				                      .getResultList();
    		listOfProduct.forEach(System.out::println);
    		
    		/** 
    		 * Approach 3 : (Best practice) code is is modern day style , type safe with generic 
    		 * with older approach ( version 4.x and 5.x) compiler doesn't know what the "Query" object hold / 
    		 * query returns ( not type safe) , but the with generic compiler know what query object holds ( exactly which class )
    		 */
    		
    		/**
    		 * list() vs getResultList() 
    		 * -> both result list object holding one or other entities class object i.e List<Product> 
    		 * -> list() is Hibernate specific api method - means portable among multiple ORM software
    		 * -> getResultList() is JPA specified method means portable among Different ORM software ( standard JPA )
    		 * -> working wise same 
    		 */
    	}
    	catch(HibernateException e) {
    		e.printStackTrace();
    	}
    }
}
