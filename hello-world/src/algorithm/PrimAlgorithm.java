package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class PrimAlgorithm {
	public static void main(String[] args) {
		char[] data = {'A','B','C','D','E','F','G'};
		//邻接矩阵的关系用二维数组来表示
		int [][] weight= {
				{0,5,7,0,0,0,2},
				{5,0,0,9,0,0,3},
				{7,0,0,0,8,0,0},
				{0,9,0,0,0,4,0},
				{0,0,8,0,0,5,4},
				{0,0,0,4,5,0,6},
				{2,3,0,0,4,6,0}
		};
		MinTree tree = new MinTree();
		tree.createGraph(new Graph(data, weight));
		tree.showGraph();
		
		tree.Prim(0);
		
	
	}
	
	
	private static class MinTree{
		private Graph graph;
		//创建图的邻接矩阵
		public void createGraph(Graph g) {
			graph = g;
		}
		
		//打印图
		public void showGraph() {
			for(int[] w:graph.weight)
				System.out.println(Arrays.toString(w));
		}
		
		//编写Prim算法，得到最小生成树
		/**
		 * 
		 * @param v 从图的第几个顶点开始找
		 */
		public void Prim(int v) {
			boolean[] isVisited = new boolean[graph.vertex]; //表示是否访问过
			isVisited[v] = true; //默认设置从第v个顶点开始
			/**用 h1和h2 记录2个顶点的下标*/
			int h1=-1;
			int h2=-1;
			int max=getMax();
			int count=0;
			HashMap<String, Integer> result = new HashMap<>(); 
	
			for(int k=1;k<graph.vertex;k++) { //根据算法，最后边个数应该为vertex-1个
				int minWeight = max;
				
				//双重循环
				for(int i=0;i<graph.vertex;i++) {
					for(int j=0;j<graph.vertex;j++) {
						//确定子图中哪2个节点最近，这2个顶点其中一个被访问过，另一个没有
						if(isVisited[i]==true && isVisited[j]==false && graph.weight[i][j] < minWeight && graph.weight[i][j] != 0) {
							minWeight = graph.weight[i][j];
							h1=i;
							h2=j;
						}
					}
				}
				
				isVisited[h2] = true; //设置成访问，之后会从这一行开始访问
				result.put(graph.data[h1]+"-"+graph.data[h2], graph.weight[h1][h2]);
				count += graph.weight[h1][h2];
			}
			
			System.out.println();
			for(Entry<String, Integer> rst:result.entrySet())
				System.out.println(rst.getKey()+" : "+rst.getValue());
			System.out.println("Min Path: "+count);
			
		}
		
		private int getMax() {
			int max=graph.weight[0][0];
			for(int i=0;i<graph.vertex;i++) {
				for(int j=0;j<graph.vertex;j++) {
					if(graph.weight[i][j]>max)
						max = graph.weight[i][j];
				}
			}
			return max;
				
		}
		
		
	}
	
	private static class Graph{
		public int vertex;
		public char[] data;
		int[][] weight;
		Graph(char[] d, int[][] w){
			vertex = d.length;
			data = d;
			weight = w;
		}
		
		
	}
}
