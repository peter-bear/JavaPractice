package NetProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(10086);
		System.out.println("������������");
		Socket accept = listener.accept();
		InputStream input = accept.getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(input));
		System.out.println((String)bf.readLine());
		input.close();
		listener.close();
		accept.close();
		System.out.println("�������ѹر�");
	}
}
