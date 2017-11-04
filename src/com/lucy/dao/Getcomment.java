package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lucy.bean.Comment;
import com.lucy.bean.News; 

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
						.getInt(3), res.getString(4), res.getString(5));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
		return comments;

	}
	
	public int getCommentCount(){
		conn = com.lucy.until.Connsql.getconn();
		int count=0;
		try {
			ps = conn.prepareStatement("select * from tf_comment");
			res = ps.executeQuery();
			while(res.next()){
				count++;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
		finally {
			close();
		}	
		
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
			e.printStackTrace();
		}

	}
	
	public boolean insertComment(Comment  m){
		boolean flag=false;
		conn=com.lucy.until.Connsql.getconn();
		String sql="insert into tf_comment (commentnewid,commentname,commenttext) values (?,?,?)";
		try{
				ps = conn.prepareStatement(sql);
				ps.setInt(1, m.getCommentnewid());
		        ps.setString(2, m.getCommentname());    
		        ps.setString(3, m.getCommenttext());
				int res = ps.executeUpdate();
				if (res > 0) {
					flag = true;
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			} finally {
				close();
			}
		return flag;
		
	}
	
	public boolean delCommentbyid(String delIds) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {			
			String sql="delete from tf_comment where commentid in ('"+delIds+"')";
			PreparedStatement ps=conn.prepareStatement(sql);
			int res = ps.executeUpdate();
			if (res > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return flag;
	}

	/**
	 * 
	 */
	public boolean upComment(Comment comment) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("update tf_comment set commentnewid='"
					+ comment.getCommentnewid() + "',commentname='" + comment.getCommentname()
					+ "',commenttext='" + comment.getCommenttext()
					+ "'  where commentid="+comment.getCommentid());
			int res = ps.executeUpdate();
			if (res > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return flag;
	}

	
	public ArrayList<String> getcommtitle(){
		conn=com.lucy.until.Connsql.getconn();
		try {
			ps=conn.prepareStatement("select n.new_title from tf_news n,tf_comment c where c.comm_news_id=n.new_id");
			res=ps.executeQuery();
			v=new ArrayList<String>();
			while(res.next()){
				v.add(res.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return v;
	}

}
