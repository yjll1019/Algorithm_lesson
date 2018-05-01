package lesson03_02;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 04�� 07��
 * �� �� : �� ����(quick Sort)�� String[] �����ϱ�.
 */
public class QuickSort_String {

	static void swap(String []s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	static int partition(String[] s, int start, int end) {
		String value = s[end];
		int i=start-1;
				
		for(int j=start; j<=end-1; ++j) { //j=start! j=0���� �ϸ� ������ 0���� end-1���� ���ϱ� ������ i�� ������ �Ѿ� ArrayIndexOutOfBoundsException�߻�!
			if(s[j].compareTo(value)<0) swap(s, ++i, j);
		}
		swap(s, i+1, end);
		return i+1;
	}
	
	static void quickSort(String[] s, int start, int end) {
		
		if(start>=end) return ;
		int middle = partition(s, start, end);
		quickSort(s, start, middle-1);
		quickSort(s, middle+1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_02_QuickSort_String : �̿���");
		
		String [] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		System.out.println("quickSort���� �� : "+Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("quickSort���� �� : "+Arrays.toString(arr));
	}	

}
