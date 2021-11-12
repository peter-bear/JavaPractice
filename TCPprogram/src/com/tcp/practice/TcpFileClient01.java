package com.tcp.practice;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1. 编写一个服务端和一个客户端
 * 2. 服务端在一个端口监听
 * 3. 客户端连接到服务器并发送一个图片
 * 4. 服务器接收这个图片保存到SRC下
 * 5. 服务器再发送"收到图片"然后退出
 * 6. 客户端接收到图片退出
 * 7. 程序要求使用(工具类)StreamUtils.java
 * @author 23881
 *
 */
public class TcpFileClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("启动客户端");
		//客户端与服务端建立连接
		Socket socket = new Socket("192.168.0.55", 10086);
		
		//客户端发送文件
		StreamUtils.SendFile(socket, "C:\\Users\\23881\\Desktop\\Self_study\\Java基础\\桌宠素材\\kiss.gif");
		
		//客户端接收服务器发送的数据
		System.out.println(StreamUtils.Read(socket));
		
		//客户端退出
		socket.close();
		System.out.println("关闭客户端");
		
	}	
	

}
