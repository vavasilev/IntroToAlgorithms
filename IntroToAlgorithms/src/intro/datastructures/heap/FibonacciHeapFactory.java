package intro.datastructures.heap;

import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.MinMaxProvider;
import intro.datastructures.heap.Heap.HeapType;

public class FibonacciHeapFactory<T extends Comparable<T>, U extends KeyedData<T>> implements HeapFactory<T, U> {

	@Override
	public Heap<T, U> createHeap(U[] data, HeapType heapType,
			MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		Heap<T, U> heap = new FibonacciHeap<T, U>(heapType, minMaxProvider);
		
		for(U elm : data) {
			heap.insert(elm);
		}
		
		return heap;
	}

}
