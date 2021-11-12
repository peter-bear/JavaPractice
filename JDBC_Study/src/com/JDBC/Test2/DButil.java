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
	private static final Properties properties = new Properties(); //�洢�����ļ�Map���� 
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	//��ȡ���������ļ�
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
	
	//��ȡ����
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
	
	//��������
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
	
	//�ύ����
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
	
	//�ع�����
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
	
	//�ر�����
	public static void CloseAll(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if(connection != null) {
				connection.close();
				threadLocal.remove();//�Ƴ��ѹر�connection����
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
