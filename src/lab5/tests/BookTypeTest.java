package lab5.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lab5.PaperBook;

class BookTypeTest {

	@Test
	void test() {
		PaperBook book1 = new PaperBook("Dune");
		PaperBook book2 = new PaperBook("1984");

		
		assertTrue((book1).getClass().getName().endsWith("PaperBook"));
		assertTrue(book1.getClass().equals(book2.getClass()));
	}

}
