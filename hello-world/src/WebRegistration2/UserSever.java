package WebRegistration2;

public class UserSever {
	public static void main(String[] args) {
		//д�����̣߳�һ������ע�ᣬһ��������¼
		RegistThread reg = new RegistThread();
		LoginThread log = new LoginThread();
		reg.start();
		log.start();
	} 
}
