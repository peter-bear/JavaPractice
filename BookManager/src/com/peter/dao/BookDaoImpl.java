package com.peter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.peter.model.Book;
import com.peter.util.DaoUtil;
import com.peter.util.MatchType;

public class BookDaoImpl implements BookDao, MatchType{

	@Override
	public int Insert(Book NewBook) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO t_book (Title, Author, Desp, ISBN, Type) VALUES(?,?,?,?,?)";
		Object[] elements = {NewBook.getTitle(), NewBook.getAuthor(), NewBook.getDesp(), NewBook.getISBN(), NewBook.getType()};
		
		return 	DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public int Update(Book NewBook) {
		// TODO Auto-generated method stub
		String sql ="UPDATE t_book SET Title=?, Desp=?, ISBN=?, Type=?,Author =? WHERE ID=? ";
		Object[] elements = {NewBook.getTitle(), NewBook.getDesp(), NewBook.getISBN(), NewBook.getType(), NewBook.getAuthor(), NewBook.getID()};
		
		return DaoUtil.commonUpdate(sql, elements);
	}

	@Override
	public int Delete(int ID) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM t_book WHERE ID=? ";
		return DaoUtil.commonUpdate(sql, ID);
	}

	@Override
	public Book select(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM t_book WHERE Title=?";
		
		LinkedList<Book> books = DaoUtil.commonSelect(sql, new BookDaoImpl(), name);
		if(!books.isEmpty())
			return books.get(0);
		else {
			return null;
		}
		
	}

	@Override
	public Book select2(String ISBN) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_book WHERE ISBN=?";
		LinkedList<Book> books = DaoUtil.commonSelect(sql, new BookDaoImpl(), ISBN);
		if(!books.isEmpty())
			return books.get(0);
		else {
			return null;
		}
	}

	@Override
	public LinkedList<Book> selectAll() {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM t_book";
		LinkedList<Book> books = DaoUtil.commonSelect(sql, new BookDaoImpl(), null);
		return books;
	}

	@Override
	public <T> T Matching(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Book book=null;
		try {
			book = new Book(resultSet.getInt("ID"), resultSet.getString("Title"),resultSet.getString("Author"),resultSet.getString("Desp"),resultSet.getString("ISBN"), resultSet.getString("Type"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T)book;
	}

	@Override
	public LinkedList<Book> selectAll(String author) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_book WHERE Author=?";
		LinkedList<Book> books = DaoUtil.commonSelect(sql, new BookDaoImpl(), author);
		return books;
	}

	@Override
	public LinkedList<Book> selectAll2(String type) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM t_book WHERE Type=?";
		LinkedList<Book> books = DaoUtil.commonSelect(sql, new BookDaoImpl(), type);
		return books;
	}



}
