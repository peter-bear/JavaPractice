package DisjointSet;

public class CircleJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {
				{0, 1},
//				{0, 2},
				{0, 4},
				{1, 2},
//				{2, 4},
				{2, 3},
		};
		isCircle(a, 5);
	}
	
	private static int[] p;
	
	private static int find(int x) {
		if(p[x] <0)
			return x;
		else {
			return p[x] = find(p[x]);
		}
	}
	
	
	
	private static boolean union(int i, int j) {
		int x=find(i);
		int y =find(j);
		if(x!=y) {
			if(p[y] < p[x])
				p[x]= y;
			else {
				p[y] =x;
			}
			return false;
		}else {
			return true;
		}
	}
	
	public static void isCircle(int[][] a, int len) {
		p = new int[len];
		for(int i=0;i<p.length;i++)
			p[i]=-1;
		boolean rst;
		for(int[] i:a) {
			rst = union(i[0],i[1]);
			if(rst) {
				System.out.println("These data include circle");
				break;
			}
		}
		
	}

}
