package modifier;

import java.util.Arrays;

public class TestFinal {
	public static void main(String[] args) {
//		FinalStudy point = new FinalStudy();
//		point.SetPoint(1, 2);
//		point.Print();
		final int[] nums = new int[] {1,3,5,7};
		System.out.println(Arrays.toString(nums));
//		nums = new int[] {5,6,7};//��ʱ���ܶ�nums�ٽ��и�ֵ����Ϊ�Ѿ�nums�Ѿ�����˳���
		nums[0] = 9; //����nums�ڲ������ݿ��Խ��и��ģ���Ϊnums����������
		System.out.println(Arrays.toString(nums));
		
		final Point p1 = new Point();
		p1.SetPoint(6, 6);
		p1.Print();
		p1.SetPoint(10, 10);
		p1.Print();
	}
}
