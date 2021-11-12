package java_class_study;

import java.util.ArrayList;

public class factor {
	private Boolean isprime(int a) {
		for(int i=2; i<a;i++) {
			if (a%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int num=40;
		factor a = new factor();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=2; i<num; i++) {
			if (num%i == 0 && a.isprime(i)) {
				list.add(i);
			}
		}
		System.out.print(1);
		for(int j=0; j<list.size();j++) {
			while(num%list.get(j)==0) {
				System.out.print("*"+list.get(j));
				num = num / list.get(j);
			}
		}
	}
}
