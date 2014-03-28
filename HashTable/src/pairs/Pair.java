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
		return Math.abs(key.hashCode());
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		Pair<K, V> pair = (Pair<K, V>) o;
		return key.equals(pair.getKey());
	}

	@Override
	public String toString() {
		return key + " = " + value;
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
