package com.lucy.service;

import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Comment;
import com.lucy.common.BeanFactory;
import com.lucy.dao.BBSDao;
import com.lucy.dao.CommentDao;

public class Commentservice {

	CommentDao commentdao = (CommentDao) BeanFactory.getBean("CommentDao");

	public List<Comment> getcomment() {
		return commentdao.getcomment();
	}

	public List<String> getcommtitle() {
		return commentdao.getcommtitle();
	}

	public int getCommentCount() {
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
