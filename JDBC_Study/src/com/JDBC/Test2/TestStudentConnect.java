package com.JDBC.Test2;

import java.util.ArrayList;
import java.util.Scanner;

public class TestStudentConnect {
	static Scanner input= new Scanner(System.in);
	static ConnectToStudentDB dao= new ConnectToStudentDB();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option=0;
		
		System.out.println("Welcome To Our Database");
		do{
			String menu="1. Insert\n2. Delete\n3. Update\n4. Select\n5. SelectAll\n6. Exit";
			System.out.println(menu);
			System.out.print("Your Choice: ");
			option = input.nextInt();
//			System.out.println(option);
			switch (option) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				select();
				break;
			case 5:
				selectAll();
				break;
			case 6:
				System.out.println("Bye Bye");
				break;
			default:
				break;
			}
			
			
			
		}while(option != 6);
		input.close();

	}
	
	public static void insert() {
//		Scanner input = new Scanner(System.in);
		System.out.println("Please input the name: ");
		String name = input.next();
		System.out.println("Please input the password: ");
		String pass = input.next();
		int rst = dao.insert(new Student(name, pass));
		if(rst != 0)
			System.out.println("Insert Successfully");
		else {
			System.out.println("Fail to insert");
		}
//		input.close();
		
	}
	
	public static void delete() {
//		Scanner input = new Scanner(System.in);
		System.out.println("Input the person who you want to delete: ");
		String name = input.next();
		int rst = dao.delete(name);
		if(rst != 0) 
			System.out.println("Delete Successfully");
		else {
			System.out.println("Fail to delete");
		}
//		input.close();
	}
	
	public static void update() {
			
		try {
			
			DButil.begin();
			System.out.println("Please input the name: ");
			String name = input.next();
			System.out.println("Please input the new password: ");
			String pass = input.next();
			int rst = dao.update(new Student(name, pass));
			if(rst != 0)
				System.out.println("Update Successfully");
				
			else {
				System.out.println("Fail to Update");
			}
			DButil.commit();
		} catch(RuntimeException e) {
			DButil.rollback();
			System.out.println("Fail to Update");
		}
		
		
	}
	
	public static void select() {
		System.out.println("Please input the name: ");
		String name = input.next();
		System.out.println();
		System.out.println(dao.select(name));
		System.out.println();

	}
	
	public static void selectAll() {
		System.out.println();
		ArrayList<Student> list = dao.selectAll();
		for(Student s:list) {
			System.out.println(s);
		}
		System.out.println();
	}

}
