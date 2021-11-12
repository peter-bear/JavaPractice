package com.qq.View;

import com.qq.Service.UserClientService;
import com.qq.Util.StringUtil;

public class LoginView {
	
	public static boolean showView(UserClientService UserClientService) {
		System.out.printf("«Î ‰»Î”√ªß∫≈£∫");
		String userID = StringUtil.get();
		System.out.printf("«Î ‰»Î√‹  ¬Î£∫");
		String passWord = StringUtil.get();
		
		boolean connect = UserClientService.checkUser(userID, passWord);
		
		if(connect) {
			return SecondMainView.showView(userID);
		}else {
			System.out.println("\n\t============µ«¬º ß∞‹============\n");
			return true;
		}
		
	}

}
