package amazonprep.algorithms.sort;

public interface MinMaxProvider<T extends Comparable<T>, U extends Sortable<T>> {
	T getMinKey();
	T getMaxKey();
	
	U getMinSortable();
	U getMaxSortable();
}
