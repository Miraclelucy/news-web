package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Comment;
import com.lucy.bean.News;
import com.lucy.dao.datatool.MyDataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;


public class NewsDao {

	static DataSource ds=  MyDataSourceUtil.getDataSource();
	QueryRunner queryRunner = new QueryRunner(ds);

	/**
	 * 
	 * 
	 * @return
	 */
	public List<News> getnews() {
		String  sql1="select newId,newTitle,newContent,newType,newTime  from tf_news";
		try {
			List<News> news=queryRunner.query(sql1,new BeanListHandler<>(News.class));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}


	public int countnew(){

		int count=0;
		try {
			Object o =queryRunner.query("select count(*)  from tf_news", new ScalarHandler());
			if(o!=null){
				count= Integer.parseInt(o==null?"":o.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	

	public boolean insertnew(News news) {

		boolean flag = false;
		try {
			String sql="insert into tf_news(newTitle,newContent,newType,newTime) values(?,?,?,?)";
			int updateNum = queryRunner.update(sql,news.getNewTitle(),news.getNewContent(),news.getNewType(),news.getNewTime());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;


	}

	public boolean delnewsbyid(String delIds) {

		boolean flag = false;
		try {
			int updateNum = queryRunner.update("delete from tf_news where newId in ("+delIds+")");
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
	public boolean upnews(News news) {
		boolean flag = false;
		try {
			String  sql="update tf_news set newType=?,newTitle=?,newContent=?,newTime=?  where newId=?";
			int updateNum = queryRunner.update(sql,news.getNewType(),news.getNewTitle(),news.getNewContent(),news.getNewTime(),news.getNewId());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * 根据关键字模糊查找新闻 
	 */
	public List<News> chuaxun(String str) {
		str = "'%" + str + "%'";
		String  sql1="select newId,newTitle,newContent,newType,newTime from tf_news where newTitle like "
				+ str + " or newContent  like " + str + "";
		try {
			List<News> news=queryRunner.query(sql1,new BeanListHandler<>(News.class));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 根据ID号获取新闻
	 */
	public List<News> getnews(int newsid) {

		String  sql1="select newId,newTitle,newContent,newType,newTime from tf_news  where newId ='"+newsid+"'";
		try {
			List<News> news=queryRunner.query(sql1,new BeanListHandler<>(News.class));
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 */
	/*public ArrayList<String> gettype(int id) {
		return types;

	}*/

}
