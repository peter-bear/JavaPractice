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
		//ʹ�õ���������
		Iterator<Entry<Object, Object>> itr = container.entrySet().iterator();
		while(itr.hasNext()) {
			 Entry<Object, Object> set = itr.next();
			System.out.println(set.getKey()+"=====>"+set.getValue());
		}
		
		//ʹ��set����
//		Set<String> set = container.stringPropertyNames();
//		for(String pro:set) {
//			System.out.println(pro+"=====>"+container.getProperty(pro));
//		}
		
		//�������б������ָ���������
		PrintWriter file =new PrintWriter(new FileOutputStream("E:\\java����\\properties_save.txt"));
		container.list(file);
		file.close();
		
		//store���������ʺϵķ�������ֵ��д�뵽����������Ա���ע��
//		FileOutputStream fos = new FileOutputStream("E:\\java����\\properties_save.txt");
//		container.store(fos, "American President");
//		fos.close();
		
		//load����properties����
		FileInputStream fis = new FileInputStream("E:\\java����\\properties_save.txt");
		container.load(fis);
		fis.close();
		Set<String> set = container.stringPropertyNames();
		for(String pro:set) {
			System.out.println(pro+"=====>"+container.getProperty(pro));
		}
		
	}
}
