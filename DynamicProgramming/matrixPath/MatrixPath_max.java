package test;
/*
 * �ۼ��� : 2018�� 06�� 19��
 * �ۼ��� : �̿���
 * �� �� : ����� ��� ���� - ū ���� ������ ��� 
 */
public class MatrixPath_max {
	static int[][] arr = new int[4][4]; //r,c������ ������ �����ϱ����� �迭
	static int[][] a = { { 6, 7, 12, 5 }, 
						{ 5, 3, 11, 18 }, 
						{ 7, 17, 3, 3 }, 
						{ 8, 10, 14, 9 } };
	static int count=0;
	static int ����(int r, int c) {
		count++;
		System.out.printf("����(%d, %d) \n", r,c);
		if(arr[r][c]!=0) return arr[r][c];
		int �����ܰ�����=0; //�����ܰ����� + �� ���� �����ؾ��Ѵ�.
		if(r==0 && c==0) �����ܰ�����=0;
		else if(r>0 && c==0) �����ܰ�����=����(r-1,c);
		else if(r==0 && c>0) �����ܰ�����=����(r,c-1);
		else �����ܰ����� = Math.max(����(r-1,c), ����(r,c-1));
		arr[r][c] = �����ܰ����� + a[r][c];
		return arr[r][c];
	}
	
	static void ������(int r, int c) {
		if(r==0 && c==0) {
			System.out.printf("����(%d, %d) \n", r,c);
			return;
		}
		else if(r==0 && c>0) {
			������(r,c-1);
			System.out.printf("����(%d, %d) \n", r,c);//��ͷ� ������ �ƴ� �����鼭 ȣ��.
		}
		else if(r>0 && c==0) {
			������(r-1, c);
			System.out.printf("����(%d, %d) \n", r,c);
		}
		else { 
			if (arr[r][c - 1] > arr[r - 1][c]) {
				������(r, c - 1);
				System.out.printf("����(%d, %d) \n", r,c);
			} else {
				������(r - 1, c);
				System.out.printf("����(%d, %d) \n", r,c);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�ִ����� : "+����(3,3));
		System.out.println("count:"+count);
		������(3,3);
		
	}

}
