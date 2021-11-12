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
		//接收客户端发送的请求与数据
				try {
					//1创建ServerSocket
					ServerSocket listener = new ServerSocket(1818);
					
					//2调用accept
					System.out.println("登录服务器已打开。。。。");
					Socket socket = listener.accept();
					
					//3获取输入输出流
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
					
					//4接收客户端发送的数据 JSON {id : 1001, pwd :123}
					String json = br.readLine();
					//去掉前后数据中的大括号
					String[] info = json.substring(1, json.length()-1).split(",");
					String id = info[0].split(":")[1];
					
					//5加载属性文件，需要调用工具类
					Properties properties = Tools.LoadProperties();
					
					//6判断账号是否存在
					if(properties.containsKey(id)) {
						//7判断ID与密码是否匹配
						String pwd = info[1].split(":")[1];
						String value = properties.getProperty(id);
						String pass= value.substring(1,value.length()-1).split(",")[2].split(":")[1];
						if(pwd.equals(pass))
							bw.write("ID 与  Password 正确");
						else 
							bw.write("ID 或 Password不正确");
					}
					else {
						//保存属性文件
						bw.write("用户不存在");
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
