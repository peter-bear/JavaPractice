package com.peter.dao;

import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.BookType;

public interface BookTypeDao {
	public abstract int Add(BookType type);
	public abstract int Update(BookType type);
	public abstract int Delete(String type);
	public abstract BookType getBookType(String type);
	public abstract LinkedList<BookType> getBookTypes();
}
