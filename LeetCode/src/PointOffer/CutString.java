package PointOffer;

public class CutString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CutMethod1(8));
	}
	
	public static int CutMethod1(int n) {
		if(n<2)
			return 0;
		else if(n==2)
			return 1;
		else if(n==3)
			return 2;
		int max;
		int[] products = new int[n+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		products[3]=3;
		for(int i=4;i<=n;i++) {
			max=0;
			for(int j=1;j<=i/2;j++) {
				int tmp = products[j]*products[i-j];
				if(tmp > max)
					max =tmp;
				products[i] = max;
				
				
			}
		
		}
		
		return products[n];
	}

}
