package DataStructure;

public class EightGueenDemo {
	//定义一个max表示一共有多少个皇后
	int max =8;
	//定义一个一维数组，数组下标表示第几行，下标对应的数表示第几列
	int[] array =new int[max];
	int count=0;
	public static void main(String[] args) {
		EightGueenDemo queen = new EightGueenDemo();
		queen.check(0);
		System.out.printf("一共有%d种可能",queen.count);

	}
	
	//打印数组
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	//判断是否安全(冲突)
	//n表示第n个皇后
	public boolean safe(int n) {
		for(int i=0;i<n;i++) {
			//表示在同一列或同一斜线
			if(array[i] ==array[n] || Math.abs(n-i)==Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//编写方法，放置第n个皇后
	public void check(int n) {
		if(n==max) {
			print();
			count++;
			return;
		}
		//一共要放8个皇后，8个循环递归，
		for(int i=0;i<max;i++) {
			//先把该皇后放在第n行第i列
			array[n] =i;
			//是否冲突
			if(safe(n)) {
				//如果不冲突，接着放第n+1个皇后，递归
				check(n+1);
			}
			//如果冲突，i++,将皇后在第n行向后移动一位，直到不冲突
		}
	}

}
