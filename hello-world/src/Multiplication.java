public class Multiplication{
	public static int[][] Tables(int startAt,int goingTo ){
		int size = goingTo - startAt+1;
		int[][] rst = new int[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				rst[i][j] = (size+i)*(size+j);
			}
		}
		return rst;
	}
	public static void PrintOut(int[][] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] a = Tables(5,8);
		PrintOut(a);
	}
}