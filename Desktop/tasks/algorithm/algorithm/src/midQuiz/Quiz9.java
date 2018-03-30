package midQuiz;
/*
 * �ۼ��� : 2018�� 03�� 26��
 * �� �� : �˰��� �߰� ��������.
 */
public class Quiz9 {
	
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
	
	static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i >= 1; --i) {
			boolean �Ϸ� = true;
			for (int j = 0; j < i; ++j) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					�Ϸ� = false;
				}
			}
			print(a);
			if (�Ϸ�) break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("midQuiz_Quiz9 : �̿���");
		
		int[] a = {7, 4, 1, 9, 3};
		bubbleSort(a);
	}
}
