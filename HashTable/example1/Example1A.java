package example1;
/*
 * 작성일 : 2018년 05월 22일
 * 내 용 : 간단한 해시 테이블 작성.
 * 		시간 복잡도(add,remove,contains) O(1), 공간 복잡도 O(n) >> 공간 낭비가 심하다.
 */
public class Example1A {
	static class HashTable{
		int[] a;
		
		public HashTable(int n) { //1~200까지의 정수를 저장할거라면 201크기의 배열 생성
			a = new int[n+1];
		}
		
		public void add(int value) {
			a[value] = value;
		}
		
		public void remove(int value) {
			a[value] = 0;
		}
		
		public boolean contains(int value) {
			return a[value]==value;
		}
		
	}
	
	public static void main(String[] args) {
		int maxValue=200, maxCount=10;
		HashTable hashTable = new HashTable(maxValue);
		
		int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
		
		for(int i=0; i<data.length; ++i)
			hashTable.add(data[i]);
		
		for(int i=1; i<=maxValue; ++i) { //해시테이블에 있는 값 출력
			if(hashTable.contains(i))
				System.out.println(i);
		}
	}
}
