package lesson03;
/*
 * �ۼ��� : 2018�� 03�� 23��
 * �� �� : �迭�� ���� ��ġ���� ���������� ���� ���� ���� ��ġ(�ε���)�� �����ϴ� �޼ҵ� findMin ����.
 */
public class Example4 {

	static int findMin(int[] a, int index) {
		int min = index;
		for(int i=index; i<a.length; ++i) {
			if(a[min] > a[i]) {
				min = i;
			}
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("lesson03_Example4 : �̿���");
		
		int [] a = {14, 11, 13, 15};
		
		for(int i=0; i<a.length; ++i) {
			int minIndex = findMin(a, i);
			System.out.println(a[minIndex]);
		}
		
	}

}
