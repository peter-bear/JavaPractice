package com.tcp.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


//�ַ���ȡ�ͻ���
public class TcpWordClient2 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("����Client");
		Socket socket = new Socket("192.168.0.55", 10086);
		System.out.println("������Server");
		
		//���������������
		OutputStream output = socket.getOutputStream();
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(output));
		bfw.write("Hello Server");
		//���ý������
		bfw.newLine(); //��ʱҪ��Է�ҲҪ��readLine()�����������������
		//���ʹ���ַ���������Ҫ����ˢ��
		bfw.flush();
		

		
		
		//���շ���������������
		InputStream input = socket.getInputStream();
		BufferedReader bfr = new BufferedReader(new InputStreamReader(input));
		System.out.println("Server said: "+bfr.readLine());
	
		
		//�رտͻ���
		System.out.println("�ر�Client");
		output.close();
		input.close();
		bfr.close();
		bfw.close();
		socket.close();
	}

}
