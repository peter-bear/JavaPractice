package com.peter.Modle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


//�û��߳��࣬���ڽ��շ��������͹�������Ϣ
public class UserThread extends Thread{
	private Socket UserSocket=null;
	private static ArrayList<String> allUsers=null;
	private static ArrayList<String> ChatContent=new ArrayList<>();
	
	public UserThread(Socket us) {
		UserSocket = us;
	}
	
	public Socket getUserSocket() {
		return UserSocket;
	}

	public ArrayList<String> getAllUsers() {
		return allUsers;
	}
	
	public ArrayList<String> getContent(){
		return ChatContent;
	}


	@Override
	public void run() {
		while(true) {
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(UserSocket.getInputStream());
				Message mms = (Message)ois.readObject(); //���������û�з������ݣ�ͨ����һֱ����
				
				if(mms.getMT() == MessageType.allUsers) {
					UserThread.allUsers = mms.getUsers();
//					System.out.println("hello");
				}else if(mms.getMT() == MessageType.chat) {
					ChatContent.add(mms.getSender()+" �� "+mms.getReceiver()+" ˵:\n "+mms.getWords());
					System.out.println("������Ϣ��");
					//��ʾ������Ϣ��Ϣ
					for(String chatContent:ChatContent)
						System.out.println(chatContent);
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
