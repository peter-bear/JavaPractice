package TcpTransferFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
	public static void main(String[] args) throws Exception {
		ServerSocket sever = new ServerSocket(10086);
		System.out.println("服务器已开启");
		Socket accept = sever.accept();
		BufferedInputStream bufIn = new BufferedInputStream(accept.getInputStream());
		int data;
		BufferedOutputStream bufOut = new BufferedOutputStream(new FileOutputStream("E:\\java程序\\PicSource\\Summer_Pocket\\Beauty.jpg"));
		while((data = bufIn.read())!= -1) {
			bufOut.write(data);
			bufOut.flush();
		}
		bufOut.close();
		bufIn.close();
		sever.close();
		accept.close();
		System.out.println("服务器接收完毕");
		
	}
}
