package modifier;

public class TestStatic {
	public static void main(String[] args) {
		StaticStudy num = new StaticStudy();
		num.show();//��ʼֵ
		num.add();
		StaticStudy.add2();
		num.show();//add���ֵ
		System.out.println("�������þ�̬����: "+StaticStudy.cnt2);//�������þ�̬����
		System.out.println("----ʵ�����ڶ�������"+"----");
		StaticStudy num2 = new StaticStudy();
		num2.add();
		StaticStudy.add2();
		num2.show();

	}
}
