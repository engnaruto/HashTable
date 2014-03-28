package hash.table;

import java.util.ArrayList;

import pairs.Pair;

public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

	private ArrayList<Pair<K, V>>[] map;
	// private ArrayList<Pair<K, V>>[] tempMap;
	private int mapLength;
	private int size;

	@SuppressWarnings("unchecked")
	public SeparateChainingHashTable() {
		mapLength = 100;
		size = 0;
		map = new ArrayList[mapLength];

		for (int i = 0; i < mapLength; i++) {
			map[i] = new ArrayList<Pair<K, V>>();
		}
	}

	@SuppressWarnings("unchecked")
	private SeparateChainingHashTable(int mapLength) {
		this.mapLength = mapLength;
		size = 0;
		map = new ArrayList[mapLength];
		for (int i = 0; i < mapLength; i++) {
			map[i] = new ArrayList<Pair<K, V>>();
		}
	}

	// put key­value pair into the table

	@Override
	public void put(K key, V value) {
		Pair<K, V> pair = new Pair<K, V>(key, value);
		int mapIndex = getHashCode(pair);
		if (map[mapIndex].contains(pair)) {
			int index = map[mapIndex].indexOf(pair);
			map[mapIndex].get(index).setValue(value);
		} else {
			map[mapIndex].add(pair);
			size++;
			double loadFactor = (double) size / (double) mapLength;
			if (loadFactor >= 3) {
				rehash();
			}
		}
	}

	private void rehash() {
		Iterable<K> keys = keys();
		SeparateChainingHashTable<K, V> temp = new SeparateChainingHashTable<K, V>(
				mapLength * 2);
		for (K key : keys) {
			V value = get(key);
			temp.put(key, value);
		}
		map = temp.map;
		size = temp.size;
		mapLength = temp.mapLength;
		System.out.println("Rehashing : Size = " + size + " mapLength = "
				+ mapLength);
		keys = keys();
	}

	// get value paired with key, return null if
	// hash don't contain key
	@Override
	public V get(K key) {
		Pair<K, V> pair = new Pair<K, V>(key, null);
		int mapIndex = getHashCode(pair);
		if (map[mapIndex].contains(pair)) {
			int index = map[mapIndex].indexOf(pair);
			return map[mapIndex].get(index).getValue();
		}
		return null;
	}

	// remove key (and its value) from table

	@Override
	public void delete(K key) {
		Pair<K, V> pair = new Pair<K, V>(key, null);
		int mapIndex = getHashCode(pair);
		if (map[mapIndex].contains(pair)) {
			map[mapIndex].remove(pair);
			size--;
		}
	}

	// return true if there is a value paired with key
	// and false otherwise.

	@Override
	public boolean contains(K key) {
		Pair<K, V> pair = new Pair<K, V>(key, null);
		int mapIndex = getHashCode(pair);
		return map[mapIndex].contains(pair);
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
			// System.out.println(i + " " + map[i].size());
			for (int j = 0; j < map[i].size(); j++) {
				keys.add(map[i].get(j).getKey());
			}
		}
		return keys;
	}

	private int getHashCode(Pair<?, ?> pair) {
		return pair.hashCode() % mapLength;
	}

	// private int getNewHashCode(Pair<?, ?> pair) {
	// return pair.hashCode() % mapLength * 2;
	// }
}
