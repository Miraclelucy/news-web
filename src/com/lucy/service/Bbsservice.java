package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.Bbs;
import com.lucy.common.BeanFactory;
import com.lucy.dao.AdminDao;
import com.lucy.dao.BBSDao;

public class Bbsservice {

	BBSDao bbsDao= (BBSDao) BeanFactory.getBean("BBSDao");
	public boolean insetbbs(String name, String tilte, String text) {
		return bbsDao.insetbbs(name, tilte, text);
	}
	public ArrayList<Bbs> getbbs() {
		return bbsDao.getbbs();
	}
	public boolean delbbs(int id) {
		return bbsDao.delbbs(id);
	}
		
		

}