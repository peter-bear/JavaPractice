package Threads;

import java.util.HashMap;

public class ManagerSTCThread {
	//将多个线程放入到集合中
	/**
	 * key 是用户id
	 * value 是用户的线程
	 */
	private static HashMap<String, ServerToClientThread> map = new HashMap<>();
	/**
	 * 把用户id 及其线程添加进map集合
	 * @param userID
	 * @param thread
	 */
	public static void addConnectThread(String userID, ServerToClientThread thread) {
		map.put(userID, thread);
	}
	
	/**
	 * 
	 * @param uid
	 * @return 返回对应的线程
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
	 *1. 从集合中移除某个线程对象
	 */
	
	public static void removeThread(String uid) {
		map.remove(uid);
	}
}
