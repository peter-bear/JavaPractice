package com.peter.dao;

import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.User;

public interface UserDao {
	public abstract int AddUser(User NewUser);
	public abstract int ChangePassword(User NewUser);
	public abstract User getUser(String userName);
	public abstract LinkedList<User> getAllUser();
}
