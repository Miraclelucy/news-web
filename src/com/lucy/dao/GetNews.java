package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lucy.bean.News;

/**
 * 
 * CRUD
 * 
 * @author Administrator
 * 
 */
public class GetNews {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet res = null;
	private ArrayList<News> news = null;
	private ArrayList<String> types = null;
	private boolean flag;

	/**
	 * 
	 * 
	 * @return
	 */
	public ArrayList<News> getnews() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select * from tf_news");
			res = ps.executeQuery();
			news = new ArrayList<News>();
			while (res.next()) {
				News newsall = new News( res.getInt(1),res.getString(2),res.getString(3), res.getString(4),res.getString(5));

				news.add(newsall);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return news;
	}

	/**
	 * 
	 * 
	 * @param news
	 * @return
	 */
	public int countnew(){
		conn = com.lucy.until.Connsql.getconn();
		int count=0;
		try {
			ps = conn.prepareStatement("select * from tf_news");
			res = ps.executeQuery();
			while(res.next()){
				count++;
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}	
	}
	
	
	/**
	 * 
	 * 
	 * @param news
	 * @return
	 */
	public boolean insertnew(News news) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		if (conn != null) {
			try {
				// Date date = new Date();
				// SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
				// String dat = sim.format(date);
				System.out.println(news.getNewTitle());
				System.out.println(news.getNewContent());
				System.out.println(news.getNewType());
				
				ps = conn
						.prepareStatement("insert into tf_news(newTitle,newContent,newType,newTime) values(?,?,?,?)");
                 ps.setString(1, news.getNewTitle());
                 ps.setString(2, news.getNewContent());    
                 ps.setString(3, news.getNewType());
                 ps.setString(4, news.getNewTime());
				int res = ps.executeUpdate();
				if (res > 0) {
					flag = true;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				close();
			}
		}
		return flag;
	}
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public boolean delnewsbyid(String delIds) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {			
			String sql="delete from tf_news where newId in ('"+delIds+"')";
			PreparedStatement ps=conn.prepareStatement(sql);
			int res = ps.executeUpdate();
			if (res > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return flag;
	}

	/**
	 * 
	 */
	public boolean upnews(News news) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("update tf_news set newType='"
					+ news.getNewType() + "',newTitle='" + news.getNewTitle()
					+ "',newContent='" + news.getNewContent()
					+ "',newTime='" + news.getNewTime()
					+ "'where newId="+news.getNewId());
			int res = ps.executeUpdate();
			if (res > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return flag;
	}

	/**
	 * 根据关键字模糊查找新闻 
	 */
	public ArrayList<News> chuaxun(String str) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			str = "'%" + str + "%'";
			ps = conn
					.prepareStatement("select * from tf_news where newTitle like "
							+ str + " or newContent  like " + str + "");
			res = ps.executeQuery();
			news = new ArrayList<News>();
			while (res.next()) {
				News newsall = new News(res.getInt(1), res.getString(2), res
						.getString(3), res.getString(4), res.getString(5));

				news.add(newsall);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return news;
	}

	/**
	 * 根据ID号获取新闻
	 */
	public ArrayList<News> getnews(int newsid) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select * from tf_news where newId =?");
			ps.setInt(1, newsid);
			res = ps.executeQuery();
			news = new ArrayList<News>();
			if (res.next()) {
				News newsall = new News(res.getInt(1), res.getString(2), res
						.getString(3), res.getString(4), res.getString(5));

				news.add(newsall);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return news;
	}

	/**
	 * 
	 */
	public ArrayList<String> gettype(int id) {
		return types;

	}
	
	/**
	 * 
	 */
	private void close() {

		try {
			if (res != null) {
				res.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	

}
