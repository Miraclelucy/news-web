package com.lucy.service;

import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.Admin;
import com.lucy.common.BeanFactory;
import com.lucy.dao.AdminDao;
/**
 *@描述 
 *@参数  
 *@返回值  
 *@创建人  lushiqin
 *@创建时间  2017-11-26
 *@修改人和其它信息
 */
public class Adminservice {
	
	AdminDao adminDao= (AdminDao) BeanFactory.getBean("AdminDao");
	public  boolean checkAdmin(String name,String pwd){
		return adminDao.checkAdmin(name, pwd);
	}
	public List<Admin> getall() {
		return adminDao.getall();
	}
	public int countadmin(){
		return adminDao.countadmin();
	}
	public boolean del(String ids){
		return adminDao.del(ids);
	}
	public boolean add(Admin admin){
		return adminDao.add(admin);
	}
	public boolean upadmin(Admin admin) {
		return adminDao.upadmin(admin);
	}
}
