package lesson01;
/*
 * �ۼ����� : 2018�� 03�� 18��
 * �� �� : �ݸ��� �̿��ؼ� �迭�� ��ĭ �� �ڷ� �̷�� ����.
 */
public class Example1 {
	
	static void print(int[] a) {
		for(int i : a)
			System.out.printf("%d ", i);
	}
	
	static void insert(int []a, int index, int value) {

		for(int i=a.length-1; i>index; --i) {
			a[i] = a[i-1];
		}

		a[index] = value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Example1 : �̿���");
		
		int[] a = new int[10];

		for(int i=0; i<a.length; ++i) {
			a[i] = i;
		}
		System.out.print("���� �� �迭 ���: ");
		print(a);
	
		System.out.println();
	
		insert(a, 5, -99);
		System.out.print("���� �� �迭 ���: ");
		print(a);
	}

}
