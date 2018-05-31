package example1;

/*
 * 작성일 : 2018년 05월 31일
 * 내용 : Example1D 보완.
 *      중복되는 값이 있을 경우 다음 배열의 인덱스에 값을 저장한다. 
		삭제 시 0이 아닌 -1을 저장한다.
 */
public class Example1D_2 {
	
	static class HashTable{
		static final int EMPTY = 0;
		static final int SIZE = 37;
		static final int DELETE = -1;
		int[] a;
		
		public HashTable() {
			a = new int[SIZE];
		}
		
		public void add(int value) throws Exception{
			int startIndex = value % SIZE;
			int count = 0;
			
			do {

				int index = (startIndex + count) % SIZE; //충돌시 다음 칸에 저장하기 위해서 count를 더해준다.
				if(a[index]==EMPTY || a[index]==DELETE) {
					a[index] = value; 
					return;
				}
				else if(a[index]==value) return; //이미 값이 들어있으면 리턴
				++count; // 값이 인덱스에 들어있지만 비어있지도 않고 들어있는 값이 넣고자하는 값이 아니면 충돌발생

			}while(count<a.length); //충돌 발생으로 인해 한 칸씩 자리를 옮겨가면서 값을 넣고자 했으나 배열이 꽉 차 있는 경우. 
			throw new Exception("공간 부족");
		}
		
		public void remove(int value) {
			int startIndex = value % SIZE;
			int count = 0;
			
			//값이 있는 경우
			do {
				int index = (startIndex+count) % SIZE;
				 
				if(a[index]==EMPTY) return ; //EMPTY인 경우 그 뒤에도 찾는 값이 없다는 뜻이므로 return
				//여기서 DELETE를 검사하지 않는 이유 : 8을 삭제 할 때 배열에 4 -1 8 이렇게 있으면 8이 뒤에 있는데도 리턴을 해버리기 때문에.
				else if(a[index]==value) {
					a[index%SIZE] = DELETE; //값이 있는 경우 값을 삭제(-1로 바꿔준다.)
					return;
				}
				count++;
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
   //     int[] data = {5,10,15,20,25,30,35,40};

        int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
        hashTable.remove(7);
        
        System.out.println("\n 7삭제 후 ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
        System.out.println("\n115 contians : "+hashTable.contains(115));
        System.out.println("1 contians : "+hashTable.contains(1));
        
        hashTable.remove(15);
        
        System.out.println("15 삭제 후 : ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
	}

}
