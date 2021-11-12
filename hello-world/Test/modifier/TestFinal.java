package modifier;

import java.util.Arrays;

public class TestFinal {
	public static void main(String[] args) {
//		FinalStudy point = new FinalStudy();
//		point.SetPoint(1, 2);
//		point.Print();
		final int[] nums = new int[] {1,3,5,7};
		System.out.println(Arrays.toString(nums));
//		nums = new int[] {5,6,7};//此时不能对nums再进行赋值，因为已经nums已经变成了常量
		nums[0] = 9; //但是nums内部的数据可以进行更改，因为nums是引用类型
		System.out.println(Arrays.toString(nums));
		
		final Point p1 = new Point();
		p1.SetPoint(6, 6);
		p1.Print();
		p1.SetPoint(10, 10);
		p1.Print();
	}
}
