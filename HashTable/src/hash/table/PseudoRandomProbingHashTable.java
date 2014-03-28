package hash.table;

import java.util.ArrayList;
import java.util.Collections;

import pairs.PairB;

public class PseudoRandomProbingHashTable<K, V> implements HashTable<K, V> {
	private PairB<K, V> map[];
	private ArrayList<Integer> probingSequance;
	private int mapLength;
	private int size;

	@SuppressWarnings("unchecked")
	public PseudoRandomProbingHashTable() {
		mapLength = 100;
		size = 0;
		map = new PairB[mapLength];
		probingSequance = new ArrayList<Integer>();
		for (int i = 0; i < mapLength; i++) {
			probingSequance.add(i);
		}
		Collections.shuffle(probingSequance);
	}

	// put key�value pair into the table

	@Override
	public void put(K key, V value) {
		PairB<K, V> pair = new PairB<K, V>(key, value);
		int home = getHashCode(pair);

		for (int i = 0; i < mapLength; i++) {
			int index = getNextProbe(home, i);
			if (map[index] == null) {
				map[index] = pair;
				size++;
				return;
			} else if (map[index].equals(pair)) {
				map[index] = pair;
				return;
			}
		}
		for (int i = 0; i < mapLength; i++) {
			int index = getNextProbe(home, i);
			if (map[index] != null && map[index].isDeleted()) {
				map[index] = pair;
				size++;
				return;
			}
		}
		System.out.println("HashTable is Full!!!");
	}

	// get value paired with key, return null if
	// hash don't contain key

	@Override
	public V get(K key) {
		PairB<K, V> pair = new PairB<K, V>(key, null);
		int home = getHashCode(pair);
		for (int i = 0; i < mapLength; i++) {
			int index = getNextProbe(home, i);
			if (map[index] == null) {
				return null;
			} else if (map[index].equals(pair) && !map[index].isDeleted()) {
				return map[index].getValue();
			}
		}
		return null;
	}

	// remove key (and its value) from table

	@Override
	public void delete(K key) {
		PairB<K, V> pair = new PairB<K, V>(key, null);
		int home = getHashCode(pair);
		for (int i = 0; i < mapLength; i++) {
			int index = getNextProbe(home, i);
			if (map[index] == null) {
				return;
			} else if (map[index].equals(pair) && !map[index].isDeleted()) {
				map[index].setDeleted(true);
				size--;
				return;
			}
		}
	}

	// return true if there is a value paired with key
	// and false otherwise.

	@Override
	public boolean contains(K key) {
		PairB<K, V> pair = new PairB<K, V>(key, null);
		int home = getHashCode(pair);
		for (int i = 0; i < mapLength; i++) {
			int index = getNextProbe(home, i);
			if (map[index] == null) {
				return false;
			} else if (map[index].equals(pair)) {
				return !map[index].isDeleted();
			}
		}
		return false;
	}

	// return true if the table is empty.

	@Override
	public boolean isEmpty() {
		return size != 0;
	}

	// return size of the table.

	@Override
	public int size() {
		return size;
	}

	// all keys in the table

	@Override
	public Iterable<K> keys() {
		ArrayList<K> keys = new ArrayList<K>();
		for (int i = 0; i < mapLength; i++) {
			if (map[i] != null && !map[i].isDeleted()) {
				keys.add(map[i].getKey());
			}
		}
		return keys;
	}

	private int getHashCode(PairB<K, V> pair) {
		return pair.hashCode() % mapLength;
	}

	private int getNextProbe(int home, int i) {
		return (home + probingSequance.get(i)) % mapLength;
	}
	
	
}
