package com.qq.Util;

import java.util.Scanner;

public class StringUtil {
	private static Scanner input = new Scanner(System.in);
	public static String readNum(int i) {
		
		String num;
		while(true) {
			boolean isDigit = true;
			System.out.printf("Please input your choice: ");
			num = input.next().substring(0, i);
			if(num != null) {
				for(char c:num.toCharArray())
					if(!Character.isDigit(c)) {
						System.out.println("Please input a correct digit!!");
						isDigit = false;
					}
				if(isDigit) {
					break;
				}	
			}
			
		}
		
		return num;
	}
	
	public static String get() {
		return input.next();
	}
	
	public static String getLine() {
		return input.nextLine();
	}
}
