package com.JDBC.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class SearchInfo {

	public static void main(String[] args) throws Exception {
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "1234");
		Connection connect = JDBCUtil.getConnect("jdbc:mysql://localhost:3306/JDBCstudy", info);
		Statement state = (Statement)connect.createStatement();
		String sql = "SELECT * FROM student";
		ResultSet rst = state.executeQuery(sql);
		while(rst.next()) {
			System.out.println(rst.getString("username")+" "+rst.getString("password"));
		}
		
		JDBCUtil.CloseAll(connect, state);

	}

}
