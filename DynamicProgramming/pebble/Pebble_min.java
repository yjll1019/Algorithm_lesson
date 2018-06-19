package test;
/*
 * 작성일 : 2018년 06월 14일
 * 작성자 : 이예지
 * 내 용 : 조약돌 놓기 문제 - 최소값 경로찾기 문제로 구현.
 */
public class Pebble_min {
	static int[][] a = { { 6, 7, 12, -5, 5, 3, 11, 3 }, { -8, 10, 14, 9, 7, 13, 8, 5 }, { 11, 12, 7, 4, 8, -2, 9, 4 } };
	static int[][] arr = new int[8][5];// 열,패턴만큼

	static boolean 인접가능패턴(int 패턴1, int 패턴2) {
		if (패턴1 == 패턴2)
			return false;
		int[][] patterns = { { 1, 4 }, { 3, 4 }, { 4, 3 }, { 4, 1 } };
		for (int i = 0; i < patterns.length; ++i) {
			if (패턴1 == patterns[i][0] && 패턴2 == patterns[i][1])
				return false;
		}
		return true;
	}

	static int 열점수(int c, int p) throws Exception {
		switch (p) {
		case 1:
			return a[0][c];
		case 2:
			return a[1][c];
		case 3:
			return a[2][c];
		case 4:
			return a[0][c] + a[2][c];
		}
		throw new Exception("invalid p:" + p);
	}

	static int 전체점수(int c) throws Exception {
		int max = Integer.MAX_VALUE;
		for (int p = 1; p <= 4; ++p) {
			int 점수 = 전체점수(c, p); // c열을 1,2,3,4패턴으로 계산했을 때 값들 비교해서 최고값 리턴
			if (max > 점수)
				max = 점수;
		}
		return max;
	}

	static int 전체점수(int c, int p) throws Exception {
		System.out.printf("점수(%d, %d) \n", c, p);
		if (arr[c][p] != 0)
			return arr[c][p];

		if (c == 0)
			return arr[c][p] = 열점수(c, p);
		int 점수;
		int 이전열최고점수 = Integer.MAX_VALUE;
		for (int q = 1; q <= 4; ++q) {// c열의 p패턴과 맞는 c-1의 q패턴 찾기
			if (인접가능패턴(p, q)) {
				점수 = 전체점수(c - 1, q);// c열,p패턴과 c-1열,q패턴 시 점수(계속 재귀)
				if (점수 < 이전열최고점수)
					이전열최고점수 = 점수;
			}
		}
		arr[c][p] = 이전열최고점수 + 열점수(c, p);
		return arr[c][p];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(전체점수(7));
	}
}
