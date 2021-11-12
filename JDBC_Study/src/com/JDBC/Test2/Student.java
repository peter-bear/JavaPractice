package com.JDBC.Test2;
/**
 * Create a student class
 * this class can be used to accept or store student information
 * @author 23881
 *
 */
public class Student {
	private String username;
	private String password;
	Student() {
		// TODO Auto-generated constructor stub
	}
	
	Student(String usr, String pass){
		username = usr;
		password = pass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
