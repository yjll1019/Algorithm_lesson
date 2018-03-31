package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 31��
 * �� �� : �迭 ���� �� �Ű������� Comparable [] �� �α�
 */
public class Prac3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_Prac3 : �̿���");
		
		//���� �޼ҵ��� �Ķ���͸� Comparable[] �� ���ϸ� �Ķ������ Ÿ�Ը��� ���� �޼ҵ带 �������� �ʰ�, Comparable�� ������ ��� Ŭ������ �Ķ���� ������ �� �� �ֱ� ������ ���ϴ�.
		
		Integer[] a = {1,5,3,88,70,100,56};
		selectionSort(a);
		System.out.println("Integer ���� : "+Arrays.toString(a));
		
		Double [] b =  { 17.1, 14.3, 11.2, 19.5, 11.3, 14.1, 17.5, 19.2 };
		selectionSort(b);
		System.out.println("Double ���� : "+Arrays.toString(b));
		
		String [] c = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		selectionSort(c);
		System.out.println("String ���� : "+Arrays.toString(c));
		
	}
	
	static void swap(Comparable[] a, int i, int j) {
		//�迭 a���� a[i]�� a[j]�� ���� �ٲ��ִ� �޼ҵ� swap
		//O(1)
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(Comparable[] a, int start) {
		//�迭 a[start]���� ���� ������ ���� �� ���� ���� ���� ��ġ(�ε���)�� �����ϴ� �޼ҵ� findMin
		//�տ������� ������ �ּڰ��� ã��.
		
		int min = start;
		for(int i=start; i<a.length; ++i) {
			if(a[min].compareTo(a[i])>0) //min�� i���� ũ��
				min = i; //min�� i
		}
		return min;
	}
	
	static void selectionSort(Comparable[] a) {

		int min=0;
		
		for(int i=0; i<a.length-1; ++i) { 
			min = findMin(a, i); 
			if(min!=i) swap(a, i, min); 
		}
	}
}
