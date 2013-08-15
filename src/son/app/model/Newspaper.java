package son.app.model;

public class Newspaper {
	private String name;
	private String title;
	private int category;
	private int icon;
	
	public Newspaper(String name, String title, int category, int icon) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.category = category;
		this.icon = icon;
		this.title = title;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCategory(){
		return category;
	}
	
	public int getThumbnail(){
		return icon;
	}
	
	public String getTitle () {
		return title;
	}
}
