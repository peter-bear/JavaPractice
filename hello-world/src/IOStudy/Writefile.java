package IOStudy;

import java.io.FileOutputStream;
import java.io.IOException;

public class Writefile {
	public static void main(String[] args) throws IOException {
		//1.0 将指定内容写入指定文件
//		如果在后面加让true，即赋予append为true，写入的内容就不会覆盖原来的内容
		FileOutputStream Out = new FileOutputStream("E:\\java程序\\OutPutFile.txt",true);
		String words = "HELLO WORLD ";
		Out.write(words.getBytes());
		
		//1.1 读取文件并将内容写入指定文件
//		FileInputStream In = new FileInputStream("E:\\java程序\\ReadFile.txt");
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
