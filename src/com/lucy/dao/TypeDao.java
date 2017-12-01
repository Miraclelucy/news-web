package com.lucy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.lucy.bean.News;
import com.lucy.bean.Type;
import com.lucy.dao.datatool.MyDataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;

public class TypeDao {
	static DataSource ds=  MyDataSourceUtil.getDataSource();
	QueryRunner queryRunner = new QueryRunner(ds);

	/**
	 * 
	 */
	public List<Type> gettype() {

		String  sql1="select typeId,typeName from tf_type ";
		try {
			List<Type> types=queryRunner.query(sql1,new BeanListHandler<>(Type.class));
			return types;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * 根据类型Id获取类型名称
	 */
	public Type gettypeName(int typeId) {

		String  sql1="select typeId,typeName from  tf_type where typeId="+typeId;
		try {
			Type type=queryRunner.query(sql1,new BeanHandler<Type>(Type.class));
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * 
	 * @return
	 */
	public int counttype(){

		int count=0;
		try {
			Object o =queryRunner.query("select count(*)  from tf_type", new ScalarHandler());
			if(o!=null){
				count= Integer.parseInt(o==null?"":o.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	/**
	 * 
	 */ 
	public boolean deletetype(String delIds) {
		boolean flag = false;
		try {
			int updateNum = queryRunner.update("delete from tf_type where typeId in ('"+delIds+"')");
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;


	}

	/**
	 * 
	 */
	public boolean inserttype(String str) {
		boolean flag = false;
		try {
			String sql="insert into tf_type(typeName) values(?)";
			int updateNum = queryRunner.update(sql,str);
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}
	/**
	 * 
	 */
	public boolean uptype(Type type) {
		boolean flag = false;
		try {
			String  sql="update tf_type set typeName=?  where typeId=?";
			int updateNum = queryRunner.update(sql, type.getTypeName(),type.getTypeId());
			if(updateNum>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}


}
