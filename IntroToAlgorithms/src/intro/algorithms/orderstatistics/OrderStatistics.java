package amazonprep.algorithms.orderstatistics;

import amazonprep.algorithms.sort.QuickSort;
import amazonprep.algorithms.sort.Sortable;

public class OrderStatistics<T extends Comparable<T>, U extends Sortable<T>> extends QuickSort<T, U> {

	public U find(U [] A, int i) {
		return find(A, 0, A.length - 1, i);
	}
	
	private U find(U [] A, int start, int end, int i) {
		if(start == end) {
			return A[start];
		}
		
		int q = partition(A, start, end);
		int k = q - start;
		
		if(k == i) {
			return A[q];
		} else if(k < i) {
			return find(A, q+1, end, i-k-1);
		} else {
			return find(A, start, q-1, i);
		}
	}
}