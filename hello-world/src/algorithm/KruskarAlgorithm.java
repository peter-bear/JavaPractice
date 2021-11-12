package algorithm;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Kruskar�㷨
 * 1. ����ÿ���ߵ�List
 * 2. �ѱ���ӽ�List
 * 3. ��List����
 * 4. ��ͷ��β��ȡList�� �жϱߵ����������Ƿ��γɻ�·
 * @author 23881
 *
 */
public class KruskarAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String[] data = {"A","B","C","D"};
//		int[][] weight= {
//				{0,3,3,7},
//				{3,0,2,4},
//				{3,2,0,6},
//				{7,4,6,0}
//		};
		
		String[] data = {"A","B","C","D","E","F","G"};
		int[][] weight= {
				{0,12,0,0,0,16,14},
				{12,0,10,0,0,7,0},
				{0,10,0,3,5,6,0},
				{0,0,3,0,4,0,0},
				{0,0,5,4,0,2,8},
				{16,7,6,0,2,0,9},
				{14,0,0,0,8,9,0}
		};
		
		Kruskar(data, weight);
		

	}
	
	public static void Kruskar(String[] data, int[][] weight) {
		boolean[][] isVisited = new boolean[data.length][data.length];
		LinkedList<Edge<String>> list =  new LinkedList<>();
		LinkedList<Edge<String>> result =  new LinkedList<>();
		for(int i=0;i<weight.length;i++) {
			for(int j=0;j<weight.length;j++) {
				if(isVisited[i][j] == false && weight[i][j] != 0) {
					list.add(new Edge<String>(i, j, weight[i][j]));
					isVisited[i][j] = true;
					isVisited[j][i] = true;
				}
			}
		}
		
		Collections.sort(list);
		for(Edge<String> e:list) 
			System.out.println(e.print(data));
		System.out.println();
		
		int[] ends = new int[data.length];
		for(Edge<String> e:list) {
			if(result.size() == data.length-1)
				break;
			
			
			//��³˹�����㷨����
			int m = GetEnd(ends, e.x);
			int n = GetEnd(ends, e.y);
			//�ж��յ��Ƿ���һ���ģ����Ƿ��γɻ�·
			if(m !=n) {
				ends[m]=n;
				result.add(e);
			}
			
		}
		
		for(Edge<String> e:result) 
			System.out.println(e.print(data));
	

		
		
	}
	
	/**
	 * ��ȡ��Ӧ�±���յ�
	 * @param ends
	 * @param i
	 * @return
	 */
	private static int GetEnd(int[] ends, int i) {
		while(ends[i] !=0)
			i = ends[i];
		return i;
	}
	
	
	
	private static class Edge<E> implements Comparable<Edge<String>>{
		public int x;
		public int y;
		public int weight;
		Edge(int a, int b, int w){
			x = a;
			y = b;
			weight = w;
		}
		
		public String print(E[] data) {
			return data[x]+" "+data[y]+" : "+weight;
		}

		@Override
		public int compareTo(Edge<String> e) {
			// TODO Auto-generated method stub
			return weight -e.weight;
		}
		
	}

}
