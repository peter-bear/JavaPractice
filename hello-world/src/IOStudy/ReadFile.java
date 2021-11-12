package IOStudy;

import java.io.BufferedInputStream;
//import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("E:\\java程序\\ReadFile.txt");
//1.0使用普通读取循环
//		file.read()读取出来的是字节流信息，要转化成char或string，而且不能重复调用file.read,
//		否则会覆盖原来信息
		//1.4 使用系统缓冲流进行读取
//		文件内容先读入缓冲区
//		BufferedInputStream buf = new BufferedInputStream(file);
//		int data;
//			while((data = buf.read()) != -1) {
//			System.out.print((char)data);
//		}
//1.1 使用buffer读取
		byte[] buffer = new byte[3];
//		file.read(buffer);
//		System.out.println(new String(buffer));
////1.3		使用buffer循环读取
		int count=0;
		while((count = file.read(buffer))!=-1) {
			System.out.print(new String(buffer,0,count));
		}
		
		
		file.close();
//		buf.close();//内部会自动调用flush方法
	}
}
