package lesson02;
////////////////������ �ϼ� �ƴ�
/*
 * �ۼ����� : 2018�� 03�� 22��
 * �� �� : �Է� �迭�� �߰� ���� ã�� ���� ���Ѵ�.
 * 		  �� ��� ã�� ���� ũ��, �߰� ���� �������� ���ʿ��� ã�´�.
 *		  ã�� ���� ������, �߰� ���� �������� ���ʿ��� ã�´�.
 *		 ���� �����ϸ� �ε����� �����ϰ� ���� ������ -1�� �����ϸ� ã�⸦ �����Ѵ�.
 */
public class BinaryTree {

	static int search2(int [] a, int start, int end, int value) {

		int middle = (start+end)/2;
		
		while(start <= end) {
			if(a[middle]>value) {
				end = middle-1;
				middle = search2(a, start, end, value);
			}
			else if(a[middle]<value) {
				start = middle+1;
				middle = search2(a, start, end, value);
			}
			else if(a[middle]==value) {
				return middle;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Search2 : �̿���");
		
		int [] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int [] b = {0,1,2,3,8};
		System.out.println(search2(b,0,b.length-1,9));
		//System.out.println(search2(a, 0,a.length-1, 11));
	}

}
