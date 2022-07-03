package planner;

public abstract class TaskID<I> {
	
	protected I taskID;
	
	protected TaskID(I taskID) {
		this.taskID = taskID;
	}
	
	public abstract I generateTaskID();
	
	@Override
	public String toString() {
		return generateTaskID().toString();
	}

}