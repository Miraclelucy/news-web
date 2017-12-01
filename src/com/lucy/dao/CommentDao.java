package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Admin;
import com.lucy.bean.Comment;
import com.lucy.bean.News;
import com.lucy.dao.datatool.MyDataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;

public class CommentDao {

	static DataSource ds=  MyDataSourceUtil.getDataSource();
	QueryRunner queryRunner = new QueryRunner(ds);



	public List<Comment> getcomment() {

		String  sql1="select commentid,commenttype,commentnewid,commentname,commenttext  from tf_comment";
		try {
			List<Comment> comments=queryRunner.query(sql1,new BeanListHandler<>(Comment.class));
			return comments;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}


	}
	
	public int getCommentCount(){

		int count=0;
		try {
			Object o =queryRunner.query("select count(*)  from tf_comment", new ScalarHandler());
			if(o!=null){
				count= Integer.parseInt(o==null?"":o.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;


		
	}
	
	


	public boolean insertComment(Comment  m){

		boolean flag = false;
		try {
			String sql="insert into tf_comment (commentnewid,commentname,commenttext) values (?,?,?)";
			int updateNum = queryRunner.update(sql,m.getCommentnewid(), m.getCommentname(),m.getCommenttext());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public boolean delCommentbyid(String ids) {
		boolean flag = false;
		try {
			int updateNum = queryRunner.update("delete from tf_comment where commentid in ('"+ids+"')");
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;


	}

	/**
	 * 
	 */
	public boolean upComment(Comment  comment) {
		boolean flag = false;
		try {
			String  sql="update tf_comment set commentnewid=?,commentname=?,commenttext=?  where commentid=?";
			int updateNum = queryRunner.update(sql,comment.getCommentnewid(),comment.getCommentname(),comment.getCommenttext(),comment.getCommentid());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;


	}

	
	public List<String> getcommtitle(){
		String  sql="select n.new_title from tf_news n,tf_comment c where c.comm_news_id=n.new_id";
		try {
			List<String> comments=queryRunner.query(sql,new BeanListHandler<>(String.class));
			return comments;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
