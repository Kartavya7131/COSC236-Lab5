package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.LibrarianController;
import lab5.Member;
import lab5.PaperBook;

public class TestBorrowAndReturnMessages {
	
LibrarianController testLibrary = new LibrarianController();
	
	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Dune");
	PaperBook book2 = new PaperBook("1984");
	PaperBook book3 = new PaperBook("Moby Dick");
	PaperBook book4 = new PaperBook("Tom Sawyer");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
		
		//Set Up Library
		testLibrary.addMember(member1.getName());
		testLibrary.addPaperBook(book1.getTitle());
		testLibrary.addPaperBook(book2.getTitle());
		testLibrary.addPaperBook(book3.getTitle());
		testLibrary.addPaperBook(book4.getTitle());
	}
	
	@Test
	void borrowBookMessages() {
		
		//Successfully Borrow Book
		assertEquals(testLibrary.borrowBookByMember(book1.getTitle(), member1.getName()), member1 + " Has successfully borrowed: " + book1);
		
		//Borrow book1 twice
		testLibrary.borrowBookByMember(book1.getTitle(), member1.getName());
		assertEquals(testLibrary.borrowBookByMember(book1.getTitle(), member1.getName()), "Failed to borrow book: The book is not available"); //checks if the return message is correct
		
		//Borrow Book that person has already borrowed
		testLibrary.getLibrary().findBookByTitle(book1.getTitle()).setIsAvailable(true); // set the book to available
		assertEquals(testLibrary.borrowBookByMember(book1.getTitle(), member1.getName()), "Failed to borrow book: " + member1 +  " has already borrowed " + book1);
		
		//Borrow More then allowed amount of books
		testLibrary.borrowBookByMember(book2.getTitle(), member1.getName());
		testLibrary.borrowBookByMember(book3.getTitle(), member1.getName());
		
		assertEquals(testLibrary.borrowBookByMember(book4.getTitle(), member1.getName()), "Failed to borrow book: " + member1 + " has borrowed too many books");
	}

}
