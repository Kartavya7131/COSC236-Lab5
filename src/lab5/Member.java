package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingService borrowingService;
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		borrowingService = BorrowingService.getInstance();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Member: " + name;
	}
	
	public String borrowBook(Book book) {
		BorrowingBookResult result = borrowingService.borrowBook(this, book);
		
		if(result.getResult()) {
			return result.getMessage();
		}else {
			return result.getMessage();
		}
	}
	
	public String returnBook(Book book) {
		BorrowingBookResult result = borrowingService.returnBook(this, book);
		
		if(result.getResult()) {
			return result.getMessage();
		}else {
			return result.getMessage();
		}
	}
	
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
	
	public BorrowingService getBorrowingService() {
		return borrowingService;
	}
}
