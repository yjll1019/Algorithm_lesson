package lesson03_02;

import java.util.Arrays;
/*
 * �ۼ��� : 2018�� 04�� 07��
 * �� �� : �� ����(quick Sort)�� Person[] �����ϱ�.
 */
public class PersonTest2 {
	static void swap(Person []s, int i, int j) {
		Person temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	static int partition(Person[] s, int start, int end) {
		Person value = s[end];
		int i=start-1;
				
		for(int j=start; j<=end-1; ++j) {
			if(s[j].name.compareTo(value.name)<0) swap(s, ++i, j);
		}
		swap(s, i+1, end);
		return i+1;
	}
	
	static void quickSort(Person[] s, int start, int end) {
		
		if(start>=end) return ;
		int middle = partition(s, start, end);
		quickSort(s, start, middle-1);
		quickSort(s, middle+1, end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_02_PersonTest2 : �̿���");

		Person[] p = new Person[] { 
				new Person("ȫ�浿", 18), 
				new Person("ȫ�浿", 20), 
				new Person("�Ӳ���", 22),
				new Person("����ġ", 23) 
				};
		System.out.println("quickSort���� �� : "+Arrays.toString(p));
		quickSort(p, 0, p.length-1);
		System.out.println("quickSort���� �� : "+Arrays.toString(p));
	}

}
