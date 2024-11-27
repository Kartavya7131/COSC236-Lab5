package lab5;

public abstract class BookFactory {

	public Book createBook(String title) { return null; };
	
}

//EBookFactory
class EBookFactory extends BookFactory {
    
	@Override
	public Book createBook(String title) {
		return new Ebook(title);
	}
    
}

//PaperBookFactory
class PaperBookFactory extends BookFactory {
    
    @Override
    public Book createBook(String title) {
        return new PaperBook(title);
    }
}

//AudioBookFactory
class AudioBookFactory extends BookFactory {
    
    @Override
    public Book createBook(String title) {
        return new AudioBook(title);
    }
}