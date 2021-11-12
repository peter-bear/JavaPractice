package Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import Model.Message;
import Model.MessageType;
import Model.User;
import Threads.ClientToServeThread;
import Threads.ManageCTSThread;

public class UserClientService {
	private User u = new User(); //�����ط���Ҫ���������
	private Socket socket;
	
	/**
	 * 1. ��¼����
	 * @param id
	 * @param pwd
	 * @return
	 */
	//����id��PWD��������ȥ��֤�û���¼
	public boolean checkUser(String id, String pwd) {
		//����User����
		u.setUserID(id);
		u.setPass(pwd);
		boolean log = false;
		//���ӷ���ˣ�����u����
		try {
			socket = new Socket("192.168.0.53", 10086);
			//�õ�ObjectOutputStream����
			ObjectOutputStream oop = new ObjectOutputStream(socket.getOutputStream());
			//����User����
			oop.writeObject(u); 
			

			
			//�ӷ���˶�ȡMessage����
			ObjectInputStream oip = new ObjectInputStream(socket.getInputStream());
			Message mms = (Message)oip.readObject();
			
			//�ж��Ƿ��¼�ɹ�
			if(mms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
				
				
				//����һ����������˱���ͨ�ŵ��߳�
				ClientToServeThread CTS = new ClientToServeThread(socket);
				CTS.start();
				
				//Ϊ�˿ͻ��˵���չ Ҫ���̷߳��뵽�����й���
				ManageCTSThread.addConnectThread(u.getUserID(), CTS);
				
				log =true;
			}else {
				//��¼ʧ�ܾͲ����������ͨ�ŵ��߳�
				//Ҫ�ر�Socket
				socket.close();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		
		return log;
	}
	
	/**
	 * ��ȡ�û�ID
	 * @return
	 */
	public String getU() {
		return u.getUserID();
	}
	
	/**
	 * 1 ��ʾ�����û�
	 */
	public String[] showOnlineUser() {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIENDS);
		message.setSender(u.getUserID());
		
		//���ͻ�ȡfriend��Ϣ��������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(u.getUserID()).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ManageCTSThread.getThread(u.getUserID()).getFriends();
	}
	
	
	/**
	 * 1 ����ͨ�û�����
	 */
	public void TalkWithOther(String sender, String other, String content, String time) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(sender);
		message.setGetter(other);
		message.setContent(content);
		message.setSendTime(time);
		
		
		//�����������ݸ�������
		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageCTSThread.getThread(sender).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//��ȡ���͵�����
	public String GetTheContent() {
		return  ManageCTSThread.getThread(u.getUserID()).GetMessage();
	}



	/**
	 * 1. �˳�����
	 * 2. �������������˳�ָ��
	 */
	public void LogOut() {
		
		
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserID());
		
		//����Message
		try {
			ObjectOutputStream oos= new ObjectOutputStream(ManageCTSThread.getThread(u.getUserID()).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ManageCTSThread.getThread(u.getUserID()).stop();
	}
	

	
	
}
