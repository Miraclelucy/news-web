package com.lucy.dao.demo;
import com.lucy.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.util.Arrays;
import java.util.*;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.*;

/**
 * @描述 两种方式配置c3p0的源文件
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class C3p0Demo {

    public static void main(String[] args) throws Exception {
        //空参，自动到classpath目录下面加载“c3p0-config.xml”或者c3p0.properties配置文件---配置文件的存储位置和名称必须是这样，且使用“默认配置”
        ComboPooledDataSource ds= new ComboPooledDataSource();
        //ComboPooledDataSource pool = new ComboPooledDataSource("demo");//加载“c3p0-config.xml”文件中定义的“demo”这个配置元素

        /* ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://10.10.69.131:3306/atest");
        ds.setUser("ossm");
        ds.setPassword("dGlEh&AcI#*gRz1RX");*/

        Connection conn=ds.getConnection();
        System.out.println(conn);
        QueryRunner qurey=new QueryRunner(ds);
        String sql="select userid,username from tf_user ";
        Object []  obj=qurey.query(sql,new ArrayHandler());
        System.out.println(Arrays.toString(obj));

        List<Object[] > obj2=qurey.query(sql,new ArrayListHandler());
        for(Object[] j:obj2){
            System.out.println(Arrays.toString(j));
        }

        String sql2="select * from tf_user ";
        User  user=qurey.query(sql2,new BeanHandler<>(User.class));
        System.out.println("返回第一条记录并转成对象------"+user.toString());

        List<User>  userlist=qurey.query(sql2,new BeanListHandler<>(User.class));
        for(User u:userlist){
            System.out.println(u.toString());

        }


    }
}
