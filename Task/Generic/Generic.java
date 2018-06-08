package task;
/*
 * 작성일 : 2018년 04워 01일
 * 내 용 : 제네릭 클래스 연습 (과제)
 */
public class Generic <T>{
	private T[] arr;
	int count = 0;
	
	public Generic(int size) {
		arr = (T[]) new Object[size];
	}

	public T get(int index) {
		return arr[index];
	}

	public void put(T value) {
		arr[count++] = value;
	}
	
	
}