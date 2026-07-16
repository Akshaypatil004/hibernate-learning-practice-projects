package com.akshay.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.akshay.entity.Product;
import com.akshay.util.HBUtil;

import jakarta.persistence.TypedQuery;

/**
 * ->selecting specific multiple columns values of the db table
 * ->selecting specific single column values of the db table
 */
public class App {
    public static void main(String[] args) {
    	SessionFactory factory = HBUtil.getSessionFactory();
    	Session session = HBUtil.getSession();
    	try(factory;session){
    		
    		// HQL scaler select query ( retrieving  specific multiple column values  )
//    		Query query = session.createQuery("select pid,pname,price from Product where qty=:qty");
//    		query.setParameter("qty", 2);
//    		 List<Object[]> result = query.getResultList();
//    		result.forEach(row ->{
//    			for(Object val : row) {
//    				System.out.println(val + " ");
//    			}
//    		});
    		
    		// above is old style version 4.x ,  5.x not a good practice , not typed safe
    		
    		// OR
//    		Query<Object[]> query = session.createQuery("select pid,pname,price from Product where qty=:qty",Object[].class);
//    		query.setParameter("qty", 2);
//    		 List<Object[]> result = query.getResultList();
//    		result.forEach(row ->{
//    			for(Object val : row) {
//    				System.out.println(val + " ");
//    			}
//    		});
    		
    		
    		//OR -> using TypedQuery<T> and text block for long quries
//    		TypedQuery<Object[]> query =  session.createQuery("""
//											    				select p.pid,p.pname,p.price
//											    				from Product p
//											    				where p.qty = :qty 
//											    				""",Object[].class);
//    		query.setParameter("qty", 2);
//    		List<Object[]> list = query.getResultList();
//    		list.forEach(row -> {
//    			for(Object val : row) {
//    				System.out.print(val + " ");
//    			}
//    			System.out.println();
//    		});
    		
    		// retriving specific single column value
//    		SelectionQuery<String> selectionQuery = session.createSelectionQuery("select p.pname from Product p where p.pid = :id",String.class);
//    		selectionQuery.setParameter("id", 1);
//    		String singleResult = selectionQuery.getSingleResult();
//    		System.out.println(singleResult);
    		// or
//    		List<String> list = selectionQuery.getResultList();
//    		list.forEach(System.out::println);
    		
    		// single aggregate function
    		long selectionQuery = session.createSelectionQuery("select count(*) from Product",Long.class).getSingleResult();
    		System.out.println(selectionQuery);
    	}
    	catch(HibernateException e) {
    		e.printStackTrace();
    	}
    	
    	
       
    }
}
