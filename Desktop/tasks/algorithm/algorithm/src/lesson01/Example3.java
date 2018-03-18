package lesson01;
/*
 * �ۼ����� : 2018�� 03�� 18��
 * �� �� : �ݺ����� ���ȣ���� �̿��� Node���.
 */
public class Example3 {
	
	static class Node{
		int value;
		Node next;
		
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public void printAll() {
			//�ݺ����� �̿��ؼ� ���
			Node p = this;
			while(p!=null) {
				System.out.printf("%d ", p.value);
				p = p.next;
			}
		
		}
		
		public void printAllRecursive(Node p) {
			//��� ȣ���� �̿��ؼ� ���.
			
			if(p==null) return;
			System.out.printf("%d ", p.value);
			printAllRecursive(p.next);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Example3: �̿���");
		Node root = null;
		for(int i=1; i<=10; ++i) {
			root = new Node(i, root);
		}
		
		System.out.print("printAll()�޼ҵ� : ");
		root.printAll();
		System.out.println();
		
		System.out.print("printAllRecursive()�޼ҵ� : ");
		root.printAllRecursive(root);
		
	}

}
