package pebble;

/*
 * �ۼ��� : 2018�� 06�� 14��
 * �ۼ��� : �̿���
 * �� �� : ���൹ ���� ����
 */
public class Example1 {
	static int[][] dpArr = new int[8][5];
	static int[][] a = { { 6, 7, 12, -5, 5, 3, 11, 3 },
						{ -8, 10, 14, 9, 7, 13, 8, 5 },
						{ 11, 12, 7, 4, 8, -2, 9, 4 } };

	static boolean ������������(int p1, int p2) {
		if(p1==p2) return false; //���� ���ϳ����� ���൹�� ���� �� ����!
		int[][] patterns = {{1,4},{3,4},{4,1},{4,3}}; //�Բ� �� �� ���� ����
		for(int i=0; i<patterns.length; ++i) {
			if(p1==patterns[i][0] && p2==patterns[i][1]) 
				return false;
		}
		return true;	
	}
	
	static int ������(int c, int p) throws Exception{
		switch(p) {
			case 1: return a[0][c]; //1������ ��� ù ��° ���� ���� �� ����
			case 2: return a[1][c];
			case 3: return a[2][c];
			case 4: return a[0][c] + a[2][c];
		}
		throw new Exception("invalid p:" + p);//�ش����� �ʴ� ������ ���� ���
	}
	
	static int ��ü����(int c, int p) throws Exception{
		System.out.println("["+c+"],"+"["+p+"]");
		if(dpArr[c][p]!=0) return dpArr[c][p];
		//c�� p���� �� ���� �ܰ迡���� ������� ���� ��,������ ������ ���ļ� ���� 
		if(c==0) return dpArr[c][p]=������(c,p); //0���� �� ���Ͽ� ���� ���� ����
		
		int ������_�ְ����� = Integer.MIN_VALUE;
		
		for(int q=1; q<=4; ++q) {
			if(������������(p,q)) { //���������� �����̸�
				int ���� = ��ü����(c-1,q); //c-1��p���ϱ����� ����
				if(���� > ������_�ְ�����) 
					������_�ְ����� = ����;
			}
		}
		return dpArr[c][p]=������_�ְ�����+������(c,p);
	}
	
	static int ��ü����(int c) throws Exception {
		//c������ for���� ���� ������ �����鼭 � �������� ���� ���� �ִ밪���� ���� �ִ����� ����.
		int �ְ����� = Integer.MIN_VALUE;
		for(int p=1; p<=4; ++p) {
			int ���� = ��ü����(c,p);
			if(���� > �ְ�����) �ְ����� = ����;
		}
		return �ְ�����;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(��ü����(7));
	}

}
