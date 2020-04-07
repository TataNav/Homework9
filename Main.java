package SocialApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<Announcments> announcments = new ArrayList<>();
	static User loggedInUser = null;
	static User adminUser = new User("admin", "1234");
	
	public static void main(String[] args) {
		users.add(adminUser);
		System.out.println(users.get(0).getUserName());
		
		while(true) {
			System.out.println("1. Login");
			System.out.println("2. Register");
			int i =  scanner.nextInt();
			if(i == 1) {
				goLoginScreen();
				break;
			} else if (i == 2) {
				goRegistrationScreen();
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	}
	
	public static void goStartPage() {
		while(true) {
			System.out.println("1. Login");
			System.out.println("2. Register");
			int i =  scanner.nextInt();
			if(i == 1) {
				goLoginScreen();
				break;
			} else if (i == 2) {
				goRegistrationScreen();
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	}
	
	public static void goLoginScreen() {
		System.out.println("Input username");
		String username = scanner.next();
		System.out.println("Input password");
		String password = scanner.next();
		boolean foundUser = false;
		
		for (User user : users) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				foundUser = true;
				System.out.println("Login successful");
				loggedInUser = user;
				goUserHomePage();
				break;
			}
		}
		if (!foundUser) {
			System.out.println("Wrong username and password.");
			goLoginScreen();
		}
	}
	
	public static void goUserHomePage() {
		while(true) {
			int j = 0;
			if(!loggedInUser.getUserName().equals(adminUser.getUserName()) && announcments.size() > 0 && !announcments.get(j).isSeen()) {
				System.out.println("You've got new announcments...");
				for (Announcments announcment : announcments) {
					System.out.println(announcment.getAnnouncmentTitle());
					j++;
				}
			}

			System.out.println("1. Messages");
			System.out.println("2. Announcments");
			System.out.println("3. Log out");
			int i =  scanner.nextInt();
			if (i == 1) {
				goMessagesScreen();
				break;
			} else if (i == 2) {
				goAnnounsmentsScreen();
				break;
			} else if (i == 3) {
				System.out.println("Logged out");
				loggedInUser = null;
				goStartPage();
			} else {
				System.out.println("Wrong input");
			}
		}
	}
	
	public static void goMessagesScreen() {
		boolean foundTarget = false;

		System.out.println("All users");
		for (User user : users) {
			if(!loggedInUser.getUserName().equals(user.getUserName()) && !user.getUserName().equals(adminUser.getUserName())) {
				System.out.println(user.getUserName());
				foundTarget = true;
			}
		}

		if (foundTarget) {
			System.out.println("Input some user's username");
			String someUserName = scanner.next();
			User target = null;
			for(User user : users) {
				if(user.getUserName().equals(someUserName)) {
					target = user;
					break;
				}
			}
			
			if(target != null && !(target.getUserName().equals(loggedInUser.getUserName()))) {
				goPM(target);
			} else {
				System.out.println("No such user");
				goMessagesScreen();
			}
		} 
		
		System.out.println("Press any key to go back");
		String s = scanner.next();
		goUserHomePage();
	}
	
	public static void goPM(User target) {
		System.out.println("Yor messages from " + target.getUserName());
		for(Messages message : loggedInUser.getMessages()) {
			if (message.getFrom().getUserName().equals(target.getUserName())) {
				System.out.println(message.getMessage());
			}
		}
		
		System.out.println("Write a message.");
		String message = scanner.next();
		Messages message1 = new Messages(message, loggedInUser, target);
		target.getMessages().add(message1);
		System.out.println("Message sent");
		goUserHomePage();
	}
	
	public static void goRegistrationScreen() {
		System.out.println("Input username");
		String username = scanner.next();
		boolean foundUser = false;
		for (User user : users){
			if(user.getUserName().equals(username)) {
				System.out.println("User already exists. Try again.");
				foundUser = true;
				break;
			}
		}
		
		if (foundUser) {
			goRegistrationScreen();
		} else {
			System.out.println("Input password");
			String password = scanner.next();
			User user = new User(username, password);
			users.add(user);
			System.out.println("Successfully created a new user with username: " + username);
			goStartPage();
		}
	}
	
	public static void goAnnounsmentsScreen() {
		while (true) {
			if (announcments.size() > 0) {
				System.out.println("List of all announcments");
				int j = 0;
				for (Announcments announcment : announcments) {
					j++;
					System.out.println(j + ". " + announcment.getAnnouncmentTitle());
				}
			} else if (announcments.size() == 0) {
				System.out.println("No announcment");
			}

			if(loggedInUser == adminUser) {
				if (announcments.size() > 0) {
					System.out.println("1. See Announcement");
					System.out.println("2. Create an announcment");
					System.out.println("3. Go Back");
					int i = scanner.nextInt();
					if (i == 1) {
						seeAnnouncementDetails();
					} else if (i == 2) {
						goToAddAnnouncment();
					} else if (i == 3){
						goUserHomePage();
					} else {
						System.out.println("Wrong input");
					}
				} else {
					System.out.println("1. Create an announcment.");
					System.out.println("2. Go Back");
					int j = scanner.nextInt();
					if (j == 1) {
						goToAddAnnouncment();
					} else if (j == 2){
						goUserHomePage();
					} else {
						System.out.println("Wrong input");
					}
				}
			} else {
				if (announcments.size() > 0) {
					System.out.println("1. See Announcement");
					System.out.println("2. Go Back");
					int k = scanner.nextInt();
					if (k == 1) {
						seeAnnouncementDetails();
					} else if (k == 2) {
						goUserHomePage();
					} else {
						System.out.println("Wrong input");
					}
				} else {
					System.out.println("1. Go Back");
					int n = scanner.nextInt();
					if (n == 1) {
						goUserHomePage();
					} else {
						System.out.println("Wrong input");
					}
				}
			}
		}
	}
	
	public static void goToAddAnnouncment() {
		System.out.println("Insert the Announcment title: ");
		String announcmentTitle = scanner.next();
		System.out.println("Insert the Announcment body: ");
		String announcmentBody = scanner.next();
		Announcments annoumcment = new Announcments(announcmentTitle, announcmentBody);
		announcments.add(annoumcment);
		System.out.println("successfully done!");
		goAnnounsmentsScreen();
	}
	
	public static void seeAnnouncementDetails() {
		while(true) {
			int j = 0;
			for (Announcments announcment : announcments) {
				j++;
				System.out.println(j + ". " + announcment.getAnnouncmentTitle());
			}
			System.out.println("Insert the desired announcement number...");
			int k = scanner.nextInt();
			System.out.println(announcments.get(k - 1).getAnnouncmentTitle());
			System.out.println(announcments.get(k - 1).getAnnouncmentBody());
			announcments.get(k - 1).setSeen(true);
			System.out.println("1. Go Back");
			int n = scanner.nextInt();
			if (n == 1) {
				goAnnounsmentsScreen();
			} else {
				System.out.println("Wrong input");
			}
		}
	}
}
