package Threads;

import java.util.HashMap;

public class ManagerSTCThread {
	//������̷߳��뵽������
	/**
	 * key ���û�id
	 * value ���û����߳�
	 */
	private static HashMap<String, ServerToClientThread> map = new HashMap<>();
	/**
	 * ���û�id �����߳���ӽ�map����
	 * @param userID
	 * @param thread
	 */
	public static void addConnectThread(String userID, ServerToClientThread thread) {
		map.put(userID, thread);
	}
	
	/**
	 * 
	 * @param uid
	 * @return ���ض�Ӧ���߳�
	 */
	public static ServerToClientThread getThread(String uid) {
		return map.get(uid);
	}
	
	public static String getAllThreads() {
		String temp="";
		for(String key: map.keySet())
			temp += key+" ";
		return temp;
	}
	
	
	/**
	 *1. �Ӽ������Ƴ�ĳ���̶߳���
	 */
	
	public static void removeThread(String uid) {
		map.remove(uid);
	}
}
