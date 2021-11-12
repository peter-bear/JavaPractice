package modifier;

import java.util.Arrays;

public class RadixSort{
	public static void main(String[] args) {
		// �� arr ���п��������ı��������
	    int[] array = {77,26,93,17,0,54,31,44,55,20 };
	    int maxDigit = getMaxDigit(array);
	    System.out.println(Arrays.toString(radixSort(array, maxDigit)));
	}
    

    /**
     * ��ȡ���λ��
     */
    public static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    public static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    public static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // ���Ǹ����������������չһ�������������� [0-9]��Ӧ������[10-19]��Ӧ���� (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * �Զ����ݣ�����������
     *
     * @param arr
     * @param value
     */
    public static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}