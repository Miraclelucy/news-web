package com.lucy.until;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connsql {
	private static Connection conn=null;
	  // JDBC 驱动名及数据库 URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://10.10.69.131:3306/atest?useUnicode=true&characterEncoding=utf8";

  // 数据库的用户名与密码，需要根据自己的设置
  static final String USER = "ossm";
  static final String PASS = "dGlEh&AcI#*gRz1RX";
  
	public static  Connection getconn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println();
		} catch (Exception e) {               
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/*private static Connection conn=null;
	
	public static  Connection getconn(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=news", "sa", "123");
		} catch (Exception e) {               
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}*/
	public static void main(String[] args) {
		System.out.println(Connsql.getconn());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}


}
