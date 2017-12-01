package com.lucy.service;

import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.News;
import com.lucy.common.BeanFactory;
import com.lucy.dao.NewsDao;

public class Newsservice {
	NewsDao newsDao=(NewsDao) BeanFactory.getBean("NewsDao");

	public List<News> getnews(){
		return  newsDao.getnews();
	}
	public boolean insertnew(News news){
		return newsDao.insertnew(news);
	}
	public int countnew(){
		return newsDao.countnew();
	}
	public  boolean delnewsbyid(String delIds){
		return newsDao.delnewsbyid(delIds);
	}
	public boolean upnews(News news){
		return newsDao.upnews(news);
	}
	public List<News> getnews(int newsid) {
		return newsDao.getnews(newsid);
	}
	public List<News> chuaxun(String str) {
		return newsDao.chuaxun(str);
	}
}
