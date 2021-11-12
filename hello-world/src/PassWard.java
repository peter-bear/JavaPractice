import java.util.HashMap;
import java.util.Scanner;
public class PassWard{
	public static HashMap<String,String> init(){
		HashMap<String, String> origi = new HashMap<String,String>();
		String UP =   "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-1234567890";
		String DOWN = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM-!@#$%^&*()";
		String a;
		String b;
		for(int i=0;i<UP.length();i++) {
				a=UP.substring(i, i+1);
				b=DOWN.substring(i,i+1);
				origi.put(a, b);
		}
		return origi;
	}
	public static void Input(HashMap<String,String> code) {
		Scanner in = new Scanner(System.in);
		String txt = in.next();
		String result="";
		for(int j=0;j<txt.length();j++) {
			String value = code.get(txt.substring(j,j+1));
			result +=value;
			//System.out.println(value);
		}
		System.out.println(result);
		in.close();
	}
	public static void main(String[] args) {
		
		HashMap<String,String> code = init();
		Input(code);
	}
}