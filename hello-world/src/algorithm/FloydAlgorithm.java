package algorithm;

import java.util.Arrays;

public class FloydAlgorithm {
	public static void main(String[] args) {
		int N=255;
		String[] data = {"A","B","C","D","E","F","G"};
		int[][] matrix = {
				{0,5,7,N,N,N,2},
				{5,0,N,9,N,N,3},
				{7,N,0,N,8,N,N},
				{N,9,N,0,N,4,N},
				{N,N,8,N,0,5,4},
				{N,N,N,4,5,0,6},
				{2,3,N,N,4,6,0}
		};
		Floyd(data, matrix);
		
	}
	
	public static <E> void Floyd(E[] d, int[][] m ) {
		Graph<E> graph = new Graph<>(d, m);
//		graph.showGraph();
		graph.start();
		graph.showGraph();
	}
	
	private static class Graph<E>{
		private E[] data;
		private int[][] rst ;
		private int[][] matrix;
		Graph(E[] d, int[][] m){
			
			data = d;
			matrix  = new int[data.length][data.length];
			rst = new int[data.length][data.length];
			for(int i=0;i<data.length;i++) {
				for(int j=0;j<data.length;j++) {
					rst[i][j] = i;
					matrix[i][j] = m[i][j];
				}
			}
		}
		
		public void showGraph() {
			for(int[] m:matrix)
				System.out.println(Arrays.toString(m));
			System.out.println();
			for(int[] m:rst)
				System.out.println(Arrays.toString(m));
			System.out.println();
		}
		
		public void start() {
			int len=0;
			//对中间顶点遍历，k是中间顶点的下标
			for(int k=0;k<data.length;k++) {
				//从i顶点出发
				for(int i=0;i<data.length;i++) {
					for(int j=0;j<data.length;j++) {
						len = matrix[i][k] + matrix[k][j]; //从i出发，经过k，到达j的距离
						if(len < matrix[i][j]) {
							matrix[i][j] = len; 
							rst[i][j] = rst[k][j]; //Update前驱节点
						}
							
					}
				}
			}
		}
		
		
	}
}
