package IOStudy;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class buf {
	public static void main(String[] args) throws Exception {
		System.out.println("hello world");
		FileOutputStream file = new FileOutputStream("E:\\java³ÌÐò\\BufferOutput.txt",true);
		BufferedOutputStream buf = new BufferedOutputStream(file);
		for(int i=0;i<4;i++) {
			buf.write("hello world ".getBytes());
			buf.flush();
		}
		System.out.println("Finish");
		buf.close();
	}
}
