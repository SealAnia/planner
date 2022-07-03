package util;

import planner.Category;
import planner.Priority;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import planner.SingleTimeTask;
import planner.SingleTimeTaskID;
import planner.TaskCollection;
import test.NonParseableStringException;
import test.TooShortNameException;

@UtilityClass
public class SingleTimeTaskCreator {
	
	private final static Scanner SCANNER = new Scanner(System.in);
	
	public static SingleTimeTask createSingleTimeTask() throws TooShortNameException, NonParseableStringException {
		SingleTimeTask singleTimeTask = new SingleTimeTask();
		singleTimeTask.setName(getNameFromUser());
		
		TaskCollection.checkTaskName(singleTimeTask);
		
		singleTimeTask.setDeadline(getDeadlineFromUser());
		singleTimeTask.setIsDone(false);
		singleTimeTask.setPriority(getPriorityFromUser());
		singleTimeTask.setCategory(Category.SINGLETIME);
		singleTimeTask.setSingleTimeTaskID(createSingleTimeTaskID());
		TaskCollection.TASKS.add(singleTimeTask);
		//TaskCollection.addNewTask(singleTimeTask);
		singleTimeTask.create(singleTimeTask);
		System.out.println(singleTimeTask.toString());
		return singleTimeTask;
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
	
	private static Date getDeadlineFromUser() {
		System.out.println("Let's set deadline: ");
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
	
	private static SingleTimeTaskID createSingleTimeTaskID() {
		SingleTimeTaskID singleTimeTaskID = new SingleTimeTaskID(null);
		singleTimeTaskID.generateTaskID();
		return singleTimeTaskID;
	}

}