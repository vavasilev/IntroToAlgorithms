package intro.algorithms.sort;

public class QuickSort<T extends Comparable<T>, U extends KeyedData<T>> implements SortingAlgorithm<T, U> {

	@Override
	public U[] sort(U[] A) {
		quickSort(A, 0, A.length-1);
		return A;
	}
	
	private void quickSort(KeyedData<T>[] A, int start, int end) {
		if(start >= end) {
			return;
		}
		int q = partition(A, start, end);
		quickSort(A, start, q-1);
		quickSort(A, q+1, end);
	}
	
	protected int partition(KeyedData<T>[] A, int start, int end) {
		int pivotI = start + (int)(Math.random()*(end-start+1));
		T pivot = A[pivotI].getKey();
		Util.swap(A, pivotI, end);
		int i=start-1;
		for(int j = start; j<=end; j++) {
			if(A[j].getKey().compareTo(pivot) <= 0) {
				i++;
				if(i!=j && A[i] != A[j]) {
					Util.swap(A, i, j);
				}
			}
		}
		return i;
	}

	@Override
	public String getName() {
		return "Quick Sort";
	}

}
