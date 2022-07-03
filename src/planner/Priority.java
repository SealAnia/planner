package planner;

import test.NonParseableStringException;

public enum Priority {
	
	URGENT("Urgent!"),
	MEDIUM("Medium priority"),
	LITTLE("Little priority");
	
	private String priority;
	
	Priority(String priority) {
		this.priority = priority;
	}
	
	//Tut ne nuzhny gettery i settery?
	//public String getPriority() {
		//return priority;
	//}
	
	//public void setPriority(String priority) {
		//this.priority = priority;
	//}
	
	@Override
	public String toString() {
		return priority;
	}

	public static Priority parse(String priority) throws NonParseableStringException {
		try {
			return valueOf(priority);
		}
		catch(NullPointerException e) {
            throw new NonParseableStringException("Entered value is null.");
        } catch (IllegalArgumentException e) {
            throw new NonParseableStringException("Entered value is invalid.");
        }
	}

}