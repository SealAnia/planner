package planner;

public enum Category {
	
	SINGLETIME("Single-time"),
	REPEATED("Repeated");
	
	private String category;

	Category(String category) {
		this.category = category;
	}
	
	//public String getCategory() {
		//return category;
	//}
	
	//public void setCategory(String category) {
		//this.category = category;
	//}
	
	@Override
    public String toString() {
        return category;
    }
	
}