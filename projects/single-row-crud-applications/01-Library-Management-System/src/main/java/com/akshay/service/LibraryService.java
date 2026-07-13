package com.akshay.service;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.entity.Book;
import com.akshay.util.HBUtil;

/**
 * This class represent Library Book management all the operations
 * and also contain persistence logic , business logic
 */
public class LibraryService {
	
	/**
	 * Add book to the library system 
	 * @param book - accept book (object)
	 * @return nothing  
	 */
	public void addBook(Book book) {
		Transaction tx  = null;
		try(Session session = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			// object moves to persistence state 
			// save/insert operation 
			session.persist(book);
			
			tx.commit();
			
		}// when session close object move to detach state
		catch(HibernateException e) {
			if(tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
			throw new IllegalArgumentException("Something went wrong !!",e);
		}
	}
	
	/**
	 * Search book by id 
	 * @param bookId - accept book id 
	 * @return optional - if book available then return optional containing (book) otherwise null
	 */
	public Optional<Book> search(int bookId){
		try(Session session = HBUtil.getSession()){
			
			Book book = session.find(Book.class, bookId);
			
			return Optional.ofNullable(book);
			
		}
		catch(HibernateException e) {
			throw new IllegalArgumentException("Something went wrong !!",e);
		}
	}

	/**
	 * update the book price 
	 * @param bookId
	 * @param newPrice
	 * @return nothing 
	 */
	public void updateBookPrice(int bookId, double newPrice) {
		Transaction tx = null;
		try(Session session = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			Optional<Book> bookFound = search(bookId);
			
			Book book = bookFound.get();
			if(book != null) {
				// get old book price 
				double oldPrice = book.getPrice();
				// update new price
				book.setPrice(newPrice);
				tx.commit();
				// display message
				System.out.println("Old Price : " + oldPrice);
				System.out.println("New Price : " + newPrice);
				System.out.println("Book updated successfully");
			}
			else {
				System.out.println("Book Not Found !");
			}
		}
		catch(HibernateException e) {
			if(tx!= null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
			throw new IllegalArgumentException("something went wrong !",e);
		}
	}
	
	/**
	 * Remove book
	 * @param bookId - takes book id 
	 * @return nothing 
	 */
	public void delete(int bookId) {
		
		Transaction tx = null;
		
		try(Session session = HBUtil.getSession()){
			tx = session.beginTransaction();
			
			Book book = search(bookId).orElseThrow(()-> new IllegalArgumentException("Book not found"));
			
			session.remove(book);
			
			tx.commit();
			
			System.out.println("Book Deleted  Successfully");
			
		}
		catch(HibernateException e) {
			if(tx != null && tx.getRollbackOnly() && tx.getStatus() != null) {
				tx.rollback();
			}
			throw new IllegalArgumentException("Something went wrong !",e);
		}
		
	}
}
