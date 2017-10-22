package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lucy.bean.Comment;

public class Getcomment {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet res = null;
	private Comment comment = null;
	private ArrayList<Comment> comments = null;
	private ArrayList<String> v = null;

	public ArrayList<Comment> getcomment() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select * from tf_comment");
			res = ps.executeQuery();
			comments = new ArrayList<Comment>();
			while (res.next()) {
				comment = new Comment(res.getInt(1), res.getString(2), res
						.getInt(3), res.getString(4), res.getInt(5));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return comments;

	}

	public  void close() {
		try {
			if (ps != null) {
				ps.close();
			}
			if (res != null) {
				res.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ArrayList<String> getcommtitle(){
		conn=com.lucy.until.Connsql.getconn();
		try {
			ps=conn.prepareStatement("select n.new_title from tf_news n,comment c where c.comm_news_id=n.new_id");
			res=ps.executeQuery();
			v=new ArrayList<String>();
			while(res.next()){
				v.add(res.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return v;
	}

}
