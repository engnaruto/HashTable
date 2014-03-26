package hash.table;

import java.util.ArrayList;

import pairs.Pair;

public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

	private ArrayList<Pair<K, V>>[] map;
	private int size;

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable() {
		size = 100;
		map = new ArrayList[size];

		for (int i = 0; i < size; i++) {
			map[i] = new ArrayList<Pair<K, V>>();
		}
	}

	// put key�value pair into the table

	@Override
	public void put(K key, V value) {
		Pair<K, V> pair = new Pair<K, V>(key, value);
		int hashCode = HashFunction.getHashCode(pair, size);
		if (map[hashCode].contains(pair)) {
			
		}
	}

	// get value paired with key, return null if
	// hash don't contain key

	@Override
	public String get(K key) {

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
