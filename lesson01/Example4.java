package lesson01;

/*
 * �ۼ����� : 2018�� 03�� 18�� �Ͽ���
 * �� �� : �ݺ���, ���ȣ���� �̿��� Node��ü �߰�
 */
public class Example4 {

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
		
		public void addTail(int value) {
			//�ݺ��� �̿�
			Node p = this;
			while(p.next!=null) {
				p = p.next;
			}
			p.next = new Node(value,null);
		}
		
		public void addTailRecursive(int value) {
			//���ȣ�� �̿�
			
			if(this.next!=null) this.next.addTailRecursive(value);
			else this.next = new Node(value, null);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exapmle4 : �̿���");
		
		Node root = new Node(0, null);
		
		for(int i=1; i<=10; ++i) {
			root.addTail(i);
		}
		
		System.out.print("addTail�޼ҵ� ȣ�� ���: ");
		root.printAll();
		
		System.out.println();
		
		Node root2 = new Node(0,null);
		
		System.out.print("addTailRecursive�޼ҵ� ȣ�� ���: ");
		
		for(int i=1; i<=10; ++i) {
			root2.addTailRecursive(i);
		}
		
		root2.printAll();
	}

}
