package task;

import java.util.Scanner;

/*
 * 작성일자 : 2018년 03월 10일
 * 내 용 : 재귀 호출을 이용해서 binaryTree add메소드를 구현한다.
 */

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("재귀호출을 이용한 이진트리 add메소드");
	
		BinaryTree t = new BinaryTree();
		Scanner input = new Scanner(System.in);
		
		int num;
			
			do {
			System.out.println();
			System.out.println("메뉴 번호를 입력하세요.");
			System.out.println("1. 출력  2. 추가  3.종료");
			num = input.nextInt();
			
				switch(num) {
				case 1: System.out.println("중위 순회를 시작합니다.");
						t.print();
				break;
				case 2: System.out.println("추가할 정수를 입력해주세요.");
						int value = input.nextInt();
						t.add(value);
				break;
				case 3: System.out.println("프로그램을 종료합니다.");			
				break;
				default : System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
				break;
				}
			
			}	while(num!=3);
		
	}

}
