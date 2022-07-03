package planner;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TaskCollection implements Comparable {
	
	private TaskCollection() {
		
	}
	
	public static String FILENAME = "resources/tasks.txt";
	
	public static List<Task<? extends TaskID<?>>> TASKS = new ArrayList<Task<? extends TaskID<?>>>();
	
	@Override
	public void compareTo(Task<?> task, Task<?> task2) {
		if(task.hashCode() == (task2.hashCode())) {
			System.out.println("This task already exists!");
		}
	}
	
	public static void printAllTasks() {
		System.out.println("All tasks: ".toUpperCase());
		TASKS.forEach(t -> {
			System.out.println(t.toString());
			System.out.println("***");
		});
	}
	
	public static void sortTasksByName() {
		
	Comparator <Task<? extends TaskID<?>>> compareByName =  (o1, o2) ->
		o1.getName().compareTo(o2.getName()); {
			Collections.sort(TASKS, compareByName);
			System.out.println("Tasks Sorted By Name: ".toUpperCase());
			TASKS.forEach((name) -> System.out.println(name));
		}
		
	}
	
	public static void sortTasksByCategory() {
		Comparator <Task<? extends TaskID<?>>> compareByCategory = (o1, o2) ->
		o1.getCategory().compareTo(o2.getCategory()); {
			Collections.sort(TASKS, compareByCategory);
			System.out.println("Tasks Sorted By Category: ".toUpperCase());
			TASKS.forEach((category) -> System.out.println(category));
		}
		
	}
	
	public static void sortTasksByPriority() {
		Comparator <Task<? extends TaskID<?>>> compareByPriority = (o1, o2) -> 
		o1.getPriority().compareTo(o2.getPriority()); {
			Collections.sort(TASKS, compareByPriority);
			System.out.println("Tasks Sorted By Priority: ".toUpperCase());
			TASKS.forEach((priority) -> System.out.println(priority));
		}
	}
	
	public static void sortTasksByDeadline() {
		Comparator <Task<? extends TaskID<?>>> compareByDeadline = (o1, o2) ->
		o1.getDeadline().compareTo(o2.getDeadline()); {
			Collections.sort(TASKS, compareByDeadline);
			System.out.println("Tasks Sorted By deadline: ".toUpperCase());
			TASKS.forEach((deadline) -> System.out.println(deadline));
		}
	}
	
	public static void checkTaskName(Task<? extends TaskID<?>> t) {
		boolean nameExists = TASKS.stream()
				.anyMatch(task -> task.getName().equalsIgnoreCase(t.getName()));
		if(nameExists == true) {
			System.out.println("A task with this name already exists!");
		}
	}
	
	//Kompilyator predlozhil SupressWarning, no ne znayu, zachem on nuzhen
	@SuppressWarnings("null")
	//Hochu sdelat' metod, kotoryj proveryayet, net li zadanija s povtoryayushchimsya imenem, no somnevayus' pravil'no li yego sdelala
	//public static void addNewTask(Task<? extends TaskID<?>> t) {
		//if(TASKS.isEmpty() == true) {
			//TASKS.add(t);
		//}
		//List<String> names = new ArrayList<String>();
		//names.add(t.getName());
		//if(TASKS.isEmpty() == false) {
			//Stream<List<String>> stream = Stream.of(names);
			//boolean result = stream.noneMatch(name -> name.equals(t.getName()));
			//if(result == true) {
				//TASKS.add(t);
			//} else {
				//System.out.println("A task with this name already exists!");
			//}
		//}
	//}
	
	public static void printTaskNames() {
		System.out.println("Task Names: ".toUpperCase());
		TASKS.stream()
			.map(task -> task.getName())
			.forEach(System.out::println);
	}
	
	public static void deleteTask(Task<?> task) {
		System.out.println(task.getName() + " is deleted.");
		TASKS.remove(task);
	}
}