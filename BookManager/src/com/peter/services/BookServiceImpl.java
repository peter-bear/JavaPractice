package com.peter.services;

import java.util.LinkedList;

import com.peter.dao.BookDaoImpl;
import com.peter.model.Book;

public class BookServiceImpl implements BookService{
	private BookDaoImpl bookDao = new BookDaoImpl();


	@Override
	public boolean add(String title, String author, String dsp, String ISBN, String Type) {
		// TODO Auto-generated method stub
		boolean rst =false;
		//ISBN保证书不重复

		if(bookDao.select(title)==null&&bookDao.select2(ISBN)==null) {
			bookDao.Insert(new Book(title, author,dsp, ISBN, Type));
			rst =true;
		
		}
		
		return rst;
	}

	@Override
	public boolean update(String title, String author, String dsp, String ISBN, String Type, int ID) {
		// TODO Auto-generated method stub
		boolean rst =false;
		//保证求改后的ISBN
		if(bookDao.select2(ISBN) ==null) {
			bookDao.Update(new Book(ID, title, author,dsp, ISBN, Type));
			rst =true;
		}
		else {
			if( bookDao.select2(ISBN).getID() == ID) {
				bookDao.Update(new Book(ID, title, author,dsp, ISBN, Type));
				rst =true;
			}
		}
		return rst;
	}

	@Override
	public boolean delete(int ID) {
		// TODO Auto-generated method stub
//		boolean rst =false;
//		Book book = bookDao.select(title);
//		if(book!=null) {
//			bookDao.Delete(book.getID());
//			rst =true;
//		}
//		return rst;
		if(bookDao.Delete(ID)>0)
			return true;
		return false;
	}


	@Override
	public Book getBook(String title) {
		// TODO Auto-generated method stub
		return bookDao.select(title);
	}

	@Override
	public Book getBook2(String ISBN) {
		// TODO Auto-generated method stub
		return bookDao.select2(ISBN);
	}

	@Override
	public LinkedList<Book> getBooks(String author) {
		// TODO Auto-generated method stub
		return bookDao.selectAll(author);
	}

	@Override
	public LinkedList<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
	}

	@Override
	public LinkedList<Book> getBooks2(String type) {
		// TODO Auto-generated method stub
		return bookDao.selectAll2(type);
	}



}
