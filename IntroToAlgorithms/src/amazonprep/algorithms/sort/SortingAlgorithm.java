package amazonprep.algorithms.sort;

public interface SortingAlgorithm<T extends Comparable<T>, U extends Sortable<T>> {

	U [] sort(U [] A);
	String getName();
}
