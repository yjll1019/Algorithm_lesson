package example2;

/*
 * 작성일 : 2018년 05월 23일
 * 내 용 : HashTable의 충돌을 해결하는 방법 중 DoubleHashing 방법
 * 		 충돌 시 값이 삽입될 인덱스를 값에 따라 다르게 정한다.
 */

public class DoubleHashing {

	static class HashTable{
		
		static final int EMPTY = 0;
		static final int DELETED = -1;
		static final int SIZE = 37;
		static final int STEP_SIZE = 7;
		int [] a;
		
		public HashTable() {
			a = new int[SIZE];
		}
		
		public void add(int value) throws Exception{
			int startIndex = value % SIZE;
			int step = (value%STEP_SIZE)+1;
			int count = 0;
			
			do {
				int index = (startIndex + count*step) % SIZE;
				if(a[index]==EMPTY | a[index]==DELETED) { //배열의 위치가 비어있거나 원소 값이 삭제되었다면 그 자리에 value삽입.
					a[index] = value;
					return;
				}
				else if(a[index]==value) return;
				
				++count;
			}while(count<a.length);
			throw new Exception("공간 부족");
		}
		
		public void remove(int value) {
			int startIndex = value % SIZE;
			int step = (value % STEP_SIZE) + 1; 
			int count = 0;
			
			do {
				int index  = (startIndex + count*step) % SIZE;
				if(a[index]==EMPTY) return;
				else if(a[index]==value) {
					a[index] = DELETED; //삭제할 값을 찾으면 값을 -1으로 변경
				}
				count++;
			}while(count<a.length);
			
		}
		
		public boolean contains(int value) {
			int startIndex = value % SIZE;
			int step = (value % STEP_SIZE) + 1; 
			int count = 0;
			
			do {
				int index = (startIndex + count*step) % SIZE;
				if(a[index]==EMPTY) return false;
				else if(a[index]==value) return true;
				count++;
			}while(count<a.length);
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int maxValue = 200, maxCount = 10; 
		HashTable hashTable = new HashTable();
		
		int[] data ={ 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
		
		for(int i=0; i<data.length; ++i) {
			hashTable.add(data[i]);
		}
		
		for(int i=1; i<=maxValue; ++i) {
			if(hashTable.contains(i))
				System.out.println(i);
		}
		
		System.out.println("10삽입, 4삭제 후:");
		
		hashTable.add(10);
		hashTable.remove(4);
		
		for(int i=1; i<=maxValue; ++i) {
			if(hashTable.contains(i))
				System.out.println(i);
		}
		

	}

}
