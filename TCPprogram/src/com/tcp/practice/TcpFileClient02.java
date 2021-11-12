package com.tcp.practice;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpFileClient02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.0.54", 10086);
	
		//客户端输入请求的文件
		Scanner in = new Scanner(System.in);
		System.out.printf("输入文件：");
		String words = in.next();
		StreamUtils.Write(socket, words);
		
		//客户端获取文件
		if(StreamUtils.ReceiveFile(socket, "E:\\"+words))
			System.out.println("客户端接收到文件");
		else {
			System.out.println("客户端未接收到文件");
		}
		

		
		//关闭
		in.close();
		socket.close();
		System.out.println("关闭客户端");
	}

}
