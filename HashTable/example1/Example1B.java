package example1;
/*
 * 작성일 : 2018년 05월 22일
 * 내 용 : 값을 저장하는 배열 
 * 		시간 복잡도 add : O(1) / remove,contains : O(n) 다 찾아서 삭제하고 값 유무를 따져야함. 
 * 		 공간 복잡도 O(1) >> 배열에 들어갈 값만큼 배열을 생성하기 때문에 .
 */
public class Example1B {
	
	static class MyArray{
		int[] a;
		int count; //배열에 값이 저장될 때마다 ++ 삭제될 때마다 --
		
		public MyArray(int size) {
			a = new int[size];
			count = 0;
		}
		
		public void add(int value) {
			a[count] = value;
			++count;
		}
		
		public int findIndex(int value) { //들어있는 값의 인덱스 리턴
			for(int i=0; i<a.length; i++) {
				if(a[i]==value) return i;
			}
			return -1; //값이 없을 시
		}
		
		public void remove(int value) {
			int index = findIndex(value);
			if(index==-1) return;
			for(int i=index; i<a.length-1; ++i) {
				a[i]=a[i+1];
			}
			count--;
		}
		
		public boolean contains(int value) {
			return (findIndex(value)!=-1); //-1 : 값 없음 , 그  외(인덱스): 값 있음 
		}
	
		public int get(int index) {
			return a[index];
		}
	}
	
	public static void main(String[] args) {
		int maxValue=200, maxCount=10;
		
		MyArray myArray = new MyArray(maxCount);
		
		int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
        for (int i = 0; i < data.length; ++i)
            myArray.add(data[i]);
        
        for(int i=0; i<maxCount; ++i) {
        	System.out.println(myArray.get(i));
        }
	}
	
}
