package lesson03;

import java.util.Arrays;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : �⺻ �ڷ����� ��ü �迭�� ����
 */

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_ArrayTest : �̿���");
		
		int [] a = { 17, 14, 11, 19, 13, 15, 20, 12, 16, 18 };
		Arrays.sort(a, 0, 5); //�ε��� 0~4���� �κ� ����
		System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        
        double [] b =  { 17.1, 14.3, 11.2, 19.5, 11.3, 14.1, 17.5, 19.2 };
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        char [] c = {'a', 'c', 'd', 'b', 'z'};
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
        // �⺻ �ڷ��� ����
        
        
        String [] d = { "zero", "one", "two", "three", "four", "five", "six", "seven" };
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));

        Integer[] f = { 17, 14, 11, 19, 13, 15, 20, 12, 16, 18 };
        Arrays.sort(f);
        System.out.println(Arrays.toString(f));
        //��ü �迭 ����
	}

}
