package WebRegistration2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class LoginThread extends Thread{

	@Override
	public void run() {
		//���տͻ��˷��͵�����������
				try {
					//1����ServerSocket
					ServerSocket listener = new ServerSocket(1818);
					
					//2����accept
					System.out.println("��¼�������Ѵ򿪡�������");
					Socket socket = listener.accept();
					
					//3��ȡ���������
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
					
					//4���տͻ��˷��͵����� JSON {id : 1001, pwd :123}
					String json = br.readLine();
					//ȥ��ǰ�������еĴ�����
					String[] info = json.substring(1, json.length()-1).split(",");
					String id = info[0].split(":")[1];
					
					//5���������ļ�����Ҫ���ù�����
					Properties properties = Tools.LoadProperties();
					
					//6�ж��˺��Ƿ����
					if(properties.containsKey(id)) {
						//7�ж�ID�������Ƿ�ƥ��
						String pwd = info[1].split(":")[1];
						String value = properties.getProperty(id);
						String pass= value.substring(1,value.length()-1).split(",")[2].split(":")[1];
						if(pwd.equals(pass))
							bw.write("ID ��  Password ��ȷ");
						else 
							bw.write("ID �� Password����ȷ");
					}
					else {
						//���������ļ�
						bw.write("�û�������");
					}
					bw.newLine();
					bw.flush();
					bw.close();
					br.close();
					socket.close();
					listener.close();
					
							
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
	
}
