package com.peter.services;

import java.util.LinkedList;

import com.peter.model.Book;

public interface BookService {
	public abstract boolean add(String title, String author, String dsp, String ISBN, String Type);
	public abstract boolean update(String title, String author, String dsp, String ISBN, String Type, int ID);
	public abstract boolean delete(int ID);
//	public abstract boolean delete(String title);
	public abstract Book getBook(String title);
	public abstract Book getBook2(String ISBN);
	public abstract LinkedList<Book> getBooks(String author);
	public abstract LinkedList<Book> getBooks2(String type);
	public abstract LinkedList<Book> getAllBooks();
	
	
}
