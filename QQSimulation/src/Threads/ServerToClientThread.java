package Threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import Model.Message;
import Model.MessageType;

/**
 * 1. 此类可以使服务器与客户端保持连接
 * @author 23881
 *
 */
public class ServerToClientThread extends Thread{
	
	private Socket socket;
	private String usrID;
	
	
	public ServerToClientThread(Socket socket, String id) {
		this.socket = socket;
		this.usrID = id;
	}



	@Override
	public void run() {
		while(true) {

			
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message)ois.readObject();
				if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIENDS)) {
					System.out.println(message.getSender()+"要求显示在线用户");
					
					//服务器返回相关内容
					message.setContent(ManagerSTCThread.getAllThreads());
					message.setMesType(MessageType.MESSAGE_ONLINE_FRIENDS);
					message.setGetter(message.getSender());
					message.setSender("服务器");
					
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message);
				}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					//获取发送的目标用户
					
					System.out.println(message.getSender()+" 向 "+message.getGetter()+" 发送 "+message.getContent());
					ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(message.getGetter()).socket.getOutputStream());
					oos.writeObject(message);
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
					//群发消息
					String temp = ManagerSTCThread.getAllThreads();
					String[] users = temp.split(" ");
					for(String u:users) {
						if(!u.equals(message.getSender())) {
							ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(u).socket.getOutputStream());
							oos.writeObject(message);
						}
					}
					
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_FILE)) {
					//接收到的是文件
					ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(message.getGetter()).socket.getOutputStream());
					oos.writeObject(message);
					
				} else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
					//退出服务器
					ManagerSTCThread.removeThread(message.getSender());
					socket.close();
					System.out.println("用户 "+message.getSender()+" 下线");
					break;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
