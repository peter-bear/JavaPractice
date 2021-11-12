package PointOffer;

import java.math.BigDecimal;

public class PowerNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power2(4.0,2));
	}
	
	public static double power(double base, int exponent) {
		if(new BigDecimal(base).compareTo(new BigDecimal(0.0))==0 && exponent ==0) {
			return 0.0;
		}
		if(exponent == 0)
			return 1.0;
		else if(exponent==1)
			return base;
		
		double rst=1;
		for(int i=0;i<Math.abs(exponent);i++)
			rst *= base;
		if(exponent <0)
			return 1.0/rst;
		
		return rst;
	}
	
	public static double power2(double base, int exponent) {
		if(new BigDecimal(base).compareTo(new BigDecimal(0.0))==0 && exponent ==0) 
			return 0.0;
		
		
		double rst=cal(base, Math.abs(exponent));
		if(exponent<0)
			return 1.0/rst;
		return rst;
	}
	
	public static double cal(double base, int exponent) {
		if(exponent == 0)
			return 1.0;
		else if(exponent==1)
			return base;
		
		double rst= cal(base, exponent>>1);
		rst *= rst;
		if((exponent & 0x1) ==1)
			rst *=  base;
		
			
		return rst;
	}

}
