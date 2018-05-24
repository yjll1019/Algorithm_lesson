package example3;

/*
 * �ۼ��� : 2018�� 05�� 23��
 * �� �� : �ؽ� ���̺��� ũ�� �ڵ� ���� ����.
 */
public class HashTableIncreaseSize {

	static class HashTable {

		static final int EMPTY = 0;
		static final int DELETED = -1;
		static final double A = 0.3758;

		int[] a;

		int count;
		int threshold;

		public HashTable() {
			this(32);
		}

		public HashTable(int size) {
			this.a = new int[size];
			this.count = 0;
			this.threshold = (int) (this.a.length * 0.7);// 70%�̻��� ���� �迭�� ũ�⸦ �ø�����.
		}

		private void resize() throws Exception {
			int newSize = a.length * 2;
			HashTable newTable = new HashTable(newSize);
			for (int i = 0; i < a.length; ++i) {
				if (a[i] != EMPTY && a[i] != DELETED)
					newTable.add(a[i]);
			}
			this.a = newTable.a;
			this.threshold = newTable.threshold;
		}

		// ������ ��ġ ��� ��� �� Multiplication Method
		private int getStartIndex(int value) {
			double fractionalPart = (value * A) % 1;
			return (int) (fractionalPart * this.a.length);
		}

		// �浹 �ذ� ��� �� DoubleHashing : ���Ե� ���� ���� ������ �ε����� �ٸ���.
		private static int getStepDistance(int value) {
			int r = 0;
			switch (value % 7) {
			case 0:
				r = 3;
				break;
			case 1:
				r = 5;
				break;
			case 2:
				r = 7;
				break;
			case 3:
				r = 11;
				break;
			case 4:
				r = 13;
				break;
			case 5:
				r = 17;
				break;
			case 6:
				r = 19;
				break;
			}
			return r;
		}

		public void add(int value) throws Exception {
			int startIndex = getStartIndex(value);
			int step = getStepDistance(value);
			int collisionCount = 0;

			do {
				int index = (startIndex + step * collisionCount) % a.length;
				if (a[index] == EMPTY || a[index] == DELETED) {
					a[index] = value;
					this.count++;
					if (this.count >= this.threshold)
						resize();
					return;
				} else if (a[index] == value)
					return;
				collisionCount++;
			} while (collisionCount < a.length);

		}

		public void remove(int value) {
			int startIndex = getStartIndex(value); // ó�� ���� ���� �ε���
			int step = getStepDistance(value);// �浹 �� �ǳ� �� ���� ���(���� ���� �ٸ���)
			int collisionCount = 0;

			do {
				int index = (startIndex + step * collisionCount) % a.length;
				if (a[index] == EMPTY || a[index] == DELETED)
					return;
				else if (a[index] == value) {
					a[index] = DELETED;
					this.count--;
					return;
				}
				collisionCount++;
			} while (collisionCount < a.length);
		}

		public boolean contains(int value) {
			int startIndex = getStartIndex(value);
			int step = getStepDistance(value);
			int collisionCount = 0;
			do {
				int index = (startIndex + step * collisionCount) % a.length;
				if (a[index] == EMPTY || a[index] == DELETED)
					return false;
				if (a[index] == value)
					return true;
				collisionCount++;
			} while (collisionCount < a.length);
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("HashTableIncreaseSize : �̿���");
		int maxValue = 200, maxCount = 10;
		HashTable hashTable = new HashTable();
		int[] data = { 4, 13, 144, 7, 9, 11, 44, 115, 107, 196 };
		for (int i = 0; i < data.length; ++i)
			hashTable.add(data[i]);

		for (int i = 1; i <= maxValue; ++i) {
			if (hashTable.contains(i))
				System.out.printf("%d ", i);
		}

		System.out.println();
		System.out.println("contains 100? " + hashTable.contains(100));

		hashTable.remove(11);
		hashTable.remove(44);
		hashTable.add(100);

		System.out.println();
		System.out.println("11,44���� / 100 ���� ��: ");

		for (int i = 1; i <= maxValue; ++i) {
			if (hashTable.contains(i))
				System.out.printf("%d ", i);
		}
		System.out.println();

		System.out.println("contains 100? " + hashTable.contains(100));

		for (int i = 1; i <= 100; i++) {
			hashTable.add(i * 3);
		}

		for (int i = 1; i <= maxValue; ++i) {
			if (hashTable.contains(i))
				System.out.printf("%d ", i);
		}

	}

}
