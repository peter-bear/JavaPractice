package com.JDBC.Test2;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class ConnectToStudentDB implements ConnectDBforStu, MatchType{

	
	@Override
	public int insert(Student student) {
		String[] elements= {student.getUsername(), student.getPassword()};
		
		return DaoUtil.commonUpdate("INSERT INTO student VALUES (?,?)", elements);
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		String[] elements= {name};
		
		return DaoUtil.commonUpdate("DELETE FROM student WHERE username = ?", elements);

	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		String[] elements= {student.getPassword(),student.getUsername()};
		
		return DaoUtil.commonUpdate("UPDATE student SET `password` = ? WHERE username = ? ", elements);
		
	}

	@Override
	public Student select(String name) {
		// TODO Auto-generated method stub
		ArrayList<Student> students = DaoUtil.commonSelect2("SELECT * FROM student WHERE username =?", name);
		
		return students.get(0);
	}

	@Override
	public ArrayList<Student> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Student> students = DaoUtil.commonSelect2("SELECT * FROM student", null);
		return students;
	}

	@Override
	public <T> T matching(ResultSet set) {
		// TODO Auto-generated method stub
		Student student =null;
		try {
			student = new Student(set.getString("username"), set.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) student;
	}

}
