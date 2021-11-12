package com.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpWordSever {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(10086);
		System.out.println("����Server");
		
		//��ʼ��������
		Socket socket = serverSocket.accept();
		
		//��ȡclient���͵���Ϣ
		InputStream input = socket.getInputStream();
		byte[] buf = new byte[1024]; //��д������
		int len=0;
		while((len = input.read(buf))!=-1)
			System.out.println("Client said: "+new String(buf, 0, len));

		
		//��Client������Ϣ
		OutputStream output = socket.getOutputStream();
		output.write("Hello, Client".getBytes());
		socket.shutdownOutput();
		
		//�رշ�����
		System.out.println("�ر�Server");
		output.close();
		socket.close();
		serverSocket.close();

	}

}
