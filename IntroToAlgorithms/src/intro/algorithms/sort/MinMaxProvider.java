package intro.algorithms.sort;

public interface MinMaxProvider<T extends Comparable<T>, U extends KeyedData<T>> {
	T getMinKey();
	T getMaxKey();
	
	U getMinKeyedData();
	U getMaxKeyedData();
}
