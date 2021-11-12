package com.JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;

public class DeleteInfo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCstudy","root","1234"); 
		if(connect != null) {
			System.out.println("connect to database successfully");
			Statement statement = (Statement)connect.createStatement();
			String username="'jim'";
			String sql ="DELETE FROM student WHERE username="+username;
			int rst =statement.executeUpdate(sql);
			System.out.println(rst+" is affected");
		}else {
			System.out.println("username or password of Database are not correct");
		}
		

	}

}
