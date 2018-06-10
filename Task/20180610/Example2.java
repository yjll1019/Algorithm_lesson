package algorithmTask2;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * �ۼ��� : 2018�� 6�� 10��
 * �� �� : WordInfo Ŭ������, ArrayList<WordInfo> Ŭ������ �̿��ؼ� �ܾ� ����� �����ϱ�.
		�ܾ� ��Ͽ��� �ܾ ã�� �۾��� ���� Ž������ �����ϱ�. >> ���� Ž�� �̿� 
 */
class WordInfoComparator implements Comparator<WordInfo>{
	
	@Override
	public int compare(WordInfo w1, WordInfo w2) {
		int r = w2.word.compareTo(w1.word);
		if(r!=0) return r;
		return w2.count-w1.count;
	}
}


public class Example2 {
    static final String �ؽ�Ʈ���� = "c:/shakespeare.txt";

    static String getWord(Reader reader) throws IOException { // �ؽ�Ʈ ���Ͽ��� �ܾ �ϳ��� �о �����Ѵ�
        int ch;
        StringBuilder builder = new StringBuilder();  // ���ĺ� ���� �ϳ��� �߰��Ͽ� �ܾ ������ ��ü
        while ((ch = reader.read()) != -1) {  // ���Ͽ��� ���ڸ� �ϳ��� �д´�. ���� ���ڰ� -1 �̸� ������ ���̴�.
            if (Character.isAlphabetic(ch))   // ���� ���ڰ� ���ĺ��̸�
                builder.append((char)ch);     // ���ڸ� �ܾ �߰��Ѵ�
            else                                 // ���� ���ڰ� ���ĺ��� �ƴϸ�
                if (builder.length() > 0) break; // ä���� ���ĺ� ���ڰ� �ִٸ�, �� �ܾ �����ϱ� ���� break �Ѵ�
        }
        if (builder.length() > 0) return builder.toString(); // ä���� ���ĺ� ���ڰ� �ִٸ�, �� �ܾ �����Ѵ�.
        else return null; // ä���� ���ĺ� ���ڰ� ���ٸ�, null�� �����Ѵ�. ������ ������ null�� �����ϰ� �ȴ�.
    }

    static WordInfo findWord(ArrayList<WordInfo> list, String word) { // WordInfo ��Ͽ��� �ܾ ã�Ƽ� �����Ѵ�
    	//���� Ž�� >> list�ű�� > word���� ���� �յڷ� Ž�� >> ����
    	Collections.sort(list, new WordInfoComparator());
    	
    	if(list.size()==0) return null;
    	int start = 0;
    	int end = list.size()-1;
    	
    	while(start<=end) {
    		int middle = (start+end)/2;
    		if(list.get(middle).word.compareTo(word)==0) {
    			return list.get(middle);
    		}
    		else if(list.get(middle).word.compareTo(word)>0) {
    			end = middle-1;
    		}
    		else if(list.get(middle).word.compareTo(word)<0) {
    			//�� �� ã�� ��
    			start = middle+1;
    		}
    	}
    	return null;
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

    
    public static void main(String[] args) throws Exception {
    	System.out.println("201632021: �̿���");
        BufferedReader reader = new BufferedReader(new FileReader(�ؽ�Ʈ����));
        ArrayList<WordInfo> a = new ArrayList<WordInfo>(); // WordInfo�� ������ ArrayList ��ü ����
        String word;
        while ( (word = getWord(reader)) != null) { // �ؽ�Ʈ ���Ͽ��� �ܾ �ϳ��� �о�´�
            word = word.toLowerCase();              // �ܾ �ҹ��ڷ� ��ȯ�Ѵ�
            WordInfo wordInfo = findWord(a, word); // WordInfo ��Ͽ��� word�� ã�´�
            if (wordInfo != null)
                wordInfo.count++;                  // ã������ ++count
            else
                a.add(new WordInfo(word, 1));   // ��ã������ �� �ܾ� ���
        }

        selectionSort(a); // WordInfo �迭�� count ������������ �����Ѵ�.
        for (int i = 0; i < 10; ++i) // ���� 10 �� �ܾ� ���
            System.out.printf("%s %d\n", a.get(i).word, a.get(i).count);
    }
}
