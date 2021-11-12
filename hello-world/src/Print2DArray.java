public class Print2DArray{
	public static void PrintOut(int[][] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] a = new int[5][5];
		PrintOut(a);
	}
}