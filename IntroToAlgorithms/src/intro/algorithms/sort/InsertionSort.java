package intro.algorithms.sort;

public class InsertionSort<T extends Comparable<T>, U extends KeyedData<T>> implements SortingAlgorithm<T, U> {

	@Override
	public U[] sort(U[] A) {
		for(int i = 1; i<A.length; i++) {
			U element = A[i];
			int j = i-1;
			while(j >= 0 && element.getKey().compareTo(A[j].getKey()) < 0) {
				A[j+1] = A[j];
				j--;
			}
			A[j+1] = element;
		}
		return A;
	}

	@Override
	public String getName() {
		return "InsertionSort";
	}

}
