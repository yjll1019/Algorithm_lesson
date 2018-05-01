package lesson03_02;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : �������� (mergeSort)�� String[] �����ϱ�.
 */

public class mergeSort_String {

	static void mergeSort(String[] s, int start, int end) {
		
			if(start<end) {
				int middle = (start+end)/2;
				mergeSort(s, start, middle);
				mergeSort(s, middle+1, end);
				merge(s, start, middle, end);
			}
	}
	
	static void merge(String []s, int start, int middle, int end) {
		int ���� = end-start+1;
		String [] temp = new String[����];
		int i = 0;
		int index1 = start;
		int index2 = middle+1;
		
		while(index1<=middle && index2<=end) {
			if(s[index1].compareTo(s[index2])<0) //s[index1]�� s[index2]�� ������ �� ������
				temp[i++]=s[index1++];
			else
				temp[i++]=s[index2++];
		}
		
		while(index1<=middle)
			temp[i++] = s[index1++];
		
		while(index2<=end)
			temp[i++] = s[index2++];
		
		
		for(i=0; i<temp.length; ++i) {
			s[start+i] = temp[i];
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_2_mergeSort_Stirng : �̿���");
		
		String [] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
		System.out.println("mergeSort���� �� : "+Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1);
		System.out.println("mergeSort���� �� : "+Arrays.toString(arr));
		
	}

}
