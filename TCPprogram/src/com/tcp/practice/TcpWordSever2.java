package com.tcp.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//字符读取服务器
public class TcpWordSever2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(10086);
		System.out.println("开启Server");
		
		//开始监听阻塞
		Socket socket = serverSocket.accept();
		
		//获取client发送的信息
		InputStream input = socket.getInputStream();	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
		System.out.println("client said: "+bfr.readLine());

		
		//向Client发送信息
		OutputStream output = socket.getOutputStream();
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(output));
		bfw.write("Hello, Client");
		//设置输出结束标记
		bfw.newLine();
		//如果使用字符流，数据要进行刷新，否则数据不会写入数据通道
		bfw.flush();
		
		
		
		//关闭服务器
		System.out.println("关闭Server");
		output.close();
		socket.close();
		bfw.close();
		input.close();
		bfr.close();
		serverSocket.close();

	}

}
