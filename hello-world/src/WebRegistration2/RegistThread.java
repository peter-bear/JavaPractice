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
 * 实现注册功能
 * @author 23881
 *
 */
public class RegistThread extends Thread{

	@Override
	public void run() {
		//接收客户端发送的请求与数据
		try {
			//1创建ServerSocket
			ServerSocket listener = new ServerSocket(10086);
			
			//2调用accept
			System.out.println("服务器已打开。。。。");
			Socket socket = listener.accept();
			
			//3获取输入输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			
			//4接收客户端发送的数据 JSON {id : 1001, name: tom, pwd :123, age:20}
			String json = br.readLine();
			//去掉前后数据中的大括号
			String[] info = json.substring(1, json.length()-1).split(",");
			String id = info[0].split(":")[1];
			
			//5加载属性文件，需要调用工具类
			Properties properties = Tools.LoadProperties();
			
			//判断
			if(properties.containsKey(id)) {
				bw.write("此用户已存在");
			}
			else {
				//保存属性文件
				Tools.SaveProperties(json);
				bw.write("注册成功");
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
