package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.Comment;
import com.lucy.dao.Getcomment;

public class Commentservice { 
       
	Getcomment  commentdao=new Getcomment();
	public ArrayList<Comment> getcomment() {
		return commentdao.getcomment();
	}
	public ArrayList<String> getcommtitle(){
		return commentdao.getcommtitle();
	}
	public int getCommentCount(){
		return commentdao.getCommentCount();
	}
	
	public boolean delCommentbyid(String delIds) {
		return commentdao.delCommentbyid(delIds);
	}
	
	public boolean upComment(Comment comment) {
	return commentdao.upComment(comment);
	}
	
	public boolean insertComment(Comment comment) {
		return commentdao.insertComment(comment);
		}
	
}
