package lesson03;
/*
 * �ۼ��� : 2018�� 03�� 23��
 * �� �� : �迭���� �ּҰ��� �ε����� �����ϴ� findMin�޼ҵ� ����.
 */
public class Example3 {

	static int findMin(int[] a) {
		int min=0;
		for(int i=0; i<a.length; ++i) {
			if(a[min]>a[i])
				min = i;
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_Example3 : �̿���");

		int [] a1 = {17, 14, 11, 19};
		int [] a2 = {-17, -14, -11, -19};
		
		int minIndex = findMin(a1);
		System.out.println("a1�� �ּҰ� �ε��� : "+minIndex);
		
		minIndex = findMin(a2);
		System.out.println("a2�� �ּҰ� �ε��� : "+minIndex);

	}

}
