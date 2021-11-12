package com.qq.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

import com.qq.Model.Message;
import com.qq.Model.MessageType;
import com.qq.Threads.ManageCTSThread;
import com.qq.Util.StringUtil;

public class SecondMainView {
	public static boolean showView(String userID) {
		System.out.println("============��ӭ���û� "+userID+" ��============");
		boolean loop = true;
		String key;
		while(loop) {
			System.out.println("\n============����ͨ��ϵͳ�����˵����û� "+userID+" ��============");
			System.out.println("\t\t 1 ��ʾ�����û��б�");
			System.out.println("\t\t 2 Ⱥ����Ϣ");
			System.out.println("\t\t 3 ˽����Ϣ");
			System.out.println("\t\t 4 �����ļ�");
			System.out.println("\t\t 9 �˳�ϵͳ");
			
			key = StringUtil.readNum(1); //��ȡ�û�����
			
			switch (key) {
			case "1":
				ShowOnlineFriend(userID);
				break;
			
			case "2":
				System.out.printf("�������������ݣ�");
				StringUtil.getLine();
				String contentToAll = StringUtil.getLine();
				SpeakToAll(userID, contentToAll);
				break;
			
			case "3":
				
				System.out.printf("\n������Ŀ���û���");
				String other = StringUtil.get();
				System.out.printf("�������������ݣ�");
				StringUtil.getLine();
				String content = StringUtil.getLine();
				TalkWithOther(userID, other, content);
				
				break;
			
			case "4":
				System.out.printf("\n������Ŀ���û���");
				String target = StringUtil.get();
				System.out.printf("�������ļ���ַ��");
				String path = StringUtil.get();
				SendFile(userID, target, path);
				break;
				
			case "9":
				loop = false;
				break;
			}
		}
		return loop;
	}

	
	/**
	 * ��ʾ�����û��б�
	 */
	private static void ShowOnlineFriend(String userID) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIENDS);
		message.setSender(userID);
		
		//���ͻ�ȡfriend��Ϣ��������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(userID).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 1 ����ͨ�û�����
	 */
	private static void TalkWithOther(String sender, String other, String content) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(sender);
		message.setGetter(other);
		message.setContent(content);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"��"+time.getSeconds());
		
		System.out.println("\nʱ�䣺"+message.getSendTime());
		System.out.println("�û� "+message.getSender()+"���û� "+message.getGetter()+" ˵��"+message.getContent());
		
		
		//�����������ݸ�������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 1 Ⱥ����Ϣ
	 */
	private static void SpeakToAll(String sender, String content) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_TO_ALL);
		message.setSender(sender);
		message.setContent(content);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"��"+time.getSeconds());
		
		System.out.println("\nʱ�䣺"+message.getSendTime());
		System.out.println("�û� "+message.getSender()+"�� ������ ˵��"+message.getContent());
		
		//�����������ݸ�������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 1 �����ļ�
	 */
	private static void SendFile(String sender, String other, String path) {
		Message message=new Message();
		message.setSender(sender);
		message.setGetter(other);
		message.setMesType(MessageType.MESSAGE_FILE);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"��"+time.getSeconds());
		
		
		try {
			byte[] content;
			//���ڻ�ȡ�ļ���·��
			File filePath = new File(path);
			FileInputStream file = new FileInputStream(filePath);
			content = new byte[(int)filePath.length()];
			file.read(content);
			
			file.close();
			
			message.setFile(content);
			message.setContent(filePath.getAbsolutePath().substring(filePath.getParent().length()));
			
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}
