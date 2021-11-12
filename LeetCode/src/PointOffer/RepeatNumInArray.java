package PointOffer;

public class RepeatNumInArray {
	public static void main(String[] args) {
		int[] arr = {2,3,1,0,2,5,3};
//		int[] arr= {2,3,5,4,3,2,6,7};
//		System.out.println(hashMethod(arr));
		System.out.println(SortArrMethod(arr));
	}
	
	public static int hashMethod(int arr[]) {
		int[] tempArr = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			tempArr[arr[i]] +=1;
		}
		for(int j=0;j<tempArr.length;j++) {
			if(tempArr[j] >= 2)
				return j;
		}
		return -1;
	}
	
	public static int SortArrMethod(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int tmp =i;
			int tmp2;
			while(arr[tmp]!=tmp) {
				tmp2 = arr[arr[tmp]];
				if(tmp2 == arr[tmp])
					return tmp2;
				arr[arr[tmp]] = arr[tmp];
				tmp = tmp2;
			}
		}
		return -1;
	}

}
