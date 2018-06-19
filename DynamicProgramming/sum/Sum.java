package test;

/*
 * 작성일 :2018년 06월 19일
 * 내용 : 1부터 n까지 중 홀수만 더한 합을 구하는 sum함수 
 */

public class Sum {
	
	static int sum(int n) {
		System.out.println("n은 : "+n);
		if(n==1) return 1;
		if(n%2==0) {
			return 0+sum(n-1);
		}
		else {
		return n+sum(n-1);
	}
	}		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(10));
	}

}
