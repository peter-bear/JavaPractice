package algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 马踏棋盘算法
 * @author 23881
 *1. 创建一个二维数组，作为棋盘
 *2. 将当前位置设置为已访问，根据当前位置计算马儿还能走哪些位置（最多有8个）， 并放入到ArrayList中
 *3. 遍历ArrayList中的所有位置，看看哪个可以走通
 *4. 判断马是否完成任务，step，用计数器来统计，最终步数为36，完成不了，设置为0
 */
public class ChessHorseAlgorithm2 {
	
	
	private static int X;//列
	private static int Y; //行
	private static int[][] ChessBoard;
	private static boolean[] isVisited;
	private static boolean finish = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Start(8, 8, 3, 2);
	}
	
	/**
	 * 
	 * @param c 棋盘的列数
	 * @param r 棋盘的行数
	 * @param x 马位于第x列
	 * @param y 马位于第y行
	 * @param step 步数
	 * 
	 */
	public static void Start(int c, int r, int row, int column) {
		ChessBoard = new int[r][c];
		isVisited = new boolean[c*r];
		X = c;
		Y = r;
		Run(row-1, column-1, 1);
		
		for(int[] cb: ChessBoard)
			System.out.println(Arrays.toString(cb));
	}
	
	private static void Run(int row, int coloumn, int step) {
		ChessBoard[row][coloumn] = step; //给棋盘相应的位置标step(步数)
		isVisited[row * X +coloumn ] = true;
		ArrayList<Point> ps = GetNext(new Point(coloumn, row));
		sort(ps);
		while(!ps.isEmpty()){
			Point p = ps.remove(0); // 取出第一个point,下一步可以去走的点
			if(!isVisited[p.y* X + p.x])	
				Run(p.y, p.x, step+1);
		}

		if(step < X*Y && ! finish) {
			
			ChessBoard[row][coloumn] = 0;
			isVisited[row * X +coloumn] = false;
			
		}else {
			finish = true;
		}
			
			
	}
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point arg0, Point arg1) {
				// TODO Auto-generated method stub
				int p1 = GetNext(arg0).size();
				int p2 = GetNext(arg1).size();
				if(p1 >p2)
					return 1;
				else if(p1 == p2)
					return 0;
				else {
					return -1;
				}
			}
			
		});
	}
	
	public static ArrayList<Point> GetNext(Point curPoint) {
		ArrayList<Point> ps = new ArrayList<>();
		Point p1 = new Point();
		if((p1.x = curPoint.x-2)>=0 && (p1.y=curPoint.y-1) >= 0) 
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x-1) >=0 && (p1.y=curPoint.y-2) >=0)
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x+1) < X && (p1.y=curPoint.y-2) >=0)
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x+2) < X && (p1.y=curPoint.y-1) >= 0)
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x-2)>=0 && (p1.y=curPoint.y+1) < Y) 
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x+1) <X && (p1.y=curPoint.y+2) < Y)
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x-1) >=0 && (p1.y=curPoint.y+2) < Y)
			ps.add(new Point(p1));
		
		if((p1.x = curPoint.x+2) < X && (p1.y=curPoint.y+1) < Y)
			ps.add(new Point(p1));
		
	
		
		
		
		return ps;
	}

}
