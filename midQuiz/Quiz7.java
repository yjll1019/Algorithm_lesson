package midQuiz;
/*
 * �ۼ��� : 2018�� 03�� 26��
 * �� �� : �˰��� �߰� ��������.
 */
public class Quiz7 {

	static int sum(int n) {
		if(n<1) return 1;
		System.out.printf("%d ", n);
		return n + sum(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("midQuiz_Quiz4 : �̿���");
		
		int [] a = {2, 4, 5};
		System.out.printf("%d ", sum(3));
	}
}
