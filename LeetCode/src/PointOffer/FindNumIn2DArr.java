package PointOffer;

public class FindNumIn2DArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		System.out.println(FindNum(arr,-1));
		
	}
	
	public static boolean FindNum(int[][] arr, int num) {
		int row=arr.length;
		int column = arr[0].length;
		if(arr[row-1][column-1] <num)
			return false;
		else if(arr[row-1][column-1] ==num)
			return true;
		if(arr[0][0] >num)
			return false;
		else if(arr[0][0] ==num)
			return true;
		
		
		for(int i=0;i<row;i++) {
			for(int j=column-1;j>=0;j--) {
				if(arr[i][j]<num)
					row++;
				if(arr[i][j]>num)
					column--;
				if(arr[i][j]==num)
					return true;
			}
		}
		return false;
	}

}
