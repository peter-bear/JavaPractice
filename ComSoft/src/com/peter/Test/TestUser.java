package com.peter.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Set;
import java.util.Map.Entry;

import com.peter.Modle.Message;
import com.peter.Modle.User;

public class TestUser {
	public static void main(String[] args) {
		User user = new User();
		try {

			Socket socket = new Socket(InetAddress.getByName("137.112.237.25"), 10086);
//			Message message = new Message();
//			message.setSender(user.getUID());
//			message.setWords(user.getUname());
			
//			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
//			output.writeObject(message);
//			
//			output.close();
			System.out.println("Start");
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Message message = (Message)input.readObject();
			System.out.println(message.getWords());
			
//			for(String tmp: message.getUsers()) {
//				System.out.println(tmp);
//			}
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
