package WebRegistration2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * �û�ע���¼�ͻ���
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
		//1����Socket
		Socket socket = new Socket("192.168.0.53",10086);
		//2��ȡ��
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
		//3��ȡ�û���Ϣ
		String json = getRegistInfo();
		//4�����û���Ϣ��������
		bw.write(json);
		bw.newLine();
		bw.flush();
		//5���շ������ظ�
		String reply = br.readLine();
		System.out.println("�������Ļظ���"+reply);
		//6�ر�
		bw.close();
		br.close();
		socket.close();
	}
	
	public static String getRegistInfo() {
		Scanner input =  new Scanner(System.in);
		System.out.println("���Զ����û�ID��");
		Long id = input.nextLong();
		System.out.println("������������");
		String name =  input.next();
		System.out.println("���������룺");
		String pas = input.next();
		System.out.println("���������䣺");
		int age = input.nextInt();
//		ת�������ݸ�ʽ��
//		���տͻ��˷��͵����� JSON {id : 1001, name: tom, pwd :123, age:20}
		String json = "{id:"+id+",name:"+name+",pwd:"+pas+",age:"+age+"}";
		input.close();
		return json;
	}
	
	public static void login() throws Exception{
		//1����Socket
				Socket socket = new Socket("192.168.0.53",1818);
				//2��ȡ��
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
				//3��ȡ�û���Ϣ
				String json = getLogIn();
				//4�����û���Ϣ��������
				bw.write(json);
				bw.newLine();
				bw.flush();
				//5���շ������ظ�
				String reply = br.readLine();
				System.out.println("�������Ļظ���"+reply);
				//6�ر�
				bw.close();
				br.close();
				socket.close();
	}
	
	public static String getLogIn() {
		Scanner input = new Scanner(System.in);
		System.out.println("������ID��");
		Long id = input.nextLong();
		System.out.println("���������룺");
		String pwd = input.next();
		String info = "{id:"+id+",pwd:"+pwd+"}";
		input.close();
		return info;
	}
}
