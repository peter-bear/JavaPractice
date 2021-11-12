package com.JDBC.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Statement;


public class UpdateInfo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCstudy","root","1234");
		Statement statement = (Statement) connect.createStatement();
		String username="'jim'";
		String password ="'666'";
		String sql="UPDATE student SET `password`="+password+"WHERE username="+username;
		int rst = statement.executeUpdate(sql);
		System.out.println(rst+" is affected");

	}

}
