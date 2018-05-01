package lesson03_02;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 04�� 15��
 * �� �� : �ִ� heap ���� ����.
 */
public class Example2_HeapSort {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void buildHeap(int[] a) {
		//O(n log n)
		int end = a.length-1;
		for(int i=end/2; i>=0; --i) {//�ڽ��� �ִ� ������ ����.
			heapify(a, i, end);
		}
	}
	
	static void heapify(int[] a, int index, int end) {
		//O(log n)
		int leftChildIndex = 2*index+1;
		int rightChildIndex = 2*index+2;
		int largeIndex;
	
		//a[index]�� �ڽ� ���� �Ǵ��ϱ�
		if(rightChildIndex<=end) { //�ڽ��� �Ѵ� �ִ� ���
			largeIndex = a[leftChildIndex]<a[rightChildIndex]? rightChildIndex : leftChildIndex;
		}
		else if(leftChildIndex<=end)//���� �ڽĸ� �ִ� ���
			largeIndex = leftChildIndex;
		else return; //�ڽ��� ���� ��� 
		
		if(a[largeIndex] > a[index]) {
			swap(a, index, largeIndex);
			heapify(a, largeIndex, end); // �ٲ� ��带 �������� �ٽ� �˻�.
		}
	}
	
	static void heapSort(int[] a) {
		//O(n log n)
		buildHeap(a);
		for(int end=a.length-1; end>=1; --end) {
			swap(a, 0, end);
			heapify(a, 0, end-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_2_Example2_HeapSort : �̿���");
		int[] a = { 3, 8, 2, 10, 4, 6, 7, 1, 9, 5 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
	}

}
