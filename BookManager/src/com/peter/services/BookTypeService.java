package com.peter.services;

import java.util.LinkedList;
import java.util.Vector;

import com.peter.model.BookType;

public interface BookTypeService {
	public abstract boolean add(String type);
	public abstract boolean add(String type, String desp);
	public abstract boolean update(String type, String desp);
	public abstract boolean delete(String type);
	public abstract BookType show(String type);
	public abstract LinkedList<BookType> showAll();
}
