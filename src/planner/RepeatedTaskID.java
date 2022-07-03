package planner;

public class RepeatedTaskID extends TaskID<String> {
	
	public RepeatedTaskID repeatedTaskID;
	
	public RepeatedTaskID(String taskID) {
		super(taskID);
	}
	
	@Override
	public String generateTaskID() {
		
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		char[] symbols = str.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(int x = 0; x < 6; x++) {
			int y = (int)(Math.random() * str.length());
			sb.append(symbols[y]);
			}
		
		taskID = sb.toString();
		return taskID;
	}
	
}
