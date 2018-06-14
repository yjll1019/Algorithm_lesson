package matrixchain;

public class Example1 {
	static int[][] dpArr;
	
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
		if(dpArr==null) dpArr=new int[a.length][a.length];
		if(dpArr[start][end]!=0) return dpArr[start][end];
		
		int ÃÖ¼Ò°ª = Integer.MAX_VALUE;
		
		for (int middle = start; middle < end; middle++) {
			int È½¼ö = multiMin(a, start, middle);// ¾Õ ºÎºÐ °ö¼ÀÈ½¼öÀÇ ÃÖ¼Ò
			È½¼ö += multiMin(a, middle + 1, end); // µÞ ºÎºÐ °ö¼ÀÈ½¼öÀÇÃÖ¼Ò
			È½¼ö += a[start].row * a[middle].col * a[end].col;
			if (È½¼ö < ÃÖ¼Ò°ª)
				ÃÖ¼Ò°ª = È½¼ö;
		}
		return dpArr[start][end]=ÃÖ¼Ò°ª;
	}

	static int multiMax(Matrix[] a, int start, int end) throws Exception {
		if (start == end) return 0;
		int ÃÖ´ë°ª = 0;

		for (int middle = start; middle < end; middle++) {
			int È½¼ö = multiMin(a, start, middle);// ¾Õ ºÎºÐ °ö¼ÀÈ½¼öÀÇ ÃÖ¼Ò
			È½¼ö += multiMin(a, middle + 1, end); // µÞ ºÎºÐ °ö¼ÀÈ½¼öÀÇÃÖ¼Ò
			È½¼ö += a[start].row * a[middle].col * a[end].col;
			if (È½¼ö > ÃÖ´ë°ª) ÃÖ´ë°ª = È½¼ö;
		}
		return ÃÖ´ë°ª;
	}
	
	public static void main(String[] args) throws Exception {
		Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50) }; 
		System.out.println(multiMin(a, 0, a.length-1)); 
		System.out.println(multiMax(a, 0, a.length-1));
	}
}
