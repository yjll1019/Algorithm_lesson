package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : Comparator�������̽��� �����Ͽ� Integer�迭�� ������������ ����.
 */
public class IntegerDescending {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_IntegerDescending : �̿���");
		
		Integer [] a = new Integer[] {19,10,11,4,70,8,100};
		//Integer [] a = {19,10,11,4,70,8,100};
		
		Arrays.sort(a, new IntegerComparator());
		System.out.println(Arrays.toString(a));
	}

}
