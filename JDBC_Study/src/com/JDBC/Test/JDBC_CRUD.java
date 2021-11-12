package com.JDBC.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class JDBC_CRUD {
	int rst=0;
	Connection connect =null;
	
	JDBC_CRUD(String url, Properties info){
		connect = JDBCUtil.getConnect(url, info);
	}
	
	public int Insert( String table, String usr, String pass ) throws Exception {
		if(connect !=null) {
			PreparedStatement state = connect.prepareStatement("INSERT INTO "+table+" VALUES (?,?)");
			state.setString(1, usr);
			state.setString(2, pass);
			
			rst = state.executeUpdate();
			JDBCUtil.CloseAll(connect, (Statement) state);
		}
		return rst;
	}
	
	public int Delete(String table, String user) throws Exception{
		if(connect !=null) {
			PreparedStatement state = connect.prepareStatement("DELETE FROM "+table+" WHERE username = ?");
			state.setString(1, user);
			
			rst = state.executeUpdate();
			JDBCUtil.CloseAll(connect, (Statement) state);
		}
		return rst;
	}
	
	public int Update(String table, String user, String pass) throws Exception{
		if(connect !=null) {
			PreparedStatement state = connect.prepareStatement("UPDATE "+table+" SET `password` = ? WHERE username = ? ");
			state.setString(1, pass);
			state.setString(2, user);
			
			rst = state.executeUpdate();
			JDBCUtil.CloseAll(connect, (Statement) state);
		}
		return rst;
	}
	
	public int Search(String col,String table) throws Exception{
		if(connect !=null) {
			PreparedStatement statement = connect.prepareStatement("SELECT "+col+" FROM "+table);
//			statement.setString(1, col);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
//				System.out.println(set.getString(1)+" "+set.getString(2));
				System.out.println(set.getString("username")+" "+set.getString("password"));
			}
			rst = 1;
			set.close();
			JDBCUtil.CloseAll(connect, (Statement)statement);
			
		}
		return rst;
	}
	

}
