package com.tcp.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.qq.Util.StringUtil;

public class test {
	public static void main(String[] args) {
//		File file = new File("E:\\java³ÌÐò\\TCPprogram\\src\\com\\tcp\\images");
//		File[] files = file.listFiles();
////		for(File f:files)
////			System.out.println(f.getName());
//		System.out.println(file.getAbsolutePath());
//		System.out.println(StringUtil.readNum(1));
//		System.out.printf("User: ");
//		String one = StringUtil.get();
//		System.out.printf("Content: ");
//		String two = StringUtil.get();
//		String three = one+two;
//		System.out.println(Character.isDigit('6'));
		String path ="C:\\Users\\23881\\Desktop\\Self_study\\k.jpg";
		System.out.println("Start");
		try {
			byte[] content;
			byte[] buf = new byte[1024];
			int len=0;
			int count=0;
			File filePath = new File(path);
			FileInputStream file = new FileInputStream(path);
			
			while((len = file.read(buf))!= -1) {
				count+=len;
			}
			content = new byte[count];
			count =0;
			while((len = file.read(buf))!=-1) {
				System.arraycopy(buf, 0, content, count, len);
				count += len;
			}
			
			file.close();
			System.out.println(content.length);
			
			
//			System.out.println(Arrays.toString(content));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
