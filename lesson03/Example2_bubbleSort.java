package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 23��
 * �� �� : �̹� ������ �� �� ���¸� �ݺ����� �����Ű�� ������ ���� ����(bubble sort) ����.
 */
public class Example2_bubbleSort {

	static void swap(int[] a, int i, int j) {
		//O(n)
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void bubbleSort(int[] a) {
		//O(n^2)
		for(int i=a.length-1; i>=1; --i) {
			boolean result = true;
			//�ۿ��ٰ� result = true�� �ϰ� �Ǹ� i���� �ٲ� �� ���� true�� ���� �ʱ⶧���� �ȿ��ٰ� ������Ѵ�!
			for(int j=0; j<i; ++j) {
				if(a[j]>a[j+1]) {
					swap(a,j,j+1);
					result = false;
				}
			}
			if(result) break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lesson03_Example2_bubbleSort : �̿���");
		
        int[] a = { 17, 14, 11, 19, 13, 15, 20, 12, 16, 18 };

        bubbleSort(a);//O(n^2)
        System.out.println(Arrays.toString(a));
		
	}

}
