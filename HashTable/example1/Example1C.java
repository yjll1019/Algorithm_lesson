package example1;
/*
 * 작성일 : 2018년 05월 22일
 * 내 용 : 간단한 해시 테이블 보완.
 *  	배열의 크기를 37로 정한 후, 37로 나눈 나머지의 위치에 원소 저장.
 *  	저장할 값이 중복하지 않기 때문에 가능. 값이 하나라도 중복되는 것이 있으면 제대로 작동하지 않음.
 * 		시간 복잡도(add,remove,contains) O(1), 공간 복잡도 O(1) 
 */
public class Example1C {
	
	static class HashTable{
		
		int[] a;
		
		public HashTable() {
			a = new int[37];
		}
		
		public void add(int value) {
			a[value%37] = value;
		}
		
		public void remove(int value) {
			a[value%37] = 0;
		}
		
		public boolean contains(int value) {
			return a[value%37]==value; //값이 있으면 true 값이 없으면 배열 안 원소가 0이기 때문에 false리턴.
		}
	}
	
	public static void main(String[] args) {
		int maxValue=200, maxCount=10;
		HashTable hashTable = new HashTable();
		
        int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
		
		for(int i=0; i<data.length; ++i) {
			hashTable.add(data[i]);
		}
		
		for(int i=1; i<=maxCount; ++i) { //1~200까지의 정수를 넣는다고 가정하였으므로
			if(hashTable.contains(i))   //1~200까지 중 값이 있으면 출력
				System.out.println(i);
		}
	}
}
