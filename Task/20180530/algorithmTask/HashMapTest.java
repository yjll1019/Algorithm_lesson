package algorithmTask;
/*
 * �ۼ��� : 2018�� 05�� 29��
 * �ۼ��� : �̿���
 * �� �� : txt������ �о�� ���ĺ� �������� �ܾ �����Ͽ� �� �ܾ��� ���� ���� Ƚ���� ���� �ܾ� 10���� ����ϴ� ���α׷� �ۼ�.(HashMap�̿�)
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
		
		System.out.println("201632021 : �̿���");
		
	      int count=0, mapCount = 0;
	      Map<String,Integer> map = new HashMap<String, Integer>();
	      
	      
	      String filePath = "c:/shakespeare.txt";
	      Scanner scanner = new Scanner(Paths.get(filePath));
	      scanner.useDelimiter("[^a-zA-Z]+");
	      while(scanner.hasNext("[a-zA-Z]+")) {
	         String s = scanner.next().toLowerCase();
	         if(map.containsKey(s)) {//�̹� �ܾ�(Ű)�� ������
	            mapCount = map.get(s);//mapCount(��)�� �ø���
	            map.put(s, mapCount+1);
	         }else {//�ܾ ������ 
	            map.put(s, 1);//�ʿ� �ְ� mapCount(��)
	         }
	         count++;

	      }
	      scanner.close();

	      System.out.println("�� �ܾ� �� : "+count);
	      
	      
	      Collection<Integer> c = map.values();
	      Object[] a = c.toArray();
	      Arrays.sort(a);
	      Collections.reverse(Arrays.asList(a));
	      
	      for (int i = 0; i <= 9; i++) {
	         for (String key : map.keySet()) {
	            if (a[i].equals(map.get(key))) {
	               System.out.printf("�ܾ�: %s, Ƚ��: %d", key, map.get(key));
	               System.out.println();
	            }
	         }
	      }

	}
}
