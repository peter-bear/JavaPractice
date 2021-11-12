package com.JDBC.Test2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class TestDButil {

	public static void main(String[] args) throws Exception{
		Connection connection = DButil.getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
		}
		DButil.CloseAll(connection, (Statement)statement, resultSet);

	}

}
