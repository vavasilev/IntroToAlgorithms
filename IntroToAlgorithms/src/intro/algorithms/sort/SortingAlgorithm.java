package intro.algorithms.sort;

public interface SortingAlgorithm<T extends Comparable<T>, U extends KeyedData<T>> {

	U [] sort(U [] A);
	String getName();
}
