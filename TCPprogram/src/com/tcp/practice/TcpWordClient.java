package com.tcp.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;



public class TcpWordClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开启Client");
		Socket socket = new Socket("192.168.0.55", 10086);
		System.out.println("连接上Server");
		
		//向服务器发送数据
		OutputStream output = socket.getOutputStream();
		output.write("Hello Server".getBytes());
		socket.shutdownOutput();
		
		
		
		//接收服务器发出的数据
		InputStream input = socket.getInputStream();
		byte[] buf = new byte[1024]; //手写缓冲区
		int len=0;
		while((len = input.read(buf))!=-1)
			System.out.println("Server said: "+new String(buf, 0, len));
	
		
		//关闭客户端
		System.out.println("关闭Client");
		output.close();
		input.close();
		socket.close();
	}

}
