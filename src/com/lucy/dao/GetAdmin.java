package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.lucy.bean.Admin;

public class GetAdmin {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet res = null;
	private ArrayList<Admin> v = null;
    private boolean flag;


    


	/**
	 *
	 * 获取全部管理员
	 */
	public ArrayList<Admin> getall() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select adminId,adminName,adminPwd from tf_admin");
			res = ps.executeQuery();
			v = new ArrayList<Admin>();
			while (res.next()) {
				Admin admin = new Admin(res.getInt(1),res.getString(2), res.getString(3));
				v.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return v;
	}
	
	public int countadmin(){
		
		conn = com.lucy.until.Connsql.getconn();
		int count=0;
		try {
			ps = conn.prepareStatement("select * from tf_admin");
			res = ps.executeQuery();
			while(res.next()){
				count++;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}	
	}
	/**
	 * 验证管理员登录
	 */
	public  boolean checkAdmin(String name,String pwd){
		conn=com.lucy.until.Connsql.getconn();
		try {
			ps=conn.prepareStatement("select * from tf_admin where adminName=? and adminPwd=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			res=ps.executeQuery();
			if(res.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return  flag; 
	}
	/**
	 * 删除管理员
	 */
	public boolean del(String ids){
		boolean flag = false;
		conn=com.lucy.until.Connsql.getconn();
		try {
			String sql="delete from tf_admin where adminId in ('"+ids+"')";
			PreparedStatement ps=conn.prepareStatement(sql);
			int res = ps.executeUpdate();
			if(res>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	/**
	 * 添加管理员
	 * 	
	 */
	public boolean add(Admin admin){
		boolean flag = false;
		conn=com.lucy.until.Connsql.getconn();
		try {
			ps=conn.prepareStatement("insert into tf_admin(adminName,adminPwd) values(?,?)");
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getAdminPwd());		
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
	 * 更改管理员密码
	 */
	public boolean upadmin(Admin admin) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("update tf_admin set adminPwd='"
					+ admin.getAdminPwd() + "'where adminId="+admin.getAdminId());
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

}
