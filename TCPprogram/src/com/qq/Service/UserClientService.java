package com.qq.Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import com.qq.Model.Message;
import com.qq.Model.MessageType;
import com.qq.Model.User;
import com.qq.Threads.ClientToServeThread;
import com.qq.Threads.ManageCTSThread;

public class UserClientService {
	private User u = new User(); //其他地方还要有这个属性
	private Socket socket;
	
	/**
	 * 1. 登录服务
	 * @param id
	 * @param pwd
	 * @return
	 */
	//根据id和PWD到服务器去验证用户登录
	public boolean checkUser(String id, String pwd) {
		//创建User对象
		u.setUserID(id);
		u.setPass(pwd);
		boolean log = false;
		//连接服务端，发送u对象
		try {
			socket = new Socket("192.168.0.53", 10086);
			//得到ObjectOutputStream对象
			ObjectOutputStream oop = new ObjectOutputStream(socket.getOutputStream());
			//发送User对象
			oop.writeObject(u); 
			

			
			//从服务端读取Message对象
			ObjectInputStream oip = new ObjectInputStream(socket.getInputStream());
			Message mms = (Message)oip.readObject();
			
			//判断是否登录成功
			if(mms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
				
				
				//创建一个与服务器端保持通信的线程
				ClientToServeThread CTS = new ClientToServeThread(socket);
				CTS.start();
				
				//为了客户端的扩展 要将线程放入到集合中管理
				ManageCTSThread.addConnectThread(u.getUserID(), CTS);
				
				log =true;
			}else {
				//登录失败就不能与服务器通信的线程
				//要关闭Socket
				socket.close();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		return log;
	}
	

	
	
	/**
	 * 1. 退出程序
	 * 2. 给服务器发送退出指令
	 */
	public void LogOut() {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserID());
		
		//发送Message
		try {
			ObjectOutputStream oos= new ObjectOutputStream(ManageCTSThread.getThread(u.getUserID()).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
