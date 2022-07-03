package app;

import planner.RepeatedTask;
import planner.SingleTimeTask;
import planner.Task;
import planner.TaskCollection;
import planner.User;
import test.NonParseableStringException;
import test.NotEmailException;
import test.TooShortNameException;
import util.RepeatedTaskCreator;
import util.SingleTimeTaskCreator;
import util.UserCreator;

public class App {
	
	public static void main(String[] args) throws TooShortNameException, NonParseableStringException {
		
		User u = new User();
		try {
			u = UserCreator.createNewUser();
		} catch (NotEmailException e) {
			e.printStackTrace();
		}
		
		System.out.println(u.toString());
		
		Task<?> task1 = new SingleTimeTask();
		try {
			task1 = SingleTimeTaskCreator.createSingleTimeTask();
			u.writeToDataBase();
		}
		catch(TooShortNameException e) {
			System.out.println(e.getMessage());
		}
		catch(NonParseableStringException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Let's create a new task.");
		}
		
		Task<?> task2 = new RepeatedTask();
		try {
			task2 = RepeatedTaskCreator.createRepeatedTask();
			u.writeToDataBase();
		}
		catch(TooShortNameException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Let's create a new task.");
		}
		
		Task<?> task3 = new SingleTimeTask();
		try {
			task3 = SingleTimeTaskCreator.createSingleTimeTask();
			u.writeToDataBase();
		}
		catch(TooShortNameException e) {
			System.out.println(e.getMessage());
		}
		
		TaskCollection.printAllTasks();
		
		TaskCollection.sortTasksByName();
		
		TaskCollection.sortTasksByCategory();
		
		TaskCollection.sortTasksByPriority();
		
		TaskCollection.printTaskNames();
		
		TaskCollection.deleteTask(task3);
		
		u.doTask(task1);
		
		TaskCollection.printAllTasks();
		
		task2.printTimeToDeadline();
		
		System.out.println(task1.equals(task3));
		
		System.out.println(task1.hashCode() == task3.hashCode());

		u.loadDataBase();
		
	}

}