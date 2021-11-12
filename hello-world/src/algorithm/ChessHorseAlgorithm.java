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
public class ChessHorseAlgorithm {
	
	
	private static int coloumn;//列
	private static int row; //行
	private static int[][] ChessBoard;
	private static boolean[][] isVisited;
	private static boolean finish = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Start(8, 8, 2, 1);
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
	public static void Start(int c, int r, int x, int y) {
		coloumn = c;
		row = r;
		ChessBoard = new int[row][coloumn];
		isVisited = new boolean[row][coloumn];
		Run(x, y, 1);
		
		for(int[] cb: ChessBoard)
			System.out.println(Arrays.toString(cb));
	}
	
	private static void Run(int x, int y, int step) {
		ChessBoard[y][x] = step; //给棋盘相应的位置标step(步数)
		isVisited[y][x] = true;
		ArrayList<Point> ps = GetNext(new Point(x, y));
		sort(ps);
		while(!ps.isEmpty()){
			Point p = ps.remove(0); // 取出第一个point,下一步可以去走的点
			if(!isVisited[p.y][p.x])	
				Run(p.x, p.y, step+1);
		}

		if(step < row*coloumn && ! finish) {
			
			ChessBoard[y][x] = 0;
			isVisited[y][x] = false;
		}else {
			finish = true;
		}
			
			
	}
	
	public static void sort(ArrayList<Point> ps) {
		ps.sort(new Comparator<Point>() {

			@Override
			public int compare(Point arg0, Point arg1) {
				// TODO Auto-generated method stub
				return GetNext(arg0).size() - GetNext(arg1).size();
			}
			
		});
	}
	
	public static ArrayList<Point> GetNext(Point curPoint) {
		ArrayList<Point> ps = new ArrayList<>();
		int X = curPoint.x; //表示列
		int Y = curPoint.y; //表示行
		if(X-2>=0 && Y-1 >= 0) 
			ps.add(new Point(X-2, Y-1));
		
		if(X-1 >=0 && Y-2 >=0)
			ps.add(new Point(X-1, Y-2));
		
		if(X+1 < coloumn && Y-2 >=0)
			ps.add(new Point(X+1, Y-2));
		
		if(X+2 < coloumn && Y-1 >= 0)
			ps.add(new Point(X+2, Y-1));
		
		
		if(X-2>=0 && Y+1 < row) 
			ps.add(new Point(X-2, Y+1));
		
		if(X-1 >=0 && Y+2 < row)
			ps.add(new Point(X-1, Y+2));
		
		if(X+1 <coloumn && Y+2 < row)
			ps.add(new Point(X+1, Y+2));
		
		if(X+2 < coloumn && Y+1 < row)
			ps.add(new Point(X+2, Y+1));
		
		return ps;
	}

}
