package lesson03_02;

/*
 * �ۼ��� : 2018�� 03�� 24��
 * �� �� : �������� (mergeSort)�� Person[] �����ϱ�.
 */

import java.util.Arrays;

	public class PersonTest {
	
		static void mergeSort(Person[] s, int start, int end) {
	
			if (start < end) {
				int middle = (start + end) / 2;
				mergeSort(s, start, middle);
				mergeSort(s, middle + 1, end);
				merge(s, start, middle, end);
			}
		}

		static void merge(Person[] s, int start, int middle, int end) {
			int ���� = end-start+1;
			Person [] temp = new Person[����];
			int i = 0;
			int index1 = start;
			int index2 = middle+1;
			
			while(index1<=middle && index2<=end) {
				if(s[index1].name.compareTo(s[index2].name)<0)
					temp[i++]=s[index1++];
				else
					temp[i++]=s[index2++];
			}
			
			while(index1<=middle)
				temp[i++] = s[index1++];
			
			while(index2<=end)
				temp[i++] = s[index2++];
			
			
			for(i=0; i<temp.length; ++i) {
				s[start+i] = temp[i];
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lesson03_02_PersonTest : �̿���");

		Person[] p = new Person[] { 
				new Person("ȫ�浿", 18), 
				new Person("ȫ�浿", 20), 
				new Person("�Ӳ���", 22),
				new Person("����ġ", 23) 
				};
		System.out.println("mergeSort���� �� : "+Arrays.toString(p));
		mergeSort(p, 0, p.length-1);
		System.out.println("mergeSort���� �� : "+Arrays.toString(p));
	}

}
