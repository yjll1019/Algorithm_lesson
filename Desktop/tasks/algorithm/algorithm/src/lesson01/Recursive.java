package lesson01;
/*
 * �ۼ����� : 2018�� 03�� 17�� �����
 * �� �� : ��� ȣ��
 */
public class Recursive {
	static int rec(int n) {
		if(n<=1) return 1; //���� ����
		return n * rec(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=3; i<=10; ++i) {
			System.out.println("i="+i+" >> "+rec(i));
		}
	}

}
