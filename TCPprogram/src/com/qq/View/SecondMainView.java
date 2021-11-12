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
		System.out.println("============欢迎（用户 "+userID+" ）============");
		boolean loop = true;
		String key;
		while(loop) {
			System.out.println("\n============网络通信系统二级菜单（用户 "+userID+" ）============");
			System.out.println("\t\t 1 显示在线用户列表");
			System.out.println("\t\t 2 群发消息");
			System.out.println("\t\t 3 私聊消息");
			System.out.println("\t\t 4 传输文件");
			System.out.println("\t\t 9 退出系统");
			
			key = StringUtil.readNum(1); //获取用户输入
			
			switch (key) {
			case "1":
				ShowOnlineFriend(userID);
				break;
			
			case "2":
				System.out.printf("请输入聊天内容：");
				StringUtil.getLine();
				String contentToAll = StringUtil.getLine();
				SpeakToAll(userID, contentToAll);
				break;
			
			case "3":
				
				System.out.printf("\n请输入目标用户：");
				String other = StringUtil.get();
				System.out.printf("请输入聊天内容：");
				StringUtil.getLine();
				String content = StringUtil.getLine();
				TalkWithOther(userID, other, content);
				
				break;
			
			case "4":
				System.out.printf("\n请输入目标用户：");
				String target = StringUtil.get();
				System.out.printf("请输入文件地址：");
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
	 * 显示在线用户列表
	 */
	private static void ShowOnlineFriend(String userID) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIENDS);
		message.setSender(userID);
		
		//发送获取friend信息给服务器
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(userID).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 1 与普通用户聊天
	 */
	private static void TalkWithOther(String sender, String other, String content) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(sender);
		message.setGetter(other);
		message.setContent(content);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"："+time.getSeconds());
		
		System.out.println("\n时间："+message.getSendTime());
		System.out.println("用户 "+message.getSender()+"对用户 "+message.getGetter()+" 说："+message.getContent());
		
		
		//发送聊天内容给服务器
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 1 群发消息
	 */
	private static void SpeakToAll(String sender, String content) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_TO_ALL);
		message.setSender(sender);
		message.setContent(content);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"："+time.getSeconds());
		
		System.out.println("\n时间："+message.getSendTime());
		System.out.println("用户 "+message.getSender()+"对 所有人 说："+message.getContent());
		
		//发送聊天内容给服务器
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 1 发送文件
	 */
	private static void SendFile(String sender, String other, String path) {
		Message message=new Message();
		message.setSender(sender);
		message.setGetter(other);
		message.setMesType(MessageType.MESSAGE_FILE);
		Date time =new Date();
		message.setSendTime(time.getHours()+":"+time.getMinutes()+"："+time.getSeconds());
		
		
		try {
			byte[] content;
			//用于获取文件的路径
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
