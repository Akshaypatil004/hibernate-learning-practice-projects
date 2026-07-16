package com.akshay.app;

import java.util.List;
import java.util.Scanner;

import com.akshay.entity.JobDetails;
import com.akshay.entity.Person;
import com.akshay.service.PersonService;
import com.akshay.util.HBUtil;

/**
 * This class represent client 
 */
public class App {
    public static void main(String[] args) {
       Scanner sc  = new Scanner(System.in);
       PersonService service = new PersonService();
       try(sc) {
    	   while(true) {
    		   System.out.println("1. Add person");
    		   System.out.println("2. Get all person record");
    		   System.out.println("3. Get person record based on designation");
    		   System.out.println("4. Exit");
    		   System.out.println("Enter your choice: ");
    		   int choice = sc.nextInt();
    		   sc.nextLine();
    		   
    		   switch(choice) {
    		   case 1:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Add Person");
    			   System.out.println("=".repeat(50));
    			   System.out.println("Enter name: ");
    			   String name = sc.nextLine();
    			   
    			   System.out.println("Enter address: ");
    			   String address = sc.nextLine();
    			   
    			   System.out.println("Enter designation: ");
    			   String desg = sc.nextLine();
    			   
    			   System.out.println("Enter company name: ");
    			   String company = sc.nextLine();
    			   
    			   System.out.println("Enter salary: ");
    			   double salary = sc.nextDouble();
    			   
    			   JobDetails job = new JobDetails(desg,company,salary);
    			   Person person = new Person(name,address,job);
    			   int id = service.addPerson(person);
    			   System.out.println("Person save sucessfully!");
    			   System.out.println("Generated ID : " +id);
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 2:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Get all person record");
    			   System.out.println("=".repeat(50));
    			   
    			   List<Person> allPersonDetails = service.getAllPersonDetails();
    			   allPersonDetails.forEach(System.out::println);
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 3:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Get person record based on designation");
    			   System.out.println("=".repeat(50));
    			   
    			   System.out.println("Enter Designation: ");
    			   desg = sc.nextLine();
    			   
    			   System.out.println(desg + " person records");
    			   System.out.println("-".repeat(50));
    			   List<Person> personByDesg = service.getPersonByDesg(desg);
    			   personByDesg.forEach(System.out::println);
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 4:
    			   return;
    			   
    		   default:
    			   System.err.println("INVALID CHOICE!!");  
    		   }
    	   }
       }
       catch(IllegalArgumentException e) {
    	  System.out.println(e.getLocalizedMessage());
       }
       catch(RuntimeException e) {
    	   System.out.println(e.getLocalizedMessage());
       }
       catch(Exception e) {
    	   System.out.println(e.getLocalizedMessage());
       }
       finally {
    	   HBUtil.shutdown();
       }
    }
}
