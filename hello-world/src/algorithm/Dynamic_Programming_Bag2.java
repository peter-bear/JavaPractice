package algorithm;

public class Dynamic_Programming_Bag2 {
	public static void main(String[] args) {
//		int[] w= {1,4,3};//��Ʒ����
//		int[] v= {1500, 3000, 2000};//��Ʒ��ֵ
		String[] obj = {"Guitar","Computer","Book"};
		int[] v= {200,300,100};
		int[] w= {2,4,1};
		int m =4;//����������
		int n = w.length;//��Ʒ�ĸ���
		
		//����
		int[][] bag =new int[n+1][m+1];
		
		
		//�洢����
		int[][] path=new int[n+1][m+1];
		
		for(int i=0;i<bag.length;i++)
			bag[i][0]=0;//��һ������Ϊ0
		for(int i=0;i<bag[0].length;i++)
			bag[0][i]=0;//��һ������Ϊ0
		
		for(int i=1;i<bag.length;i++) {
			for(int j=1;j<bag[0].length;j++) {
				if(w[i-1]>j) {
					//���������㣬ֱ�Ӽ̳�����һ��
					bag[i][j] = bag[i-1][j];
				}else {
					//�������㣬������һ���Աȣ�ѡȡ��ѵ�value
					//װ��i-1����Ʒ����ʣ��ռ�j-w[i]�����ֵ
//					bag[i][j] = Math.max(bag[i-1][j], v[i-1]+bag[i-1][j-w[i-1]]);
					if(bag[i-1][j]<v[i-1]+bag[i-1][j-w[i-1]]) {
						bag[i][j] = v[i-1]+bag[i-1][j-w[i-1]];
						//�ѵ�ǰ�����¼��path
						path[i][j]=1;
					}else {
						bag[i][j] = bag[i-1][j];
					}
					
				}
			}
		}
		
		
		//i��ʾ��
		//j��ʾ��
		for(int i=0;i<bag.length;i++) {
			for(int j=0;j<bag[0].length;j++) {
				System.out.printf(bag[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		int i=path.length-1;
		int j=path[0].length-1;
		while(i>0 && j>0) {
			if(path[i][j]==1) {
				System.out.printf("��%s���뱳��\n",obj[i-1]);
				j -= w[i-1];
			}
			i--;
		}
		
	}
}
