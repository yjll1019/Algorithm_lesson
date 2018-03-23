package lesson02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * �ۼ��� : 2018�� 3�� 22�� 
 * �� �� : ��� ȣ���� �̿��Ͽ� �迭 ���� Ž�� ����.
 */
public class Example4 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void sort(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j])
					swap(a,i,j);
			}
		}
	}
	

	static int search1(int[] a, int value) {
		//O(n)
		for(int i=0; i<a.length; i++) {
			if(a[i]==value) return i;
		}
		return -1;
	}
	
	static int search2(int[] a, int value) {
		//O(log n)
		int start = 0;
		int end = a.length-1;
		
		while(start<=end) {
			int middle = (start+end)/2;
			if(a[middle]>value)  end=middle-1;
			else if(a[middle]<value) start=middle+1;
			else return middle;
		}
		return -1;
	}
	
	static int search3(int[]a , int start, int end, int value) {
		//O(log n)
		int middle = (start+end)/2;
		
		if(start>end) return -1;
		
		if(a[middle]>value) {
			middle=search3(a, start, middle-1, value);
		}
		else if(a[middle]<value) {
			middle = search3(a, middle+1, end, value);
		}
		else return middle;
		
		return middle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Example4 : �̿���");
		
		Random random = new Random();
		int[] a = new int[10];
		
		for(int i=0; i<a.length; i++) {
			a[i] = random.nextInt(20);
		}
		
		sort(a);
		System.out.println(Arrays.toString(a));
		
		Scanner input = new Scanner(System.in);
		System.out.println("ã�� ���� �Է��ϼ���.");
		
		int value = input.nextInt();
		
		System.out.println("search1��� : "+search1(a, value));
		System.out.println("search2��� : "+search2(a, value));
		System.out.println("search3��� : "+search3(a, 0, a.length-1, value));
		
		
	}

}
