package example1;
/*
 * 작성일 : 2018년 05월 22일
 * 내용 : Example1C 보완.
 *      중복되는 값이 있을 경우 다음 배열의 인덱스에 값을 저장한다. 
		삭제 시 0이 아닌 -1을 저장한다.
 */
public class Example1D {
	
	static class HashTable{
		static final int EMPTY = 0;
		static final int SIZE = 37;
		int[] a;
		
		public HashTable() {
			a = new int[SIZE];
		}
		
		public void add(int value) throws Exception{
			int startIndex = value % SIZE;
			int count = 0;
			
			do {
				int index = (startIndex + count) % SIZE; //충돌시 다음 칸에 저장하기 위해서 count를 더해준다.
				if(a[index]==EMPTY || a[index]==-1) {
					a[index] = value; 
					return;
				}
				else if(a[index]==value) return; //이미 값이 들어있으면 리턴
				++count; // 값이 인덱스에 들어있지만 비어있지도 않고 들어있는 값이 넣고자하는 값이 아니면 충돌발생
			}while(count<a.length); //충돌 발생으로 인해 한 칸씩 자리를 옮겨가면서 값을 넣고자 했으나 배열이 꽉 차 있는 경우. 
			throw new Exception("공간 부족");
		}
		
		public void remove(int value) {
			if(this.contains(value)==false) return; //값이 없는 경우
			
			int startIndex = value % SIZE;
			int count = 0;
			
			//값이 있는 경우
			do {
				int index = (startIndex+count) % SIZE;
				 
				if(a[index%SIZE]==value) {
					a[index%SIZE] = -1; //값이 있는 경우 값을 삭제(-1로 바꿔준다.)
					return;
				}
			}while(count<a.length);	
			
		}
		
		public boolean contains(int value) {
			int startIndex = value % SIZE;
			int count = 0;
			do {
				int index = (startIndex + count)%SIZE;
				if(a[index]==EMPTY || a[index]==-1) return false;
				else if(a[index]==value) return true;
				++count;
			}while(count<a.length); //충돌 횟수가 배열의 길이보다 크면 false리턴
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Example1D : 이예지");
		
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();

        int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
        
        hashTable.remove(7);
        
        System.out.println("값 삭제 후 ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
	}

}
