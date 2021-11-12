package algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ��̤�����㷨
 * @author 23881
 *1. ����һ����ά���飬��Ϊ����
 *2. ����ǰλ������Ϊ�ѷ��ʣ����ݵ�ǰλ�ü��������������Щλ�ã������8������ �����뵽ArrayList��
 *3. ����ArrayList�е�����λ�ã������ĸ�������ͨ
 *4. �ж����Ƿ��������step���ü�������ͳ�ƣ����ղ���Ϊ36����ɲ��ˣ�����Ϊ0
 */
public class ChessHorseAlgorithm {
	
	
	private static int coloumn;//��
	private static int row; //��
	private static int[][] ChessBoard;
	private static boolean[][] isVisited;
	private static boolean finish = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Start(8, 8, 2, 1);
	}
	
	/**
	 * 
	 * @param c ���̵�����
	 * @param r ���̵�����
	 * @param x ��λ�ڵ�x��
	 * @param y ��λ�ڵ�y��
	 * @param step ����
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
		ChessBoard[y][x] = step; //��������Ӧ��λ�ñ�step(����)
		isVisited[y][x] = true;
		ArrayList<Point> ps = GetNext(new Point(x, y));
		sort(ps);
		while(!ps.isEmpty()){
			Point p = ps.remove(0); // ȡ����һ��point,��һ������ȥ�ߵĵ�
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
		int X = curPoint.x; //��ʾ��
		int Y = curPoint.y; //��ʾ��
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
