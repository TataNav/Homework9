package SocialApp;

public class Announcments {
	private String announcmentTitle;
	private String announcmentBody;
	private boolean seen;
	
	public Announcments(String announcmentTitle, String announcmentBody) {
		this.announcmentTitle = announcmentTitle; 
		this.announcmentBody = announcmentBody;
		seen = false;
	}

	public String getAnnouncmentTitle() {
		return announcmentTitle;
	}

	public void setAnnouncmentTitle(String announcmentTitle) {
		this.announcmentTitle = announcmentTitle;
	}

	public String getAnnouncmentBody() {
		return announcmentBody;
	}

	public void setAnnouncmentBody(String announcmentBody) {
		this.announcmentBody = announcmentBody;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
}
