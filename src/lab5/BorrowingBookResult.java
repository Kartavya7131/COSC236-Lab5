package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	
	public BorrowingBookResult(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.borrowingMessage = message;
	}
	
	public boolean getResult() {
		return isSuccess;
	}
	
	public String getMessage() {
		return borrowingMessage;
	}
}
