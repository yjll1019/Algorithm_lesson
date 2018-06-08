package task;

public class BinaryTree {
	private Node node;
	
	class Node{
		int num;
		Node leftChild = null;
		Node rightChild = null;
	}
	
	public BinaryTree() {
		
	}
	
	public void print() {
		if(this.node==null) {
			System.out.println("비어있는 트리입니다.");
		}else {
		printTree(this.node);
		}
	}
	
	private void printTree(Node p) {
			
			System.out.print(p.num+" ");
			if(p.leftChild!=null) {
				printTree(p.leftChild);
			}
			if(p.rightChild!=null) {
				printTree(p.rightChild);
			}
		
	}
	
	public void add(int value) {
		addTree(value, this.node);
	}
	
	private void addTree(int value, Node p) {
		Node n = new Node();
		n.num = value;
		if(p==null) {
			p = new Node();
			p.num = value;
		}
		else {
			if(value == p.num) {
				System.out.println("이미 존재하는 값입니다.");
			}	
			else if(value < p.num) {//lefhChild
				if(p.leftChild==null) {
					p.leftChild=n;
				}
				else {
					addTree(value, p.leftChild);
				}
			}
			else if(value > p.num) {
				if(p.rightChild == null) {
					p.rightChild = n;
				}
				else {
					addTree(value, p.rightChild);
				}
			}
		}
		this.node = p;
	}
}
