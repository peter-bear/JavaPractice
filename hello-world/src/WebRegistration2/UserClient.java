package WebRegistration2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用户注册登录客户端
 * @author 23881
 *
 */
public class UserClient {
	public static void main(String[] args) throws Exception {
		System.out.println("-----1 Registration, 2 Log_In-----");
		Scanner input =new Scanner(System.in);
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			regist();
			break;
		case 2:
			login();
			break;
		default:
			break;
		}
		input.close();
	}
	
	public static void regist() throws Exception {
		//1创建Socket
		Socket socket = new Socket("192.168.0.53",10086);
		//2获取流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
		//3获取用户信息
		String json = getRegistInfo();
		//4发送用户信息给服务器
		bw.write(json);
		bw.newLine();
		bw.flush();
		//5接收服务器回复
		String reply = br.readLine();
		System.out.println("服务器的回复："+reply);
		//6关闭
		bw.close();
		br.close();
		socket.close();
	}
	
	public static String getRegistInfo() {
		Scanner input =  new Scanner(System.in);
		System.out.println("请自定义用户ID：");
		Long id = input.nextLong();
		System.out.println("请输入姓名：");
		String name =  input.next();
		System.out.println("请输入密码：");
		String pas = input.next();
		System.out.println("请输入年龄：");
		int age = input.nextInt();
//		转出的数据格式：
//		接收客户端发送的数据 JSON {id : 1001, name: tom, pwd :123, age:20}
		String json = "{id:"+id+",name:"+name+",pwd:"+pas+",age:"+age+"}";
		input.close();
		return json;
	}
	
	public static void login() throws Exception{
		//1创建Socket
				Socket socket = new Socket("192.168.0.53",1818);
				//2获取流
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
				//3获取用户信息
				String json = getLogIn();
				//4发送用户信息给服务器
				bw.write(json);
				bw.newLine();
				bw.flush();
				//5接收服务器回复
				String reply = br.readLine();
				System.out.println("服务器的回复："+reply);
				//6关闭
				bw.close();
				br.close();
				socket.close();
	}
	
	public static String getLogIn() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入ID：");
		Long id = input.nextLong();
		System.out.println("请输入密码：");
		String pwd = input.next();
		String info = "{id:"+id+",pwd:"+pwd+"}";
		input.close();
		return info;
	}
}
