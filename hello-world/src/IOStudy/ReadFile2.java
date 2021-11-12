package IOStudy;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ReadFile2 {
	public static void main(String[] args) throws Exception{
		String Source = "E:\\java³ÌÐò\\×Ö·ûReader.txt";
		InputStreamReader read = new InputStreamReader(new FileInputStream(Source),"UTF-8");
//		FileReader read = new FileReader(Source);
		int count =0;
		while((count = read.read())!= -1) {
			System.out.print((char)count);
		}
		read.close();
//		read2.close();
	}
}
