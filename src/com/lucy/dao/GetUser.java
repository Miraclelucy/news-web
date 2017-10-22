package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lucy.bean.User;
import com.lucy.bean.User;

public class GetUser {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet res = null;
	private ArrayList<User> v = null;
	private boolean flag;
	/**
	 * 添加用戶
	 * 
	 */
	public boolean adduser(User user) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn
					.prepareStatement("insert into tf_user (userName,userSex,userPassword,userEmail,userAdd,userState) values(?,?,?,?,?,?)");
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserSex());
			ps.setString(3, user.getUserPassword());
			ps.setString(4, user.getUserEmail());
			ps.setString(5, user.getUserAdd());
			ps.setInt(6, 1);//設置用戶狀態，“可用”爲1，禁用爲0；
			int rs = ps.executeUpdate();
			if (rs > 0) {
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
	 * 獲取全部用戶
	 * 
	 */
	public ArrayList<User> getall() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select userId,userName,userSex,userPassword,userEmail,userAdd,userState from tf_user");
			v = new ArrayList<User>();
			res = ps.executeQuery();
			while (res.next()) {
				User user = new User(res.getInt(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getInt(7));
				v.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return v;

	}
	public int countuser(){
		conn = com.lucy.until.Connsql.getconn();
		int count=0;
		try {
			ps = conn.prepareStatement("select * from tf_user");
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

	public void close() {
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

	/**
	 *刪除用戶
	 */
	public boolean deluser(String ids) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			String sql="delete from tf_user where userId in ('"+ids+"')";
			PreparedStatement ps=conn.prepareStatement(sql);		
			int rs = ps.executeUpdate();
			if (rs > 0) {
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
	 * 更改用戶狀態
	 */
	public boolean upuser(User user) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("update tf_user set userState='"
					+ user.getUserState() + "'where userId="+user.getUserId());
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
	
	public User findUserByName(String name){
		conn = com.lucy.until.Connsql.getconn();
		User user =null;
		try {
			ps = conn.prepareStatement("select userId,userPassword,userState from tf_user where userName='"+name +"'");
			res = ps.executeQuery();		
			while (res.next()) {
				user = new User(res.getInt(1), res.getString(2),res.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return user;
		
	}
	
	public int checkLogin(String name, String pwd){
		int flag = 0;
		User user=findUserByName(name);
		if(user==null){
			flag=0;//用戶名不存在，标识爲0；			
		}
		else if(!pwd.equals(user.getUserPassword()))
		{
			flag=1;//用戶名與密碼不匹配，标识爲1；
		}
		else {
			conn = com.lucy.until.Connsql.getconn();
			try {
				ps = conn.prepareStatement("select * from tf_user where userId="+user.getUserId()+"and userState=0");
				res = ps.executeQuery();
				if(res.next()) {
					flag = 2;//用戶名被禁用，标识爲2；
				}
				else{
					flag=3;//用戶名checkin,标识爲3；
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
	    }
		return flag;
		
	}
}
