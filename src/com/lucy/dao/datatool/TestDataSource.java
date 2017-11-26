package com.lucy.dao.datatool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class TestDataSource {
    public static void main(String[] args) {
        MyDataSource myds=new MyDataSource();
        Connection con=myds.getConnection();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
