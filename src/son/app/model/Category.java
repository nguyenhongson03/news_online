package son.app.model;

public class Category {
	private String name;
	private String description;
	private String[] items;
	
	public Category(String name, String description, String[] items) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.description = description;
		this.items = items;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String[] getItems(){
		return items;
	}
}
