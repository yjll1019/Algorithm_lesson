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
		
		public void printAllRecursive() {
			//�Ű����� ���� ��� ȣ���� �̿��ؼ� ���.>> �� 
			
			if(this.next==null) {
				System.out.printf("%d ", this.value);
				return ;
			}
			System.out.printf("%d ", this.value);
			this.next.printAllRecursive();
		}
		
		public void printAllRecursive2() {
			//�Ű����� ���� ��� ȣ���� �̿��ؼ� ���. >> ������
			System.out.printf("%d ", this.value);
			if(this.next!=null) this.next.printAllRecursive2();
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
		root.printAllRecursive();
		
		System.out.println();
		System.out.print("printAllRecursive2()�޼ҵ� : ");
		root.printAllRecursive();
		
		
	}

}
