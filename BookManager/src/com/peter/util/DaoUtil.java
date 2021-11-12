package com.peter.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class DaoUtil {
	
	/**
	 * 增删改公共方法
	 * @param <E>
	 * @param sql
	 * @param elements
	 * @return
	 */
	public static <E> int commonUpdate(String sql, E... elements ) {
		int rst =0;
		Connection connection = DbUtil.getConnection();
		PreparedStatement statement =null;
		if(connection != null) {
			try {
				
				statement = connection.prepareStatement(sql);
				for(int i=0;i<elements.length;i++)
					statement.setObject(i+1, elements[i]);
				rst = statement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DbUtil.CloseAll(connection, statement, null);
		
		
		return rst;
	}
	
	/**
	 * 公共查找方法，返回LinkdList集合
	 * @param <E>
	 * @param <T>
	 * @param sql
	 * @param match
	 * @param elements
	 * @return
	 */
	public static <E, T> LinkedList<E> commonSelect(String sql, MatchType match, T... elements){
		LinkedList<E> list = new LinkedList<>();
		Connection connection = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				if(elements != null) {
					for(int i=0;i<elements.length;i++)
						statement.setObject(i+1, elements[i]);
				}
				
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
//					System.out.println(resultSet.getString("userName")+" "+resultSet.getString("password"));
//					E element = match.Matching(resultSet);
//					System.out.println(element);
					list.add(match.Matching(resultSet));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		DbUtil.CloseAll(connection, statement, resultSet);
		return list;
	}
}
