package NetProgram;

import java.net.InetAddress;


public class GetIP {
	public static void main(String[] args) throws Exception {
		//获取本地主机地址对象
//		InetAddress IP = InetAddress.getLocalHost();
//		System.out.println(IP.getHostName()+"====>"+IP.getHostAddress());
		
		//根据主机名获取本机地址对象
//		InetAddress IP = InetAddress.getByName("peterbear");
//		System.out.println(IP.getHostName()+"====>"+IP.getHostAddress());
		
		//获取局域网中IP地址对象
//		InetAddress IP = InetAddress.getByName("192.168.0.54");
//		if(IP.isReachable(2000)) {
//			System.out.println(IP.getHostName()+" can be reached: "+IP.isReachable(2000));
//			System.out.println(IP.getHostAddress()+"====>"+IP.getHostName());
//		}
		
		//获取外网IP地址对象
		InetAddress[] IP = InetAddress.getAllByName("www.baidu.com");
		for(InetAddress ip: IP) {
			if(ip.isReachable(2000)) {
				System.out.println(ip.getHostAddress());
			}
		}
//		
//		InetAddress IP = InetAddress.getByName("www.baidu.com");
//		System.out.println(IP.getHostAddress()+"====>"+IP.getHostName());
		
	}
}
