package com.peter.services;

import java.util.LinkedList;
import java.util.Vector;

import com.peter.dao.BookTypeDao;
import com.peter.dao.BookTypeDaoImpl;
import com.peter.model.BookType;

public class BookTypeServiceImpl implements BookTypeService{
	private BookTypeDaoImpl dao = new BookTypeDaoImpl();
	@Override
	public boolean add(String type) {
		// TODO Auto-generated method stub
		boolean rst = false;
		if(dao.getBookType(type)==null) {
			dao.Add(new BookType(type));
			rst = true;
		}
		return rst;
	}

	@Override
	public boolean add(String type, String desp) {
		// TODO Auto-generated method stub
		boolean rst = false;
		if(dao.getBookType(type)==null) {
			dao.Add(new BookType(type, desp));
			rst = true;
		}
		return rst;
	}

	@Override
	public boolean update(String type, String desp) {
		// TODO Auto-generated method stub
		boolean rst = false;
		if(dao.getBookType(type)!=null) {
			dao.Update(new BookType(type, desp));
			rst = true;
		}
		return rst;
	}

	@Override
	public boolean delete(String type) {
		// TODO Auto-generated method stub
		boolean rst = false;
		if(dao.getBookType(type)!=null) {
			dao.Delete(type);
			rst = true;
		}
		return rst;
	}
	

	@Override
	public BookType show(String type) {
		// TODO Auto-generated method stub
		return dao.getBookType(type);
	}

	@Override
	public LinkedList<BookType> showAll() {
		// TODO Auto-generated method stub
		
		return dao.getBookTypes();
	}

}
