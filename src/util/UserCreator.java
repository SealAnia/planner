package util;

import java.util.Scanner;

import planner.User;
import test.NotEmailException;
import test.TooShortNameException;

@UtilityClass
public class UserCreator {
	
	private final static Scanner SCANNER = new Scanner(System.in);
	
	public static User createNewUser() throws NotEmailException, TooShortNameException {
		User user = new User.Builder<>()
				.withUserName(getNameFromUser())
				.withUserEmail(getEmailFromUser())
				.withPassword(getPasswordFromUser())
				.withUserID(generateUserID())
				.build();
		return user;
	}
	
	private static String getNameFromUser() {
		System.out.println("Input your name: ");
		return SCANNER.next();
	}
	
	private static String getEmailFromUser() throws NotEmailException {
		System.out.println("Input your e-mail: ");
		String eMail;
		String regex = ".*@{1}.*";
		do {
			eMail = SCANNER.next();
			if(eMail.matches(regex) == false) {
				System.err.println("It is not an e-mail");
				System.out.println("Input your e-mail one more time: ");
			}
		} while(eMail.matches(regex) != true);
		return eMail;
	}
	
	static String password;
	private static String getPasswordFromUser() throws TooShortNameException {
		System.out.println("Set the password: ");
		do {
			password = SCANNER.next();
			if(password.length() < 8) {
				System.err.println("Your password is too short. It should be 8 symbols or longer");
				System.out.println("Set a new password");
			}
		} while(password.length() < 8);
		UserCreator.confirmPassword();
		return password;
	}

	public static String confirmPassword() {
		String passwordConfirmation;
		do {
			System.out.println("Confirm the password: ");
			passwordConfirmation = SCANNER.next();
			if(!passwordConfirmation.equals(password)) {
				System.err.println("The password is incorrect.");
			}
		} while(!passwordConfirmation.equals(password)); 
		return password;
	}

	private static int generateUserID() {
		int userID = (int)(Math.random() * 1000000000) + 100000000;
		return userID;
	}
	
}