package com.lucy.bean;

public class User {
	private int userId;
	private String userName;
	private String userSex;
	private String userAge;
	private String userPassword;
	private String userEmail;
	private String userLike;
	private String userAdd;
	private String userRemark;
    private int    userState;
	

	public User() {
		super();
	}

	public User(int userId, String username, String usersex, 
			String userpassword, String useremail, String useradd, int userstate) {
		super();
		this.userId = userId;
		this.userName = username;
		this.userSex = usersex;
		this.userPassword = userpassword;
		this.userEmail = useremail;
		this.userAdd = useradd;
		this.userState = userstate;
	}
    
	public User(String username, String usersex, String userpassword,
			String useremail, String useradd) {
		super();
		this.userName = username;
		this.userSex = usersex;
		this.userPassword = userpassword;
		this.userEmail = useremail;
		this.userAdd = useradd;
	}

	public User(int userId, int userState) {
		super();
		this.userId = userId;
		this.userState = userState;
	}

	public User(int userId, String userPassword, int userState) {
		this.userId=userId;
		this.userPassword = userPassword;	
		this.userState = userState;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLike() {
		return userLike;
	}

	public void setUserLike(String userLike) {
		this.userLike = userLike;
	}

	public String getUserAdd() {
		return userAdd;
	}

	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}


}
