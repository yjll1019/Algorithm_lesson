package algorithmTask;
/*
 * 작성일 : 2018년 05월 29일
 * 작성자 : 이예지
 * 내 용 : txt파일을 읽어와 알파벳 기준으로 단어를 구분하여 총 단어의 수와 출현 횟수가 많은 단어 10개를 출력하는 프로그램 작성.(HashMap이용)
 */
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest {
	public static void main(String[] args) throws IOException {
	      // TODO Auto-generated method stub
		
		System.out.println("201632021 : 이예지");
		
	      int count=0, mapCount = 0;
	      Map<String,Integer> map = new HashMap<String, Integer>();
	      
	      
	      String filePath = "c:/shakespeare.txt";
	      Scanner scanner = new Scanner(Paths.get(filePath));
	      scanner.useDelimiter("[^a-zA-Z]+");
	      while(scanner.hasNext("[a-zA-Z]+")) {
	         String s = scanner.next().toLowerCase();
	         if(map.containsKey(s)) {//이미 단어(키)가 있으면
	            mapCount = map.get(s);//mapCount(값)를 올리고
	            map.put(s, mapCount+1);
	         }else {//단어가 없으면 
	            map.put(s, 1);//맵에 넣고 mapCount(값)
	         }
	         count++;

	      }
	      scanner.close();

	      System.out.println("총 단어 수 : "+count);
	      
	      
	      Collection<Integer> c = map.values();
	      Object[] a = c.toArray();
	      Arrays.sort(a);
	      Collections.reverse(Arrays.asList(a));
	      
	      for (int i = 0; i <= 9; i++) {
	         for (String key : map.keySet()) {
	            if (a[i].equals(map.get(key))) {
	               System.out.printf("단어: %s, 횟수: %d", key, map.get(key));
	               System.out.println();
	            }
	         }
	      }

	}
}
