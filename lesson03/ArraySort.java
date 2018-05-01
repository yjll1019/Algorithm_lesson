package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 23��
 * �� �� : �Էµ� ���� �迭���� ¦���� �迭�� �� �κп�, Ȧ���� �迭�� �� �κп� ��ġ�ϰ� �ϴ� �޼ҵ� ����.
 */
public class ArraySort {
	
	static void sort(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void bubbleSort(int[] a) {
		for(int i=a.length-1; i>=1; --i) {
			for(int j=0; j<i; ++j) {
				if(a[j]%2==1) {
					//Ȧ����
					sort(a, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("lesson03_ArraySort : �̿���");
		
		int [] a = {1,2,3,4,6,5,10,11,45};
	
		bubbleSort(a);
		
		System.out.print(Arrays.toString(a));
	}

}
