package DataStructure;

public class EightGueenDemo {
	//����һ��max��ʾһ���ж��ٸ��ʺ�
	int max =8;
	//����һ��һά���飬�����±��ʾ�ڼ��У��±��Ӧ������ʾ�ڼ���
	int[] array =new int[max];
	int count=0;
	public static void main(String[] args) {
		EightGueenDemo queen = new EightGueenDemo();
		queen.check(0);
		System.out.printf("һ����%d�ֿ���",queen.count);

	}
	
	//��ӡ����
	public void print() {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	//�ж��Ƿ�ȫ(��ͻ)
	//n��ʾ��n���ʺ�
	public boolean safe(int n) {
		for(int i=0;i<n;i++) {
			//��ʾ��ͬһ�л�ͬһб��
			if(array[i] ==array[n] || Math.abs(n-i)==Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//��д���������õ�n���ʺ�
	public void check(int n) {
		if(n==max) {
			print();
			count++;
			return;
		}
		//һ��Ҫ��8���ʺ�8��ѭ���ݹ飬
		for(int i=0;i<max;i++) {
			//�ȰѸûʺ���ڵ�n�е�i��
			array[n] =i;
			//�Ƿ��ͻ
			if(safe(n)) {
				//�������ͻ�����ŷŵ�n+1���ʺ󣬵ݹ�
				check(n+1);
			}
			//�����ͻ��i++,���ʺ��ڵ�n������ƶ�һλ��ֱ������ͻ
		}
	}

}
