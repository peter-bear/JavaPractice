package com.peter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.BookType;
import com.peter.util.DaoUtil;
import com.peter.util.MatchType;

public class BookTypeDaoImpl implements BookTypeDao, MatchType{

	@Override
	public int Add(BookType type) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO t_book_type VALUES (?, ?)";
		String[] elements = {type.getType(), type.getDsp()};
		
		return DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public int Update(BookType type) {
		// TODO Auto-generated method stub
		String sql ="UPDATE t_book_type SET Desp=? WHERE Type=?";
		String[] elements = {type.getDsp(), type.getType()};
		return DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public LinkedList<BookType> getBookTypes() {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_book_type";
		LinkedList<BookType> alltypes = DaoUtil.commonSelect(sql, new BookTypeDaoImpl(), null);
		return alltypes;
	}

	@Override
	public <T> T Matching(ResultSet resultSet) {
		// TODO Auto-generated method stub
		BookType type = null;
		try {
			type = new BookType(resultSet.getString("Type"), resultSet.getString("Desp"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) type;
	}

	@Override
	public int Delete(String type) {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM t_book_type WHERE Type=?";
		return DaoUtil.commonUpdate(sql, type);
	}

	@Override
	public BookType getBookType(String type) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_book_type WHERE Type LIKE ?";
		LinkedList<BookType> temp = DaoUtil.commonSelect(sql, new BookTypeDaoImpl(), type+"%");
		if(!temp.isEmpty())
			return temp.get(0);
		else
			return null;
		
	}

}
