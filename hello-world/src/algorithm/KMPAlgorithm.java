package algorithm;


public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 ="BBC ABCDAB ABCDABCDABDE";
		String str2 ="ABCDABD";
		System.out.println(KMP(str1, str2, MatchMap(str2)));
	}
	
	/**
	 * 构建字符匹配表
	 * @param dest 传入字符串 
	 * @return 返回匹配后的数组
	 */
	public static int[] MatchMap(String dest) {
		int[] map = new int[dest.length()];
		map[0]=0;
		for(int i=1, j=0; i<dest.length();i++) {
			
			//KMP算法核心
			while(j >0 && dest.charAt(i)!=dest.charAt(j)) {
				j = map[j-1];
			}
			//部分匹配值+1
			if(dest.charAt(i)==dest.charAt(j)) {
				j++;
			}
			map[i] =j;
		}
		return map;
	}
	
	/**
	 * 
	 * @param st1 被匹配的长字符串
	 * @param st2 拿来匹配的字符串
	 * @param map 字符匹配表
	 * @return 返回-1 或对应匹配的位置
	 */
	public static int KMP(String st1, String st2, int[] map) {
		for(int i=0, j=0;i<st1.length();i++) {
			//若字符匹配不相等
			//KMP算法核心
			while(j >0 && st1.charAt(i)!=st2.charAt(j)) {
				j = map[j-1];
			}
			
			//字符匹配相等
			if(st1.charAt(i)==st2.charAt(j)) {
				j++;
			}
			
			if(j >= st2.length())
				return i-j+1;
		}
		return -1;
		

	}

}
