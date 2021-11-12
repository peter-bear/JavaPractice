package com.peter.dao;

import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.Book;

public interface BookDao {
	public abstract int Insert(Book NewBook);
	public abstract int Update(Book NewBook);
	public abstract int Delete(int ID);
	public abstract Book select(String title);
	public abstract Book select2(String ISBN);
	public abstract LinkedList<Book> selectAll(String author);
	public abstract LinkedList<Book> selectAll2(String type);
	
	public abstract LinkedList<Book> selectAll();
	
}
