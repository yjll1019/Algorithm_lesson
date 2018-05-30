package algorithmTask;
/*
 * 작성일 : 2018년 05월 29일
 * 작성자 : 이예지
 * 내 용 : txt파일을 읽어와 알파벳 기준으로 단어를 구분하여 총 단어의 수와 출현 횟수가 많은 단어 10개를 출력하는 프로그램 작성.(ArrayList이용)
 */
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
 
class WordInfoComparator implements Comparator<WordInfo>{
	
	@Override
	public int compare(WordInfo w1, WordInfo w2) {
		int r = w2.count-w1.count;
		if(r!=0) return r;
		return w2.word.compareTo(w1.word);
	}
}

public class WordInfo {

	String word;
	int count;

	public WordInfo(String word) {
		this.word = word;
		this.count = 1;
	}
	
	@Override
	public String toString() {
		return String.format("단어 : %s, 횟수: %d \n",word, count);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("201632021 : 이예지");
		
		ArrayList<WordInfo> list = new ArrayList<WordInfo>();
		String filePath = "c:/shakespeare.txt";
		boolean result = false;
		int count = 0;
		Scanner scan = new Scanner(Paths.get(filePath));
		scan.useDelimiter("[^a-zA-Z]+");
		while(scan.hasNext("[a-zA-Z]+")) {
			String s = scan.next().toLowerCase();
			
			WordInfo info = new WordInfo(s);
			
			result = false;
			
			if(list.size()==0) {
				list.add(info);
			}
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).word.equals(s)) { //ArrayList에 s 값이 존재할 경우
					info = list.get(i);
					info.count++;
					list.set(i, info);
					count++;
					result = true;
					break;
				}
			}
			if(!result) { //s값이 존재하지 않을 경우.
					list.add(info);
					count++;
			}
			
		}
		
		
		WordInfo[] info = list.toArray(new WordInfo[] {});
		Arrays.sort(info, new WordInfoComparator());
		list = new ArrayList<WordInfo>(Arrays.asList(info));

		System.out.println("총 단어 수 : "+count);
		
		for(int i=0; i<=9; i++) {
			System.out.println(list.get(i).toString());
		}
		
		
	}

}
