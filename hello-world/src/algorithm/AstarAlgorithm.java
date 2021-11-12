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
		 * 	a. 遍历 open list ，查找 F 值最小的节点，把它作为当前要处理的节点。
			b. 把这个节点移到 close list 。
			c. 对当前方格的 4个相邻方格的每一个方格？
			◆ 如果它是不可抵达的或者它在 close list 中，忽略它。否则，做如下操作。
			◆ 如果它不在 open list 中，把它加入 open list ，并且把当前方格设置为它的父亲，记录该方格的 F ， G 和 H 值。
			◆ 如果它已经在 open list 中，检查这条路径 ( 即经由当前方格到达它那里 ) 是否更好，用 G 值作参考。更小的 G 值表示这是更好的路径。
				如果是这样，把它的父亲设置为当前方格，并重新计算它的 G 和 F 值。如果你的 open list 是按 F 值排序的话，改变后你可能需要重新排序。
			d. 停止，当你
			◆ 把终点加入到了 open list 中，此时路径已经找到了，或者
			◆ 查找终点失败，并且 open list 是空的，此时没有路径。
			3. 保存路径。从终点开始，每个方格沿着父节点移动直至起点，这就是你的路径。


		 */
		final int wall =1;
		while(!open_list.isEmpty()) {
			Node temp = open_list.poll();
			close_list.add(temp); // push the node into close_list
			if(temp.row == end_r&& temp.column == end_c)
				break;
			Node_Status[temp.row][temp.column] = 2; // update the status of this node
			int parent_h = temp.H_cost;
			
			
			//◆ 如果它是不可抵达的或者它在 close list 中，忽略它。否则，做如下操作
			if(map[temp.row-1][temp.column]!=wall  && Node_Status[temp.row-1][temp.column] ==0) {
				//◆ 如果它不在 open list 中，把它加入 open list ，并且把当前方格设置为它的父亲，记录该方格的 F ， G 和 H 值
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
