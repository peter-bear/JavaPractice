package NetProgram;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket(InetAddress.getByName("192.168.0.53"),10086);
		OutputStream output= client.getOutputStream();
		output.write("hello world".getBytes());
		client.close();
		output.close();
		System.out.println("客户端发送完毕");
		
	}
}
