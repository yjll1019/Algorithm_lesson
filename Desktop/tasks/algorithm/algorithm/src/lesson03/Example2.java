package lesson03;
/*
 * �ۼ��� : 2018�� 03�� 23�� 
 * �� �� : �迭���� a[i]�� a[j]�� ���� �ٲٴ� swap�޼ҵ� ����.
 */
import java.util.Arrays;

public class Example2 {
	
	static void swap(int []a, int i, int j) {
		int n = a[i];
		a[i] = a[j];
		a[j] = n;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("lesson03_Example2 : �̿���");
		
		int[] a = {2, 4};
		
		System.out.println(Arrays.toString(a));		
		swap(a,0,1);		
		System.out.println(Arrays.toString(a));
		
	}

}
