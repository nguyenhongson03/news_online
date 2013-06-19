package son.app.model;

public class Newspaper {
	private String name;
	private int category;
	private boolean isSelect;
	
	public Newspaper(String name, int category) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.category = category;
		isSelect = false;
	}
	
	public void setIsSelect(boolean isSelect){
		this.isSelect = isSelect;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isSelect(){
		return isSelect;
	}
	
	public int getCategory(){
		return category;
	}
}
