package example1;

/*
 * �ۼ��� : 2018�� 05�� 31��
 * ���� : Example1D ����.
 *      �ߺ��Ǵ� ���� ���� ��� ���� �迭�� �ε����� ���� �����Ѵ�. 
		���� �� 0�� �ƴ� -1�� �����Ѵ�.
 */
public class Example1D_2 {
	
	static class HashTable{
		static final int EMPTY = 0;
		static final int SIZE = 37;
		static final int DELETE = -1;
		int[] a;
		
		public HashTable() {
			a = new int[SIZE];
		}
		
		public void add(int value) throws Exception{
			int startIndex = value % SIZE;
			int count = 0;
			
			do {

				int index = (startIndex + count) % SIZE; //�浹�� ���� ĭ�� �����ϱ� ���ؼ� count�� �����ش�.
				if(a[index]==EMPTY || a[index]==DELETE) {
					a[index] = value; 
					return;
				}
				else if(a[index]==value) return; //�̹� ���� ��������� ����
				++count; // ���� �ε����� ��������� ��������� �ʰ� ����ִ� ���� �ְ����ϴ� ���� �ƴϸ� �浹�߻�

			}while(count<a.length); //�浹 �߻����� ���� �� ĭ�� �ڸ��� �Űܰ��鼭 ���� �ְ��� ������ �迭�� �� �� �ִ� ���. 
			throw new Exception("���� ����");
		}
		
		public void remove(int value) {
			int startIndex = value % SIZE;
			int count = 0;
			
			//���� �ִ� ���
			do {
				int index = (startIndex+count) % SIZE;
				 
				if(a[index]==EMPTY) return ; //EMPTY�� ��� �� �ڿ��� ã�� ���� ���ٴ� ���̹Ƿ� return
				//���⼭ DELETE�� �˻����� �ʴ� ���� : 8�� ���� �� �� �迭�� 4 -1 8 �̷��� ������ 8�� �ڿ� �ִµ��� ������ �ع����� ������.
				else if(a[index]==value) {
					a[index%SIZE] = DELETE; //���� �ִ� ��� ���� ����(-1�� �ٲ��ش�.)
					return;
				}
				count++;
			}while(count<a.length);	

		}
		
		public boolean contains(int value) {
			int startIndex = value % SIZE;
			int count = 0;
			do {
				int index = (startIndex + count)%SIZE;
				if(a[index]==EMPTY || a[index]==-1) return false;
				else if(a[index]==value) return true;
				++count;
			}while(count<a.length); //�浹 Ƚ���� �迭�� ���̺��� ũ�� false����
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Example1D : �̿���");
		
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();
   //     int[] data = {5,10,15,20,25,30,35,40};

        int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
        hashTable.remove(7);
        
        System.out.println("\n 7���� �� ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
        System.out.println("\n115 contians : "+hashTable.contains(115));
        System.out.println("1 contians : "+hashTable.contains(1));
        
        hashTable.remove(15);
        
        System.out.println("15 ���� �� : ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.print(i+" ");
        }
        
	}

}
