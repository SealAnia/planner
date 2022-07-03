package planner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Task<T extends TaskID<?>> implements TaskInterface {
	
	private String name;
	private Category category;
	private Priority priority;
	private Date deadline;
	private boolean isDone = false;
	protected static TaskID<?> taskID;

	public Task() {
		
	}
	
	public Task(String name, Priority priority, Date deadline, 
			boolean isDone, Category category, TaskID<?> taskID) {
		this.name = name;
		this.category = category;
		this.priority = priority;
		this.deadline = deadline;
		this.isDone = isDone;
		this.taskID = taskID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public TaskID<?> getTaskID() {
		return taskID;
	}
	
	public void setTaskID() {
		this.taskID = taskID;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return("Task Info: \n" + name + "\n" + "Priority: " + priority + "\n"
				+ "Deadline: " + sdf.format(deadline) + "\n" + "Is done: " + isDone + "\n" 
				+ "Category: " + category);
	}
	
	//Etot metod ne vazhen, no udalyat' zhalko
	public void create(Object task) {
		System.out.println("New task is created!");
	}
	
	public void printTimeToDeadline() {
		Date today = new Date();
		Date deadline = getDeadline();
		Long period = deadline.getTime() - today.getTime();
		System.out.println(TimeUnit.MILLISECONDS.toDays(period) + " days are left!");
	}
	
	@Override
	public boolean equals(Object that) {
		if(this == that) {
			return true;
		}
		if(that == null || getClass() != that.getClass()) {
			return false;
		}
		Task<?> t = (Task<?>) that;
		return this.name == t.name && this.category == t.category && this.priority == t.priority 
				&& this.deadline == t.deadline && this.isDone == t.isDone;
	}

	@Override
	public int hashCode() {
	   int result = getName() == null ? 0 : getName().hashCode();
	   result = 31 * result + (getCategory() == null ? 0 : getCategory().hashCode());
	   result = 31 * result + (getPriority() == null ? 0 : getPriority().hashCode());
	   result = 31 * result + (getDeadline() == null ? 0 : getDeadline().hashCode());
	   result = 31 * result + (getDeadline() == null ? 0 : getDeadline().hashCode());
	   return result;
	}
	
	public void compare(Object o1, Object o2) {
		if(o1.hashCode() == o2.hashCode()) {
			System.out.println("This task already exists!");
		}
	}
	
}