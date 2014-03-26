package hash.table;

import java.util.ArrayList;

import pairs.Pair;

public class BucketingHashTable<K, V> implements HashTable<K, V> {
	private Pair<K, V> map[];
	private ArrayList<Pair<K, V>> overflow;
	private int mapLength;
	private int size;
	private int bucketSize;

	@SuppressWarnings("unchecked")
	public BucketingHashTable() {
		mapLength = 50;
		size = 0;
		map = new Pair[mapLength];
		overflow = new ArrayList<Pair<K, V>>();
		bucketSize = 5;
	}

	// put key­value pair into the table

	@Override
	public void put(K key, V value) {

	}

	// get value paired with key, return null if
	// hash don't contain key

	@Override
	public V get(K key) {

		return null;
	}

	// remove key (and its value) from table

	@Override
	public void delete(K key) {

	}

	// return true if there is a value paired with key
	// and false otherwise.

	@Override
	public boolean contains(K key) {

		return false;
	}

	// return true if the table is empty.

	@Override
	public boolean isEmpty() {

		return false;
	}

	// return size of the table.

	@Override
	public int size() {

		return 0;
	}

	// all keys in the table

	@Override
	public Iterable<K> keys() {
		return null;
	}

}
