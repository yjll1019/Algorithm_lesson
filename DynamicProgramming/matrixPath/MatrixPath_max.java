package test;
/*
 * 작성일 : 2018년 06월 19일
 * 작성자 : 이예지
 * 내 용 : 행렬의 경로 문제 - 큰 값을 가지는 경로 
 */
public class MatrixPath_max {
	static int[][] arr = new int[4][4]; //r,c까지의 점수를 저장하기위한 배열
	static int[][] a = { { 6, 7, 12, 5 }, 
						{ 5, 3, 11, 18 }, 
						{ 7, 17, 3, 3 }, 
						{ 8, 10, 14, 9 } };
	static int count=0;
	static int 점수(int r, int c) {
		count++;
		System.out.printf("점수(%d, %d) \n", r,c);
		if(arr[r][c]!=0) return arr[r][c];
		int 이전단계점수=0; //이전단계점수 + 현 점수 리턴해야한다.
		if(r==0 && c==0) 이전단계점수=0;
		else if(r>0 && c==0) 이전단계점수=점수(r-1,c);
		else if(r==0 && c>0) 이전단계점수=점수(r,c-1);
		else 이전단계점수 = Math.max(점수(r-1,c), 점수(r,c-1));
		arr[r][c] = 이전단계점수 + a[r][c];
		return arr[r][c];
	}
	
	static void 경로출력(int r, int c) {
		if(r==0 && c==0) {
			System.out.printf("점수(%d, %d) \n", r,c);
			return;
		}
		else if(r==0 && c>0) {
			경로출력(r,c-1);
			System.out.printf("점수(%d, %d) \n", r,c);//재귀로 들어갈때가 아닌 나오면서 호출.
		}
		else if(r>0 && c==0) {
			경로출력(r-1, c);
			System.out.printf("점수(%d, %d) \n", r,c);
		}
		else { 
			if (arr[r][c - 1] > arr[r - 1][c]) {
				경로출력(r, c - 1);
				System.out.printf("점수(%d, %d) \n", r,c);
			} else {
				경로출력(r - 1, c);
				System.out.printf("점수(%d, %d) \n", r,c);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("최대점수 : "+점수(3,3));
		System.out.println("count:"+count);
		경로출력(3,3);
		
	}

}
