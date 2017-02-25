package intro.datastructures.heap;

import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.MinMaxProvider;
import intro.datastructures.heap.Heap.HeapType;

public class BinaryHeapFactory<T extends Comparable<T>, U extends KeyedData<T>> implements HeapFactory<T, U> {

	@Override
	public Heap<T, U> createHeap(U[] data, HeapType heapType,
			MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		return new BinaryHeap<T, U>(data, data.length, heapType, minMaxProvider);
	}

}
