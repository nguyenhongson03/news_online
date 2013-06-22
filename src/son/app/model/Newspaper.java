package son.app.model;

public class Newspaper {
	private String name;
	private int category;
	private boolean isSelect;
	private String thumbnail;
	
	public Newspaper(String name, int category, String thumbnail) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.category = category;
		isSelect = false;
		this.thumbnail = thumbnail;
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
	
	public String getThumbnail(){
		return thumbnail;
	}
}
