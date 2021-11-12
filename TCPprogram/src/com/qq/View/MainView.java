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
			System.out.println("============欢迎登录网络通信系统============");
			System.out.println("\t\t 1 登录系统");
			System.out.println("\t\t 9 退出系统");
			key = StringUtil.readNum(1); //获取用户输入
			
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
			
		System.out.println("退出系统");
		System.exit(0);
	}
}
