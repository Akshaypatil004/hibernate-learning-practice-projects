package com.akshay.service;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.akshay.dto.BookPriceUpdateResult;
import com.akshay.entity.Book;
import com.akshay.exception.BookNotFoundException;
import com.akshay.util.HBUtil;

/**
 * This class represent Library Book management all the operations and also
 * contain persistence logic , business logic
 */
public class LibraryService {

	/**
	 * Add book to the library system
	 * 
	 * @param book - accept book (object)
	 * @return int - return book id on successful persist operation
	 */
	public int addBook(Book book) {
		// input validation
		if (book == null) {
			throw new IllegalArgumentException("ERROR - Book should not be null");
		}
		Transaction tx = null;
		try (Session session = HBUtil.getSession()) {
			tx = session.beginTransaction();

			// object moves to persistence state
			// save/insert operation
			session.persist(book);

			tx.commit();

			return book.getBookId();

		} // when session close object move to detach state
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("failed to persist the book!", e);
		}
	}

	/**
	 * Search book by id
	 * 
	 * @param bookId - accept book id
	 * @return optional - if book available then return optional containing (book)
	 *         otherwise null
	 */
	public Optional<Book> search(int bookId) {
		// input validation
		if (bookId <= 0) {
			throw new IllegalArgumentException("ERROR - invalid book id");
		}
		try (Session session = HBUtil.getSession()) {

			Book book = session.find(Book.class, bookId);

			return Optional.ofNullable(book);

		} catch (HibernateException e) {
			throw new RuntimeException("failed to search the book!", e);
		}
	}

	/**
	 * update the book price
	 * 
	 * @param bookId
	 * @param newPrice
	 * @return BookPriceUpdateResult containing new updated information as DTO
	 */
	public BookPriceUpdateResult updateBookPrice(int bookId, double newPrice) {
		// input validation
		if (bookId <= 0 || newPrice <= 0) {
			throw new IllegalArgumentException("ERROR - Invalid book id and new price !!");
		}
		BookPriceUpdateResult result = null;
		Transaction tx = null;
		try (Session session = HBUtil.getSession()) {
			tx = session.beginTransaction();

			// entity is in persistence state
			Book book = session.find(Book.class, bookId);
			if (book == null) {
				throw new BookNotFoundException("Book not found");
			}
			// DTO object represent result
			result = new BookPriceUpdateResult();
			result.setBookId(bookId);
			result.setOldPrice(book.getPrice());
			result.setNewPrice(newPrice);
			
			// update  new price
			book.setPrice(newPrice);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("failed to update the book !", e);
		}
		return result;
	}

	/**
	 * Remove book
	 * 
	 * @param bookId - takes book id
	 * @return nothing
	 */
	public void delete(int bookId) {
		if (bookId <= 0) {
			throw new IllegalArgumentException("ERROR - invalid book id");
		}

		Transaction tx = null;

		try (Session session = HBUtil.getSession()) {
			tx = session.beginTransaction();
			// entity is in persistence state
			Book book = session.find(Book.class, bookId);
			if (book == null) {
				throw new BookNotFoundException("Book not found");
			}
			session.remove(book);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException("failed to delete the book!", e);
		}

	}
}
