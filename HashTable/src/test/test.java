package test;

import java.util.Arrays;
import java.util.Random;

import hash.table.*;

public class test {

	public static String generateString(int length) {
		Random rng = new Random();
		String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] text = new char[rng.nextInt(length) + 1];
		for (int i = 0; i < text.length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static int generateIntger(int length) {
		Random rng = new Random();
		return rng.nextInt(length);
	}

	public static void rehashingTest(HashTable<Integer, String> hashTable,
			int hashNum) {
		// double time = System.currentTimeMillis();
		int numOfKeys = 100000;
		// Random r = new Random();
		int[] keys = new int[numOfKeys];
		for (int i = 0; i < numOfKeys; i++) {
			int key = generateIntger(1999999999);
			String value = generateString(20);
			hashTable.put(key, value);
			keys[i] = key;
		}

		// for (int i = 0; i < numOfKeys; i++) {
		// if (!hashTable.contains(keys[i])) {
		// // System.out.println(hashTable.contains(keys[i]));
		// System.out.println(false);
		// }
		// }
		// for (int i = 0; i < numOfKeys; i++) {
		// hashTable.delete(keys[i]);
		// }
		// for (int i = 0; i < numOfKeys; i++) {
		// if (hashTable.contains(keys[i])) {
		// // System.out.println(hashTable.contains(keys[i]));
		// System.out.println(true);
		// }
		// }
		//
		// // for (int i : hashTable.keys()) {
		// // System.out.println(hashTable.get(i));
		// // }
		// double timee = System.currentTimeMillis();
		// timee-=time;
		System.out.println("Number of elements = " + hashTable.size()
				+ hashTable.toString() + "\nMemory Used = " + getMemoryUsed()
				+ " MB");
		String collisions[] = hashTable.toString().split(" ");
		Arrays.toString(collisions);
		collision[hashNum] += Integer
				.parseInt(collisions[collisions.length - 1]);
		// + "\nTime Used = " + timee);
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

	public static double getMemoryUsed() {
		runtime.gc();
		double memory = runtime.totalMemory() - runtime.freeMemory();
		memory /= 1024;
		memory /= 1024;
		return memory;
	}

	public static Runtime runtime;
	public static int[] collision;

	public static void main(String[] args) {
		runtime = Runtime.getRuntime();
		collision = new int[6];
		int numOfTests = 50;
		for (int i = 0; i < numOfTests; i++) {
			System.out.println("\nTEST #" + i + ":");
			System.out.println("\nSeparate Chaining HashTable Test");
			HashTable<Integer, String> hashTable = new SeparateChainingHashTable<Integer, String>();
			// hashTableTest(scHashTable);
			rehashingTest(hashTable, 0);

			System.out.println("\nBucketing HashTable Test");
			hashTable = new BucketingHashTable<Integer, String>();
			// hashTableTest(bHashTable);
			rehashingTest(hashTable, 1);

			System.out.println("\nLinear Probing HashTable Test");
			hashTable = new LinearProbingHashTable<Integer, String>();
			// hashTableTest(lpHashTable);
			rehashingTest(hashTable, 2);

			System.out.println("\nQuadratic Probing HashTable Test");
			hashTable = new QuadraticProbingHashTable<Integer, String>();
			// hashTableTest(qpHashTable);
			rehashingTest(hashTable, 3);

			System.out.println("\nPseudo Random Probing HashTable Test");
			hashTable = new PseudoRandomProbingHashTable<Integer, String>();
			// hashTableTest(prpHashTable);
			rehashingTest(hashTable, 4);

			System.out.println("\nDouble Hashing HashTable Test");
			hashTable = new DoubleHashingHashTable<Integer, String>();
			// hashTableTest(dhHashTable);
			rehashingTest(hashTable, 5);
		}
		for (int i = 0; i < collision.length; i++) {
			collision[i] /= numOfTests;
		}
		System.out.println();
		System.out.println(Arrays.toString(collision));
	}
}
