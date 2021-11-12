package com.udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsender {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//发送端连接端口
		DatagramSocket socket = new DatagramSocket(10087);
		
		//对发送数据进行封装
		byte[] data= "Hello World".getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("192.168.0.54"), 10086);
		//发送数据
		socket.send(packet);
		
		//接收receiver的回复
		byte[] buf=new byte[1024];
		packet = new DatagramPacket(buf, buf.length);
		//对数据进行拆包
		socket.receive(packet);
		data = packet.getData();
		System.out.println(new String(data));
		
		//关闭端口
		socket.close();
		
	}

}
