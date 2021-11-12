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
	 * @param <E> �����data��������
	 * @param d content
	 * @param matrix �����������Ȩ��
	 * @param index ��ʼ�����Ķ���
	 */
	public static <E> void Dijkstra(E[] d, int[][] matrix, int index) {
		
		Graph<E> graph = new Graph<>(d,matrix);
		

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(index);
		
		//������ȱ���
		while(!list.isEmpty()) {
			int i = list.pop();
			graph.start(i);
			graph.combine(list, graph.getNext(i));
		}

		//��ӡ���
		graph.showIsVisit();
		graph.showPreVisit();
		graph.showDis();
		
	}
	
	private static class Graph<E>{
		public E[] data;
		public int[] isVisted;
		public int[] preVisit; //ǰ��һ������
		public int[] dis; //�洢ָ�����㵽�����������
		public int[][] matrix; //Ȩ��
		
		Graph(E[] d, int[][] matrix){
			data = d;
			this.matrix = matrix;
			dis = new int[data.length];
			isVisted = new int[data.length];
			preVisit= new int[data.length];
		}
		
		//չʾͼ
		public void showGraph() {
			for(int[] a: matrix)
				System.out.println(Arrays.toString(a));
		}
		
		//չʾ�Ѿ����ʵ�����
		public void showIsVisit() {
			System.out.println(Arrays.toString(isVisted));
		}
		
		//չʾ��������ǰһ������
		public void showPreVisit() {
			System.out.println(Arrays.toString(preVisit));
		}
		
		//չʾ�������㵽ָ���������С����
		public void showDis() {
			System.out.println(Arrays.toString(dis));
		}
		
		//������һ������
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
		
		//�ϲ�list���ų���ͬԪ��
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
		
		//���þ���
		public void setDis(int j, int index) {
			//���þ���������ǣ���ʼdis������ʼ��ľ��룩Ϊ0�� �����ϸ��ڵ㵽��ʼ��ľ���+�ϸ��ڵ�������ڵ�ľ��� < ����ڵ㵽��ʼ�����
			if(dis[index]+matrix[index][j] < dis[j] || dis[j]==0 ) {
				setPreVisit(j, index);//������ӣ������������ϸ��ڵ���һ��
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
