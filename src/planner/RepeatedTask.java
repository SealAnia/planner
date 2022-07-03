package planner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RepeatedTask extends Task<RepeatedTaskID> {
	
	private int frequency;
	private RepeatedTaskID repeatedTaskID;
	
	public RepeatedTask() {
		
	}
	
	public RepeatedTask(String name, Date deadline, boolean isDone, int frequency, 
			Priority priority, Category category, RepeatedTaskID repeatedTaskID) {
		super(name, priority, deadline, isDone, category, taskID);
		this.frequency = frequency;
		this.repeatedTaskID = repeatedTaskID;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public RepeatedTaskID getRepeatedTaskID() {
		return repeatedTaskID;
	}
	
	public void setRepeatedTaskID(RepeatedTaskID repeatedTaskID) {
		this.repeatedTaskID = repeatedTaskID;
	}
	
	@Override
	public String toString() {
		RepeatedTaskID rti = new RepeatedTaskID(null);
		return super.toString() + 
				"\n" + "Frequency: once is " + frequency  + " days" + 
				"\n" + "The ID of your task is: " + rti.generateTaskID();
	}
	
	@Override
	public boolean equals(Object that) {
		if(this == that) {
			return true;
		}
		if(that == null || getClass() != that.getClass()) {
			return false;
		}
		RepeatedTask t = (RepeatedTask) that;
		return this.getName() == t.getName() && this.getCategory() == t.getCategory() 
				&& this.getPriority() == t.getPriority() && this.getDeadline() == t.getDeadline() 
				&& this.getIsDone() == t.getIsDone() && this.frequency == t.frequency;
	}
	
	@Override
	public int hashCode() {
	   int result = getName() == null ? 0 : getName().hashCode();
	   result = 31 * result + (getCategory() == null ? 0 : getCategory().hashCode());
	   result = 31 * result + (getPriority() == null ? 0 : getPriority().hashCode());
	   result = 31 * result + (getDeadline() == null ? 0 : getDeadline().hashCode());
	   result = 31 * result + (getDeadline() == null ? 0 : getDeadline().hashCode());
	   result = 31 * result + frequency;
	   return result;
	}
	
	public void resetDeadline() {
		Date today = new Date();
		Date deadline = getDeadline();
		do {
			Long period = deadline.getTime() - today.getTime();
			if(TimeUnit.MILLISECONDS.toDays(period) < 0) {
				Long millis = TimeUnit.DAYS.toMillis(getFrequency());
				Long newDeadline = getDeadline().getTime() + millis;
				deadline = new Date(newDeadline);
				super.setDeadline(deadline);
			}
		} while(getIsDone() != false);
	}
	
}
