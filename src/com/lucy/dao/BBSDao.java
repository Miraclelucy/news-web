package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.lucy.bean.Bbs;

public class BBSDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ArrayList<Bbs> bbs = null;
	private boolean flag;

	/**
	 * 获取全部留言
	 */
	public ArrayList<Bbs> getbbs() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn
					.prepareStatement("select bbsUsername,bbsTime,bbsContent,bbsId from tf_bbs");
			rs = ps.executeQuery();
			bbs = new ArrayList<Bbs>();
			while (rs.next()) {
				Bbs bb = new Bbs(rs.getString(1), rs.getString(2).substring(0,10), rs.getString(3),  rs.getInt(4));
				bbs.add(bb);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return bbs;
	}

	/**
	 * 添加留言
	 */
	public boolean insetbbs(String name, String tilte, String text) {
		conn = com.lucy.until.Connsql.getconn();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		try {
			ps=conn.prepareStatement("insert into tf_bbs(bbsUsername,bbsContent,bbsTitle,bbsTime) values(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,text);
			ps.setString(3, tilte);
			ps.setString(4, df.format(new Date()));
            int rs=ps.executeUpdate();
            if(rs>0){
            	flag=true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
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
/**
 * 删除留言
 */
	public boolean delbbs(int id) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps=conn.prepareStatement("delete tf_bbs where bbsId=? ");
			ps.setInt(1, id);
            int rs=ps.executeUpdate();
            if(rs>0){
            	flag=true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}	
}
