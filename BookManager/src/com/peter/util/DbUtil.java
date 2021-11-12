package com.peter.util;

import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author 23881
 *
 */

public class DbUtil {
	public static void main(String[] args) {
		Connection connection = DbUtil.getConnection();
		if(connection != null)
			System.out.println("Connect Succesfully");
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	private final static Properties info = new Properties();
	static {
		InputStream input = DbUtil.class.getResourceAsStream("/dbConnect.properties");
		try {
			info.load(input);
	
			Class.forName(info.getProperty("driver"));
			
			
		}
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		Connection connection =null;
		try {
			String url = info.getProperty("url");
			String usr = info.getProperty("usr");
			String pass = info.getProperty("pass");
			connection = DriverManager.getConnection(url, usr, pass);
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 关闭断开所有连接
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void CloseAll(Connection connection, Statement statement, ResultSet resultSet) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
