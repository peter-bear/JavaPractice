package com.tcp.practice;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1. ��дһ������˺�һ���ͻ���
 * 2. �������һ���˿ڼ���
 * 3. �ͻ������ӵ�������������һ��ͼƬ
 * 4. �������������ͼƬ���浽SRC��
 * 5. �������ٷ���"�յ�ͼƬ"Ȼ���˳�
 * 6. �ͻ��˽��յ�ͼƬ�˳�
 * 7. ����Ҫ��ʹ��(������)StreamUtils.java
 * @author 23881
 *
 */
public class TcpFileClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("�����ͻ���");
		//�ͻ��������˽�������
		Socket socket = new Socket("192.168.0.55", 10086);
		
		//�ͻ��˷����ļ�
		StreamUtils.SendFile(socket, "C:\\Users\\23881\\Desktop\\Self_study\\Java����\\�����ز�\\kiss.gif");
		
		//�ͻ��˽��շ��������͵�����
		System.out.println(StreamUtils.Read(socket));
		
		//�ͻ����˳�
		socket.close();
		System.out.println("�رտͻ���");
		
	}	
	

}
