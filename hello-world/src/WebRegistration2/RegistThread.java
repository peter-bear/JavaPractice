package WebRegistration2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * ʵ��ע�Ṧ��
 * @author 23881
 *
 */
public class RegistThread extends Thread{

	@Override
	public void run() {
		//���տͻ��˷��͵�����������
		try {
			//1����ServerSocket
			ServerSocket listener = new ServerSocket(10086);
			
			//2����accept
			System.out.println("�������Ѵ򿪡�������");
			Socket socket = listener.accept();
			
			//3��ȡ���������
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			
			//4���տͻ��˷��͵����� JSON {id : 1001, name: tom, pwd :123, age:20}
			String json = br.readLine();
			//ȥ��ǰ�������еĴ�����
			String[] info = json.substring(1, json.length()-1).split(",");
			String id = info[0].split(":")[1];
			
			//5���������ļ�����Ҫ���ù�����
			Properties properties = Tools.LoadProperties();
			
			//�ж�
			if(properties.containsKey(id)) {
				bw.write("���û��Ѵ���");
			}
			else {
				//���������ļ�
				Tools.SaveProperties(json);
				bw.write("ע��ɹ�");
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
