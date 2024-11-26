package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	
	private static BorrowingService instance;
	private int borrowingLimit;
	
	private BorrowingService() {
		borrowingLimit = 3;
	}
	
	public static BorrowingService getInstance() {
		if(instance == null) {
			instance = new BorrowingService();
			return instance;
		}else {
			return instance;
		}
	}

	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		
		//Check if book exists
		if (book == null) {
			return new BorrowingBookResult(false, "Failed to borrow book: The book does not exist");
		}
		//Check if book is already borrowed
		if (!book.getIsAvailable()) {
			return new BorrowingBookResult(false, "Failed to borrow book: The book is not available");
		}
		//Check if member already has book
		if(member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, "Failed to borrow book: " + member + " has already borrowed " + book);
		}
		//Check if member has more than 3 books borrowed
		if(member.getBorrowedBooks().size() >= borrowingLimit) {
			return new BorrowingBookResult(false, "Failed to borrow book: " + member + " has borrowed too many books");
		}
		
		member.getBorrowedBooks().add(book);
		book.setIsAvailable(false);
		return new BorrowingBookResult(true, member + " Has successfully borrowed: " + book);
	}

	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		
		//Check if book Exists
		if (book == null) {
			return new BorrowingBookResult(false, "Failed to return book: The book does not exist");
		}
		//Check to see if member has the book
		if(!member.getBorrowedBooks().contains(book)) {
			return new BorrowingBookResult(false, "Failed to return book: " + member + "has has not borrowed that book");
		}
		
		member.getBorrowedBooks().remove(book);
		book.setIsAvailable(true);
		return new BorrowingBookResult(true, member + " has succesfully returned the book: " + book);
	}
	
}
