package example1;
/*
 * �ۼ��� : 2018�� 05�� 22��
 * ���� : Example1C ����.
 *      �ߺ��Ǵ� ���� ���� ��� ���� �迭�� �ε����� ���� �����Ѵ�. 
		���� �� 0�� �ƴ� -1�� �����Ѵ�.
 */
public class Example1D {
	
	static class HashTable{
		static final int EMPTY = 0;
		static final int SIZE = 37;
		int[] a;
		
		public HashTable() {
			a = new int[SIZE];
		}
		
		public void add(int value) throws Exception{
			int startIndex = value % SIZE;
			int count = 0;
			
			do {
				int index = (startIndex + count) % SIZE; //�浹�� ���� ĭ�� �����ϱ� ���ؼ� count�� �����ش�.
				if(a[index]==EMPTY || a[index]==-1) {
					a[index] = value; 
					return;
				}
				else if(a[index]==value) return; //�̹� ���� ��������� ����
				++count; // ���� �ε����� ��������� ��������� �ʰ� ����ִ� ���� �ְ����ϴ� ���� �ƴϸ� �浹�߻�
			}while(count<a.length); //�浹 �߻����� ���� �� ĭ�� �ڸ��� �Űܰ��鼭 ���� �ְ��� ������ �迭�� �� �� �ִ� ���. 
			throw new Exception("���� ����");
		}
		
		public void remove(int value) {
			if(this.contains(value)==false) return; //���� ���� ���
			
			int startIndex = value % SIZE;
			int count = 0;
			
			//���� �ִ� ���
			do {
				int index = (startIndex+count) % SIZE;
				 
				if(a[index%SIZE]==value) {
					a[index%SIZE] = -1; //���� �ִ� ��� ���� ����(-1�� �ٲ��ش�.)
					return;
				}
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

        int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
        
        hashTable.remove(7);
        
        System.out.println("�� ���� �� ");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
	}

}
