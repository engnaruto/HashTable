package pairs;

public class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {

		return key == ((Pair<K, V>) o).getKey();
	}

	// ---------------------------------------------

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
