package Sorting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSortingTime {
	public static void main(String[] args) {
		int[] array = new int[80000];
		
		Init(array);
		System.out.println("BubbleSorting");
		PrintTime("Start: ");
		BubbleSorting(array);
		PrintTime("End: ");
		System.out.println();

		Init(array);
		System.out.println("SelectionSorting");
		PrintTime("Start: ");
		SelectionSorting(array);
		PrintTime("End: ");

		System.out.println();
		Init(array);
		System.out.println("InsertSorting");
		PrintTime("Start: ");
		InsertSorting(array);
		PrintTime("End: ");
		
		System.out.println();
		Init(array);
		System.out.println("ShellSorting");
		PrintTime("Start: ");
		ShellSorting(array);
		PrintTime("End: ");
		
		
		System.out.println();
		Init(array);
		System.out.println("QuickSorting");
		PrintTime("Start: ");
		QuickSort(array, 0, array.length-1);
		PrintTime("End: ");
		
		System.out.println();
		Init(array);
		System.out.println("QuickSorting2");
		PrintTime("Start: ");
		QuickSort2(array, 0, array.length-1);
		PrintTime("End: ");
		
		System.out.println();
		Init(array);
		System.out.println("MergeSorting");
		PrintTime("Start: ");
		MergeSort(array);
		PrintTime("End: ");
		
		System.out.println();
		Init(array);
		System.out.println("RadixSorting");
		PrintTime("Start: ");
		RadixSort(array);
		PrintTime("End: ");
		
		System.out.println();
		Init(array);
		System.out.println("HeapSorting");
		PrintTime("Start: ");
		HeapSort(array);
		PrintTime("End: ");
	}

	public static void Init(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 80000);
		}
	}

	public static void PrintTime(String words) {
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(date1);
		System.out.println(words + time);
	}

	public static void BubbleSorting(int[] array) {
		int tmp = 0;
		boolean flag = false; // flag�ж��Ƿ���������򽻻�
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = false; // �����ж���һ����û�н��������û�У���ʾ����������
			}
		}
	}

	public static void SelectionSorting(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int smallest = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[smallest]) {
					smallest = j;
				}
			}
			if (i != smallest) {
				int temp = array[i];
				array[i] = array[smallest];
				array[smallest] = temp;
			}
		}

	}

	public static void InsertSorting(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}else {
					break;
				}
			}
		}
	}
	
	//ϣ������
	public static void ShellSorting(int[] array) {
		int length = array.length;
		int temp;
		for(int step = length/2;step >0; step /=2) {
			for(int i=step;i<length;i++) {
				temp = array[i];
				int j =i;
				if(array[j] < array[j-step]) {
					while(j>=step && temp<array[j-step]) {
						array[j] = array[j - step];
						j-=step;
					}
				}
				if (j != i) {
	                array[j] = temp;
	            }
//				for(int j=i;j>=step;j-=step) {
//					if(array[j]<array[j-step]) {
//						temp = array[j];
//						array[j] = array[j-step];
//						array[j-step] = temp;
//					}
//					else
//						break;
//				}
			}
		}
	}
	
	public static void QuickSort(int[] array, int left, int right) {
		int l =left;
		int r =right;
		int temp;
		int pivot = array[(left+right)/2];
		while(l<r) {
			//���������
			while(array[l]<pivot) {
				l+=1;
			}
			//�ұ�������
			while(array[r]>pivot) {
				r -=1;
			}
			if(l>=r) {
				break;
			}
			
			temp =array[l];
			array[l]=array[r];
			array[r] = temp;
			
			//����������Ĳ�������Ῠ��
			//��������array[l] == pivot��ֵ r--;ǰ��
			if(array[l] == pivot) {
				r -=1;
			}
			
			//��������array[r] == pivot��ֵ l++;ǰ��
			if(array[r] == pivot) {
				l +=1;
			}
			
		}
		
		if(left<r) {
			QuickSort(array, left, r-1);
		}
		if(right>l) {
			QuickSort(array, l+1, right);
		}
	}
	
	public static void QuickSort2(int[] array, int left, int right) {
		int l = left;
		int r = right;
		int pivot = array[left];
		while(true) {
			while(array[r] >= pivot&&l<r) {
				r-=1;
			}
			if(l<r) {
				array[l] =array[r];
				l+=1;
			}
			while(array[l] <= pivot&&l<r) {
				l +=1;
			}
			if(l<r) {
				array[r] = array[l];
				r -=1;
			}
			if(l==r) {
				array[l] = pivot;
				break;
			}
		}
		
		if(left<r) {
			QuickSort2(array, left, r-1);
		}
		
		if(right > l) {
			QuickSort2(array, l+1, right);
		}
	}
	
	//�鲢����
	public static void MergeSort(int[] arr) {
		int[] arr2 = Divide(arr);
		for(int i=0;i<arr2.length;i++) {
			arr[i]=arr2[i];
		}
	}
	
	public static int[] Divide(int[] arr) {
		int pivot = (arr.length)/2;
		if(pivot>=1) {
			int[] left = new int[pivot];
			int[] right = new int[arr.length-pivot];
			for(int i=0;i<left.length;i++) {
				left[i] = arr[i];
			}
			for(int j=0;j<right.length;j++) {
				right[j]=arr[pivot+j];
			}
			
			left = Divide(left);
			right = Divide(right);
		
			return Conquer(left, right);
		}
		return arr;
	
	}
	
	
	public static int[] Conquer(int[] arr1, int[] arr2) {
		int[] temp = new int[arr1.length+arr2.length];
		int cur =0;
		int left =0;
		int right =0;
		while(true) {
			if(arr1[left]<arr2[right]) {
				temp[cur] = arr1[left];
				cur++;
				left++;
			}
			else if(arr1[left] > arr2[right]) {
				temp[cur] = arr2[right];
				cur++;
				right++;
			}
			else {
				temp[cur] =arr1[left];
				cur++;
				left++;
				temp[cur] = arr2[right];
				cur++;
				right++;
			}
			if(left>=arr1.length) {
				for(int i=right;i<arr2.length;i++) {
					temp[cur] = arr2[i];
					cur++;
				}
				break;
			}
			else if(right>=arr2.length){
				for(int i=left;i<arr1.length;i++) {
					temp[cur] = arr1[i];
					cur++;
				}
				break;
			}
		}
		
		return temp;
	}
	
	//Ͱ����
	public static void RadixSort(int[] array) {
		//�ҳ�����һλ
		int Max =0;
		for(int i=0;i<array.length;i++) {
			if(array[Max] <array[i]) {
				Max =i;
			}
		}
		
		//�ó����һλ�ĸ���
		int count=0;
		int temp =array[Max];
		while(temp>0) {
			temp /= 10;
			count++;
		}
		for(int j=0;j<count;j++) {
			busket(array, pow(10,j));
		}
		
		
	}
	
	//����һ�����ļ��η�
	public static int pow(int num, int exp) {
		if(exp==0) {
			return 1;
		}
		for(int i=0;i<exp-1;i++) {
			num *= num;
		}
		return num;
	}
	
	public static void busket(int[] array, int digit) {
		//����һ��Ͱ������¼����
		int[][] bucket = new int[10][array.length];
		
		//����һ����������¼ÿ��Ͱ����Ԫ�صĸ���
		int[] itemNum = new int[10];
		
		for(int i=0;i<array.length;i++) { 
		
			int no = array[i]/digit%10; //��һ��Ͱ
			bucket[no][itemNum[no]] = array[i] +10;
			itemNum[no] +=1;
		}
		
		int index=0;
		for(int j=0;j<10;j++) {
			for(int k=0;k<bucket.length;k++) {
				if(bucket[j][k] !=0) {
					array[index] = bucket[j][k] -10;
					bucket[j][k] =0;
					index++;
				}
				else {
					break;
				}
			}
			itemNum[j] =0;
		}
		index =0;
		
		
	}
	
	
	//������
	public static void HeapSort(int[] arr) {
		int temp;
		for(int i=arr.length/2-1;i>-1;i--) {
			heap(arr, i, arr.length);
		}
		for(int j=arr.length-1; j>0; j-- ) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			heap(arr, 0, j);
		}
	}
	
	
	public static void heap(int[] arr, int index, int len) {
		int temp = arr[index];

		for(int k=2*index+1; k <len; k = k *2+ 1) {
			if(k+1 < len &&arr[k] < arr[k+1]) {
				k++;
			}
			if(arr[k] > temp) {
				arr[index] = arr[k];
				index =k;
			}else {
				break;
			}
		}
		
		arr[index] =temp;
		
		

	}
}
