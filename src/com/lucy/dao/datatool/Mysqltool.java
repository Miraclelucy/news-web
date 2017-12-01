package com.lucy.dao.datatool;

import java.sql.Connection;
import java.sql.DriverManager;
import com.lucy.until.Connsql;

/**  
 * @Title: 初级版本--已废弃
 * @Package com.lucy.dao.datatool
 * @Description: 
 * @author lushiqin  
 * @date 2017年10月21日 下午9:59:22
 * @version V1.0  
 */
public class Mysqltool {
	private static Connection conn=null;
	  // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://10.10.69.131:3306/atest";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "ossm";
    static final String PASS = "dGlEh&AcI#*gRz1RX";
    
	public static  Connection getconn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}
	public static void main(String[] args) {
		System.out.println(Mysqltool.getconn());


	}

}
