package SocialApp;

public class Messages {
	private String message;
	private User from;
	private User to;
	
	public Messages(String message, User from, User to) {
		this.message = message;
		this.from = from;
		this.to = to;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
}
