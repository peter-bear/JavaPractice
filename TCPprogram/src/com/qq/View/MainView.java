package com.qq.View;

import com.qq.Service.UserClientService;
import com.qq.Util.StringUtil;

public class MainView {
	public static void main(String[] args) {
		boolean loop = true;
		boolean change = false;
		String key;
		UserClientService UserClientService = new UserClientService();
		while(loop) {
			System.out.println("============��ӭ��¼����ͨ��ϵͳ============");
			System.out.println("\t\t 1 ��¼ϵͳ");
			System.out.println("\t\t 9 �˳�ϵͳ");
			key = StringUtil.readNum(1); //��ȡ�û�����
			
			switch (key) {
			case "1":
				loop = LoginView.showView(UserClientService);
				if(loop == false)
					change = true;
				break;

			case "9":
				loop = false;
				break;
			}
		}
		
		if(change) {
			UserClientService.LogOut();
		}
			
		System.out.println("�˳�ϵͳ");
		System.exit(0);
	}
}
