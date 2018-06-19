package test;
/*
 * �ۼ��� : 2018�� 06�� 14��
 * �ۼ��� : �̿���
 * �� �� : ���൹ ���� ���� - �ּҰ� ���ã�� ������ ����.
 */
public class Pebble_min {
	static int[][] a = { { 6, 7, 12, -5, 5, 3, 11, 3 }, { -8, 10, 14, 9, 7, 13, 8, 5 }, { 11, 12, 7, 4, 8, -2, 9, 4 } };
	static int[][] arr = new int[8][5];// ��,���ϸ�ŭ

	static boolean ������������(int ����1, int ����2) {
		if (����1 == ����2)
			return false;
		int[][] patterns = { { 1, 4 }, { 3, 4 }, { 4, 3 }, { 4, 1 } };
		for (int i = 0; i < patterns.length; ++i) {
			if (����1 == patterns[i][0] && ����2 == patterns[i][1])
				return false;
		}
		return true;
	}

	static int ������(int c, int p) throws Exception {
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

	static int ��ü����(int c) throws Exception {
		int max = Integer.MAX_VALUE;
		for (int p = 1; p <= 4; ++p) {
			int ���� = ��ü����(c, p); // c���� 1,2,3,4�������� ������� �� ���� ���ؼ� �ְ� ����
			if (max > ����)
				max = ����;
		}
		return max;
	}

	static int ��ü����(int c, int p) throws Exception {
		System.out.printf("����(%d, %d) \n", c, p);
		if (arr[c][p] != 0)
			return arr[c][p];

		if (c == 0)
			return arr[c][p] = ������(c, p);
		int ����;
		int �������ְ����� = Integer.MAX_VALUE;
		for (int q = 1; q <= 4; ++q) {// c���� p���ϰ� �´� c-1�� q���� ã��
			if (������������(p, q)) {
				���� = ��ü����(c - 1, q);// c��,p���ϰ� c-1��,q���� �� ����(��� ���)
				if (���� < �������ְ�����)
					�������ְ����� = ����;
			}
		}
		arr[c][p] = �������ְ����� + ������(c, p);
		return arr[c][p];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(��ü����(7));
	}
}
