package bfs;
/*
 * 작성일 : 2018년 06월 19일 
 * 내 용 : BFS(Breadth-Frist-Search) 반복문으로 구현
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Example1 {
	
	//그래프를 표현한  HashMap을 리턴하는 메소드 
	public static HashMap<Character, String> createGraph(){
		HashMap<Character, String> map = new HashMap<>();
		map.put('A', "BCD"); // A 정점에 인접한 정점 목록 등록 
		map.put('B', "AC"); // B 정점에 인접한 정점 목록 등록
		map.put('C', "ABDE");
		map.put('D', "ACFG");
		map.put('E', "C"); 
		map.put('F', "DGH");
		map.put('G', "DFH");
		map.put('H', "FG");
		return map;
	}
	
	public static void BFS(HashMap<Character, String> 그래프, char 시작정점) {
		HashSet<Character> 방문한정점 = new HashSet<>();
		Queue<Character> 다음에방문할정점목록 = new LinkedList<Character>();
		
		방문한정점.add(시작정점);
		다음에방문할정점목록.add(시작정점);
		
		//큐가 빌때까지
		while(다음에방문할정점목록.isEmpty()==false) {
			char 현재정점 = 다음에방문할정점목록.remove();
			System.out.printf("%c", 현재정점);
			String 인접정점목록 = 그래프.get(현재정점); //현재정점과 인접되어있는 점 반환
			for(char 인접정점 : 인접정점목록.toCharArray()) {
				if(방문한정점.contains(인접정점)==false) { //큐는 remove하기때문에 hashSet이랑 비교
					방문한정점.add(인접정점);
					다음에방문할정점목록.add(인접정점);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS(createGraph(), 'A');
	}

}
