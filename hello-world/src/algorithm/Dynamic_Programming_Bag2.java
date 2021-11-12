package algorithm;

public class Dynamic_Programming_Bag2 {
	public static void main(String[] args) {
//		int[] w= {1,4,3};//物品重量
//		int[] v= {1500, 3000, 2000};//物品价值
		String[] obj = {"Guitar","Computer","Book"};
		int[] v= {200,300,100};
		int[] w= {2,4,1};
		int m =4;//背包的容量
		int n = w.length;//物品的个数
		
		//背包
		int[][] bag =new int[n+1][m+1];
		
		
		//存储数组
		int[][] path=new int[n+1][m+1];
		
		for(int i=0;i<bag.length;i++)
			bag[i][0]=0;//第一列设置为0
		for(int i=0;i<bag[0].length;i++)
			bag[0][i]=0;//第一行设置为0
		
		for(int i=1;i<bag.length;i++) {
			for(int j=1;j<bag[0].length;j++) {
				if(w[i-1]>j) {
					//容量不满足，直接继承上面一个
					bag[i][j] = bag[i-1][j];
				}else {
					//容量满足，和上面一个对比，选取最佳的value
					//装入i-1个商品，到剩余空间j-w[i]的最大值
//					bag[i][j] = Math.max(bag[i-1][j], v[i-1]+bag[i-1][j-w[i-1]]);
					if(bag[i-1][j]<v[i-1]+bag[i-1][j-w[i-1]]) {
						bag[i][j] = v[i-1]+bag[i-1][j-w[i-1]];
						//把当前情况记录到path
						path[i][j]=1;
					}else {
						bag[i][j] = bag[i-1][j];
					}
					
				}
			}
		}
		
		
		//i表示行
		//j表示列
		for(int i=0;i<bag.length;i++) {
			for(int j=0;j<bag[0].length;j++) {
				System.out.printf(bag[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0 && j>0) {
			if(path[i][j]==1) {
				System.out.printf("把%s放入背包\n",obj[i-1]);
				j -= w[i-1];
			}
			i--;
		}
		
	}
}
