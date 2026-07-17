package com.akshay.app;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.Person;
import com.akshay.util.HBUtil;


public class App {
    public static void main(String[] args) {
    	Transaction tx = null;
       try(Session session = HBUtil.getSession()){
    	   
    	   tx = session.beginTransaction();
    	   // insert operation in collection mapping
    	   // prepare object 
    	   Person p = new Person("Akshay","Pune",List.of("Akki","AK"),List.of("Shubham","Yash","Vedansh"),Set.of(1234567890L,987654321L),Map.of("Aadhar",123445L,"Voter",67890L));
    	   
    	   // persist object
    	   session.persist(p);
    	   
    	   tx.commit();
    	   
    	   System.out.println("Record saved succssfully!");
    	   System.out.println("Generated ID: " + p.getPid());
    	   System.out.println("-".repeat(50)  + "\n");
    	   
    	   // select operation / fetch record
    	   List<Person> resultList = session.createSelectionQuery("from Person",Person.class).getResultList();
    	   resultList.forEach(per ->{;
    	   System.out.println("PID : " + per.getPid());
    	   System.out.println("NAME : " + per.getPname());
    	   System.out.println("ADDRESS : " + per.getAddress());
		   List<String> nickNames = per.getNickNames();
		   System.out.println("NICKNAMES : " + nickNames.toString());
		   List<String> friends = per.getFriends();
		   System.out.println("FRIENDS : " + friends.toString());
		   Set<Long> contactNumber = per.getContactNumber();
		   System.out.println("CONTACT : " + contactNumber.toString());
		   Map<String, Long> idDetails = per.getIdDetails();
		   System.out.println("ID DETAILS : " + idDetails.toString());
    	   });
    	   
       }
       catch(HibernateException e) {
    	   if(tx!=null) {
    		   tx.rollback();
    	   }
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}
