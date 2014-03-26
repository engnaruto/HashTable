package hash.table;

public class DoubleHashingHashTable<K, V> implements HashTable<K, V> {
	
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
