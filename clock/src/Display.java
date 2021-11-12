import java.util.Scanner;
class TIME{
	private int Min =0;
	private int Hor = 0;
	public TIME(){
		
	}
	public TIME(int Hor,int Min){
		
		this.Hor = Hor;
		this.Min = Min;
	}
	public void increase(){
		this.Min++;
		if(this.Min == 60) {
			this.Hor+=1;
			this.Min=0;		
		}
		if(this.Hor==24) {
			this.Hor=0;
		}
	}
	public void show() {
		if(this.Min >10) {
			System.out.printf("Time  %d:%d", this.Hor,this.Min);
		}
		else {
			System.out.printf("Time  %d:0%d", this.Hor,this.Min);
		}
	}
	
}
public class Display{

	public static void dis(int H,int M) {
		TIME time = new TIME(H,M);
		time.increase();
		time.show();
	}
	public static void main(String[] args) {
		int H,M;
		Scanner in =new Scanner(System.in);
		System.out.print("Hour:");
		H = in.nextInt();
		System.out.print("Minite:");
		M = in.nextInt();
		if(H==24) {
			H=0;
			dis(H,M);
		}
		else if(H<24 && H>=0) {
			dis(H,M);
		}
		else if(H>24) {
			System.out.print("Please put in right time");
		}
		in.close();
		
	}
}