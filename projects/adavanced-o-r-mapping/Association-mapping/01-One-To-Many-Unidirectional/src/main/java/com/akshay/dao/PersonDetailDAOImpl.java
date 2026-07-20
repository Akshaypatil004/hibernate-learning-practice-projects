package com.akshay.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.PersonDetails;
import com.akshay.entity.PhoneNumber;
import com.akshay.util.HBUtil;

public class PersonDetailDAOImpl implements IPersonDetailsDAO{

	@Override
	public int saveDataUsingParent(PersonDetails person) {
		Transaction tx = null;
		try(Session session = HBUtil.getSession()){
			
			tx = session.beginTransaction();
			
			session.persist(person);
			
			tx.commit();
			
			return person.getPersonId();
			
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("parent and associated childs save failed !!",e);
		}
	}

	@Override
	public void loadDataUsingParent() {
		
		try(Session session = HBUtil.getSession()){
			List<PersonDetails> dataUsingParent = session.createSelectionQuery("from PersonDetails",PersonDetails.class)
					.getResultList();
			
			dataUsingParent.forEach(parent ->{
				System.out.println("Parent :: " + parent);
				Set<PhoneNumber> childs = parent.getPhoneNumbers();
				System.out.println("childs count :: " + childs.size());
				childs.forEach(child ->{
					System.out.println("Child ::" + child);
				});
				System.out.println("....................");
			});
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
			throw new RuntimeException("failed to load data using parent ",e);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("failed to load data using parent ",e);
		}
	}

	@Override
	public void addChildToExistingParent() {
		Transaction tx = null;
		try(Session session  = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			PersonDetails personDetails = session.find(PersonDetails.class, 3);
			
			//get all child of parent
			Set<PhoneNumber> childs = personDetails.getPhoneNumbers();
			
			// create a new child
			PhoneNumber ph = new PhoneNumber();
			ph.setMobileNumber(8888777777L);
			ph.setNumberType("office");
			ph.setProvider("vi");
			
			// add new child to existing parent
			childs.add(ph);
			
			tx.commit();
			
			System.out.println("child is added to existing child of parent");
			
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to add child to existing parent",e);
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to add child to existing parent ",e);
		}
	}

	@Override
	public void deleteAllChildsOfAParent() {

		Transaction tx = null;
		try(Session session  = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			PersonDetails personDetails = session.find(PersonDetails.class, 3);
			
			//get all child of parent
			Set<PhoneNumber> childs = personDetails.getPhoneNumbers();
			childs.removeAll(childs);
			
			tx.commit();
			
			System.out.println("delete all child of a parent are removed");
			
		}
		catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to delete all child of a parent",e);
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("failed to delete all child of a parent ",e);
		}
		
	}

	@Override
	public void deleteOneChildFromCollectionOfAParent() {
		Transaction tx = null;
		try(Session session = HBUtil.getSession()) {
			tx = session.beginTransaction();
			//load parent
			PersonDetails personDetails = session.find(PersonDetails.class, 4);
			
			// get all childs of parent 
			Set<PhoneNumber> phoneNumbers = personDetails.getPhoneNumbers();
			
			// load specific child that want to delete
			PhoneNumber ph = session.find(PhoneNumber.class, 153);
			
			phoneNumbers.remove(ph);
			
			tx.commit();
			
			System.out.println("specific child of a parent is deletd");
			
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("Problem in removing specific child of a parent ",e);
		}
		
	}

	@Override
	public void deleteParentAndItsChilds() {
		Transaction tx = null;
		try(Session session = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			// load parent to remove
			PersonDetails personDetails = session.find(PersonDetails.class, 4);
			session.remove(personDetails);
			tx.commit();
			System.out.println("Parent and its associated childs are delete");
		}
		catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException("parent and its associated childs are not deleted ",e);
		}
		
	}

}
