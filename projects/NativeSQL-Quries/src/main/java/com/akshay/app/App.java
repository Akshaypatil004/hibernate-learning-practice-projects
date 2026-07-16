package com.akshay.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.akshay.entity.Product;
import com.akshay.util.HBUtil;

import jakarta.persistence.NamedNativeQueries;

/**
 * Native SQL queries 
 * - Fetch all records of product table using Native SQL queries
 * - Fetch specific multiple/single column record ( scaler queries ) 
 * - Fetch all record using Named Native Sql queries 
 */
public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	// get the session object
    	try(Session session = HBUtil.getSession()){
    		/**
    		 * if native sql query fetching all db table record then mapping it entity class recommend
    		 * otherwise it will object class object[] ;
    		 * ex- 
    		 * NativeQuery nativeQuery = session.createNativeQuery("SELECT * FROM PRODUCT");
    		   List<Object[]> resultList = nativeQuery.getResultList();
	    		   resultList.forEach(row -> {
	    			for(Object val : row) {
	    				System.out.print(val + " ");
	    			}
	    			System.out.println();
    		   });
    		 * Which not type safed prefer mapping with entity class when all record fetching 
    		 */
    		// create native sql query to fetch all record 
    		NativeQuery<Product> query = session.createNativeQuery("SELECT * FROM PRODUCT", Product.class);
    		List<Product> resultList = query.getResultList();
    		resultList.forEach(System.out::println);
    		System.out.println("----------------------------------------------------------------------------\n");
    		
    		
    		// Scalar queries - fetching specific column values 
    		//crate scaler queries
    		NativeQuery<Object[]> nativeQuery = session.createNativeQuery("SELECT PNAME,PRICE FROM PRODUCT WHERE PRICE >= :price");
    		// set parameter
    		nativeQuery.setParameter("price", 50000.0);
    		//execute query 
    		List<Object[]> result = nativeQuery.getResultList();
    		result.forEach(row ->{
    			for(Object val : row) {
    				System.out.print(val + " ");
    			}
    			System.out.println();
    		});
    		System.out.println("----------------------------------------------------------------------------\n");
    		
    		// Named Native Sql queries to to fetch all db table record 
    		Query<Product> namedQuery2 = session.createNamedQuery("GET_ALL_PRODUCTS",Product.class);
    		List<Product> resultList2 = namedQuery2.getResultList();
    		resultList2.forEach(System.out::println);

    	}
    	catch(HibernateException e) {
    		e.printStackTrace();
    	}
    }
}
