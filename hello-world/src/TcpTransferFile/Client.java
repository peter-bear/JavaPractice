package TcpTransferFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.0.53", 10086);
		System.out.println("客户端开始传输数据....");
		BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
		BufferedInputStream file = new BufferedInputStream(new FileInputStream("E:\\java程序\\PicSource\\20.jpg"));
		int data;
		while((data=file.read())!=-1){
			out.write(data);
		}
		file.close();
		out.close();
		client.close();
		System.out.println("客户端传输完毕");
	}
}
