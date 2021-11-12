package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import modifier.StaticStudy;

public class AstarAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {
				{1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,1},
				{1,0,0,0,1,0,0,1},
				{1,0,0,0,1,0,0,1},
				{1,1,1,1,1,1,1,1}
		};
//		int[][] map = PrimMazeCreating.Prim(11, 11, 1, 1);
		for(int[] a:map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
//		A_Star(map, 1, 1, map.length-2, map[0].length-2);
		A_Star(map, 2, 2, 2, 6);
		
		for(int[] a:map) {
			System.out.println(Arrays.toString(a));
		}
		
	}
	
	private static class Node implements Comparable<Node>{
		Node parent;
		int row;
		int column;
		int G_cost;
		int H_cost;
		Node(int r, int c, int g, int h, Node p){
			row = r;
			column =c;
			G_cost = g;
			H_cost =h;
			parent =p;

		}
		
		@Override
		public int compareTo(Node b) {
			// TODO Auto-generated method stub
			return this.G_cost+this.H_cost-b.G_cost-b.H_cost;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Node temp = (Node) obj;
			return temp.row == this.row && temp.column == this.column;
		}
		
		
	}
	

	public static void A_Star(int[][] map, int begin_r, int begin_c,int end_r, int end_c) {
		PriorityQueue<Node> open_list = new PriorityQueue<>(); 
		PriorityQueue<Node> close_list = new PriorityQueue<>();
		int[][] Node_Status = new int[map.length][map[0].length];
		/**
		 * 0 means the node is neigher in open_list nor in close_list
		 * 1 means the node is in open_list
		 * 2 means the node is in close_list
		 * 
		 */
		int temp_g = Get_G(begin_r, begin_c, end_r, end_c);
		int temp_h = 0;
		
		open_list.add(new Node(begin_r, begin_c, temp_g, temp_h, null));
		Node_Status[begin_r][begin_c] = 1;
		
		/**
		 * 	a. ���� open list ������ F ֵ��С�Ľڵ㣬������Ϊ��ǰҪ����Ľڵ㡣
			b. ������ڵ��Ƶ� close list ��
			c. �Ե�ǰ����� 4�����ڷ����ÿһ������
			�� ������ǲ��ɵִ�Ļ������� close list �У������������������²�����
			�� ��������� open list �У��������� open list �����Ұѵ�ǰ��������Ϊ���ĸ��ף���¼�÷���� F �� G �� H ֵ��
			�� ������Ѿ��� open list �У��������·�� ( �����ɵ�ǰ���񵽴������� ) �Ƿ���ã��� G ֵ���ο�����С�� G ֵ��ʾ���Ǹ��õ�·����
				����������������ĸ�������Ϊ��ǰ���񣬲����¼������� G �� F ֵ�������� open list �ǰ� F ֵ����Ļ����ı���������Ҫ��������
			d. ֹͣ������
			�� ���յ���뵽�� open list �У���ʱ·���Ѿ��ҵ��ˣ�����
			�� �����յ�ʧ�ܣ����� open list �ǿյģ���ʱû��·����
			3. ����·�������յ㿪ʼ��ÿ���������Ÿ��ڵ��ƶ�ֱ����㣬��������·����


		 */
		final int wall =1;
		while(!open_list.isEmpty()) {
			Node temp = open_list.poll();
			close_list.add(temp); // push the node into close_list
			if(temp.row == end_r&& temp.column == end_c)
				break;
			Node_Status[temp.row][temp.column] = 2; // update the status of this node
			int parent_h = temp.H_cost;
			
			
			//�� ������ǲ��ɵִ�Ļ������� close list �У������������������²���
			if(map[temp.row-1][temp.column]!=wall  && Node_Status[temp.row-1][temp.column] ==0) {
				//�� ��������� open list �У��������� open list �����Ұѵ�ǰ��������Ϊ���ĸ��ף���¼�÷���� F �� G �� H ֵ
				Node nn = new Node(temp.row-1, temp.column, Get_G(temp.row-1, temp.column, end_r, end_c), parent_h+1, temp);
//				if(Node_Status[temp.row-1][temp.column] ==0)
					open_list.add(nn);
					map[temp.row-1][temp.column] =3;
				
			}
			if(map[temp.row+1][temp.column]!=wall  && Node_Status[temp.row+1][temp.column] ==0) {

				Node nn = new Node(temp.row+1, temp.column, Get_G(temp.row+1, temp.column, end_r, end_c), parent_h+1, temp);
//				if(Node_Status[temp.row+1][temp.column] ==0)
					open_list.add(nn);
					map[temp.row+1][temp.column] =3;
			}
				
			if(map[temp.row][temp.column-1]!=wall  && Node_Status[temp.row][temp.column-1] ==0) {
				Node nn = new Node(temp.row, temp.column-1, Get_G(temp.row, temp.column-1, end_r, end_c), parent_h+1, temp);
//				if(Node_Status[temp.row][temp.column-1] ==0)
					open_list.add(nn);
					map[temp.row][temp.column-1] =3;
			}
				
			if(map[temp.row][temp.column+1]!=wall  && Node_Status[temp.row][temp.column+1] ==0) {
				Node nn = new Node(temp.row, temp.column+1, Get_G(temp.row, temp.column+1, end_r, end_c), parent_h+1, temp);
//				if(Node_Status[temp.row][temp.column+1] ==0)
					open_list.add(nn);
					map[temp.row][temp.column+1]=3;
			}
				
			
			
			
		}
		
	Object[] arr = close_list.toArray();
	Node p =null;
	for(int i=0;i<arr.length;i++) {
		Node temp =(Node)arr[i];
		if(temp.row == end_r && temp.column == end_c) {
			p = temp;
			break;
		}
	}
	
	
	while(p != null) {
		map[p.row][p.column] =2;
		p = p.parent;
	}
		
		
	}
	
	private static int Get_G(int begin_r, int begin_c,int end_r, int end_c) {
		return Math.abs(end_r-begin_r)+Math.abs(end_c-begin_c);
	}
	
	

}
