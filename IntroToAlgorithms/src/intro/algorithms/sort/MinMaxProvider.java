package intro.algorithms.sort;

public interface MinMaxProvider<T extends Comparable<T>, U extends KeyedData<T>> {
	T getMinKey();
	T getMaxKey();
	
	U getMinSortable();
	U getMaxSortable();
}
