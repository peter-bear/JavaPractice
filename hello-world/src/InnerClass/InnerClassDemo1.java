package InnerClass;


class Outer{
	private static String inf = "Hello World";
	private String inf2 = "GoodBye World";
	//��̬�ڲ���
	public static class Inner{
		private static void print() {
			System.out.println("\t��̬��Ա������ "+inf);
			//�޷�ֱ�ӵ��÷Ǿ�̬����
//			System.out.println(inf2);
			Outer out = new Outer();
			System.out.println("\t�Ǿ�̬��Ա������ "+out.inf2);
		}
		public void print2() {
			System.out.println("\t�Ǿ�̬�������þ�̬��Ա������ "+inf);
		}
	}
	//��ͨ�ڲ���
	public  class Inner2{
		public void print() {			
			System.out.println("\t��̬��Ա������ "+inf);
			System.out.println("\t�Ǿ�̬��Ա������ "+inf2);
		}
		//���ܴ�����̬����
	}
	//�ⲿ���ܹ������Ǿ�̬����
	public void print() {
		Inner innerDemo = new Inner();
		System.out.println("��̬�ڲ���ľ�̬������ ");
		Inner.print();
		System.out.println("��̬�ڲ���ķǾ�̬������ ");
		innerDemo.print2();
	}
	//�ⲿ����Դ�����̬����

	
}
public class InnerClassDemo1 {
	public static void main(String[] args) {
		//ʵ������̬�ڲ���
		Outer.Inner StaticInnerDemo =new Outer.Inner();
		//ʵ������ͨ�ڲ���
//		Outer.Inner2 NormalInnerDemo = new Outer.Inner2();
		Outer shell = new Outer();
		shell.print();
		Outer.Inner2 NormalInnerDemo = shell.new Inner2();
		System.out.println("��̬�ڲ���ķǾ�̬������ ");
		StaticInnerDemo.print2();
		System.out.println("��ͨ�ڲ���ķ����� ");
		NormalInnerDemo.print();
	}
}
