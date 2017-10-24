package com.lucy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lucy.bean.Type;

public class GetType {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet res = null;
	private ArrayList<Type> types = null;
	private boolean flag;
	/**
	 * 
	 */
	public ArrayList<Type> gettype() {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select * from  tf_type");
			res = ps.executeQuery();
			types = new ArrayList<Type>();
			while (res.next()) {
				Type type=new Type(res.getInt(1),res.getString(2));
				types.add(type);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return types;
	}
	/**
	 * 根据类型Id获取类型名称
	 */
	public Type gettypeName(int typeId) {
		conn = com.lucy.until.Connsql.getconn();
		Type type=null;
		try {
			ps = conn.prepareStatement("select * from  tf_type where typeId="+typeId);
			res = ps.executeQuery();		
			while (res.next()) {
				 type=new Type(res.getInt(1),res.getString(2));				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return type;
	}
	/**
	 * 
	 * 
	 * @param news
	 * @return
	 */
	public int counttype(){
		conn = com.lucy.until.Connsql.getconn();
		int count=0;
		try {
			ps = conn.prepareStatement("select * from tf_type");
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
	 */
	public boolean deletetype(String str) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			String sql="delete from tf_type where typeId in ('"+str+"')";
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
	public boolean inserttype(String str) {
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("insert into tf_type(typeName) values(?) ");
			ps.setString(1, str);
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
	public boolean uptype(Type type) {
		boolean flag = false;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("update tf_type set typeName='"
					+ type.getTypeName()+"'where typeId="+type.getTypeId());
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
