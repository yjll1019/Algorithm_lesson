package midQuiz;
/*
 * �ۼ��� : 2018�� 03�� 26��
 * �� �� : �˰����� �߰� ��������.
 */
public class Quiz5 {

	static void method1(int[]a, int index) {
		if(index >=a.length) return;
		method1(a, index+1);
		System.out.printf("%d ", a[index]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("midQuiz_Quiz4 : �̿���");
		
		int [] a = {2, 4, 5};
		method1(a,0);
	}
}