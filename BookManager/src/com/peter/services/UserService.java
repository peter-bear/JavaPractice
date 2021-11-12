package com.peter.services;

public interface UserService {
	public abstract boolean InsertUser(String name, String pass);
	public abstract boolean checkUser(String name);
	public abstract boolean Login(String name, String pass);
}
