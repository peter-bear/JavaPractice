package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class PrimAlgorithm {
	public static void main(String[] args) {
		char[] data = {'A','B','C','D','E','F','G'};
		//�ڽӾ���Ĺ�ϵ�ö�ά��������ʾ
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
		//����ͼ���ڽӾ���
		public void createGraph(Graph g) {
			graph = g;
		}
		
		//��ӡͼ
		public void showGraph() {
			for(int[] w:graph.weight)
				System.out.println(Arrays.toString(w));
		}
		
		//��дPrim�㷨���õ���С������
		/**
		 * 
		 * @param v ��ͼ�ĵڼ������㿪ʼ��
		 */
		public void Prim(int v) {
			boolean[] isVisited = new boolean[graph.vertex]; //��ʾ�Ƿ���ʹ�
			isVisited[v] = true; //Ĭ�����ôӵ�v�����㿪ʼ
			/**�� h1��h2 ��¼2��������±�*/
			int h1=-1;
			int h2=-1;
			int max=getMax();
			int count=0;
			HashMap<String, Integer> result = new HashMap<>(); 
	
			for(int k=1;k<graph.vertex;k++) { //�����㷨�����߸���Ӧ��Ϊvertex-1��
				int minWeight = max;
				
				//˫��ѭ��
				for(int i=0;i<graph.vertex;i++) {
					for(int j=0;j<graph.vertex;j++) {
						//ȷ����ͼ����2���ڵ��������2����������һ�������ʹ�����һ��û��
						if(isVisited[i]==true && isVisited[j]==false && graph.weight[i][j] < minWeight && graph.weight[i][j] != 0) {
							minWeight = graph.weight[i][j];
							h1=i;
							h2=j;
						}
					}
				}
				
				isVisited[h2] = true; //���óɷ��ʣ�֮������һ�п�ʼ����
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
