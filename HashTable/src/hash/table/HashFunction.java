package hash.table;

import pairs.*;

public class HashFunction {
	public static int getHashCode(Pair<?, ?> pair, int mapLength) {
		return pair.hashCode() % mapLength;
	}
}
