package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : Comparator�������̽��� ������ PersonŬ���� �ۼ� �� Person�迭�� �����Ѵ�.
 */

public class Example1_Person2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("lesson03_Example1_Person2 : �̿���");
		
		Person2 [] p = new Person2[] {		
				new Person2("ȫ�浿", 18),
				new Person2("ȫ�浿", 20),
				new Person2("�Ӳ���", 22),
				new Person2("����ġ", 23)
		};
		
        Arrays.sort(p, new PersonNameComparator());
		System.out.println(Arrays.toString(p));
	
		Arrays.sort(p, new PersonAgeComparator());
		System.out.println(Arrays.toString(p));

	}

}
