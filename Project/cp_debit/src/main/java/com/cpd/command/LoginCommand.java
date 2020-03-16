package com.cpd.command;

public class LoginCommand {
	
	private String userName;
	private String password;
	private String userType;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoginCommand [userName=" + userName + ", password=" + password + ", userType=" + userType + "]";
	}
	
	
}

