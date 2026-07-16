package com.akshay.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.Customer;
import com.akshay.entity.Employee;
import com.akshay.entity.Person;
import com.akshay.util.HBUtil;

public class App {
    public static void main(String[] args) {
    	Transaction tx = null;
       try(Session session = HBUtil.getSession()){
    	   
    	   System.out.println("**** Save object operation ****");
    	   System.out.println("-".repeat(50));
    	   
    	   // prepare object for save operation
    	   Person per = new Person("Akshay","Google");
    	   
    	   Employee emp = new Employee("Shubham","Google","Analyst",50000.0D,1001);
    	   
    	   Customer cust = new Customer("Yash", "Google", 4000.0, 101);
    	   
    	  tx = session.beginTransaction();
    	  
    	  session.persist(per);
    	  session.persist(emp);
    	  session.persist(cust);
    	  
    	  tx.commit();
    	  
    	  System.out.println("Object are save successfully!!");
    	  System.out.println("Person - Generated ID value :: " + per.getPid());
    	  System.out.println("Employee - Generated ID value :: " + emp.getPid());
    	  System.out.println("Customer - Generated ID value :: " + cust.getPid());
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** Select object operation ****");
    	  System.out.println("-".repeat(50));
    	  System.out.println("**** Employee All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<Employee> empList = session.createSelectionQuery("from Employee",Employee.class)
    	  		 .getResultList();
    	  empList.forEach(System.out::println);
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** Customer All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<Customer> custList = session.createSelectionQuery("from Customer",Customer.class)
    	  		 .getResultList();
    	  custList.forEach(System.out::println);
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** Person All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<Person> perList = session.createSelectionQuery("from Person",Person.class)
    	  		 .getResultList();
    	  perList.forEach(System.out::println);
    	  System.out.println("-".repeat(50));
    	 
       }
       catch(HibernateException e) {
    	   if(tx != null) {
    		   tx.rollback();
    		   System.out.println("ROllBACK");  
    	   }
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
       }
       catch(Exception e) {
    	   System.out.println(e.getMessage());
    	   e.printStackTrace();
       }
       finally {
    	   HBUtil.shutdown();
       }
    }
}
