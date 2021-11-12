import java.util.Scanner;
public class TiTaTu{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int [][] array = new int[3][3];
		int [][] array = {
				{0,1,0,1},
				{1,0,0,1},
				{1,1,1,1},
				{0,1,0,1},
		};
		boolean rst_X = false;
		boolean rst_O = false;
		int numOfX_S = 0;
		int numOfO_S = 0;
		int numOfX_RS = 0;
		int numOfO_RS = 0;
		int k = array.length -1;
		//read
		/*
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				array[i][j] = in.nextInt();
			}
		}
		*/
		//check
		for(int n=0;n<array.length;n++) {
			int numOfX_H =0;
			int numOfO_H =0;
			for(int m=0;m<array[n].length;m++) {
				if(array[n][m] == 1) {
					numOfX_H++;
					if(numOfX_H == array.length ) {
						rst_X = true;
					}
				}
				else if(array[n][m] == 0){
					numOfO_H++;
					if(numOfO_H == array.length){
						rst_O = true;
					}
				}
			    
			}
			if(array[n][n] == 1) {
				numOfX_S++;
				if(numOfX_S == array.length ) {
					rst_X = true;
				}
			}
			else if(array[n][n] == 0) {
				numOfO_S++;
				if(numOfO_S == array.length ) {
					rst_O = true;
				}
			}
			//reverse diagonal line
			
				if(array[n][k] == 1) {
					numOfX_RS++;
					if(numOfX_RS == array.length ) {
						rst_X = true;
					}
				}
				else if(array[n][k] == 0) {
					numOfO_RS++;
					if(numOfO_RS == array.length ) {
						rst_O = true;
					}
				}
				k--;
			}
		
		
		
		
	 
		if(rst_X == true) {
			System.out.print("X win");
		}
		else if(rst_O == true) {
			System.out.print("O win");
		}
		else {
			System.out.print("Equal");
		}
	}
}