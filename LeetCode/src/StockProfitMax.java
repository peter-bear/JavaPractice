import java.util.Arrays;

public class StockProfitMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = {3,3,0,5,3,1,4};
		System.out.println(MaxProfit(price,2));
	}
	
	public static int MaxProfit(int[] price, int times) {
		int[][] profits = new int[times+1][price.length];
		
		for(int i=1;i<profits.length;i++) {
			int tempProfit = -price[0]+profits[i-1][0];
			for(int j=1;j<profits[0].length;j++) {
				if(profits[i-1][j-1]-price[j-1] > tempProfit) {
					tempProfit = profits[i-1][j-1]-price[j-1];
				}
				profits[i][j] = Math.max(profits[i][j-1], price[j]+tempProfit);
			}
		}
		
		return profits[profits.length-1][profits[0].length-1];
	}

}
