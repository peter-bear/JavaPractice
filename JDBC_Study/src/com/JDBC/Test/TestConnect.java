package com.JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
	public static void main(String[] args){
		Connection connection=null;
		//注册驱动，加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			String url ="jdbc:mysql://localhost:3306/classicmodels";
			String usr ="root";
			String password ="1234";
			connection = DriverManager.getConnection(url,usr,password);
			if(connection != null) {
				System.out.println("Connect successfully!!");
			}
		} catch (Exception e) {
			System.out.println("Connection Fail");
			
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
