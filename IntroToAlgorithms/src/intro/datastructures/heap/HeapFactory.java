package intro.datastructures.heap;

import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.MinMaxProvider;
import intro.datastructures.heap.Heap.HeapType;

public interface HeapFactory<T extends Comparable<T>, U extends KeyedData<T>> {

	Heap<T, U> createHeap(U [] data, HeapType heapType,
			MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider);
}
