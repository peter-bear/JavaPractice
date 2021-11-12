package com.peter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.User;
import com.peter.util.DaoUtil;
import com.peter.util.MatchType;

public class UserDaoImpl implements UserDao, MatchType{

	@Override
	public int AddUser(User NewUser) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO  t_user (userName, password) VALUES (?, ?)";
		String[] elements = {NewUser.getUserName(), NewUser.getPassWord()};
		
		return DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public int ChangePassword(User NewUser) {
		// TODO Auto-generated method stub
		
		String sql = "Update t_user SET password=? WHERE userName= ?";
		String[] elements = { NewUser.getPassWord(),NewUser.getUserName()};
		return DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_user WHERE userName =?";
		String[] elements = {userName};
		LinkedList<User> temp = DaoUtil.commonSelect(sql, new UserDaoImpl(), elements);
		if(!temp.isEmpty())
			return temp.get(0);
		else
			return null;
	}

	@Override
	public LinkedList<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_user";
		
		LinkedList<User> users =  DaoUtil.commonSelect(sql, new UserDaoImpl(), null);
		return users;
	}

	@Override
	public <T> T Matching(ResultSet resultSet) {
		// TODO Auto-generated method stub
		User user=null;
		try {
			user = new User(resultSet.getInt("id"), resultSet.getString("userName"), resultSet.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (T) user;
	}

}
