package com.JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class InsertInfo {

	public static void main(String[] args) throws Exception{
		//1. 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. 建立连接
		String url = "jdbc:mysql://localhost:3306/JDBCstudy";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "1234");
//		Connection connect = DriverManager.getConnection(url, "root","1234");
		Connection connect = DriverManager.getConnection(url, info);
		if(connect!=null) {
			System.out.println("connect successfully");
		}
		
		
		//3.sql语句
//		Statement state = (Statement) connect.createStatement();
//		String username="jim";
//		String password="123";
//		String sql = "INSERT INTO student VALUES('"+username+"','"+password+"');";
//		int rst = state.executeUpdate(sql);
//		System.out.println(rst+" has been affected");
		PreparedStatement state = connect.prepareStatement("INSERT INTO "+ "student"+" VALUES (?,?)");
		state.setString(1, "steven");
		state.setString(2, "666");
		int rst = state.executeUpdate();
		System.out.println(rst+" has been affected");

		JDBCUtil.CloseAll(connect, (Statement) state);
		
		
		//4.断开所有连接 
//		connect.close();
//		state.close();

	}

}
