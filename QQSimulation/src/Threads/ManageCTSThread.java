package Threads;

import java.util.HashMap;

public class ManageCTSThread {
	
	//将多个线程放入到集合中
	/**
	 * key 是用户id
	 * value 是用户的线程
	 */
	private static HashMap<String, ClientToServeThread> map = new HashMap<>();
	/**
	 * 把用户id 及其线程添加进map集合
	 * @param userID
	 * @param thread
	 */
	public static void addConnectThread(String userID, ClientToServeThread thread) {
		map.put(userID, thread);
	}
	
	/**
	 * 
	 * @param uid
	 * @return 返回对应的线程
	 */
	public static ClientToServeThread getThread(String uid) {
		return map.get(uid);
	}
	
	
	public static void RemoveThread(String uid) {
		map.remove(uid);
	}


	
}
