package java_class_study;

public class Rabbit {
	public static void main(String[] args) {
//		long[] sum = new long[52];
//		sum[0]=1;
//		sum[1]=1;
//		for (int i=2; i<=51; i++) {
//			sum[i] = sum[i-2]+sum[i-1];
//			System.out.println("��"+i+"���µ�������"+sum[i]+"��");
//		}
		long a = 1;
		long b = 1;
		long c = 0;
		//�����ڿ���̨��ӡ�������е�һ�����͵ڶ�������ֵ
		System.out.print(a + "\t" + b + "\t");
		//����һ��forѭ��������ѭ����������е���λ����ʮλ������
		for (int i = 3; i <= 20; i++) {
			//����������Ϊc��a+b����c��ֵ
			c = a + b;
			//����һ������a��ֵΪ�����еĵڶ�����b��ֵ
			a = b;
			//���ڶ�������b��ֵΪ�����еĵ�������c��ֵ
			b = c;
			//�ڵڶ���ѭ����ӡʱ������ӡ�����еĵ��ĸ���Ϊ��b + c = b + (a + b) 
			System.out.print(c + "\t");

		}

	}
}
