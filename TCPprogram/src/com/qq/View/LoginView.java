package com.qq.View;

import com.qq.Service.UserClientService;
import com.qq.Util.StringUtil;

public class LoginView {
	
	public static boolean showView(UserClientService UserClientService) {
		System.out.printf("�������û��ţ�");
		String userID = StringUtil.get();
		System.out.printf("��������  �룺");
		String passWord = StringUtil.get();
		
		boolean connect = UserClientService.checkUser(userID, passWord);
		
		if(connect) {
			return SecondMainView.showView(userID);
		}else {
			System.out.println("\n\t============��¼ʧ��============\n");
			return true;
		}
		
	}

}
