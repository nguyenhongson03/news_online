package son.app.model;

public class News {
	private String date;
	private String imageLink;
	private String title;
	private String link;
	private String content;
	private boolean isRead;
	
	public News(String title, String link, String imageLink) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.link = link;
		this.imageLink = imageLink;
		isRead = false;
	}
	
	public void setRead(boolean isRead){
		this.isRead = isRead;
	}
	
	public boolean isRead(){
		return isRead;
	}
	
	public String getLink(){
		return link;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getImageLink(){
		return imageLink;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
}