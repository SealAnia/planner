package planner;

import java.util.Date;

public class SingleTimeTask extends Task<SingleTimeTaskID> {
	
	private SingleTimeTaskID singleTimeTaskID;
	
	public SingleTimeTask() {
		
	}
	
	public SingleTimeTask(String name, Date deadline, boolean isDone, 
			Priority priority, Category category, SingleTimeTaskID singleTimeTaskID) {
		super(name, priority, deadline, isDone, category, taskID);
		this.singleTimeTaskID = singleTimeTaskID;
	}
	
	public SingleTimeTaskID getSingleTimeTaskID() {
		return singleTimeTaskID;
	}
	
	public void setSingleTimeTaskID(SingleTimeTaskID singleTimeTaskID) {
		this.singleTimeTaskID = singleTimeTaskID;
	}
	
	@Override
	public String toString() {
		SingleTimeTaskID stti = new SingleTimeTaskID(null);
		return super.toString() + 
				"\n" + "The ID of your task is: " + stti.generateTaskID();
	}
	
	@Override
	public boolean equals(Object that) {
		if(this == that) {
			return true;
		}
		if(that == null || getClass() != that.getClass()) {
			return false;
		}
		SingleTimeTask t = (SingleTimeTask) that;
		return this.getName() == t.getName() && this.getCategory() == t.getCategory() 
				&& this.getPriority() == t.getPriority() && this.getDeadline() == t.getDeadline() 
				&& this.getIsDone() == t.getIsDone();
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
	
}
