package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 31��
 * �� �� : �����ڷ� �� �������� int�� �迭 ����
 */
public class Prac1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_Prac1 : �̿���");
		
		
		int[] a = {11, 3, 45, 1, 8, 30};
		
		Arrays.sort(a);
		System.out.println("ArraysŬ������ sort�޼ҵ�� ���� : "+Arrays.toString(a));
		//ArraysŬ������ sort�޼ҵ带 �̿��ϸ� �⺻ �ڷ����� �迭�� ������ �� �ִ�.

		int[] b = {11, 3, 45, 1, 8, 30};
		selectionSort(b);
		System.out.println("selectionSort�� ���� : "+Arrays.toString(b));
		
		int[] c = {11, 3, 45, 1, 8, 30};
		bubbleSort(c);
		System.out.println("bubbleSort�� ���� : "+Arrays.toString(c));
		
		int[] d = {11, 3, 45, 1, 8, 30};
		insertionSort(d);
		System.out.println("insertionSort�� ���� : "+Arrays.toString(d));
	}
	
	static void insertionSort(int[] a) {
		for(int i=1; i<a.length; ++i) {
			int value = a[i];
			int j;
			for(j=i-1; j>=0; --j) {
				if(a[j]>value) {
					a[j+1]=a[j];
				}
				else break;
			}
			a[j+1] = value;
		}
	}
	
	static void bubbleSort(int[] a) {
		for(int i=a.length-1; i>=1; --i) {
			for(int j=0; j<i; ++j) {
				if(a[j]>a[j+1])	swap(a, j, j+1);
			}
		}
	}
	
	static void selectionSort(int[] a) {
		for(int i=0; i<a.length-1; ++i) {
			int minIndex = findMin(a, i);
			if(minIndex!=i) swap(a, i, minIndex);
		}
	}

	static int findMin(int[] a, int start) {
		int min = start;
		for(int i= start+1; i<a.length; ++i) {
			if(a[min]>a[i]) {
				min = i;
			}
		}
		return min;
	}
	
	static void swap(int[] a, int i , int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
}
