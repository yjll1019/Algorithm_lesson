package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : Comparable�������̽��� ������ PersonŬ���� �ۼ� �� Person�迭�� �����Ѵ�.
 */
public class Example1_Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_Example1_Person : �̿���");
		
		Person [] p = new Person[] {		
				new Person("ȫ�浿", 18),
				new Person("ȫ�浿", 20),
				new Person("�Ӳ���", 22),
				new Person("����ġ", 23)
		};
		
		Arrays.sort(p);
		System.out.println(Arrays.toString(p));
	
	}

}
