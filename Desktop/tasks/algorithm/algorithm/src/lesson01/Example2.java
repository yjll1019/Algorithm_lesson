package lesson01;
/*
 * �ۼ����� : 2018�� 03�� 18�� 
 * �� �� : �ݸ��� �̿��ؼ� �迭�� ��ĭ �� ���� �����ϰ� ������ �ε����� 0 �߰�.
 */
public class Example2 {


	static void print(int[] a) {
		for(int i : a)
			System.out.printf("%d ", i);
	}
	
	static void remove(int [] a, int index) {
		int count = 0;
		for(int i=index; i<=a.length-2; i++) {
			a[i] = a[i+1];
		}
		a[a.length-1]=0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Example2 : �̿���");
		
		int[] a = new int[10];

		for(int i=0; i<a.length; ++i) {
			a[i] = i;
		}
		System.out.print("���� �� �迭 ���: ");
		print(a);
	
		System.out.println();
	
		System.out.print("���� �� �迭 ���: ");
		remove(a, 5);
		print(a);
	}

}
