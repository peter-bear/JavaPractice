package IOStudy;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class WriteFile2 {
	public static void main(String[] args) throws Exception{
		String Source = "E:\\java程序\\字符Writer.txt";
		OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream(Source,true), "UTF-8");
//		FileWriter file = new FileWriter(Source);
		file.write(" 世界你好 ");
		System.out.println("Finish");
		file.close();
		
	}
}
