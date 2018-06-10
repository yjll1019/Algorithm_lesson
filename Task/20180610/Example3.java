package algorithmTask3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/*
 * 작성일 : 2018년 6월 10일
 * 내 용 : WordInfo 클래스와, ArrayList<WordInfo> 클래스를 이용해서 단어 목록을 구현하기.
		단어 목록에서 단어를 찾는 작업을 이진 탐색으로 구현하기. >> 이진 탐색 트리 이용 
 */

class Node {
	WordInfo value;
	Node left;
	Node right;

	public Node(WordInfo w) {
		value = w;
		this.left = null;
		this.right = null;
	}

	public void add(WordInfo wordInfo) {
		if (this.value.word.compareTo(wordInfo.word) < 0) {
			if (left == null)
				left = new Node(wordInfo);
			else
				left.add(wordInfo);
		} else if (this.value.word.compareTo(wordInfo.word) > 0) {
			if (right == null)
				right = new Node(wordInfo);
			else
				right.add(wordInfo);
		}
	}

	public WordInfo contains(WordInfo wordInfo) {
		if (this.value.word.compareTo(wordInfo.word) < 0) {
			if (left != null) {
				return left.contains(wordInfo);
			}
			return null;
		} else if (this.value.word.compareTo(wordInfo.word) > 0) {
			if (right != null) {
				return right.contains(wordInfo);
			}
			return null;
		}
		return this.value;
	}

}

public class Example3 {
	static final String 텍스트파일 = "c:/shakespeare.txt";
	
	static String getWord(Reader reader) throws IOException { // 텍스트 파일에서 단어를 하나씩 읽어서 리턴한다
		int ch;
		StringBuilder builder = new StringBuilder(); // 알파벳 문자 하나씩 추가하여 단어를 생성할 객체
		while ((ch = reader.read()) != -1) { // 파일에서 문자를 하나씩 읽는다. 읽은 문자가 -1 이면 파일의 끝이다.
			if (Character.isAlphabetic(ch)) // 읽은 문자가 알파벳이면
				builder.append((char) ch); // 문자를 단어에 추가한다
			else // 읽은 문자가 알파벳이 아니면
			if (builder.length() > 0)
				break; // 채워진 알파벳 문자가 있다면, 그 단어를 리턴하기 위해 break 한다
		}
		if (builder.length() > 0)
			return builder.toString(); // 채워진 알파벳 문자가 있다면, 그 단어를 리턴한다.
		else
			return null; // 채워진 알파벳 문자가 없다면, null을 리턴한다. 파일의 끝에서 null을 리턴하게 된다.
	}


	static void swap(ArrayList<WordInfo> a, int i, int j) {
		WordInfo temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}

	static int findMin(ArrayList<WordInfo> a, int start) {
		WordInfo minValue = a.get(start);
		int minIndex = start;
		for (int i = start + 1; i < a.size(); ++i) {
			if (a.get(i).word.compareTo(minValue.word)>0) {
				minValue = a.get(i);
				minIndex = i;
			}
		}
		return minIndex;
	}

	static void selectionSort(ArrayList<WordInfo> a) { 
		for (int i = 0; i < a.size() - 1; ++i) {
			int minIndex = findMin(a, i); 
			swap(a, i, minIndex);
		}
	}

	static WordInfo findWord(ArrayList<WordInfo> list, String word) { // WordInfo 목록에서 단어를 찾아서 리턴한다
		// list를 Node로 옮긴다. Node 탐색
		Node nodeList = null;
		if (list.size() == 0) {
			System.out.println("findeWord하는중");
			return null;
		} else {
			nodeList = new Node(list.get(0));
			for (int i = 1; i < list.size(); ++i) {
				nodeList.add(list.get(i));
			}

			return nodeList.contains(new WordInfo(word, 1));
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("이예지");
		BufferedReader reader = new BufferedReader(new FileReader(텍스트파일));
		ArrayList<WordInfo> a = new ArrayList<WordInfo>(); // WordInfo를 저장할 ArrayList 객체 생성
		String word;
		while ((word = getWord(reader)) != null) { // 텍스트 파일에서 단어를 하나씩 읽어온다
			word = word.toLowerCase(); // 단어를 소문자로 변환한다
			WordInfo wordInfo = findWord(a, word); // WordInfo 목록에서 word를 찾는다
			if (wordInfo != null)
				wordInfo.count++; // 찾았으면 ++count
			else
				a.add(new WordInfo(word, 1)); // 못찾았으면 새 단어 등록
		}

		selectionSort(a); // WordInfo 배열을 count 내림차순으로 정렬한다.

		for (int i = 0; i < 10; ++i) // 선두 10 개 단어 출력
			System.out.printf("%s %d\n", a.get(i).word, a.get(i).count);

		System.out.println("끝");
	}
}
