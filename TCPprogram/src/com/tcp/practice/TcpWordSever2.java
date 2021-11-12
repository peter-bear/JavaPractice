package com.tcp.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//�ַ���ȡ������
public class TcpWordSever2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = new ServerSocket(10086);
		System.out.println("����Server");
		
		//��ʼ��������
		Socket socket = serverSocket.accept();
		
		//��ȡclient���͵���Ϣ
		InputStream input = socket.getInputStream();	
		BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
		System.out.println("client said: "+bfr.readLine());

		
		//��Client������Ϣ
		OutputStream output = socket.getOutputStream();
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(output));
		bfw.write("Hello, Client");
		//��������������
		bfw.newLine();
		//���ʹ���ַ���������Ҫ����ˢ�£��������ݲ���д������ͨ��
		bfw.flush();
		
		
		
		//�رշ�����
		System.out.println("�ر�Server");
		output.close();
		socket.close();
		bfw.close();
		input.close();
		bfr.close();
		serverSocket.close();

	}

}
