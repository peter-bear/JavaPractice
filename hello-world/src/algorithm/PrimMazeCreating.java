package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class PrimMazeCreating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prim(11,11,1,1);
	}
	
	public static int[][] Prim(int r, int c, int start_r, int start_c) {
		//init map and isVisited
		int[][] map = new int[r][c];
		boolean[][] isVisited = new boolean[r][c];
		for(int i=1;i<map.length;i+=2) {
			for(int j=1;j<map[0].length;j+=2) {
				map[i][j]=1;
			}
		}
		

		
		isVisited[start_r][start_c] = true;
		LinkedList<wall> list = GetNext(start_c, start_r, isVisited);
		int index=0;
		while(!list.isEmpty()) {
			index = (int)(list.size()*Math.random());
			wall w = list.get(index);
			if(!isVisited[w.b_r][w.b_c]) {
				list.remove(index);
				map[w.row][w.column] =1;
				isVisited[w.b_r][w.b_c] = true; 
				list.addAll(GetNext(w.b_r, w.b_c, isVisited));
			}else if(isVisited[w.a_r][w.a_c] && isVisited[w.b_r][w.b_c]) {
				list.remove(index);
			}

			
		}
		
//		for(int[] n:map) {
//		System.out.println(Arrays.toString(n));
//	}
		
		return map;

	}
	
	private static LinkedList<wall> GetNext(int r, int c, boolean[][] isVisited){
		LinkedList<wall> list = new LinkedList<>();
		
		if(c<isVisited[0].length-2)
			list.push(new wall(r, c+1, r, c, r, c+2));
		if(c>1)
			list.push(new wall(r, c-1, r, c, r, c-2));
		if(r<isVisited.length-2)
			list.push(new wall(r+1,c, r, c, r+2, c));
		if(r>1)
			list.push(new wall(r-1,c, r, c, r-2, c));
		return list;
	}
	
	private static class wall{
		int row;
		int column;
		int a_r;
		int a_c;
		int b_r;
		int b_c;
		wall(int r, int c, int ar, int ac, int br, int bc){
			row =r;
			column =c;
			a_r = ar;
			a_c =ac;
			b_r =br;
			b_c =bc;
		}
	}

}
