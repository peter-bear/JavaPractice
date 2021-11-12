package com.udp.practice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPreceiver {
	public static void main(String[] args) throws IOException {
		//���ն˽����˿�
		DatagramSocket socket = new DatagramSocket(10086);
		
		//��������
		byte[] buf=new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		
		//�Խ��յ����ݽ��в��
		int len = packet.getLength(); //ʵ�ʽ��յ������ݳ���
		byte[] data = packet.getData(); //����ʵ�ʵ�����
		System.out.println(new String(data, 0, len));
		
		//���Ͷ˻ظ�����
		data = "Receiver Get it".getBytes();
		//�����ݷ�װ
		packet = new DatagramPacket(data, data.length,InetAddress.getByName("192.168.0.54"), 10087);
		//��������
		socket.send(packet);
		
		
		
		//�رն˿�
		socket.close();
	}
}
