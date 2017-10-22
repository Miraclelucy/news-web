package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.News;
import com.lucy.bean.Type;

public class Typeservice {
	
	
	/**
	 * 新闻类型CRUD
	 */
	public ArrayList<Type> gettype() {
		return new com.lucy.dao.GetType().gettype();
	}
	public Type gettypeName(int typeId) {
		return new com.lucy.dao.GetType().gettypeName(typeId);
	}
	
	public int counttype(){
		return new com.lucy.dao.GetType().counttype();
	}
	public boolean  deletetype(String str){
		return new com.lucy.dao.GetType().deletetype(str);
	}
	public boolean  inserttype(String str){
		return new com.lucy.dao.GetType().inserttype(str);
	}
	public boolean uptype(Type type) {
		return new com.lucy.dao.GetType().uptype(type);
	}
}
