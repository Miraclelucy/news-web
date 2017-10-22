package com.lucy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��û�����Ϣ
 * 
 * @author Administrator
 * 
 */
public class Getcontext {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public String getcontext() {
		String str = null;
		conn = com.lucy.until.Connsql.getconn();
		try {
			ps = conn.prepareStatement("select * from tf_context");
			rs = ps.executeQuery();
			while (rs.next()) {
				str = rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return str;
	}

	private void close() {

		try {
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �޸Ļ���
	 */
	public boolean xiugai(String str) {
		boolean flag = false;
         conn=com.lucy.until.Connsql.getconn();
         try {
			ps=conn.prepareStatement("update tf_context set context=?");
			ps.setString(1, str);
			int rs=ps.executeUpdate();
			if(rs>0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		return flag;
	}
}
