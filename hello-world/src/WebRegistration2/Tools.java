package WebRegistration2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Tools {
	//1加载属性文件
	public static Properties LoadProperties() {
		//1创建属性集合
		Properties properties = new Properties();
		
		//2判断文件是否存在
		File file = new File("User.properties");
		if(file.exists()) {
			FileInputStream input=null;
			try {
				input = new FileInputStream(file);
				properties.load(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				//如果文件存在就加载，如果文件不存在就为空
				if(input!=null) {
					try {
						input.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}
		return properties;
	}
	
	//2保存属性文件
	public static void SaveProperties(String json){
		String[] info = json.substring(1, json.length()-1).split(",");
		String id = info[0].split(":")[1];
		//开始保存
		FileOutputStream out=null;
		try {
			 out = new FileOutputStream("User.properties",true);
			 Properties properties = new Properties();
			 properties.setProperty(id, json);
			 properties.store(out, "Comment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
