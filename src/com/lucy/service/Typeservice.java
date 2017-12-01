package com.lucy.service;

import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Type;
import com.lucy.common.BeanFactory;
import com.lucy.dao.NewsDao;
import com.lucy.dao.TypeDao;

public class Typeservice {

	TypeDao typeDao=(TypeDao) BeanFactory.getBean("TypeDao");

	public List<Type> gettype() {
		return typeDao.gettype();
	}
	public Type gettypeName(int typeId) {
		return typeDao.gettypeName(typeId);
	}
	
	public int counttype(){
		return typeDao.counttype();
	}
	public boolean  deletetype(String str){
		return typeDao.deletetype(str);
	}
	public boolean  inserttype(String str){
		return typeDao.inserttype(str);
	}
	public boolean uptype(Type type) {
		return typeDao.uptype(type);
	}
}
