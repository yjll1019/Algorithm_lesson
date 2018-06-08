package task;
/*
 * 작성일 : 2018년 04워 01일
 * 내 용 : 제네릭 클래스 연습 (과제)
 */
public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("task_GenericTest : 이예지");
		
		Generic<String> s = new Generic<String>(3);
		s.put("yj");
		System.out.println("s[0] : "+s.get(0));
		s.put("tiber");
		System.out.println("s[1] : "+s.get(1));
		System.out.println("s[2] : "+s.get(2));
		
		Generic<Integer> i = new Generic<Integer>(4);
		i.put(0);
		System.out.println("i[0] : "+i.get(0));
		i.put(100);
		System.out.println("i[1] : "+i.get(1));
	}

}
