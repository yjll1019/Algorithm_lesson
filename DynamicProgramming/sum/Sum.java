package test;

/*
 * �ۼ��� :2018�� 06�� 19��
 * ���� : 1���� n���� �� Ȧ���� ���� ���� ���ϴ� sum�Լ� 
 */

public class Sum {
	
	static int sum(int n) {
		System.out.println("n�� : "+n);
		if(n==1) return 1;
		if(n%2==0) {
			return 0+sum(n-1);
		}
		else {
		return n+sum(n-1);
	}
	}		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10));
	}

}
