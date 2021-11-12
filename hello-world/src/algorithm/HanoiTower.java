package algorithm;

public class HanoiTower {
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		move(3,'A','B','C');
		System.out.println(count);
	}
	
	public static void move(int num, char a, char b, char c) {
		if(num==1) {
			//ֻ��1���̣���A�ƶ���C
			System.out.println(a+"->"+c);
			count++;
		}
		else {
			//��n-1���̣���A�ƶ���B
			move(num-1, a, c, b);//����ʵ�κ��βεĲ�ͬ�����ǿ��Ըı�ʵ���Դﵽ�任��Ŀ��
			System.out.println(a+"->"+c);
			count++;
			//�ٰ�ʣ�µĴ�B�ƶ���C
			move(num-1,b,a,c);
			
			
		}
	}

}
