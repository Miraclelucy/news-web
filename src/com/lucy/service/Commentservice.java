package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.Comment;

public class Commentservice {
       
	public ArrayList<Comment> getcomment() {
		return new com.lucy.dao.Getcomment().getcomment();
	}
	public ArrayList<String> getcommtitle(){
		return new com.lucy.dao.Getcomment().getcommtitle();
	}
}
