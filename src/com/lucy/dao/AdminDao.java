package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Admin;
import com.lucy.dao.datatool.MyDataSource;
import com.lucy.dao.datatool.MyDataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;

public class AdminDao {


	static DataSource ds=  MyDataSourceUtil.getDataSource();
	QueryRunner queryRunner = new QueryRunner(ds);


	/**
	 *
	 * 获取全部管理员
	 */
	public List<Admin> getall() {
		String  sql1="select adminId,adminName,adminPwd from tf_admin";
		try {
			List<Admin> cardrs=queryRunner.query(sql1,new BeanListHandler<>(Admin.class));
			return cardrs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public int countadmin(){
		int count=0;
		try {
			Object o =queryRunner.query("select count(*)  from tf_admin", new ScalarHandler());
			if(o!=null){
				count= Integer.parseInt(o==null?"":o.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}
	/**
	 * 验证管理员登录
	 */
	public  boolean checkAdmin(String name,String pwd){
		boolean flag = false;
		try {
			String  sql="select count(*)  from tf_admin  where adminName='"+name+"' and adminPwd='"+pwd+"'";
			Object number =queryRunner.query(sql,new ScalarHandler());
			System.out.println("---数据库中验证管理员登录---"+number);
			if(number!=null){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  flag;
	}
	/**
	 * 删除管理员
	 */
	public boolean del(String ids){
		boolean flag = false;
		try {
			int updateNum = queryRunner.update("delete from tf_admin where adminId in ('"+ids+"')");
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
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
		try {
			String sql="insert into tf_admin(adminName,adminPwd) values(?,?)";
			int updateNum = queryRunner.update(sql,admin.getAdminName(),admin.getAdminPwd());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	/**
	 * 更改管理员密码
	 */
	public boolean upadmin(Admin admin) {
		boolean flag = false;
		try {
			String  sql="update tf_admin set adminPwd=? where adminId=?";
			int updateNum = queryRunner.update(sql,admin.getAdminPwd(),admin.getAdminId());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


//	public void close() {
//		try {
//			if (res != null) {
//				res.close();
//			}
//			if (ps != null) {
//				ps.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//
//	}

}
