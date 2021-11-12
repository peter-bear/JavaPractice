public class Deliver_Dollar{
	public static void main(String[] args) {
		final double dime = 0.1;
		final double penny=0.01;
		final double quarter=0.25;
		//String[] dir = new String[2];
		//final double nickel =0.05;
		//int length=0;
		for (int i=0;i<(1/dime);i++) {
			for(int j=0;j<(1/penny);j++) {
				for(int k=0;k<(1/quarter);k++) {
					if(dime*i+penny*j+quarter*k == 1) {
						System.out.printf("you can use %d penny %d dime %d quarter to create one dollar\n",j,i,k);
						//length+=1;
					}
				}
			}
		}
		
	}
}