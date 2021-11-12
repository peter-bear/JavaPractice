package com.udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPreceiver {
	public static void main(String[] args) throws IOException {
		//接收端建立端口
		DatagramSocket socket = new DatagramSocket(10086);
		
		//接收数据
		byte[] buf=new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		//对接收的数据进行拆包
		int len = packet.getLength(); //实际接收到的数据长度
		byte[] data = packet.getData(); //返回实际的数据
		System.out.println(new String(data, 0, len));
		
		//向发送端回复数据
		data = "Receiver Get it".getBytes();
		//对数据封装
		packet = new DatagramPacket(data, data.length,InetAddress.getByName("192.168.0.54"), 10087);
		//发送数据
		socket.send(packet);
		
		
		
		//关闭端口
		socket.close();
	}
}
