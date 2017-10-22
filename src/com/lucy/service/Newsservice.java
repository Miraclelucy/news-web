package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.News;

public class Newsservice {
	
	/**
	 * ���ŵ�CRUD
	 * @return
	 */
	public ArrayList<News> getnews(){
		return  new com.lucy.dao.GetNews().getnews();
	}
	public boolean insertnew(News news){
		return new com.lucy.dao.GetNews().insertnew(news);
	}
	public int countnew(){
		return new com.lucy.dao.GetNews().countnew();
	}
	public  boolean delnewsbyid(String delIds){
		return new com.lucy.dao.GetNews().delnewsbyid(delIds);
	}
	public boolean upnews(News news){
		return new com.lucy.dao.GetNews().upnews(news);
	}
	public ArrayList<News> getnews(int newsid) {
		return new com.lucy.dao.GetNews().getnews(newsid);
	}
	public ArrayList<News> chuaxun(String str) {
		return new com.lucy.dao.GetNews().chuaxun(str);
	}
}
