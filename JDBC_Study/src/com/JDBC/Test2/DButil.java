package com.JDBC.Test2;
/**
 * This is a utility class
 * we can use it to build a connection with our own database and close all connections
 * 
 * this util-class can also be used in other computers  
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class DButil {
	private static final Properties properties = new Properties(); //存储配置文件Map集合 
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	//读取属性配置文件
	static {
		InputStream is = DButil.class.getResourceAsStream("/db.properties");
		try {
			properties.load(is);
			
			Class.forName(properties.getProperty("driver"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//获取连接
	public static Connection getConnection() {
		Connection connection = threadLocal.get();
		String url = properties.getProperty("url");
		String usr = properties.getProperty("username");
		String pass = properties.getProperty("password");
		try {
			if(connection == null) {
				connection = DriverManager.getConnection(url, usr, pass);
				threadLocal.set(connection);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//开启事务
	public static void begin() {
		Connection connection = null;
		try {
			connection = DButil.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//提交事务
	public static void commit() {
		Connection connection = null;
		try {
			connection = DButil.getConnection();
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseAll(connection, null, null);
		}
		
	} 
	
	//回滚事务
	public static void rollback() {
		Connection connection = null;
		try {
			connection = DButil.getConnection();
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//关闭所有
	public static void CloseAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if(connection != null) {
				connection.close();
				threadLocal.remove();//移除已关闭connection对象
			}
			if(statement!=null) {
				statement.close();
			}
			if(resultSet!= null) {
				resultSet.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
