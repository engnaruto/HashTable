package test;

import java.util.Random;

import hash.table.*;

public class test {
	public static void rehashingTest(HashTable<Integer, String> hashTable) {

		int numOfKeys = 1201;
		Random r = new Random();

		for (int i = 0; i < numOfKeys; i++) {
			int key = r.nextInt(10000);
			while (hashTable.contains(key)) {
				key = r.nextInt();
			}
			String value = key + "";
			hashTable.put(key, value);
		}
		System.out.println("#of elements = " + hashTable.size());
	}

	public static void hashTableTest(HashTable<Integer, String> hashTable) {
		hashTable.put(1, "A");
		hashTable.put(111, "A");
		hashTable.put(1111, "A");
		hashTable.put(111111, "A");
		hashTable.put(11111111, "A");
		hashTable.put(11, "A");
		hashTable.put(11, "B");
		hashTable.put(2, "B");
		hashTable.put(3, "C");
		hashTable.put(4, "D");
		hashTable.put(0, "E");
		hashTable.put(6, "F");

		System.out.println(hashTable.contains(11));
		System.out.println(hashTable.contains(0));
		System.out.println(hashTable.contains(2));
		System.out.println(hashTable.contains(3));
		System.out.println(hashTable.contains(5));
		hashTable.delete(11);
		System.out.println(hashTable.contains(11));

	}

	public static void main(String[] args) {
		System.out.println("Separate Chaining HashTable Test");
		HashTable<Integer, String> scHashTable = new SeparateChainingHashTable<Integer, String>();
		// hashTableTest(scHashTable);
		rehashingTest(scHashTable);

		// System.out.println("Bucketing HashTable Test");
		// HashTable<Integer, String> bHashTable = new
		// BucketingHashTable<Integer, String>();
		// hashTableTest(bHashTable);
		// System.out.println("Linear Probing HashTable Test");
		// HashTable<Integer, String> lpHashTable = new
		// LinearProbingHashTable<Integer, String>();
		// hashTableTest(lpHashTable);
		// System.out.println("Quadratic Probing HashTable Test");
		// HashTable<Integer, String> qpHashTable = new
		// QuadraticProbingHashTable<Integer, String>();
		// hashTableTest(qpHashTable);
		// System.out.println("Pseudo Random Probing HashTable Test");
		// HashTable<Integer, String> prpHashTable = new
		// PseudoRandomProbingHashTable<Integer, String>();
		// hashTableTest(prpHashTable);
		// System.out.println("Double Hashing HashTable Test");
		// HashTable<Integer, String> dhHashTable = new
		// DoubleHashingHashTable<Integer, String>();
		// hashTableTest(dhHashTable);
	}
}
