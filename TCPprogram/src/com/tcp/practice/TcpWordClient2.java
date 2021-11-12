package com.tcp.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


//字符读取客户端
public class TcpWordClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开启Client");
		Socket socket = new Socket("192.168.0.55", 10086);
		System.out.println("连接上Server");
		
		//向服务器发送数据
		OutputStream output = socket.getOutputStream();
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(output));
		bfw.write("Hello Server");
		//设置结束标记
		bfw.newLine(); //此时要求对方也要用readLine()方法读，否则读不到
		//如果使用字符流，数据要进行刷新
		bfw.flush();
		

		
		
		//接收服务器发出的数据
		InputStream input = socket.getInputStream();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
		System.out.println("Server said: "+bfr.readLine());
	
		
		//关闭客户端
		System.out.println("关闭Client");
		output.close();
		input.close();
		bfr.close();
		bfw.close();
		socket.close();
	}

}
