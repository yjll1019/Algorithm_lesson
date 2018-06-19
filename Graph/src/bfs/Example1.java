package bfs;
/*
 * �ۼ��� : 2018�� 06�� 19�� 
 * �� �� : BFS(Breadth-Frist-Search) �ݺ������� ����
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Example1 {
	
	//�׷����� ǥ����  HashMap�� �����ϴ� �޼ҵ� 
	public static HashMap<Character, String> createGraph(){
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "BCD"); // A ������ ������ ���� ��� ��� 
		map.put('B', "AC"); // B ������ ������ ���� ��� ���
		map.put('C', "ABDE");
		map.put('D', "ACFG");
		map.put('E', "C"); 
		map.put('F', "DGH");
		map.put('G', "DFH");
		map.put('H', "FG");
		return map;
	}
	
	public static void BFS(HashMap<Character, String> �׷���, char ��������) {
		HashSet<Character> �湮������ = new HashSet<>();
		Queue<Character> �������湮��������� = new LinkedList<Character>();
		
		�湮������.add(��������);
		�������湮���������.add(��������);
		
		//ť�� ��������
		while(�������湮���������.isEmpty()==false) {
			char �������� = �������湮���������.remove();
			System.out.printf("%c", ��������);
			String ����������� = �׷���.get(��������); //���������� �����Ǿ��ִ� �� ��ȯ
			for(char �������� : �����������.toCharArray()) {
				if(�湮������.contains(��������)==false) { //ť�� remove�ϱ⶧���� hashSet�̶� ��
					�湮������.add(��������);
					�������湮���������.add(��������);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS(createGraph(), 'A');
	}

}
