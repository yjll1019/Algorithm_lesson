package midQuiz;
/*
 * �ۼ��� : 2018�� 03�� 26��
 * �� �� : �˰��� �߰� ��������.
 */
public class Quiz8 {
	
	static void print(int[] a) {
		for(int i=0; i<a.length; ++i) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(int[] a, int start) {
		int min = start;
		for(int i=start; i<a.length; ++i) {
			if(a[min] > a[i])
				min = i;
		}
		return min;
	}
	
	static void selectionSort(int[] a) {
			for (int i = 0; i < a.length - 1; ++i) { 
				int minIndex = findMin(a, i);
				swap(a, i, minIndex);
				print(a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("midQuiz_Quiz8 : �̿���");
		
		int[] a = {7, 4, 1, 9, 3};
		selectionSort(a);
	}

}
