package Threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import Model.Message;
import Model.MessageType;

/**
 * 1. �������ʹ��������ͻ��˱�������
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
					System.out.println(message.getSender()+"Ҫ����ʾ�����û�");
					
					//�����������������
					message.setContent(ManagerSTCThread.getAllThreads());
					message.setMesType(MessageType.MESSAGE_ONLINE_FRIENDS);
					message.setGetter(message.getSender());
					message.setSender("������");
					
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message);
				}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					//��ȡ���͵�Ŀ���û�
					
					System.out.println(message.getSender()+" �� "+message.getGetter()+" ���� "+message.getContent());
					ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(message.getGetter()).socket.getOutputStream());
					oos.writeObject(message);
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
					//Ⱥ����Ϣ
					String temp = ManagerSTCThread.getAllThreads();
					String[] users = temp.split(" ");
					for(String u:users) {
						if(!u.equals(message.getSender())) {
							ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(u).socket.getOutputStream());
							oos.writeObject(message);
						}
					}
					
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_FILE)) {
					//���յ������ļ�
					ObjectOutputStream oos = new ObjectOutputStream(ManagerSTCThread.getThread(message.getGetter()).socket.getOutputStream());
					oos.writeObject(message);
					
				} else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
					//�˳�������
					ManagerSTCThread.removeThread(message.getSender());
					socket.close();
					System.out.println("�û� "+message.getSender()+" ����");
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
