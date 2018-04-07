package lesson03_02;
/*
 * �ۼ��� : 2018�� 04�� 07��
 * �� �� : �� ����(quickSort)�� String[]�� �����ϵ�, ���ذ��� ���η� ���ؼ� �����ϱ�.(�����ڷ� �� �˰��� �����Ʒ�)
 */
import java.util.Arrays;

public class Reverse_QuickSort {
	static void swap(String []s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	static int partition(String[] s, int start, int end) {
		String value = s[start];
		int i=start;
				
		for(int j=start+1; j<=end; ++j) {
			if(s[j].compareTo(value)<0) swap(s, ++i, j);
		}
		swap(s, i, start);
		return i;
	}
	
	static void quickSort(String[] s, int start, int end) {
		
		if(start>=end) return ;
		int middle = partition(s, start, end);
		quickSort(s, start, middle-1);
		quickSort(s, middle+1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_02_Reverse_QuickSort : �̿���");
		
		String [] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		System.out.println("quickSort���� �� : "+Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("quickSort���� �� : "+Arrays.toString(arr));
	}	

}
