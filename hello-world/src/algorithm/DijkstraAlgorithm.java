package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data = {"A","B","C","D","E","F","G"};
		int[][] matrix = {
				{0,5,7,0,0,0,2},
				{5,0,0,9,0,0,3},
				{7,0,0,0,8,0,0},
				{0,9,0,0,0,4,0},
				{0,0,8,0,0,5,4},
				{0,0,0,4,5,0,6},
				{2,3,0,0,4,6,0}
		};
		
//		String[] data = {"A","B","C","D","E","F"};
//		int[][] matrix = {
//				{0,3,2,0,0,0},
//				{3,0,0,0,1,0},
//				{2,0,0,4,1,0},
//				{0,0,4,0,5,0},
//				{0,1,1,5,0,6},
//				{0,0,0,0,6,0}
//		};
		
		Dijkstra(data, matrix, 0);
		


	}
	
	/**
	 * 
	 * @param <E> 输入的data数据类型
	 * @param d content
	 * @param matrix 到各个顶点的权重
	 * @param index 开始遍历的顶点
	 */
	public static <E> void Dijkstra(E[] d, int[][] matrix, int index) {
		
		Graph<E> graph = new Graph<>(d,matrix);
		

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(index);
		
		//广度优先遍历
		while(!list.isEmpty()) {
			int i = list.pop();
			graph.start(i);
			graph.combine(list, graph.getNext(i));
		}

		//打印输出
		graph.showIsVisit();
		graph.showPreVisit();
		graph.showDis();
		
	}
	
	private static class Graph<E>{
		public E[] data;
		public int[] isVisted;
		public int[] preVisit; //前面一个顶点
		public int[] dis; //存储指定顶点到各顶点的数组
		public int[][] matrix; //权重
		
		Graph(E[] d, int[][] matrix){
			data = d;
			this.matrix = matrix;
			dis = new int[data.length];
			isVisted = new int[data.length];
			preVisit= new int[data.length];
		}
		
		//展示图
		public void showGraph() {
			for(int[] a: matrix)
				System.out.println(Arrays.toString(a));
		}
		
		//展示已经访问的数组
		public void showIsVisit() {
			System.out.println(Arrays.toString(isVisted));
		}
		
		//展示各个顶点前一个顶点
		public void showPreVisit() {
			System.out.println(Arrays.toString(preVisit));
		}
		
		//展示各个顶点到指定顶点的最小距离
		public void showDis() {
			System.out.println(Arrays.toString(dis));
		}
		
		//返回下一组数据
		public LinkedList<Integer> getNext(int index) {
//			dis[index]=0;
			isVisted[index] =1;
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0;i<data.length;i++) {
				if(matrix[index][i]>0 && isVisted[i]==0) {
					list.add(i);
				}
			}
//			list.push(index);
			return list;

		}
		
		//合并list，排除相同元素
		public void combine(LinkedList<Integer> l1, LinkedList<Integer> l2) {
			while(!l2.isEmpty()) {
				int num =l2.pop();
				if(!l1.contains(num))
					l1.add(num);
			}
		}
		
		
		public void setPreVisit(int index, int pre) {
			preVisit[index] = pre;
		}
		
		//设置距离
		public void setDis(int j, int index) {
			//设置距离的条件是，初始dis（到起始点的距离）为0， 或者上个节点到起始点的距离+上个节点与这个节点的距离 < 这个节点到起始点距离
			if(dis[index]+matrix[index][j] < dis[j] || dis[j]==0 ) {
				setPreVisit(j, index);//可以添加，把这个顶点的上个节点标记一下
				dis[j]=matrix[index][j]+dis[index];
				
			}
			
		}
		
		public void start(int index) {
			LinkedList<Integer> list = getNext(index);
			
			while(!list.isEmpty()) {

				setDis(list.pop(), index);
			}
			
		}
		
	}

}
