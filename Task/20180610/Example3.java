package algorithmTask3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/*
 * �ۼ��� : 2018�� 6�� 10��
 * �� �� : WordInfo Ŭ������, ArrayList<WordInfo> Ŭ������ �̿��ؼ� �ܾ� ����� �����ϱ�.
		�ܾ� ��Ͽ��� �ܾ ã�� �۾��� ���� Ž������ �����ϱ�. >> ���� Ž�� Ʈ�� �̿� 
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
	static final String �ؽ�Ʈ���� = "c:/shakespeare.txt";
	
	static String getWord(Reader reader) throws IOException { // �ؽ�Ʈ ���Ͽ��� �ܾ �ϳ��� �о �����Ѵ�
		int ch;
		StringBuilder builder = new StringBuilder(); // ���ĺ� ���� �ϳ��� �߰��Ͽ� �ܾ ������ ��ü
		while ((ch = reader.read()) != -1) { // ���Ͽ��� ���ڸ� �ϳ��� �д´�. ���� ���ڰ� -1 �̸� ������ ���̴�.
			if (Character.isAlphabetic(ch)) // ���� ���ڰ� ���ĺ��̸�
				builder.append((char) ch); // ���ڸ� �ܾ �߰��Ѵ�
			else // ���� ���ڰ� ���ĺ��� �ƴϸ�
			if (builder.length() > 0)
				break; // ä���� ���ĺ� ���ڰ� �ִٸ�, �� �ܾ �����ϱ� ���� break �Ѵ�
		}
		if (builder.length() > 0)
			return builder.toString(); // ä���� ���ĺ� ���ڰ� �ִٸ�, �� �ܾ �����Ѵ�.
		else
			return null; // ä���� ���ĺ� ���ڰ� ���ٸ�, null�� �����Ѵ�. ������ ������ null�� �����ϰ� �ȴ�.
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

	static WordInfo findWord(ArrayList<WordInfo> list, String word) { // WordInfo ��Ͽ��� �ܾ ã�Ƽ� �����Ѵ�
		// list�� Node�� �ű��. Node Ž��
		Node nodeList = null;
		if (list.size() == 0) {
			System.out.println("findeWord�ϴ���");
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
		System.out.println("�̿���");
		BufferedReader reader = new BufferedReader(new FileReader(�ؽ�Ʈ����));
		ArrayList<WordInfo> a = new ArrayList<WordInfo>(); // WordInfo�� ������ ArrayList ��ü ����
		String word;
		while ((word = getWord(reader)) != null) { // �ؽ�Ʈ ���Ͽ��� �ܾ �ϳ��� �о�´�
			word = word.toLowerCase(); // �ܾ �ҹ��ڷ� ��ȯ�Ѵ�
			WordInfo wordInfo = findWord(a, word); // WordInfo ��Ͽ��� word�� ã�´�
			if (wordInfo != null)
				wordInfo.count++; // ã������ ++count
			else
				a.add(new WordInfo(word, 1)); // ��ã������ �� �ܾ� ���
		}

		selectionSort(a); // WordInfo �迭�� count ������������ �����Ѵ�.

		for (int i = 0; i < 10; ++i) // ���� 10 �� �ܾ� ���
			System.out.printf("%s %d\n", a.get(i).word, a.get(i).count);

		System.out.println("��");
	}
}
