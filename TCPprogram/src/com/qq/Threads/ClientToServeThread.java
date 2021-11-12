package com.qq.Threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

import com.qq.Model.Message;
import com.qq.Model.MessageType;
import com.qq.Util.StringUtil;

public class ClientToServeThread extends Thread{
	//�������Socket
	private Socket socket;

	public ClientToServeThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	//Ϊ�����ȡsocket
	public Socket getSocket() {
		return socket;
	}
	
	 


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Ϊ�˱���ͨ�ţ�ʹ��Whileѭ��
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message mms = (Message)ois.readObject(); //���������û�з������ݣ�ͨ����һֱ����
				
				//�õ������û��б�
				if(mms.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIENDS)) {
					String[] friends = mms.getContent().split(" ");
					System.out.println("\n============�����û��б�============");
					for(String f: friends)
						System.out.printf(f+"   ");
					System.out.println();
				}
				
				//�õ�����
				else if(mms.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					System.out.println("\nʱ�䣺"+mms.getSendTime());
					System.out.println("�û� "+mms.getSender()+"���û� "+mms.getGetter()+" ˵��"+mms.getContent());
				}
				//�õ�Ⱥ����Ϣ
				else if(mms.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
					
					System.out.println("\nʱ�䣺"+mms.getSendTime());
					System.out.println("�û� "+mms.getSender()+"�� ������ ˵��"+mms.getContent());
				}
				//�õ������ļ�
				else if(mms.getMesType().equals(MessageType.MESSAGE_FILE)) {
//					Scanner in = new Scanner(System.in);
//					System.out.printf("\n���շ�(Y / N) ");
//					
//					String choice = in.next();
//					if(choice.equals("Y")) {
//						System.out.println("\nʱ�䣺"+mms.getSendTime());
//						System.out.println("�û� "+mms.getSender()+"���û� "+mms.getGetter()+" �����ļ���"+mms.getContent());
//						System.out.printf("�����ļ�Ŀ¼��");
////						StringUtil.get();
//						
//						String path = in.next();
//						FileOutputStream output = new FileOutputStream(path+"\\"+mms.getContent());
//						output.write(mms.getFile());
//						output.close();
//					}
//					in.close();
					System.out.println("\nʱ�䣺"+mms.getSendTime());
					System.out.println("�û� "+mms.getSender()+"���û� "+mms.getGetter()+" �����ļ���"+mms.getContent());
					FileOutputStream output = new FileOutputStream("C:\\Users\\23881\\Desktop\\"+mms.getContent());
					output.write(mms.getFile());
					output.close();
					System.out.println("�ļ��Ѵ���������");
				}
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
