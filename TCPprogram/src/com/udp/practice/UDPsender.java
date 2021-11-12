package com.udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsender {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//���Ͷ����Ӷ˿�
		DatagramSocket socket = new DatagramSocket(10087);
		
		//�Է������ݽ��з�װ
		byte[] data= "Hello World".getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("192.168.0.54"), 10086);
		//��������
		socket.send(packet);
		
		//����receiver�Ļظ�
		byte[] buf=new byte[1024];
		packet = new DatagramPacket(buf, buf.length);
		//�����ݽ��в��
		socket.receive(packet);
		data = packet.getData();
		System.out.println(new String(data));
		
		//�رն˿�
		socket.close();
		
	}

}
