package intro.datastructures.heap;

import intro.algorithms.sort.KeyedData;

public interface Heap<T extends Comparable<T>, U extends KeyedData<T>> {
	U extractOptimalElement();
	U getOptimalElement();
	int getSize();
	void insert(U element);
	void updateKey(U element, T key);
	
	public static enum HeapType {
		MIN, MAX
	}
}
