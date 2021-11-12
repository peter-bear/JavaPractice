package com.tcp.practice;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer02 {
/**
 * 1. 服务器端接收到客户端的请求数据
 * 2. 服务器在本地目录寻找是否有相关文件 有就发送 没有就发送默认文件
 * 3. 客户端接收文件并保存到相关目录
 * @param args
 * @throws IOException 
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//服务器端建立端口
		ServerSocket serverSocket = new ServerSocket(10086);
		System.out.println("服务器开始运行");
		Socket socket = serverSocket.accept();
		
		//服务器接收请求
		String choice = StreamUtils.Read(socket);
		String defaul = "kiss.gif";
		
		//到根目录下搜索文件
		File file = new File("E:\\java程序\\TCPprogram\\src\\com\\tcp\\images");
		File[] files = file.listFiles();
		boolean contain =false;
		for(File f:files)
			if(f.getName().equals(choice)) {
				contain = true;
				StreamUtils.SendFile(socket, "E:\\java程序\\TCPprogram\\src\\com\\tcp\\images\\"+choice);
			}
		
		//没找到就返回默认文件
		if(!contain) {
			StreamUtils.SendFile(socket, "E:\\java程序\\TCPprogram\\src\\com\\tcp\\images\\"+defaul);
		}
		
		//传输完毕，关闭
		socket.close();
		serverSocket.close();
		System.out.println("关闭服务器");

	}

}
