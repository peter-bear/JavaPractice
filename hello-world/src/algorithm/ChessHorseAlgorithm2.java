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
public class ChessHorseAlgorithm2 {
	
	
	private static int X;//��
	private static int Y; //��
	private static int[][] ChessBoard;
	private static boolean[] isVisited;
	private static boolean finish = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Start(8, 8, 3, 2);
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
		ChessBoard[row][coloumn] = step; //��������Ӧ��λ�ñ�step(����)
		isVisited[row * X +coloumn ] = true;
		ArrayList<Point> ps = GetNext(new Point(coloumn, row));
		sort(ps);
		while(!ps.isEmpty()){
			Point p = ps.remove(0); // ȡ����һ��point,��һ������ȥ�ߵĵ�
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
