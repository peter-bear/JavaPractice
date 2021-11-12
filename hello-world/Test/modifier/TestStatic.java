package modifier;

public class TestStatic {
	public static void main(String[] args) {
		StaticStudy num = new StaticStudy();
		num.show();//初始值
		num.add();
		StaticStudy.add2();
		num.show();//add后的值
		System.out.println("类名调用静态属性: "+StaticStudy.cnt2);//类名调用静态属性
		System.out.println("----实例化第二个对象"+"----");
		StaticStudy num2 = new StaticStudy();
		num2.add();
		StaticStudy.add2();
		num2.show();

	}
}
