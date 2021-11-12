package WebRegistration;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {
	public static Properties LoadFile() {
		//1����properties����
		Properties properties = new Properties();
		String Source ="E:\\java����\\hello-world\\src\\WebRegistration\\inf.bin";
		//2�ж��ļ��Ƿ����
		File file = new File(Source);
		if(file.exists()) {
			//����������ȡ����
			FileInputStream input = null;
			try {
				input = new FileInputStream(file);
				properties.load(input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
	
	public static void SaveFile(String json) {
		//1����properties����
		Properties properties =  new Properties();
		//2�����û����������
		String[] info = json.substring(1, json.length()-1).split(",");
		String id = info[0].split(":")[1];
		String Source ="E:\\java����\\hello-world\\src\\WebRegistration\\inf.bin";
		//3�����������ļ�
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(Source,true);
			properties.setProperty(id, json);
			properties.store(file, "comment");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			if(file!=null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static String GetID(String json) {
		return json.substring(1, json.length()-1).split(",")[0].split(":")[1];
	}
	
	public static Boolean CheckPwd(String json) {
		String id = GetID(json);
		String[] info = json.substring(1, json.length()-1).split(",");
		String pwd = info[1].split(":")[1];
		String value = LoadFile().getProperty(id);
		String pass= value.substring(1,value.length()-1).split(",")[2].split(":")[1];
		return pwd.equals(pass);
	}
}
