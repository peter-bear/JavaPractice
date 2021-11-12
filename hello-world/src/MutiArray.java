//import java.util.Scanner;
public class MutiArray{
	public static void main(String[] args) {
		String[] country = {
				"Canada",
				"China",
				"Germany",
				"Korea",
				"Japan",
				"Russia",
				"United State",
		};
		int[][] counts = {
				{1,0,1},
				{1,1,0},
				{0,0,1},
				{1,0,0},
				{0,1,1},
				{0,1,1},
				{1,1,0},
		};
		String[] index = {
				"Country",
				"Gold",
				"Silver",
				"Bronze",
				"Total",
		};
		for(int j=0; j<index.length;j++) {
			System.out.printf("%15s", index[j]);
		}
		System.out.print("\n");
		for(int i =0 ; i<country.length; i++) {
			int total=0;
			System.out.printf("%15s", country[i]);
			for(int k =0;k<counts[0].length;k++) {
				System.out.printf("%15d", counts[i][k]);
				total+=counts[i][k];
			}
			System.out.printf("%15d", total);
			System.out.print("\n");
		}
	}
}