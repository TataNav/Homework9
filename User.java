package SocialApp;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private ArrayList<Messages> messages;
	private ArrayList<Announcments> announcment;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		messages = new ArrayList<>();
		setAnnouncment(new ArrayList<>());
	}
		
	public String getUserName() {
		return username;
	}
		
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Messages> getMessages() {
		return messages;
	}
	
	public void setMessages(ArrayList<Messages> messages) {
		this.messages = messages;
	}

	public ArrayList<Announcments> getAnnouncment() {
		return announcment;
	}

	public void setAnnouncment(ArrayList<Announcments> announcment) {
		this.announcment = announcment;
	}
}
