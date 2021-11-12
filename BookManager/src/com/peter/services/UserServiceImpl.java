package com.peter.services;

import com.peter.dao.UserDaoImpl;
import com.peter.model.User;

public class UserServiceImpl implements UserService{
	private UserDaoImpl UDI = new UserDaoImpl();
	@Override
	public boolean InsertUser(String name, String pass) {
		// TODO Auto-generated method stub
		boolean rst=false;
		
		if (UDI.getUser(name) == null) {
			UDI.AddUser(new User(name, pass));
			rst=true;
		}
		
		
		return rst;
	}

	@Override
	public boolean Login(String name, String pass) {
		// TODO Auto-generated method stub
		User user = UDI.getUser(name);
		if(checkUser(name)&&pass.equals(user.getPassWord()))
			return true;
		else {
			return false;
		}
	}

	@Override
	public boolean checkUser(String name) {
		// TODO Auto-generated method stub
		if(UDI.getUser(name)==null)
			return false;
		return true;
	}

	

}
