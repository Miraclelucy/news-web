package com.lucy.service;

import java.util.ArrayList;
import java.util.List;

import com.lucy.bean.User;
import com.lucy.common.BeanFactory;
import com.lucy.dao.TypeDao;
import com.lucy.dao.UserDao;

public class Userservice {
	UserDao userDao=(UserDao) BeanFactory.getBean("UserDao");

	public boolean adduser(User user) {
		return userDao.adduser(user);
	}
	public List<User> getall(){
		return userDao.getall();
	}
	public int countuser(){
		return userDao.countuser();
	}
	public boolean deluser(String ids) {
		return userDao.deluser(ids);
	}
	public boolean upuser(User user) {
		return userDao.upuser(user);
	}
	public int  checkLogin(String name, String pwd){
		return userDao.checkLogin(name,pwd);
	}
}
