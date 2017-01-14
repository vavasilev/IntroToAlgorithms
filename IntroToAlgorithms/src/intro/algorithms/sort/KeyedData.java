package intro.algorithms.sort;

public interface KeyedData<T extends Comparable<T>> {

	T getKey();
	void setKey(T key);
}
