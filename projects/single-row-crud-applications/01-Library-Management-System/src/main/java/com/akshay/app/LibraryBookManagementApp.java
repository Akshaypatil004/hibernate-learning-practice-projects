package com.akshay.app;

import java.util.Scanner;

import com.akshay.dto.BookPriceUpdateResult;
import com.akshay.entity.Book;
import com.akshay.service.LibraryService;
import com.akshay.util.HBUtil;

public class LibraryBookManagementApp {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("=".repeat(50));
       System.out.println("Library Book Management");
       System.out.println("=".repeat(50));
       
       LibraryService service = new LibraryService();
       
       try{
    	   while(true) {
    		   System.out.println("=".repeat(50));
    		   System.out.println("1. Add Book");
    		   System.out.println("2. Search Book");
    		   System.out.println("3. Update book price");
    		   System.out.println("4. Delete Book");
    		   System.out.println("5. exit");
    		   System.out.println("=".repeat(50));
    		   System.out.println("Enter your choice: ");
    		   int choice = sc.nextInt();
    		   sc.nextLine();
    		   
    		   switch(choice) {
    		   case 1:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Enter Title: ");
    			   String title = sc.nextLine();
    			   
    			   System.out.println("Enter Author: ");
    			   String author = sc.nextLine();
    			   
    			   System.out.println("Enter Publisher: ");
    			   String publisher = sc.nextLine();
    			   
    			   System.out.println("Enter price: ");
    			   double price = sc.nextDouble();
    			   
    			   System.out.println("Available (YES/NO): ");
    			   String available = sc.next();
    			   
    			   Book book = new Book(title, author, price, publisher);
    			   if(available.equalsIgnoreCase("yes")) {
    				   book.setAvailable(true);
    			   }
    			   else {
    				   book.setAvailable(false);
    			   }
    			   System.out.println("=".repeat(50));
    			   int bookId = service.addBook(book);
    			   System.out.println("Book Saved Successfully!");
    			   System.out.println("Generated Book ID : " + bookId);
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 2:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Enter book ID: ");
    			   bookId = sc.nextInt();
    			   System.out.println("=".repeat(50));
    			   
				   service.search(bookId).ifPresentOrElse(b -> {
					   System.out.println("Book Found");
					   System.out.println("-".repeat(30));
					   System.out.println("Book ID: " + b.getBookId());
					   System.out.println("Title: " + b.getTitle());
					   System.out.println("Author: " + b.getAuthor());
					   System.out.println("Publisher: " + b.getPublisher());
					   System.out.println("price: " + b.getPrice());
					   System.out.println("Available: " + b.getAvailable());
				   }, ()-> System.out.println("Book not found"));
				   System.out.println("=".repeat(50));
    			   break;
    		   case 3:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Enter Book Id: ");
    			   bookId = sc.nextInt();
    			   		   
    			   System.out.println("Enter New Price:");
    			   double newPrice = sc.nextDouble();
    			   System.out.println("=".repeat(50));
    			   
    			   BookPriceUpdateResult updateBook = service.updateBookPrice(bookId, newPrice);
    			   System.out.println("Old Price: " + updateBook.oldPrice());
    			   System.out.println("New Price: " + updateBook.newPrice());
    			   System.out.println("Book Updated Successfully");
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 4:
    			   System.out.println("=".repeat(50));
    			   System.out.println("Enter Book Id: ");
    			   bookId = sc.nextInt();
    			   
    			   System.out.println("Do you really want to delete?");
    			   System.out.println("yes/no");
    			   String option = sc.next();
    			   if(option.equalsIgnoreCase("yes")) {
    				   service.delete(bookId);
    				   System.out.println("Book Deleted Successfully"); 
    			   }
    			   else {
    				   System.out.println("Book Deletion Cancelled");
    			   }
    			   System.out.println("=".repeat(50));
    			   break;
    		   case 5:
    			   return;
    			default:
    				System.out.println("Invalid choice !!");
    		   }
    	   }
    	   
       }
       catch(Exception e) {
    	   System.err.println(e.getLocalizedMessage());
       }
       finally {
    	   HBUtil.shutdown();
    	   sc.close();
       }
    }
}
