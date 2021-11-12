package Model;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID; //�û�ID
	private String pass; //�û�����
	
	public User() {
		userID = null;
		pass = null;
	}
	
	public User(String id, String p) {
		userID = id;
		pass = p;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
