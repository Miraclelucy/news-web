package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Admin;
import com.lucy.bean.User;
import com.lucy.bean.User;
import com.lucy.dao.datatool.MyDataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;

public class UserDao {

	static DataSource ds=  MyDataSourceUtil.getDataSource();
	QueryRunner queryRunner = new QueryRunner(ds);

	/**
	 * 添加用戶
	 * 
	 */
	public boolean adduser(User user) {

		boolean flag = false;
		try {
			String sql="insert into tf_user (userName,userSex,userPassword,userEmail,userAdd,userState) values(?,?,?,?,?,?)";
			int updateNum = queryRunner.update(sql,user.getUserName(),user.getUserSex(),user.getUserPassword(),user.getUserEmail(),user.getUserAdd(),1);
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * 獲取全部用戶
	 * 
	 */
	public List<User> getall() {

		String  sql1="select userId,userName,userSex,userPassword,userEmail,userAdd,userState from tf_user";
		try {
			List<User> users=queryRunner.query(sql1,new BeanListHandler<>(User.class));
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public int countuser(){

		int count=0;
		try {
			Object o =queryRunner.query("select count(*)  from tf_user", new ScalarHandler());
			if(o!=null){
				count= Integer.parseInt(o==null?"":o.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
		
	}



	/**
	 *刪除用戶
	 */
	public boolean deluser(String ids) {

		boolean flag = false;
		try {
			int updateNum = queryRunner.update("delete from tf_user where userId in ('"+ids+"')");
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}
	/**
	 * 更改用戶狀態
	 */
	public boolean upuser(User user) {

		boolean flag = false;
		try {
			String  sql="update tf_user set userState=? where userId=?";
			int updateNum = queryRunner.update(sql,user.getUserState(),user.getUserId());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;


	}
	
	public User findUserByName(String name){

		String  sql1="select userId,userPassword,userState from tf_user where userName='"+name +"'";
		try {
			User user=queryRunner.query(sql1,new BeanHandler<>(User.class));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public User findUserById(int id){

		String  sql1="select userId,userPassword,userState from tf_user where userId="+id+" and userState='0'";
		try {
			User user=queryRunner.query(sql1,new BeanHandler<>(User.class));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

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
			if( findUserById(user.getUserId())!=null){
				flag = 2;//用戶名被禁用，标识爲2；
			}
			else{
				flag=3;//用戶名checkin,标识爲3；
			}
	    }
		return flag;
		
	}
}
