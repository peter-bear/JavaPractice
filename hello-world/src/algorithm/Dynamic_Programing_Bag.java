package algorithm;

public class Dynamic_Programing_Bag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bagcapa=4;
//		String[] obj = {"G","C","B"};
//		int[] v= {200,300,100};
//		int[] w= {2,4,1};
		
		String[] obj = {"G","S","L"};
		int[] v= {1500,3000,2000};
		int[] w= {1,4,3};
		
		int[][]path =new int[bagcapa][obj.length+1];
		int[][]bag =new int[bagcapa][obj.length+1];
		int[][]capacity=new int[bagcapa][obj.length+1];
		//初始化
//		System.out.println(rst[0].length);
		for(int i=0;i<bag.length;i++) {
			for(int j=0;j<bag[0].length;j++) {
				if(i==0)
					bag[0][j]=0;
				else
					capacity[i][j] = j+1;
			}
		}
		
		for(int i=1;i<bag.length;i++) {
			for(int j=0;j<bag[0].length;j++) {
				if(capacity[i][j]>=w[i-1]) {
					bag[i][j] = v[i-1]+bag[i-1][j];
					path[i][j] = 1;
					if(i<bag.length-1)
						capacity[i+1][j] -= w[i-1];
				}else if(w[i-1]<=j+1) {
//					System.out.println(capacity[i-1][j]);
					if(capacity[i-1][j]<=w[i-1]) {
//						System.out.println(v[i-1]+bag[i-2][j]);
						bag[i][j] = Math.max(v[i-1]+bag[i-2][j], bag[i-1][j]);
					}else {
						bag[i][j] = Math.max(v[i-1], bag[i-1][j]);
					}
					

					if(i<bag.length-1 && bag[i][j] !=bag[i-1][j]) {
//						path[i][j] = 0;
						for(int k=0; k<i;k++)
							path[k][j]=0;
						path[i][j] = 1;
						capacity[i+1][j] -= w[i-1];
					}
						
				}
				
				else {
			

					bag[i][j] = bag[i-1][j];
					if(i<bag.length-1)
						capacity[i+1][j] = capacity[i][j];
					
				}
			}
			
		}
		
		for(int i=0;i<path.length;i++) {
			for(int j=0;j<path[0].length;j++) {
				System.out.printf(capacity[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i=0;i<path.length;i++) {
			for(int j=0;j<path[0].length;j++) {
				System.out.printf(bag[i][j]+"\t");
			}
			System.out.println();
		}
		
		//打印容量

		System.out.printf("When the bag's capacity is %d, it can store Max($ %d)\n",bagcapa, bag[bagcapa-1][obj.length]);
		
		for(int i=0;i<path.length;i++) {
			
			if(path[i][bagcapa-1]==1)
				System.out.printf("Put %s into the bag\n",obj[i-1]);
		}
			

	}
	
	
	
	
	

}
