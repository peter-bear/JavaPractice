package WebRegistration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws Exception {
		//1创建Socket对象
		Socket path = new Socket("192.168.0.53", 10086);
		Scanner input = new Scanner(System.in);
		//3缓冲流输入与输出
		BufferedReader br= new BufferedReader(new InputStreamReader(path.getInputStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(path.getOutputStream(),"utf-8"));
		bw.write(choice(input));
		bw.newLine();
		bw.flush();
		
		String reply = br.readLine();
		while(!reply.equals("true")) {
			Socket path2 = new Socket("192.168.0.53", 10086);
			BufferedReader br1= new BufferedReader(new InputStreamReader(path2.getInputStream(),"utf-8"));
			BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(path2.getOutputStream(),"utf-8"));
			if(reply.equals("false")) {
				System.out.println("ID and Passwords are Incorrect");
				bw1.write(choice(input));
				bw1.newLine();
				bw1.flush();
				reply = br1.readLine();
				System.out.println(reply);
			}
			else if(reply.equals("reg")) {
				System.out.println("Please register your account before log in!!!");
				bw1.write(choice(input));
				bw1.newLine();
				bw1.flush();
				reply = br1.readLine();
			}
			else if(reply.equals("exist")) {
				System.out.println("This account has exist");
				bw1.write(choice(input));
				bw1.newLine();
				bw1.flush();
				reply = br1.readLine();
			}
			else if(reply.equals("true")) {
				break;
			}
			else {
				System.out.println(reply);
				break;
			}
			path2.close();
		}
		System.out.println("Welcome");
		
		path.close();
		input.close();
	}
	
	public static String choice(Scanner in) {
		System.out.println();
		System.out.println("\tWelcome to Peter's Blog!");
		while(true) {
			System.out.println("What are you going to do?");
			System.out.println("1. Log In");
			System.out.println("2. Registration");
			System.out.println("3. Change Password");
			System.out.print("Your choice(choose the number): ");
			String choice1 = in.next();
			switch (Integer.valueOf(choice1)) {
			case 1:
				return "1"+getLogIn(in);
			case 2:
				String json = getRegistInfo(in);
				return "2"+json;
			case 3:
				in.close();
				return "3";
			default:
				System.out.println();
				System.out.println("Please put in correct number!!");
			}
		}
	}
	
	public static String getRegistInfo(Scanner input) {
		System.out.println("请自定义用户ID：");
		String id = input.next();
		System.out.println("请输入姓名：");
		String name =  input.next();
		System.out.println("请输入密码：");
		String pas = input.next();
		System.out.println("请输入年龄：");
		int age = input.nextInt();
//		转出的数据格式：
//		接收客户端发送的数据 JSON {id : 1001, name: tom, pwd :123, age:20}
		String json = "{id:"+id+",name:"+name+",pwd:"+pas+",age:"+age+"}";
		return json;
	}
	
	public static String getLogIn(Scanner input) {
		System.out.println("请输入ID：");
		Long id = input.nextLong();
		System.out.println("请输入密码：");
		String pwd = input.next();
		String info = "{id:"+id+",pwd:"+pwd+"}";
		return info;
	}
}
