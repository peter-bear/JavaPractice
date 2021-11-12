package algorithm;


public class KMPAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 ="BBC ABCDAB ABCDABCDABDE";
		String str2 ="ABCDABD";
		System.out.println(KMP(str1, str2, MatchMap(str2)));
	}
	
	/**
	 * �����ַ�ƥ���
	 * @param dest �����ַ��� 
	 * @return ����ƥ��������
	 */
	public static int[] MatchMap(String dest) {
		int[] map = new int[dest.length()];
		map[0]=0;
		for(int i=1, j=0; i<dest.length();i++) {
			
			//KMP�㷨����
			while(j >0 && dest.charAt(i)!=dest.charAt(j)) {
				j = map[j-1];
			}
			//����ƥ��ֵ+1
			if(dest.charAt(i)==dest.charAt(j)) {
				j++;
			}
			map[i] =j;
		}
		return map;
	}
	
	/**
	 * 
	 * @param st1 ��ƥ��ĳ��ַ���
	 * @param st2 ����ƥ����ַ���
	 * @param map �ַ�ƥ���
	 * @return ����-1 ���Ӧƥ���λ��
	 */
	public static int KMP(String st1, String st2, int[] map) {
		for(int i=0, j=0;i<st1.length();i++) {
			//���ַ�ƥ�䲻���
			//KMP�㷨����
			while(j >0 && st1.charAt(i)!=st2.charAt(j)) {
				j = map[j-1];
			}
			
			//�ַ�ƥ�����
			if(st1.charAt(i)==st2.charAt(j)) {
				j++;
			}
			
			if(j >= st2.length())
				return i-j+1;
		}
		return -1;
		

	}

}
