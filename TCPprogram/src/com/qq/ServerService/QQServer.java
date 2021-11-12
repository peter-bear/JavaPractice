package com.qq.ServerService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.qq.Model.Message;
import com.qq.Model.MessageType;
import com.qq.Model.User;
import com.qq.Threads.ManagerSTCThread;
import com.qq.Threads.ServerToClientThread;

public class QQServer {
	private	ServerSocket serverSocket = null;
	private static HashMap<String, User> users = new HashMap<>();
	static {
		users.put("peter", new User("peter", "666"));
		users.put("Jerry", new User("Jerry", "555"));
		users.put("Bob", new User("Bob", "777"));
		
	}
	public QQServer() {
		// TODO Auto-generated method stub
		System.out.println("服务器开始监听");
		
		try {
			serverSocket = new ServerSocket(10086);
			while(true) { //监听是循环监听
				Socket socket = serverSocket.accept();
				
				//得到Socket相关的输入
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				Message message = new Message();
				
				User user = (User)ois.readObject();
				if(checkUser(user)) {
					message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
					//把登录成功的信息返回给客户端
					oos.writeObject(message);
					
					System.out.println("用户 "+user.getUserID()+" 上线");
					
					//创建一个线程和客户端保持通信
					ServerToClientThread STC = new ServerToClientThread(socket, user.getUserID());
					STC.start();
					
					//把该线程对象放入集合中
					ManagerSTCThread.addConnectThread(user.getUserID(), STC);
					
					
				}else {
					message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
					oos.writeObject(message);
					socket.close(); //关闭socket
				}
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//退出后台
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private boolean checkUser(User user) {
		return users.containsKey(user.getUserID())&& users.get(user.getUserID()).getPass().equals(user.getPass());
	}

}
