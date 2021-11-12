package PointOffer;

public class PrintMatrixCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {
//				{1,2,3,4},
//				{5,6,7,8},
//				{9,10,11,12},
//				{13,14,15,16}
				
				{7,8,9},
				{12,13,14}
				
//				{1,2,3,4,5},
//				{6,7,8,9,10},
//				{11,12,13,14,15},
//				{16,17,18,19,20}
		};
		
		PrintWithCircle(matrix);
	}
	
	public static void PrintWithCircle(int[][] matrix) {
		int Xstart = 0;
		int Xend = matrix[0].length-1;
		int Ystart =0;
		int Yend = matrix.length-1;
		
		while(true) {
			if(Xstart<Xend) {
				for(int i=Xstart;i<=Xend;i++)
					System.out.print(matrix[Ystart][i]+" ");
//				if(Yend - Ystart>1)
					Ystart++;
			}

			if(Ystart<Yend) {
				for(int j=Ystart;j<=Yend;j++)
					System.out.print(matrix[j][Xend]+" ");
//				if(Xend - Xstart>1)
					Xend--;
			}

			
			if(Ystart<Yend) {
				for(int k=Xend;k>=Xstart;k--)
					System.out.print(matrix[Yend][k]+" ");
//				if(Yend - Ystart>1)
					Yend--;
			}

			if(Xstart<Xend) {
				for(int z=Yend;z>=Ystart;z--)
					System.out.print(matrix[z][Xstart]+" ");
//				if(Xend - Xstart>1)
					Xstart++;
			}
			if(Xstart>=Xend && Ystart>=Yend)
				break;
			
			System.out.println("\nTest:"+Xstart+"-"+Xend+"-"+Ystart+"-"+Yend);
		}

			
		
	}

}
