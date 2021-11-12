package PointOffer;

public class SwitchArrayMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6,7,0,1,2,3,4,5};
//		int[] arr= {1,0,1,1,1};
		System.out.println(getMin2(arr));
	}
	
	public static int getMin(int[] arr) {
		int left=0;
		int right = arr.length-1;	
		if(arr[right] < arr[right-1])
			return arr[right];
		
		while(left < right-1) {
			int pivot = (left +right)/2;
			System.out.println(arr[left]+" "+arr[pivot]+" "+arr[right]);
			if(arr[pivot] < arr[pivot-1] && arr[pivot] < arr[pivot+1])
				return arr[pivot];
			if(arr[pivot]<arr[pivot+1])
				right = pivot;
			if(arr[pivot]>arr[pivot+1])
				left = pivot;		
		}
		
		return arr[left];
	}
	
	public static int getMin2(int[] arr) {
		int left=0;
		int right = arr.length-1;	
		if(arr[right] < arr[right-1])
			return arr[right];
		
		while(left < right-1) {
			int pivot = (left +right)/2;
//			System.out.println(arr[left]+" "+arr[pivot]+" "+arr[right]);
			if(arr[left]==arr[pivot] && arr[pivot] == arr[right])
				return MinOrder(arr);
			if(arr[pivot] < arr[pivot-1] && arr[pivot] < arr[pivot+1])
				return arr[pivot];
			if(arr[pivot]<arr[pivot+1])
				right = pivot;
			if(arr[pivot]>arr[pivot+1])
				left = pivot;		
		}
		
		return arr[left];
	}
	
	public static int MinOrder(int[] arr) {
		int small=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[small])
				small =i;
		}
		return arr[small];
	}

}
