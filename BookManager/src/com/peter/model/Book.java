package com.peter.model;

public class Book {
	private int ID;
	private String Title;
	private String Desp;
	private String Author;
	private String ISBN;
	private String Type;
	public Book() {
		super();
	}
	



	
	public Book(String name, String Author, String desp, String ISBN,String Type) {
		this.Title = name;
		this.Desp = desp;
		this.ISBN = ISBN;
		this.Author = Author;
		this.Type = Type;
	}
	
	public Book(int ID, String name, String Author, String desp, String ISBN,String Type) {
		this.ID = ID;
		this.Title = name;
		this.Desp = desp;
		this.ISBN = ISBN;
		this.Author = Author;
		this.Type = Type;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDesp() {
		return Desp;
	}

	public void setDesp(String desp) {
		Desp = desp;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}



	public String getType() {
		return Type;
	}



	public void setType(String type) {
		Type = type;
	}





	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Book temp = (Book)obj;
		return temp.Author.equals(this.Author) && temp.Title.equals(this.Title);
	}
	
	
	
	
}
