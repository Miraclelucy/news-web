package com.lucy.dao.datatool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class MyDataSource {

    static LinkedList<Connection> pool=new LinkedList<>();

    static {
        //初始化3个链接
            for(int i=0;i<3;i++){
                Connection con=Mysqltool.getconn();
                pool.addLast(con);
            }

    }

    public static Connection getConnection(){
        //初始化3个链接
        if(pool.isEmpty()){
            //如果为空，再添加2个进入连接池
            for(int i=0;i<=2;i++){
                Connection con=Mysqltool.getconn();
                pool.addLast(con);
            }

        }
        Connection con=pool.removeFirst();
        MyConnectionWrpper myconn= new MyConnectionWrpper(con,pool);

        return myconn;
    }

   /* public static void toback(Connection  conn){
        pool.addLast(conn);
    }
*/

}
