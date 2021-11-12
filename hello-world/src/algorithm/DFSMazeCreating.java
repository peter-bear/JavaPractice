package algorithm;

import java.util.Arrays;

public class DFSMazeCreating {
	
	public static void main(String[] args) {
		int[][] temp =DFS(7,7,1,1);
		System.out.println();
		for(int[] i:temp)
			System.out.println(Arrays.toString(i));
		
	}
	
	private static boolean[][] isVisited;
	
	public static int[][] DFS(int row, int column, int start_row, int start_column) {
		int[][] map=new int[row][column];
		isVisited = new boolean[row][column];
		
		//初始化map
		//0 represent wall
		//1 represent the block or pass space
		
		for(int i=1;i<map.length;i+=2) {
			for(int j=1;j<map[0].length;j+=2) {
				map[i][j]=1;
			}
		}
		
//		System.out.println("\t原图");
//		printMap(map);
		CreatePath(map, 1,1);
//		System.out.println("\tPath");
//		printMap(map);
//		printVisit();
		
		return map;
	}
	
	private static void CreatePath(int[][] map, int row, int column) {
		//把此时这个点设置为已访问
		isVisited[row][column] = true;

		int left =0;
		int right=0;
		int up=0;
		int down=0;
		
		
		while(true) {
			int dir = (int)(4*Math.random());
			if(dir == 0 ) {
				//up
				up++;
				if(row >1 && !isVisited[row-2][column]) {
					map[row-1][column] =1; 
					CreatePath(map, row-2, column);
				}

				
			}else if(dir ==1 ) {
				//right
				right++;
				
				if(column <map[0].length-2 && !isVisited[row][column+2]) {
					map[row][column+1] =1;
					CreatePath(map, row, column+2);					
				}

				
			}else if(dir ==2) {
				//down
				down++;
				if(row <map.length-2 && !isVisited[row+2][column]) {
					map[row+1][column] =1;
					CreatePath(map, row+2, column);
				}

				
			}else if(dir ==3 ) {
				//left
				left++;
				if(column > 1 && !isVisited[row][column-2]) {
					map[row][column-1] =1;
					CreatePath(map, row, column-2);					
				}
			}
			
			//确保每个方向都有完全访问到
			if(left>=1 && right>=1 && up>=1 &&down>=1)
				break;

		}
	}

	
	private static void printMap(int[][] map) {
		for(int[] n:map) {
			System.out.println(Arrays.toString(n));
		}
	}
	
	private static void printVisit() {
		for(boolean[] n:isVisited) {
			System.out.println(Arrays.toString(n));
		}
	}
	
	

}
