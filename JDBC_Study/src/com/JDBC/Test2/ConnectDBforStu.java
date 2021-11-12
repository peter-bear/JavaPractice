package com.JDBC.Test2;

import java.util.ArrayList;

public interface ConnectDBforStu{
	public abstract int insert(Student student);
	public abstract int delete(String name);
	public abstract int update(Student student);
	public abstract Student select(String name);
	public abstract ArrayList<Student> selectAll();
}
