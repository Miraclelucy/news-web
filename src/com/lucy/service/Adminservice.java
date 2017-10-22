package com.lucy.service;

import java.util.ArrayList;

import com.lucy.bean.Admin;

public class Adminservice {
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return flag
	 */
	public  boolean checkAdmin(String name,String pwd){
		return new com.lucy.dao.GetAdmin().checkAdmin(name, pwd);
	}
	public ArrayList<Admin> getall() {
		return new com.lucy.dao.GetAdmin().getall();
	}
	public int countadmin(){
		return new com.lucy.dao.GetAdmin().countadmin();
	}
	public boolean del(String ids){
		return new com.lucy.dao.GetAdmin().del(ids);
	}
	public boolean add(Admin admin){
		return new com.lucy.dao.GetAdmin().add(admin);
	}
	public boolean upadmin(Admin admin) {
		return new com.lucy.dao.GetAdmin().upadmin(admin);
	}
}
