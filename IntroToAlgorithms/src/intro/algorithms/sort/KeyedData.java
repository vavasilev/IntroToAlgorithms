package amazonprep.algorithms.sort;

public interface Sortable<T extends Comparable<T>> {

	T getKey();
	void setKey(T key);
}
