package lesson;
/*
 * �ۼ����� : 2018�� 03��  12�� ������
 * �� �� : ����Լ��� ����Ͽ� 1���� �Ķ���ͷ� ���޵� �������� ���� ����.
 */
public class CH01_Example2 {

	static int sum(int n) {
		if (n == 1) //�� : if(n<1) return 0;
			return 1; //return 1�� �����ν� �޼ҵ� ��ü�� ����Ǹ� n�� 1�̸����� �������� �ʴ´�.
		return n + sum(n-1);
	}

	public static void main(String[] args) {
		for(int i=3; i<=10; ++i) {
			System.out.printf("%d %d\n", i, sum(i));
		}
	}
	
}
