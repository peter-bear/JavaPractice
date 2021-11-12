package PointOffer;

public class isNumeric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="+6.66E-6";
		System.out.println(isNumber(s));
	}
	
	public static boolean isNumber(String number) {
		if(number == null)
			return false;
		
		char[] s=number.toCharArray();
		
		//ֱ���ж����һ���Ƿ�Ϊ��������
		if(s[s.length-1]<=48 || s[s.length-1]>=57)
			return false;
		
		//��һ��ɨ�裬��С�������
		int num = ScanInteger(0,s);
		
		//�����ص�ǡ�ɳ�����Χ���ȡ����
		if(num>=s.length-1) 
			return true;
		
		//�ڶ���ɨ�裬ɨ��С�����Է�����ֹͣ
		if(s[num]=='.') 
			num = ScanUnsighInteger(++num, s);
			
		
		//�����ص�ǡ�ɳ�����Χ���ȡ����
		if(num>=s.length-1) 
			return true;
		
		//������ɨ�裬ɨ��E��������Ƿ�Ϊ����
		if(s[num]=='E' || s[num]=='e') 
			num = ScanInteger(++num,s);
		
		
		//��ɨ���귢�ֻ���ʣ���ûɨ�꣬���ʾE������С����false
		if(num<number.length()-1)
			return false;
		else {
			return true;
		}
	}
	
	public static int ScanInteger(int i, char[] s) {
		if(s[i]=='+' || s[i]=='-')
			i++;
		return ScanUnsighInteger(i, s);
	}
	
	public static int ScanUnsighInteger(int i, char[] s) {
		while(i<s.length && s[i]>=48 && s[i]<=57) 
			i++;
		
		return i;
	}
	

	
	

}
