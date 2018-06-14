package matrixPath;
/*
 * 작성일 : 2018년 06월 14일
 * 작성자 : 이예지
 * 내 용 : 행렬의 경로 문제
 */

public class Example1 {
	static int[][] arr = {{6,7,12},
						{5,3,11},
						{7,17,3}};
	static int[][] dpArr = new int[3][3];
	static int count=0;
/********
	static int 점수(int r, int c) {
		System.out.println("["+r+"]"+"["+c+"]");
		if(r==0 && c==0) return arr[r][c];
		else if(r>0 && c==0) return arr[r][c]+점수(r-1,c);
		else if(r==0 && c>0) return arr[r][c]+점수(r,c-1);
		else {
			return arr[r][c] + (arr[r-1][c]>arr[r][c-1]? 점수(r,c-1): 점수(r-1,c));
		}	//코드의 문제점 : 값을 더한게 최소가 되는 경로를 찾는 것이기 때문에 ?앞의 조건은 그 r,c위치에서의 점수만 판단하기때문에 
		//경로 판단이 아니다. 따라서 잘못된 코드!
	}
********/
	static int 점수(int r, int c) {
		count++;
		System.out.println("["+r+"]"+"["+c+"]");
		if(dpArr[r][c]!=0) return dpArr[r][c];
		int 이전단계점수 = 0;
		if(r==0 && c==0) 이전단계점수 = 0;
		else if(r>0 && c==0) 이전단계점수 = 점수(r-1,c);
		else if(r==0 && c>0) 이전단계점수 = 점수(r,c-1);
		else 
			이전단계점수 = Math.min(점수(r-1,c), 점수(r,c-1));
		dpArr[r][c] = arr[r][c] + 이전단계점수; //arr[r,c]까지의 최소 경로 점수.
		return dpArr[r][c];
		
	}
	
	
	
    public static void main(String[] args) throws Exception {
    	System.out.println(점수(arr.length-1,arr.length-1));
    	System.out.println("count : "+count);
    }
}
