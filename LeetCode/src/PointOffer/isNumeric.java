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
		
		//直接判断最后一个是否为常规数字
		if(s[s.length-1]<=48 || s[s.length-1]>=57)
			return false;
		
		//第一轮扫描，以小数点结束
		int num = ScanInteger(0,s);
		
		//若返回的恰巧超出范围则读取结束
		if(num>=s.length-1) 
			return true;
		
		//第二轮扫描，扫描小数后，以非整数停止
		if(s[num]=='.') 
			num = ScanUnsighInteger(++num, s);
			
		
		//若返回的恰巧超出范围则读取结束
		if(num>=s.length-1) 
			return true;
		
		//第三轮扫描，扫描E后面的数是否为整数
		if(s[num]=='E' || s[num]=='e') 
			num = ScanInteger(++num,s);
		
		
		//若扫描完发现还有剩余的没扫完，则表示E后面是小数，false
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
