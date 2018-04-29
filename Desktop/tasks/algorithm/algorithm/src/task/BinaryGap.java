package task;
/*
 * �ۼ��� : 2018�� 04�� 29��
 * �� �� : ��) 1001 �̸� ���̳ʸ� ���� ���̰� 2
 * 			529�� �������� 1000010001 �̹Ƿ� ���̳ʸ� ���� ���̰� 4
 * 			20�� ��������  10100�̹Ƿ� ���̳ʸ� ���� ���̰� 1
 * 			15�� ��������  1111�̹Ƿ� ���̳ʸ� ���� ���̰� 0�̴�
 *			solution�޼ҵ��� �Ű������� ���� ������ �Է��ϸ� ���̳ʸ� ���� ���̸� �����ϴ� �޼ҵ� �ۼ�.
 */

// 1. �������� �ٲٱ�  2.������ 1 1���� �˻�  3. �� ���� ���ӵ� 0�� ����� ī��Ʈ�ϱ�

public class BinaryGap {

	static public int solution(int n) {
		String a = Integer.toBinaryString(n); //�������� ��ȯ
		int count = 0;
		int max = 0 ;
		System.out.print(n+"�� �������� : "+a);
		if(a.charAt(0)=='0' || a.charAt(a.length()-1)=='0') return 0;
		
		for(int i=0; i<a.length()-1; i++) {
			if(a.charAt(i)=='0') count++;
			else {
				max = (max>count)? max : count; 
				count = 0;
			}
		}
		return (max>count)? max : count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("task_BinaryGap : �̿���");
		System.out.println(" >> 4�� BinaryGap ���� : "+ solution(4));
		System.out.println(" >> 9�� BinaryGap ����  : "+ solution(9));
		System.out.println(" >> 1041�� BinaryGap ����  : "+ solution(1041));
		System.out.println(" >> 8488�� BinaryGap ����  "+ solution(8489));
		System.out.println(" >> 1181825�� BinaryGap ���� "+ solution(1181825));
	}

}
