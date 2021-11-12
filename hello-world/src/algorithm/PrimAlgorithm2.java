package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class PrimAlgorithm2 {

    private static int INF=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data = {'A','B','C','D','E','F','G'};
		int [][] map= {
				{0,5,7,INF,INF,INF,2},
				{5,0,INF,9,INF,INF,3},
				{7,INF,0,INF,8,INF,INF},
				{INF,9,INF,0,INF,4,INF},
				{INF,INF,8,INF,0,5,4},
				{INF,INF,INF,4,5,0,6},
				{2,3,INF,INF,4,6,0}
		};
		System.out.println("Start");
		Prim(1, map, data);
	}
	

	public static void Prim(int start, int[][] map, char[] data) {
		HashMap<String, Integer> paths = new HashMap<>();
		int num = data.length;
		
		
		//��Ŷ���
		int[] pre =new int[num];
		
		int[] weights = new int[num]; //Ȩ�� 
		for(int i=0;i<weights.length;i++) {
			weights[i] = map[start][i]; //Ĭ��Ȩ����start��Ϊ��׼
			if(weights[i] !=INF)
				pre[i] =start; 
		}
		
		weights[start] =0; //����Ȩ��Ϊ0 
		
		pre[start] =-1;
		
		for(int i=0;i< num;i++) {
			if(i == start)
				continue;
			//����2 ���±꣬������¼��̱ߵĶ���
			int j=0;
			int k=0;
			
			
			int min = INF;
			while(j < num) {
				//Ȩ����С�Ҳ�Ϊ0
				
				if(weights[j]!=0 &&weights[j] < min) {
					min = weights[j];
					k = j; //��ֵ
				}
				j++;
			}
			
			
			weights[k] =0;
			
			//����Ȩ��
			for(int n=0;n<num;n++) {
				if(weights[n]!=0 && map[k][n] < weights[n]) {
					pre[n] = k;
					weights[n] = map[k][n];
				}
			}
			
			
		}
		
		for(int i=0;i<num;i++) {
			if(pre[i] !=-1) {
				paths.put(data[pre[i]]+"-"+data[i], map[pre[i]][i]);
			}
		}

		int count =0;
		for(Entry<String, Integer> p:paths.entrySet()) {
			count += p.getValue();
			System.out.println(p.getKey()+" : "+p.getValue());
		}
		
		
		System.out.println("Least : "+count);
		
//		System.out.println(Arrays.toString(pre));
	}
	
	

    

    
}
	
