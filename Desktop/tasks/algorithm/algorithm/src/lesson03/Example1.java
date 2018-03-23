package lesson03;
//findMin2 selectionSort2 ���� ���� ������!
import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 23��
 * �� �� : ��������(selection sort) ����
 */
public class Example1 {

	static void swap(int[] a, int i, int j) {
		//�迭 a���� a[i]�� a[j]�� ���� �ٲ��ִ� �޼ҵ� swap
		//O(1)
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(int[] a, int start) {
		//�迭 a[start]���� ���� ������ ���� �� ���� ���� ���� ��ġ(�ε���)�� �����ϴ� �޼ҵ� findMin
		//�տ������� ������ �ּڰ��� ã�� �տ� ��ġ��Ű�� ���
		//O(n)
		int min = start;
		for(int i=start; i<a.length; ++i) {
			if(a[min] > a[i])
				min = i;
		}
		return min;
	}
	
	static int findMin2(int[] a, int start) {
		//�迭 a[start]�������� ���������� �� ���� ���� ���� ��ġ(�ε���)�� �����ϴ� �޼ҵ� findMin2
		//�ڿ������� ������ �ִ��� ã�� �ڿ� ��ġ��Ű�� ���
		//O(n)
		int max = a.length-1;
		for(int i=a.length-1; i<=1; --i) {
			if(a[max] < a[i])
				max = i;
		}
		return max;
	}
	
	static void selectionSort(int[] a) {
		//O(log n)
		int min=0;
		
		for(int i=0; i<a.length-1; ++i) { //��¼�� ������ �ε������� ������ �ε������� ���ϴ°� �ǹ̰� ���� ������ a.length-1��.
			min = findMin(a, i); //i�� ��ġ���� a[i]���� ����  �� ���� ���� ���� �ε����� ����, ������ �״�� i����
			if(min!=i) swap(a, i, min); //min�� i�� �ٸ���(�״�� i�� �ƴ� ���� ���� ���� ���� �Ǿ��ٸ�) a[i]�� a[min]�� ���� �ٲ۴�.
		}
	}
	
	static void selectionSort2(int[] a) {
		//O(log n)
		int min=0;
		
		for(int i=a.length-1; i<=1; ++i) { //��¼�� ������ �ε������� ������ �ε������� ���ϴ°� �ǹ̰� ���� ������ a.length-1��.
			min = findMin2(a, i); //i�� ��ġ���� a[i]���� ����  �� ���� ���� ���� �ε����� ����, ������ �״�� i����
			if(min!=i) swap(a, i, min); //min�� i�� �ٸ���(�״�� i�� �ƴ� ���� ���� ���� ���� �Ǿ��ٸ�) a[i]�� a[min]�� ���� �ٲ۴�.
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_Example1 : �̿���");
		
		int [] a = {17, 14, 11, 19, 13, 15, 18, 12, 16, 20 };
		
		selectionSort(a); //O(n)
		System.out.println(Arrays.toString(a));
		
		selectionSort2(a); //O(n)
		System.out.println(Arrays.toString(a));
	}

}
