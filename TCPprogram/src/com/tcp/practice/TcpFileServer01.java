package com.tcp.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer01 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//服务端在一个端口监听
		ServerSocket server = new ServerSocket(10086);
		System.out.println("启动服务器");	
		Socket socket = server.accept();
		
		//服务器接收到图片，保存
		if(StreamUtils.ReceiveFile(socket, "E:\\java程序\\TCPprogram\\src\\com\\tcp\\images\\kiss.gif")) {
			System.out.println("客户端文件发送完成");
			StreamUtils.Write(socket, "文件传输完成，服务器收到图片");
		}
		
		//退出服务器
		socket.close();
		server.close();
		System.out.println("关闭服务器");
		
	}

}
