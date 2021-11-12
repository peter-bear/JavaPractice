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
		System.out.println("开启Server");
		
		//开始监听阻塞
		Socket socket = serverSocket.accept();
		
		//获取client发送的信息
		InputStream input = socket.getInputStream();
		byte[] buf = new byte[1024]; //手写缓冲区
		int len=0;
		while((len = input.read(buf))!=-1)
			System.out.println("Client said: "+new String(buf, 0, len));

		
		//向Client发送信息
		OutputStream output = socket.getOutputStream();
		output.write("Hello, Client".getBytes());
		socket.shutdownOutput();
		
		//关闭服务器
		System.out.println("关闭Server");
		output.close();
		socket.close();
		serverSocket.close();

	}

}
