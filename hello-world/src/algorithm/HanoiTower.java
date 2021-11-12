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
			//只有1个盘，从A移动到C
			System.out.println(a+"->"+c);
			count++;
		}
		else {
			//把n-1个盘，从A移动到B
			move(num-1, a, c, b);//由于实参和形参的不同，我们可以改变实参以达到变换的目的
			System.out.println(a+"->"+c);
			count++;
			//再把剩下的从B移动到C
			move(num-1,b,a,c);
			
			
		}
	}

}
