package test;

import hash.table.BucketingHashTable;

public class test2 {
	public static void main(String[] args) {
		{

			BucketingHashTable<Integer, Integer> hash = new BucketingHashTable<Integer, Integer>();
			System.out.println("Hash is empty? (true) " + hash.isEmpty());
			System.out.println("Insert 4567....");
			hash.put(4567, 4567);
			System.out.println("Hash is empty? (false) " + hash.isEmpty());
			System.out.println("Insert 67....");
			hash.put(67, 67);
			System.out.println("Insert 37....");
			hash.put(37, 37);
			System.out.println("Hash size? (3) " + hash.size());
			// hash.print();
			System.out.println("Contains 4567? (true): " + hash.contains(4567));
			System.out.println("Contains 37? (true): " + hash.contains(37));
			System.out.println("Contains 7? (false): " + hash.contains(7));
			System.out.println("Insert 0 - 29....");
			for (int i = 0; i < 30; i++)
				hash.put(i, i);
			// hash.print();
			System.out.println("Contains 7? (true): " + hash.contains(7));
			System.out.println("Delete 4567....");
			hash.delete(4567);
			System.out
					.println("Contains 4567? (false): " + hash.contains(4567));
			System.out.println("Contains 100? (false): " + hash.contains(100));
			System.out.println("Delete a non-existing entry: 100");
			hash.delete(100);
			System.out.println("Contains 100? (false): " + hash.contains(100));
			System.out.println("Insert Duplicate: 37");
			System.out.println("Insert 37 (val 73)....");
			hash.put(37, 73);
			System.out.println("New value of 37: " + hash.get(37));
			System.out.println("Hash is empty? (false) " + hash.isEmpty());
			System.out.println("Hash size? (32) " + hash.size());
			Iterable<Integer> keys = hash.keys();
			System.out.println("Print keys: ");
			System.out.println(keys.toString());

		}
	}
}
