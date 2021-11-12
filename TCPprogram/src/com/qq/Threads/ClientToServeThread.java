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
	//必须持有Socket
	private Socket socket;

	public ClientToServeThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	//为方便读取socket
	public Socket getSocket() {
		return socket;
	}
	
	 


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//为了保持通信，使用While循环
		while(true) {
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message mms = (Message)ois.readObject(); //如果服务器没有发送数据，通道会一直阻塞
				
				//得到在线用户列表
				if(mms.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIENDS)) {
					String[] friends = mms.getContent().split(" ");
					System.out.println("\n============在线用户列表============");
					for(String f: friends)
						System.out.printf(f+"   ");
					System.out.println();
				}
				
				//得到聊天
				else if(mms.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					System.out.println("\n时间："+mms.getSendTime());
					System.out.println("用户 "+mms.getSender()+"对用户 "+mms.getGetter()+" 说："+mms.getContent());
				}
				//得到群发消息
				else if(mms.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
					
					System.out.println("\n时间："+mms.getSendTime());
					System.out.println("用户 "+mms.getSender()+"对 所有人 说："+mms.getContent());
				}
				//得到的是文件
				else if(mms.getMesType().equals(MessageType.MESSAGE_FILE)) {
//					Scanner in = new Scanner(System.in);
//					System.out.printf("\n接收否：(Y / N) ");
//					
//					String choice = in.next();
//					if(choice.equals("Y")) {
//						System.out.println("\n时间："+mms.getSendTime());
//						System.out.println("用户 "+mms.getSender()+"对用户 "+mms.getGetter()+" 发送文件："+mms.getContent());
//						System.out.printf("储存文件目录：");
////						StringUtil.get();
//						
//						String path = in.next();
//						FileOutputStream output = new FileOutputStream(path+"\\"+mms.getContent());
//						output.write(mms.getFile());
//						output.close();
//					}
//					in.close();
					System.out.println("\n时间："+mms.getSendTime());
					System.out.println("用户 "+mms.getSender()+"对用户 "+mms.getGetter()+" 发送文件："+mms.getContent());
					FileOutputStream output = new FileOutputStream("C:\\Users\\23881\\Desktop\\"+mms.getContent());
					output.write(mms.getFile());
					output.close();
					System.out.println("文件已储存在桌面");
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
