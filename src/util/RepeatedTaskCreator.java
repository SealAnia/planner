package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import planner.Category;
import planner.Priority;
import planner.RepeatedTask;
import planner.RepeatedTaskID;
import planner.TaskCollection;
import test.NonParseableStringException;
import test.TooShortNameException;

@UtilityClass
public class RepeatedTaskCreator {
	
	private final static Scanner SCANNER = new Scanner(System.in);
	
	public static RepeatedTask createRepeatedTask() throws TooShortNameException, NonParseableStringException {
		RepeatedTask repeatedTask = new RepeatedTask();
		repeatedTask.setName(getNameFromUser());
		
		TaskCollection.checkTaskName(repeatedTask);
		
		repeatedTask.setFrequency(getFrequencyFromUser());
		repeatedTask.setDeadline(getDeadlineFromUser());
		repeatedTask.resetDeadline();
		repeatedTask.setIsDone(false);
		repeatedTask.setPriority(getPriorityFromUser());
		repeatedTask.setCategory(Category.REPEATED);
		repeatedTask.setRepeatedTaskID(createRepeatedTaskID());
		TaskCollection.TASKS.add(repeatedTask);
		//TaskCollection.addNewTask(repeatedTask);
		repeatedTask.create(repeatedTask);
		System.out.println(repeatedTask.toString());
		return repeatedTask;
	}
	
	private static String getNameFromUser() throws TooShortNameException {
		System.out.println("Enter task name: ");
		String name;
		do {
			name = SCANNER.next();
			if(name.length() < 3) {
				System.err.println("Your task name is too short!");
				System.out.println("Enter task name one more time: ");
			}
			
		} while(name.length() < 3);
		return name;
	}

	private static int getFrequencyFromUser() {
		System.out.println("How often will you do this: ");
		return SCANNER.nextInt();
	}
	
	private static Date getDeadlineFromUser() {
		System.out.println("Let's set the first deadline: ");
		System.out.println("Input day: ");
		int day = SCANNER.nextInt();
		System.out.println("Input month: ");
		int month = SCANNER.nextInt();
		System.out.println("Input year: ");
		int year = SCANNER.nextInt();
		Calendar c = new GregorianCalendar(year, month - 1, day);
		Date deadline = c.getTime();
		return deadline;
	}
	
	private static Priority getPriorityFromUser() throws NonParseableStringException {
		System.out.println("How important is this: ");
		String priority = SCANNER.next();
		return Priority.parse(priority);
	}
	
	private static RepeatedTaskID createRepeatedTaskID() {
		RepeatedTaskID repeatedTaskID = new RepeatedTaskID(null);
		repeatedTaskID.generateTaskID();
		return repeatedTaskID;
	}

}