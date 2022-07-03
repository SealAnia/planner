package planner;

public class SingleTimeTaskID extends TaskID<Integer> {
	
	public SingleTimeTaskID singleTimeTaskID;
	
	public SingleTimeTaskID(Integer taskID) {
		super(taskID);
	}
	
	@Override
	public Integer generateTaskID() {
		return (int)(Math.random() * 999999 + 100000);
	}
	
}
