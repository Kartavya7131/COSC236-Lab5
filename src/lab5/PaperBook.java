package lab5;

public class PaperBook implements Book {
	
	private String title;
	private boolean isAvailable;
	
	public PaperBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	@Override
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book: " + title;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}
}
