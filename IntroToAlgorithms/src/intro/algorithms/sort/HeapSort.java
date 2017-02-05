package intro.algorithms.sort;

import intro.datastructures.heap.BinaryHeap;

public class HeapSort<T extends Comparable<T>, U extends KeyedData<T>> implements SortingAlgorithm<T, U> {

	@Override
	public U[] sort(U[] A) {
		BinaryHeap<T,U> h = new BinaryHeap<T,U>(A,
				A.length,
				BinaryHeap.HeapType.MAX,
				null);
		
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
