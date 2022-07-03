package planner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;

import util.UserCreator;

public class User {
	
	private String userName;
	private String userEmail;
	private String password;
	private int userID;
	
	public User() {
		
	}
	
	public static class Builder<TUserName, TUserEmail, TPassword, TUserID> {
		
		private String userName;
		private String userEmail;
		private String password;
		private int userID;
		
		public Builder() {
			
		}
		
		public static Builder<?, ?, ?, ?> builder() {
			return new Builder<>();
		}
		
		public Builder(String userName, String userEmail, String password, int userID) {
			this.userName = userName;
			this.userEmail = userEmail;
			this.password = password;
			this.userID = userID;
		}
		
		public Builder<TUserName, TUserEmail, TPassword, TUserID> withUserName(String userName) {
			return new Builder<>(userName, userEmail, password, userID);
		}
		
		public Builder<TUserName, TUserEmail, TPassword, TUserID> withUserEmail(String userEmail) {
			return new Builder<>(userName, userEmail, password, userID);
		}
		
		public Builder<TUserName, TUserEmail, TPassword, TUserID> withPassword(String password) {
			return new Builder<>(userName, userEmail, password, userID);
		}
		
		public Builder<TUserName, TUserEmail, TPassword, TUserID> withUserID(int userID) {
			return new Builder<>(userName, userEmail, password, userID);
		}
		
		public User build() {
			User newUser = new User();
			newUser.userName = userName;
			newUser.userEmail = userEmail;
			newUser.password = password;
			newUser.userID = userID;
			return newUser;
		}
	}
	
	@Override
	public String toString() {
		return userName +", ID: " + userID + ", e-mail: " + userEmail;
	}
	
	public static void doTask(Task<?> task) {
		task.setIsDone(true);
		System.out.println("The task " + task.getName() + " is done.");
		TaskCollection.deleteTask(task);
	}

	public void writeToDataBase() {
		System.out.println("Let's save your task.");
		UserCreator.confirmPassword();
		try(FileOutputStream fos = new FileOutputStream(TaskCollection.FILENAME)) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(Task<?> t : TaskCollection.TASKS) {
				oos.writeObject(t.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Napisala metod loadDataBase dvumya sposobami: tak, kak delali na lektsyi i cherez File reader
	public void loadDataBase() {
		UserCreator.confirmPassword();
		try (FileInputStream fis = new FileInputStream(TaskCollection.FILENAME)) {
			int size = fis.available();
			byte[] buffer = new byte[size];
			fis.read(buffer);
			System.out.println(new String(buffer));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//public void loadDataBase2() {
		//UserCreator.confirmPassword();
		//try (FileReader reader = new FileReader(TaskCollection.FILENAME)) {
			//int result = reader.read();
			//while(result != -1) {
				//System.out.print((char) result);
				//result = reader.read();
			//}
		//}
		//catch (IOException e) {
			//e.printStackTrace();
		//}
	//}
	
}