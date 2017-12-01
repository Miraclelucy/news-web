package com.lucy.dao.datatool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @描述 升级版本--使用ing
 * @创建人 lushiqin
 * @创建时间 2017-11-12
 * @修改人和其它信息
 */
public class MyDataSourceUtil {
    private static ThreadLocal<Connection> tl=new ThreadLocal<>();

    //该类直接生成一个classpath目录下的配置文件中的数据连接池对象
    private static ComboPooledDataSource ds=new ComboPooledDataSource();

    /**
     * 获取数据源
     * @return 连接池
     */
    public static DataSource getDataSource(){
        return ds;
    }

    //获取一个连接
    public static Connection  getConnection()  throws SQLException{
        Connection conn = tl.get();
        if(conn==null){
            //第一次获取 创建一个连接 和当前的线程绑定
            conn=ds.getConnection();

            //绑定
            tl.set(conn);
        }
        return conn;


    }

    //释放连接
    public static void  closeConnection( Connection conn)  {
        if (conn != null) {
            try {
                conn.close();
                tl.remove();//和当前线程接触绑定
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    //开启事务
    public void  startTransaction() throws SQLException{
            Connection conn= getConnection();
            conn.setAutoCommit(false);
    }

    //提交事务

    public void  commitTransaction() throws SQLException{
        try {
            Connection conn= getConnection();
            conn.commit();
            closeConnection(conn);
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //回滚事务
    public void  rollbackTransaction() throws SQLException{
        try {
            Connection conn= getConnection();
            conn.rollback();
            closeConnection(conn);
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
