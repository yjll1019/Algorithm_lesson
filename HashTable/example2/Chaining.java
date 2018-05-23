package example2;

/*
 * 작성일 : 2018년 05월 23일
 * 내 용 : HashTable의 충돌을 해결하는 방법 중 Chaining 방법
 * 		저장할 데이터를 링크드 리스트에 등록한다.
 */

public class Chaining {
	
	static class Node{
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		static Node remove(Node node, int value) {
			if(node == null) return null;
			if(node.value == value) return node.next;
			node.next = remove(node.next, value);
			return node; //값이 없는 경우
		}
	
		static boolean contains(Node node, int value) {
			if(node == null) return false;
			if(node.value == value) return true;
			return contains(node.next, value);
		}
	}
	
	static class HashTable{
		static final int SIZE = 37;
		Node[] a;
		
		public HashTable() {
			a = new Node[SIZE];
		}
		
		public void add(int value) throws Exception{
			int index = value%SIZE;
			a[index] = new Node(value, a[index]); //들어가 있었던 원소들이 뒤로 밀려남.
		}
		
		public void remove(int value) {
			int index = value % SIZE;
			a[index] = Node.remove(a[index], value);
		}
		
		public boolean contains(int value) {
			int index = value % SIZE;
			return  Node.contains(a[index], value);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();

        int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };

        for(int i=0; i<data.length; ++i) {
        	hashTable.add(data[i]);
        }
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
        
        hashTable.remove(11);
        hashTable.remove(44);
        
        hashTable.add(100);
        
        System.out.println("11,44삭제 & 100 삽입 후 :");
        
        for(int i=1; i<=maxValue; ++i) {
        	if(hashTable.contains(i))
        		System.out.println(i);
        }
        
       System.out.println("contains(100) : "+hashTable.contains(100));
       System.out.println("contains(1000) : "+hashTable.contains(1000));
	}

}
