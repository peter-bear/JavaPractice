package IOStudy;

import java.io.BufferedInputStream;
//import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("E:\\java����\\ReadFile.txt");
//1.0ʹ����ͨ��ȡѭ��
//		file.read()��ȡ���������ֽ�����Ϣ��Ҫת����char��string�����Ҳ����ظ�����file.read,
//		����Ḳ��ԭ����Ϣ
		//1.4 ʹ��ϵͳ���������ж�ȡ
//		�ļ������ȶ��뻺����
//		BufferedInputStream buf = new BufferedInputStream(file);
//		int data;
//			while((data = buf.read()) != -1) {
//			System.out.print((char)data);
//		}
//1.1 ʹ��buffer��ȡ
		byte[] buffer = new byte[3];
//		file.read(buffer);
//		System.out.println(new String(buffer));
////1.3		ʹ��bufferѭ����ȡ
		int count=0;
		while((count = file.read(buffer))!=-1) {
			System.out.print(new String(buffer,0,count));
		}
		
		
		file.close();
//		buf.close();//�ڲ����Զ�����flush����
	}
}
