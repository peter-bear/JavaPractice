package IOStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertyStudy {
	public static void main(String[] args) throws Exception {
		Properties container = new Properties();
		container.setProperty("Trump", "72");
		container.setProperty("Biden", "74");
		System.out.println(container.getProperty("Trump"));
		//使用迭代器遍历
		Iterator<Entry<Object, Object>> itr = container.entrySet().iterator();
		while(itr.hasNext()) {
			 Entry<Object, Object> set = itr.next();
			System.out.println(set.getKey()+"=====>"+set.getValue());
		}
		
		//使用set遍历
//		Set<String> set = container.stringPropertyNames();
//		for(String pro:set) {
//			System.out.println(pro+"=====>"+container.getProperty(pro));
//		}
		
		//将属性列表输出到指定的输出流
		PrintWriter file =new PrintWriter(new FileOutputStream("E:\\java程序\\properties_save.txt"));
		container.list(file);
		file.close();
		
		//store方法，以适合的方法将键值对写入到输出流，可以保存注释
//		FileOutputStream fos = new FileOutputStream("E:\\java程序\\properties_save.txt");
//		container.store(fos, "American President");
//		fos.close();
		
		//load加载properties内容
		FileInputStream fis = new FileInputStream("E:\\java程序\\properties_save.txt");
		container.load(fis);
		fis.close();
		Set<String> set = container.stringPropertyNames();
		for(String pro:set) {
			System.out.println(pro+"=====>"+container.getProperty(pro));
		}
		
	}
}
