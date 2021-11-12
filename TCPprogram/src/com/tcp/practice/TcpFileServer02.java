package com.tcp.practice;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer02 {
/**
 * 1. �������˽��յ��ͻ��˵���������
 * 2. �������ڱ���Ŀ¼Ѱ���Ƿ�������ļ� �оͷ��� û�оͷ���Ĭ���ļ�
 * 3. �ͻ��˽����ļ������浽���Ŀ¼
 * @param args
 * @throws IOException 
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//�������˽����˿�
		ServerSocket serverSocket = new ServerSocket(10086);
		System.out.println("��������ʼ����");
		Socket socket = serverSocket.accept();
		
		//��������������
		String choice = StreamUtils.Read(socket);
		String defaul = "kiss.gif";
		
		//����Ŀ¼�������ļ�
		File file = new File("E:\\java����\\TCPprogram\\src\\com\\tcp\\images");
		File[] files = file.listFiles();
		boolean contain =false;
		for(File f:files)
			if(f.getName().equals(choice)) {
				contain = true;
				StreamUtils.SendFile(socket, "E:\\java����\\TCPprogram\\src\\com\\tcp\\images\\"+choice);
			}
		
		//û�ҵ��ͷ���Ĭ���ļ�
		if(!contain) {
			StreamUtils.SendFile(socket, "E:\\java����\\TCPprogram\\src\\com\\tcp\\images\\"+defaul);
		}
		
		//������ϣ��ر�
		socket.close();
		serverSocket.close();
		System.out.println("�رշ�����");

	}

}
