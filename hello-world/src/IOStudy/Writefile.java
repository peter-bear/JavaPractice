package IOStudy;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writefile {
	public static void main(String[] args) throws IOException {
		//1.0 ��ָ������д��ָ���ļ�
//		����ں������true��������appendΪtrue��д������ݾͲ��Ḳ��ԭ��������
		FileOutputStream Out = new FileOutputStream("E:\\java����\\OutPutFile.txt",true);
		String words = "HELLO WORLD ";
		Out.write(words.getBytes());
		
		//1.1 ��ȡ�ļ���������д��ָ���ļ�
//		FileInputStream In = new FileInputStream("E:\\java����\\ReadFile.txt");
//		
//		int data;
//		while((data = In.read())!=-1) {
//			Out.write(data);
//		}
//		In.close();
		Out.close();
		System.out.println("Finish Writing");
	}
}
