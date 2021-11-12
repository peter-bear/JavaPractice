package WebRegistration2;

public class UserSever {
	public static void main(String[] args) {
		//写两个线程，一个用来注册，一个用来登录
		RegistThread reg = new RegistThread();
		LoginThread log = new LoginThread();
		reg.start();
		log.start();
	} 
}
