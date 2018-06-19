package dfs;
/*
 * 작성일 : 2018년 06월 19일 
 * 내 용 : BFS(Breadth-Frist-Search) 재귀함수로 구현 
 */
import java.util.HashMap;
import java.util.HashSet;

public class Example1_rec {
	// 그래프를 표현한 HashMap을 리턴하는 메소드
	public static HashMap<Character, String> createGraph() {
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "BFH"); // A 정점에 인접한 정점 목록 등록
		map.put('B', "ACEF"); // B 정점에 인접한 정점 목록 등록 
		map.put('C', "BDE"); 
		map.put('D', "CE"); 
		map.put('E', "BCD");
		map.put('F', "ABGH");
		map.put('G', "F"); 
		map.put('H', "AF"); 
		return map;
	}
	public static void DFS(HashMap<Character, String> 그래프, char 시작정점) {
		DFS(그래프, 시작정점, new HashSet<>());
	}
		
	public static void DFS(HashMap<Character,String> 그래프, char 현재정점, HashSet<Character> 방문한정점) { 
		방문한정점.add(현재정점);
		System.out.printf("%c", 현재정점);
		String 인접목록 = 그래프.get(현재정점);
		for(char 인접정점 : 인접목록.toCharArray()) {
			if(방문한정점.contains(인접정점)==false) {
				DFS(그래프, 인접정점, 방문한정점);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS(createGraph(),'A');
	}

}
