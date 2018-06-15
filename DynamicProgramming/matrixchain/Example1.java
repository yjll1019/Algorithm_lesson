package matrixchain;

public class Example1 {
	static int[][] dpArr;
	static int[][] middle����;

	static class Matrix {
		int row, col;

		public Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int multiMin(Matrix[] a, int start, int end) throws Exception {
		if (start == end)
			return 0;
		if (dpArr == null) {
			dpArr = new int[a.length][a.length];
			middle���� = new int[a.length][a.length];
		}
		if (dpArr[start][end] != 0)
			return dpArr[start][end];

		int �ּҰ� = Integer.MAX_VALUE;

		for (int middle = start; middle < end; middle++) {
			int Ƚ�� = multiMin(a, start, middle);// �� �κ� ����Ƚ���� �ּ�
			Ƚ�� += multiMin(a, middle + 1, end); // �� �κ� ����Ƚ�����ּ�
			Ƚ�� += a[start].row * a[middle].col * a[end].col;
			if (Ƚ�� < �ּҰ�) {
				�ּҰ� = Ƚ��;
				middle����[start][end] = middle;
			}
		}
		return dpArr[start][end] = �ּҰ�;
	}

	static int multiMax(Matrix[] a, int start, int end) throws Exception {
		if (start == end)
			return 0;
		int �ִ밪 = 0;

		for (int middle = start; middle < end; middle++) {
			int Ƚ�� = multiMin(a, start, middle);// �� �κ� ����Ƚ���� �ּ�
			Ƚ�� += multiMin(a, middle + 1, end); // �� �κ� ����Ƚ�����ּ�
			Ƚ�� += a[start].row * a[middle].col * a[end].col;
			if (Ƚ�� > �ִ밪)
				�ִ밪 = Ƚ��;
		}
		return �ִ밪;
	}

	static String ��������(Matrix[] a, int start, int end) {
		int middle = middle����[start][end]; //s���� e���� ���� ȿ������ middle�� 
		if (start == end)//����� 1���̸� 
			return String.format("���(%d,%d)", a[start].row, a[start].col);
		return String.format("( %s * %s )", ��������(a, start, middle), ��������(a, middle + 1, end));
	}

	public static void main(String[] args) throws Exception {
//		Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50) };
//		System.out.println(multiMin(a, 0, a.length - 1));
	//	System.out.println(multiMax(a, 0, a.length - 1));

		Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50), new Matrix(50, 3),
				new Matrix(3, 8), new Matrix(8, 30) };
		System.out.println(multiMin(a, 0, a.length - 1));
		System.out.println(��������(a, 0, a.length - 1));
	}
}
