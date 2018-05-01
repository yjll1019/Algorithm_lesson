package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 3�� 26��
 * �� �� : String[] �迭 �����ϱ�, �����ڷ� 03 �������� 
 */
public class StringArray {

	static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(String[] a, int start) {
		int min = start;
		for(int i=start; i<a.length; ++i) {
			if(a[min].compareTo(a[i])>0) //min�� i���� ũ��
				min = i; //min�� i
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
	
	static void bubbleSort(String[] a) {
		for(int i=a.length-1; i>0; --i) {
			for(int j=0; j<i; ++j) {
				if(a[j].compareTo(a[j+1])>0) //j�� j+1���� ũ�� 
					swap(a, j, j+1);
			}
		}
	}
	
	static void insertionSort(String[] a) {
		for(int i=1; i<a.length; ++i) {
			String value = a[i];
			int j;
			for(j=i-1; j>=0; --j) {
				if(a[j].compareTo(value)>0) //j�� value���� ũ�� j�� j+1�� 
					a[j+1] = a[j];
				else
					break;
			}
			a[j+1] = value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_StringArray:�̿���");
		
		String[] a = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		Arrays.sort(a);
		System.out.println("ArraysŬ���� sort�޼ҵ� ����:"+Arrays.toString(a));
		//ArraysŬ������ sort�޼ҵ带 �̿��ؼ� String�迭�� ������ �� �ִ�.
		
		String [] b = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		selectionSort(b);
		System.out.println("selectionSort�� ���� : "+Arrays.toString(b));
		
		String [] c = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		bubbleSort(c);
		System.out.println("bubbleSort�� ���� : "+Arrays.toString(c));

		String [] d = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		insertionSort(d);
		System.out.println("insertionSort�� ���� : "+Arrays.toString(d));
		
	}

}
