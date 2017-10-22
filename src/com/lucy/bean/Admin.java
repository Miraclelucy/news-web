package com.lucy.bean;

public class Admin {
	private int adminId;
	private String adminName;
	private String adminPwd;

	public Admin() {
		super();
	}

	public Admin(int adminId, String aname, String apssword) {
		super();
		this.adminId = adminId;
		this.adminName = aname;
		this.adminPwd = apssword;
	}

	public Admin(String aname, String apssword) {
		super();
		this.adminPwd = apssword;
		this.adminName = aname;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

}
