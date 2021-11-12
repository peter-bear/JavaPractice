package WebRegistration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Properties;

public class Sever {
	public static void main(String[] args) throws Exception{
		//1����ServerSocket�������˿�
		ServerSocket sever = new ServerSocket(10086);
		System.out.println("��������ʼ����");

		
		//4���÷���������ʱ��
		Long start = Calendar.getInstance().getTimeInMillis();
		Long end =(long) 0;
		
		
		while((end-start)<60000) {
			try {
			end = Calendar.getInstance().getTimeInMillis();
			//2��ѭ���ڲ�����accept�������Ϳ��Ի�ȡÿ�οͻ��˷��͵�����
			Socket path = sever.accept();
			
			//3���������������
			BufferedReader br= new BufferedReader(new InputStreamReader(path.getInputStream(),"utf-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(path.getOutputStream(),"utf-8"));
			//5��ȡ�û��ľ�������JSON����
			String info = br.readLine();
			String json = info.substring(1, info.length());
			
			int choice =0;
			if(info.startsWith("1")) {
				choice =1;
			}
			else if(info.startsWith("2")) {
				choice =2;
			}
			switch (choice) {
			case  1:
				bw.write(LogIn(json));
				bw.close();
				break;
			
			case 2:
				bw.write(Registration(json));
				bw.close();
				break;
				
			default:
				System.out.println("bye");
				bw.close();
				break;
			}
			path.close();
			}
			catch(SocketException e){
				
			}
		}
		System.out.println("ʱ�䵽���������ر�");
		sever.close();
	}
	
	//��¼�ж�
	public static String LogIn(String json) {
		Properties properties = Tools.LoadFile();
		if(properties.containsKey(Tools.GetID(json))) {
			if(Tools.CheckPwd(json)) {
				return "true";
			}
			return "false";
		}
		else {
			return "reg";
		}
		
	}
	
	
	//ע���ж�
	public static String Registration(String json) {
		Properties properties = Tools.LoadFile();
		String id = Tools.GetID(json);
		if(properties.containsKey(id)) {	
			return "exist";
		}
		else {
			Tools.SaveFile(json);
			return "You have registered successfully!!";
		}
		
		
	}
}
