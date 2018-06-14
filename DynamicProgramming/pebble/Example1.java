package pebble;

/*
 * 작성일 : 2018년 06월 14일
 * 작성자 : 이예지
 * 내 용 : 조약돌 놓기 문제
 */
public class Example1 {
	static int[][] dpArr = new int[8][5];
	static int[][] a = { { 6, 7, 12, -5, 5, 3, 11, 3 },
						{ -8, 10, 14, 9, 7, 13, 8, 5 },
						{ 11, 12, 7, 4, 8, -2, 9, 4 } };

	static boolean 인접가능패턴(int p1, int p2) {
		if(p1==p2) return false; //같은 패턴끼리는 조약돌을 놓을 수 없음!
		int[][] patterns = {{1,4},{3,4},{4,1},{4,3}}; //함께 할 수 없는 패턴
		for(int i=0; i<patterns.length; ++i) {
			if(p1==patterns[i][0] && p2==patterns[i][1]) 
				return false;
		}
		return true;	
	}
	
	static int 열점수(int c, int p) throws Exception{
		switch(p) {
			case 1: return a[0][c]; //1패턴의 경우 첫 번째 행의 원소 값 리턴
			case 2: return a[1][c];
			case 3: return a[2][c];
			case 4: return a[0][c] + a[2][c];
		}
		throw new Exception("invalid p:" + p);//해당하지 않는 패턴이 들어올 경우
	}
	
	static int 전체점수(int c, int p) throws Exception{
		System.out.println("["+c+"],"+"["+p+"]");
		if(dpArr[c][p]!=0) return dpArr[c][p];
		//c열 p패턴 시 이전 단계에서의 점수들과 현재 열,패턴의 점수를 합쳐서 리턴 
		if(c==0) return dpArr[c][p]=열점수(c,p); //0열일 때 패턴에 따른 점수 리턴
		
		int 이전열_최고점수 = Integer.MIN_VALUE;
		
		for(int q=1; q<=4; ++q) {
			if(인접가능패턴(p,q)) { //인접가능한 패턴이면
				int 점수 = 전체점수(c-1,q); //c-1열p패턴까지의 점수
				if(점수 > 이전열_최고점수) 
					이전열_최고점수 = 점수;
			}
		}
		return dpArr[c][p]=이전열_최고점수+열점수(c,p);
	}
	
	static int 전체점수(int c) throws Exception {
		//c열에서 for문을 통해 패턴을 돌리면서 어떤 패턴으로 돌을 놔야 최대값인지 고르고 최대점수 리턴.
		int 최고점수 = Integer.MIN_VALUE;
		for(int p=1; p<=4; ++p) {
			int 점수 = 전체점수(c,p);
			if(점수 > 최고점수) 최고점수 = 점수;
		}
		return 최고점수;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(전체점수(7));
	}

}
