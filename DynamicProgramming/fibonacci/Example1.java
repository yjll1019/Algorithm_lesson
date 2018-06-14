package fibonacci;

/*
 * 작성일 : 2018년 06월 14일
 * 작성자 : 이예지
 * 내 용 : 피보나치수 구현.
 */


public class Example1 {
	static int count=0;
	static int [] arr = new int[100];
	
	static int fibonacci(int n) {
		System.out.println("n: "+n);
		count++;
		
		if(arr[n]!=0) return arr[n];
		if(n==1 || n==2) 
			arr[n] = 1;
		else arr[n] = fibonacci(n-1)+fibonacci(n-2);
		return arr[n];
	}
	
	public static void main(String[] args) {
		int value = fibonacci(7);
		System.out.println(value);
		System.out.println("count = "+count);
	}
}
