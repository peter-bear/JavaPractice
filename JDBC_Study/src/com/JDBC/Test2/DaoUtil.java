package com.JDBC.Test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

public class DaoUtil<T> {
	/**
	 * 
	 * @param sql input sql string
	 * @param elements related parameters
	 * @return 0 means do not find, 1 means find
	 */
	public static int commonUpdate(String sql, String... elements ) {
		int rst=0;
		Connection connection = DButil.getConnection();
		if(connection!=null) {
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(sql);
				for(int i=0;i<elements.length;i++) {
					statement.setString(i+1, elements[i]);
				}
				rst = statement.executeUpdate();
				DButil.CloseAll(null, (Statement)statement, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return rst;
	}
	
	public static  ArrayList<Object> commonSelect(String sql, String... elements ){
		Connection connection = DButil.getConnection();
		ArrayList<Object> list = null;
		if(connection !=null) {
			try {
				list = new ArrayList<>();
				PreparedStatement statement = connection.prepareStatement(sql);
				if(elements !=null) {
					for(int i=0;i<elements.length;i++) {
						statement.setString(i+1, elements[i]);
					}
				}
				
				ResultSet set = statement.executeQuery();
//				System.out.println(new ConnectToStudentDB().matching(set).getClass());
//				ArrayList<> temp = new ArrayList<>();
				while(set.next()) {
					list.add(new ConnectToStudentDB().matching(set));
					
				}
				
				DButil.CloseAll(null, (Statement)statement, set);
	
			}catch(SQLException e){
				
			}

		}
		return list;
	}
	
	/**
	 * 
	 * @param <T> generic type of arraylist
	 * @param sql input sql words
	 * @param elements related parameters
	 * @return store result into the given list
	 */
	public static  <T> ArrayList<T> commonSelect2(String sql, String... elements ){
		Connection connection = DButil.getConnection();
		ArrayList<T> list = null;
		if(connection !=null) {
			try {
				list = new ArrayList<>();
				PreparedStatement statement = connection.prepareStatement(sql);
				if(elements !=null) {
					for(int i=0;i<elements.length;i++) {
						statement.setString(i+1, elements[i]);
					}
				}
				
				ResultSet set = statement.executeQuery();
//				System.out.println(new ConnectToStudentDB().matching(set).getClass());
//				ArrayList<> temp = new ArrayList<>();
				while(set.next()) {
					list.add((T) new ConnectToStudentDB().matching(set));
					
				}
				
				DButil.CloseAll(null, (Statement)statement, set);
	
			}catch(SQLException e){
				
			}

		}
		return list;
	}
	
	
}

