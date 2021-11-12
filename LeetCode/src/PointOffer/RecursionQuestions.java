package PointOffer;

import java.util.LinkedList;

public class RecursionQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=0;i<6;i++)
//			System.out.println(Fibonacci2(i));
//		System.out.println(frog(3));
		TestForCanThrough();
	}
	
	public static int Fibonacci(int n) {
		if(n<=0)
			return 0;
		else if(n==1)
			return 1;
		else {
			return Fibonacci(n-1) + Fibonacci(n-2); 
		}
	}
	
	public static int Fibonacci2(int n) {
		if(n<=0)
			return 0;
		else if(n==1)
			return 1;
		else {
			int a=0;
			int b=1;
			int rst=2;
			for(int i=2;i<=n;i++) {
				rst = a+b;
				a = b;
				b = rst;
			}
			return rst;
		}
	}
	
	public static int frog(int n) {
		if(n<=0)
			return 0;
		else if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else {
			int a=1;
			int b=2;
			int rst=3;
			for(int i=3;i<=n;i++) {
				rst = a+b;
				a = b;
				b = rst;
			}
			return rst;
		}
	}
	
	public static void TestForCanThrough() {
		char[][] matrix= {
				{'a','b','t','g'},
				{'c','f','c','s'},
				{'j','d','e','h'}
		};
		
		String path = "cfbtcs";
	
		System.out.println(canThrough(matrix,path));
	}
	
	public static boolean canThrough(char[][] matrix, String p) {
		char[] path = p.toCharArray();
		int index =0;
		boolean include = false;
		boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
		LinkedList<Node<Character>> nexts = null;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j] == path[index] && isVisited[i][j] == false) {
					isVisited[i][j] = true;
					include = true;
					nexts = getNext(i, j, matrix, isVisited);
					index++;
					break;
				}
			}
		}
		if(include) {
			return checkPath(nexts,path, index, matrix, isVisited);
		}
			
		else {
			return false;
		}
	}
	
	public static boolean checkPath(LinkedList<Node<Character>> nexts,  char[] path, int index, char[][] matrix,boolean[][] isVisited) {
		if(index == path.length)
			return true;
		for(Node<Character> tmp:nexts) {
			if(tmp.value == path[index]) {
				return checkPath(getNext(tmp.r, tmp.c, matrix, isVisited), path, ++index, matrix, isVisited);
			}	
		}
		return false;
	}
	
	public static LinkedList<Node<Character>> getNext(int row, int column, char[][] matrix, boolean[][] isVisited){
		LinkedList<Node<Character>> nexts = new LinkedList<>();
		if(row +1 < matrix.length && !isVisited[row+1][column])
			nexts.add(new Node<>(row+1,column, matrix[row+1][column]));
		if(row -1 >= 0 && !isVisited[row-1][column])
			nexts.add(new Node<>(row-1,column, matrix[row-1][column]));
		if(column +1 < matrix[0].length && !isVisited[row][column+1])
			nexts.add(new Node<>(row,column+1, matrix[row][column+1]));
		if(column -1 >= 0 && !isVisited[row][column-1])
			nexts.add(new Node<>(row,column-1, matrix[row][column-1]));
		
		return nexts;
	}
	
	private static class Node<E>{
		int r;
		int c;
		E value;
		Node(int row, int column, E v){
			r = row;
			c = column;
			value = v;
		}
	}


}
