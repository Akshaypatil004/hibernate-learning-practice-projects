package com.akshay.app;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.CardPayment;
import com.akshay.entity.ChequePayment;
import com.akshay.entity.Payment;
import com.akshay.util.HBUtil;

public class App {
    public static void main(String[] args) {
    	Transaction tx = null;
       try(Session session = HBUtil.getSession()){
    	   
    	   System.out.println("**** Save object operation ****");
    	   System.out.println("-".repeat(50));
    	   
    	   // prepare object for save operation
    	   
    	   CardPayment card = new CardPayment(9000.0,LocalDate.of(2026, 7, 15),23456,"credit","visa");
    	   
    	   ChequePayment cheque = new ChequePayment(5000.0,LocalDate.of(2026, 7, 14),1111,"self");
    	
    	  tx = session.beginTransaction();
    	  
    	  session.persist(card);
    	  session.persist(cheque);
    	  
    	  tx.commit();
    	  
    	  System.out.println("Object are save successfully!!");
    	  System.out.println("CardPayment - Generated ID value :: " + card.getTxId());
    	  System.out.println("ChequePayment - Generated ID value :: " + cheque.getTxId());
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** Select object operation ****");
    	  System.out.println("-".repeat(50));
    	  System.out.println("**** CardPayment All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<CardPayment> empList = session.createSelectionQuery("from CardPayment",CardPayment.class)
    	  		 .getResultList();
    	  empList.forEach(System.out::println);
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** ChequePayment All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<ChequePayment> custList = session.createSelectionQuery("from ChequePayment",ChequePayment.class)
    	  		 .getResultList();
    	  custList.forEach(System.out::println);
    	  System.out.println("-".repeat(50));
    	  
    	  System.out.println("**** Payment All records ****");
    	  System.out.println("-".repeat(50));
    	  
    	  List<Payment> perList = session.createSelectionQuery("from Payment",Payment.class)
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
