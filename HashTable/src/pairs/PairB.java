package pairs;

public class PairB<K, V> {
	private K key;
	private V value;
	private boolean deleted;

	public PairB(K key, V value) {
		this.key = key;
		this.value = value;
		deleted = false;
	}

	@Override
	public int hashCode() {
		return key.hashCode();
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
