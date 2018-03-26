package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 3�� 26��
 * �� �� : String[] �迭 �����ϱ�
 */
public class StringArray {

	static void swap(String[] a, int i, int j) {
		//�迭 a���� a[i]�� a[j]�� ���� �ٲ��ִ� �޼ҵ� swap
		//O(1)
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(String[] a, int start) {
		//�迭 a[start]���� ���� ������ ���� �� ���� ���� ���� ��ġ(�ε���)�� �����ϴ� �޼ҵ� findMin
		//�տ������� ������ �ּڰ��� ã��.
		
		int min = start;
		for(int i=start; i<a.length; ++i) {
			if(a[min].compareTo(a[i])>0)
				min = i;
		}
		return min;
	}
	
	static void selectionSort(String[] a) {

		int min=0;
		
		for(int i=0; i<a.length-1; ++i) { 
			min = findMin(a, i); 
			if(min!=i) swap(a, i, min); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_StringArray:�̿���");
		
		String [] a = {"god","desk","apple","home"};
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
