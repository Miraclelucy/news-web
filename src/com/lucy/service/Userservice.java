package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.User;

public class Userservice {
	public boolean adduser(User user) {
		return new com.lucy.dao.GetUser().adduser(user);
	}
	public ArrayList<User> getall(){
		return new com.lucy.dao.GetUser().getall();
	}
	public int countuser(){
		return new com.lucy.dao.GetUser().countuser();
	}
	public boolean deluser(String ids) {
		return new com.lucy.dao.GetUser().deluser(ids);
	}
	public boolean upuser(User user) {
		return new com.lucy.dao.GetUser().upuser(user);
	}
	public int  checkLogin(String name, String pwd){
		return new com.lucy.dao.GetUser().checkLogin(name,pwd);
	}
}
