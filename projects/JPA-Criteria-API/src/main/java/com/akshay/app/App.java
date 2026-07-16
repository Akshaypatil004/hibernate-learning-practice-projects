package com.akshay.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.akshay.entity.Employee;
import com.akshay.util.HBUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * JPA Criteria API - Bulk Operation
 * - Fetch all record operation
 */
public class App {
    public static void main(String[] args) {
        try(Session session = HBUtil.getSession()){
        	
        // Ex : 1 Fetch all record 
        
        // create CriteriaBuilder object from session object
        	CriteriaBuilder builder = session.getCriteriaBuilder();
        
        // create CriteriaQuery object from CriteriaBuilder object
        	CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        	
        // create Root object specifying the from object from CriteriaQuery object
        	Root<Employee> root = query.from(Employee.class);
        	
        // define select clause
        	query.select(root);
        	
        // create the query object having CriteriaQuery object
        	SelectionQuery<Employee> selectionQuery = session.createSelectionQuery(query);
        	
        // execute the query 
        	List<Employee> resultList = selectionQuery.getResultList();
        
        // process the result
        	resultList.forEach(System.out::println);
        		
        }
        catch(HibernateException e) {
        	e.printStackTrace();
        }
    }
}
