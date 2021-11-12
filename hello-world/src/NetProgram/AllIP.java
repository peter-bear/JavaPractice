package NetProgram;


 

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

/*

 * ��ȡ�����������е�ip��Ϣ

 * dos����   arp -a

 * 

 * java�������dos����

 * Process process = Runtime.getRuntime().exec("arp -a")

 * 

 */

public class AllIP {

 

	public static void main(String[] args) {

		// dos����

		String cmd = "arp -a";

		try {

			Process process = Runtime.getRuntime().exec(cmd);

			InputStream is = process.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader br = new BufferedReader(isr);
			
			List<String> list = new ArrayList<>();
			String content = br.readLine();

			while (content != null) {
				if(content.contains("137.112.")) {
					String[] container = content.split(" ");
					for(String ip:container) {
						if(ip.contains("137.112.")) {
							list.add(ip);
						}
					}
				}
//				System.out.println(content);
				content = br.readLine();

			}
			//��������IP��list
//			for(Object ip:list.toArray()) {
//				System.out.println(ip);
//			}
			
			Map<String, String> device = getHostnames(list);
			System.out.println(device);

		} catch (IOException e) {

			e.printStackTrace();

		}
		

	}
	public static Map<String,String> getHostnames(List<String> ips){

        Map<String,String> map = new HashMap<String,String>();
        System.out.println("������ȡhostname...");
        for(String ip : ips){
            String command = "ping -a " + ip;
            Runtime r = Runtime.getRuntime();
            Process p;
            try {
                p = r.exec(command);
                BufferedReader br = new BufferedReader(new InputStreamReader(p
                        .getInputStream()));
                String inline;
                while ((inline = br.readLine()) != null) {
                    if(inline.indexOf("[") > -1){
                        int start = inline.indexOf("Ping ");
                        int end = inline.indexOf("[");
                        String hostname = inline.substring(start+"Ping ".length(),end-1);
                        System.out.println(hostname);
                        map.put(ip,hostname);
                    }
                }
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("��ȡ������");
        return map;
    }

	

 

}
