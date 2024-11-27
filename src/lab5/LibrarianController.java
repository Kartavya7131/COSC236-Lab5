package lab5;

public class LibrarianController {
	
	Library library; // Library dependency
	PaperBookFactory paperBookFactory; 
	EBookFactory eBookFactory;
	AudioBookFactory audioBookFactory;
	
	public LibrarianController() {
		this.library = new Library(); // Constructor injection
		this.paperBookFactory = new PaperBookFactory();
		this.eBookFactory = new EBookFactory();
		this.audioBookFactory = new AudioBookFactory();
	}
	
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	
	public void addBook(BookFactory factory, String title) {
		library.addBook(factory.createBook(title));;
	}
	
	public void addPaperBook(String title) {
        addBook(paperBookFactory, title);
    }

    public void addEBook(String title) {
        addBook(eBookFactory, title);
    }

    public void addAudioBook(String title) {
        addBook(audioBookFactory, title);
    }
    
	public void addMember(String name) {
		library.addMember(new Member(name)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public String borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			return member.borrowBook(book); // member borrows a book, not library 
		else 	
			return "Either book " + title + " or member " + name + " not found.";
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search 
		if (book != null && member != null)
			member.returnBook(book); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
}
