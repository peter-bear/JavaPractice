package DisjointSet;

import java.util.Arrays;

public class Disjoint1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Disjoint1 set = new Disjoint1(6);
		set.union(0, 1);
		set.union(0, 2);
	
		set.union(3, 4);
		set.union(3, 5);
		set.union(0, 3);
		
		System.out.println(set.find(4));
		set.print();
	}
	
	private int s[];
	
	public Disjoint1(int numElements) {
		s = new int[numElements];
		for(int i=0;i<s.length;i++)
			s[i] = -1;
		
	}
	
//	public int find(int x) {
//		int temp=x;
//		while(s[temp]!=-1)
//			temp = s[temp];
//		return temp;
//	}

	
	public int find(int x) {
		if(s[x] <0)
			return x;
		else {
			return s[x] = find(s[x]); //path compression, decrease the running time
		}
	}
	
	
	public void union(int root1, int root2) {
		if(s[root2]<s[root1]) //root2 is depper
			s[root1] = root2; //make root2 new root
		else {
			if(s[root1] == s[root2]) 
				s[root1] --;  //Update height if same
			s[root2] = root1; //make root1 new root
			
		}
		
	}
	
	public void print() {
		System.out.println(Arrays.toString(s));
	}

}
