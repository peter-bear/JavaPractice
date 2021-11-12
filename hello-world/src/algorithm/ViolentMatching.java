package algorithm;

public class ViolentMatching {

	public static void main(String[] args) {
		//±©¡¶∆•≈‰À„∑® 
		System.out.println(matching("ABCDBCEFFDHFCD","FFD"));
		
	}
	
	public static int matching(String str1, String str2) {
		int i=0;
		int j=0;
		char[] s1 =str1.toCharArray();
		char[] s2 =str2.toCharArray();
		while(i<s1.length && j<s2.length) {
			if(s1[i] == s2[j]) {
				i++;
				j++;
			}
			else {
				i= i-j+1;
				j=0;
				
			}
		}
		if(j==s2.length)
			return i-j;
		else {
			return -1;
		}
		
	}

}
