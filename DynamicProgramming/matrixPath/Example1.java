package matrixPath;
/*
 * �ۼ��� : 2018�� 06�� 14��
 * �ۼ��� : �̿���
 * �� �� : ����� ��� ����
 */

public class Example1 {
	static int[][] arr = {{6,7,12},
						{5,3,11},
						{7,17,3}};
	static int[][] dpArr = new int[3][3];
	static int count=0;
/********
	static int ����(int r, int c) {
		System.out.println("["+r+"]"+"["+c+"]");
		if(r==0 && c==0) return arr[r][c];
		else if(r>0 && c==0) return arr[r][c]+����(r-1,c);
		else if(r==0 && c>0) return arr[r][c]+����(r,c-1);
		else {
			return arr[r][c] + (arr[r-1][c]>arr[r][c-1]? ����(r,c-1): ����(r-1,c));
		}	//�ڵ��� ������ : ���� ���Ѱ� �ּҰ� �Ǵ� ��θ� ã�� ���̱� ������ ?���� ������ �� r,c��ġ������ ������ �Ǵ��ϱ⶧���� 
		//��� �Ǵ��� �ƴϴ�. ���� �߸��� �ڵ�!
	}
********/
	static int ����(int r, int c) {
		count++;
		System.out.println("["+r+"]"+"["+c+"]");
		if(dpArr[r][c]!=0) return dpArr[r][c];
		int �����ܰ����� = 0;
		if(r==0 && c==0) �����ܰ����� = 0;
		else if(r>0 && c==0) �����ܰ����� = ����(r-1,c);
		else if(r==0 && c>0) �����ܰ����� = ����(r,c-1);
		else 
			�����ܰ����� = Math.min(����(r-1,c), ����(r,c-1));
		dpArr[r][c] = arr[r][c] + �����ܰ�����; //arr[r,c]������ �ּ� ��� ����.
		return dpArr[r][c];
		
	}
	
	static void ������(int r,int c) {
		//System.out.println("("+r+","+c+")");
		if(r==0 && c==0) {
			System.out.println("(0,0)");
			return;
		}
		if(r==0 && c>0) {
			������(r,c-1);
			System.out.println("("+r+","+c+")");
		}
		if(r>0 && c==0) {
			������(r-1,c);
			System.out.println("("+r+","+c+")");
		}
		else {
			if(dpArr[r-1][c]>=dpArr[r][c-1]) {//r-1,c�� ��ΰ� r,c-1����� �������� ũ��
				//�迭�ȿ��� r,c��� ������ �ּҰ��� ����ֱ⶧���� �� ���� ���ؼ� ���� ������ ��� �̵�
				������(r,c-1);
				System.out.println("("+r+","+c+")");
			}
			else { 
				������(r-1,c);
				System.out.println("("+r+","+c+")");
			}
		}
	}
	

		static void ������2(int r,int c) {
			if(r==0&&c==0){
				System.out.println("("+r+","+c+")");
				return;
			}
			if(c==0 || (r>0&&dpArr[r-1][c]<=dpArr[r][c-1])){
				������(r-1,c);
				System.out.println("("+r+","+c+")");
			}
			else{
				System.out.println("("+r+","+c+")");
				������(r,c-1);
			}
		}
	

    public static void main(String[] args) throws Exception {
    	System.out.println(����(arr.length-1,arr.length-1));
    	System.out.println("count : "+count);
    	System.out.println("������ : ");
    	������(2,2);
    	System.out.println("������2 : ");
    	������2(2,2);
    }
}
