package com.tcp.practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer01 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//�������һ���˿ڼ���
		ServerSocket server = new ServerSocket(10086);
		System.out.println("����������");	
		Socket socket = server.accept();
		
		//���������յ�ͼƬ������
		if(StreamUtils.ReceiveFile(socket, "E:\\java����\\TCPprogram\\src\\com\\tcp\\images\\kiss.gif")) {
			System.out.println("�ͻ����ļ��������");
			StreamUtils.Write(socket, "�ļ�������ɣ��������յ�ͼƬ");
		}
		
		//�˳�������
		socket.close();
		server.close();
		System.out.println("�رշ�����");
		
	}

}
