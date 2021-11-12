package com.peter.Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.peter.Modle.Message;
import com.peter.Modle.MessageType;
import com.peter.Modle.User;
import com.peter.Modle.UserThread;

public class UserConnectService {
	private static Socket UserSocket = null;
	private static User user= new User();
	private static UserThread userThread;
	public static void ConnectToServer() {
		try {
			UserSocket = new Socket("137.112.237.25", 10086);
			Message message = new Message();
			message.setMT(MessageType.connect);
			message.setSender(user.getUname()+":"+user.getUID());
			
			
			ObjectOutputStream output = new ObjectOutputStream(UserSocket.getOutputStream());
			output.writeObject(message);
			
			userThread = new UserThread(UserSocket);
			userThread.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ�����û�IP
	public static ArrayList<String> GetAllIP() {

		
		Message message = new Message();
		message.setMT(MessageType.allUsers);
		message.setSender(user.getUname()+":"+user.getUID());
		try {
			ObjectOutputStream output = new ObjectOutputStream(userThread.getUserSocket().getOutputStream());
			output.writeObject(message);
			//�ȴ�����IP
			if(userThread.getAllUsers() == null) {
				Thread.sleep(5000);
			}
			if(userThread.getAllUsers() == null)
				return null;
			return userThread.getAllUsers();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String SendChatContent(String receiver, String words){
		Message message =  new Message();
		message.setMT(MessageType.chat);
		message.setSender(user.getUname()+":"+user.getUID());
		message.setReceiver(receiver);
		Date date = new Date();
		message.setWords(words+"\t"+date.toString());
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(userThread.getUserSocket().getOutputStream());
			output.writeObject(message);
			String words1 = message.getSender()+" �� "+message.getReceiver()+" ˵:\n "+message.getWords();
			userThread.getContent().add(words1);
			return words1;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "���ӳ�ʱ����Ϣδ����";
	} 
	
	//�˳�����
	public static void Exit() {
		//������������˳�ָ��
		Message message = new Message();
		message.setMT(MessageType.exit);
		message.setSender(user.getUname()+":"+user.getUID());
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(userThread.getUserSocket().getOutputStream());
			output.writeObject(message);
			System.exit(0);//ϵͳ�˳�
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
