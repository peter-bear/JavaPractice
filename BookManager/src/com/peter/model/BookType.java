package com.peter.model;

public class BookType {
	private String type;
	private String dsp;
	
	
	
	public BookType() {
		super();
	}
	
	
	
	public BookType(String type) {
		super();
		this.type = type;
	}



	public BookType(String type, String dsp) {
		super();
		this.type = type;
		this.dsp = dsp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDsp() {
		return dsp;
	}
	public void setDsp(String dsp) {
		this.dsp = dsp;
	}



	@Override
	public String toString() {
		return "BookType [type=" + type + ", dsp=" + dsp + "]";
	}
	
	
	
}
