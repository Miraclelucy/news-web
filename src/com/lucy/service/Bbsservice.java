package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.Bbs;

public class Bbsservice {
	

	public boolean insetbbs(String name, String tilte, String text) {
		return new com.lucy.dao.Getbbs().insetbbs(name, tilte, text);
	}
	public ArrayList<Bbs> getbbs() {
		return new com.lucy.dao.Getbbs().getbbs();
	}
	public boolean delbbs(int id) {
		return new com.lucy.dao.Getbbs().delbbs(id);
	}
		
		

}