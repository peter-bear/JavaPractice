package com.tcp.practice;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpFileClient02 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Socket socket = new Socket("192.168.0.54", 10086);
	
		//�ͻ�������������ļ�
		Scanner in = new Scanner(System.in);
		System.out.printf("�����ļ���");
		String words = in.next();
		StreamUtils.Write(socket, words);
		
		//�ͻ��˻�ȡ�ļ�
		if(StreamUtils.ReceiveFile(socket, "E:\\"+words))
			System.out.println("�ͻ��˽��յ��ļ�");
		else {
			System.out.println("�ͻ���δ���յ��ļ�");
		}
		

		
		//�ر�
		in.close();
		socket.close();
		System.out.println("�رտͻ���");
	}

}
