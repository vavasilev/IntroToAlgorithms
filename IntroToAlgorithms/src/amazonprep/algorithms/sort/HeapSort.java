package amazonprep.algorithms.sort;

import amazonprep.datastructures.heap.Heap;

public class HeapSort<T extends Comparable<T>, U extends Sortable<T>> implements SortingAlgorithm<T, U> {

	@Override
	public U[] sort(U[] A) {
		Heap<T,U> h = new Heap<T,U>(A, A.length, Heap.HeapType.MAX);
		h.maintainHeapPropertyAll();
		
		for(int i = A.length-1; i>0; i--) {
			U max = h.extractOptimalElement();
			A[i] = max;
		}
		return A;
	}

	@Override
	public String getName() {
		return "Heap Sort";
	}

}
