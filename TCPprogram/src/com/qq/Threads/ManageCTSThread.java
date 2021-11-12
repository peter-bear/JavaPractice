package com.qq.Threads;

import java.util.HashMap;

public class ManageCTSThread {
	
	//������̷߳��뵽������
	/**
	 * key ���û�id
	 * value ���û����߳�
	 */
	private static HashMap<String, ClientToServeThread> map = new HashMap<>();
	/**
	 * ���û�id �����߳���ӽ�map����
	 * @param userID
	 * @param thread
	 */
	public static void addConnectThread(String userID, ClientToServeThread thread) {
		map.put(userID, thread);
	}
	
	/**
	 * 
	 * @param uid
	 * @return ���ض�Ӧ���߳�
	 */
	public static ClientToServeThread getThread(String uid) {
		return map.get(uid);
	}
	
	
	/**
	 *1. �Ӽ������Ƴ�ĳ���̶߳���
	 */
	
	public static void removeThread(String uid) {
		map.remove(uid);
	}
	
}
