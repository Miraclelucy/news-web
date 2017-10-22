package com.lucy.bean;

public class News {
	private int  newId;
	private String newTitle;
	private String newContent;
	private String newType;	
	private String newTime;


	public News() {
		super();
	}
	public News(String newTitle,  String newContent ,String newType ){
		this.newTitle = newTitle;
		this.newContent = newContent;
		this.newType = newType;
		
		
	}	
	public News(String newTitle,  String newContent ,String newType,String newtime) {
		this.newTitle = newTitle;
		this.newContent = newContent;
		this.newType = newType;
		this.newTime=newtime;
		
	}
	public News(int newId,String newtitle, String newContent, String newtype,
			String newtime
			) {
		super();
		this.newId = newId;
		this.newContent = newContent;
		this.newTime = newtime;		
		this.newType = newtype;
		this.newTitle = newtitle;

	}
	public int getNewId() {
		return newId;
	}
	public void setNewId(int newId) {
		this.newId = newId;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public String getNewType() {
		return newType;
	}
	public void setNewType(String newType) {
		this.newType = newType;
	}
	public String getNewTime() {
		return newTime;
	}
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
	
	

}
