package IOStudy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BufferCharRead {
	public static void main(String[] args) throws Exception{
		String source = "E:\\±à³Ì.txt";
		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(source), "GBK"));
		for(int i=0;i<20;i++)
		System.out.println(buf.readLine());
		
		buf.close();
	}
}
