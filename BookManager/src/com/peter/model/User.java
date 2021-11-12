package com.peter.model;
/**
 * 用户类
 * 存储用户ID
 * 用户名UserName
 * 用户密码Password
 * @author 23881
 *
 */
public class User {
	private int id;
	private String userName;
	private String passWord;
	
	public User() {
		super();
	}
	
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public User(int id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: "+id+" UserName: "+userName+" PassWord: "+passWord;
	}
	
	
}
