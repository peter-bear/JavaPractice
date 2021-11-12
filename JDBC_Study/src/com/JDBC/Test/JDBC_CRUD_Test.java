package com.JDBC.Test;

import java.util.Properties;

public class JDBC_CRUD_Test {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/JDBCstudy";
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "1234");
		JDBC_CRUD jdbc = new JDBC_CRUD(url,info);
//		jdbc.Insert("student", "steven", "666");
//		jdbc.Update("student", "steven", "1234");
//		jdbc.Delete("student", "steven");	
		jdbc.Search("*", "student");

		
	}

}
