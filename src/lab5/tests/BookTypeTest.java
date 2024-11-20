package lab5.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.Ebook;
import lab5.PaperBook;

class BookTypeTest {

	@Test
	void test() {
		PaperBook book1 = new PaperBook("Dune");
		PaperBook book2 = new PaperBook("1984");

		
		assertTrue((book1).getClass().getName().endsWith("PaperBook"));
		assertTrue(book1.getClass().equals(book2.getClass()));
	}

	 @Test
	    void testEbook() {
	        Ebook eBook = new Ebook("1984");

	        // Test that the class type ends with "EBook"
	        assertTrue(eBook.getClass().getName().endsWith("Ebook"));

	        // Test its functionality
	        assertTrue(eBook.getIsAvailable()); // Newly created eBook should be available
	    }

	    @Test
	    void testAudioBook() {
	        AudioBook audioBook = new AudioBook("Atomic Habits");

	        // Test that the class type ends with "AudioBook"
	        assertTrue(audioBook.getClass().getName().endsWith("AudioBook"));

	        // Test its functionality
	        assertTrue(audioBook.getIsAvailable()); // Newly created AudioBook should be available
	    }
}
