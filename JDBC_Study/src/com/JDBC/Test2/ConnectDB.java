package com.JDBC.Test2;


import java.util.ArrayList;

public interface ConnectDB<T> {
	public abstract int insert(T t);
	public abstract int delete(T t);
	public abstract int update(T t);
	public abstract T select(T t);
	public abstract ArrayList<?> selectAll();
}
