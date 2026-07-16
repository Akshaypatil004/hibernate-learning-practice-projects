package com.akshay.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.Person;
import com.akshay.util.HBUtil;

/**
 * This class represent person operations
 * contain persistence logic and provide result
 */
public class PersonService {
	
	/**
	 * This method persist person into db 
	 * @param person , person to persist(save)
	 * @return Generated ID value after successfully person persist to db otherwise return -1
	 */
	public int addPerson(Person person) {
		// validation
		if(person == null) {
			throw new IllegalArgumentException("ERROR - person cannot null");
		}
		
		Transaction tx = null;
		try(Session session = HBUtil.getSession()){
			
			tx = session.beginTransaction();
			
			session.persist(person);
			
			tx.commit();
			
			return person.getPid(); 
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("ERROR WHILE SAVING PERSON",e);
		}	
	}
	
	/**
	 * This method fetch all person's record from db 
	 * @return all person's record as List collection containing all person's record if record 
	 * are their otherwise return empty list
	 */
	public List<Person> getAllPersonDetails(){
		try(Session session = HBUtil.getSession()){
			return session.createSelectionQuery("from Person",Person.class)
					.getResultList();
		}
		catch(HibernateException e) {
			throw new RuntimeException("ERROR WHILE GETTING ALL PERSON RECORD ",e);
		}	
	}
	
	/**
	 * This method fetch all person's record based on designation
	 * @param val represent designation vale
	 * @return list collection having person record having @param val designation
	 */
	public List<Person> getPersonByDesg(String val){
		try(Session session = HBUtil.getSession()){
			// This HQL query represent how to accept component map property's sub property(specific property)
			// ( main property.sub property)
			return session.createSelectionQuery("from Person where job.desg = :desg",Person.class)
					.setParameter("desg", val)
					.getResultList();
		}
		catch(HibernateException e) {
			throw new RuntimeException("ERROR WHILE GETTING PERSON RECORD ",e);
		}	
	}

}
