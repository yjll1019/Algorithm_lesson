package lesson01;
/*
 * �ۼ����� : 2018�� 03�� 18��
 * �� �� : ���ȣ�� ����.
 */
public class Example6 {

	static void print(int [] arr, int index) {
		//���ȣ���� �̿��� �迭�� ���� ����ϴ� �޼ҵ� print
		if(index >= arr.length) return; //���� ����.
		System.out.printf("%d ", arr[index]); //���� �ܰ�. 
		print(arr,index+1);//���� �ܰ� ��� ȣ��.
	}
	
	static int sum(int n) {
		//1���� n������ �հ踦 ����ϴ� �޼ҵ� sum
		if(n<1) return 0;
		return n+sum(n-1); 
	}
	//<=1�� ó���ϰԵǸ� ���࿡ 0�� ���ͼ� ���Ǹ� 1�� �Ǳ⶧����.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Example6 : �̿���");
		System.out.println();
		
		int [] a = {1,2,3,4,5,6,7,8,9};
		System.out.print("print�޼ҵ� ��� ��� : ");
		print(a, 0);
		
		System.out.println();
		System.out.printf("sum�޼ҵ� ��� ��� : %d", sum(3));
	}

}
