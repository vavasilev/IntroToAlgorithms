package intro.datastructures.heap;

import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.Util;

public class BinaryHeap<T extends Comparable<T>, U extends KeyedData<T>>
		implements Heap<T, U> {
	private U [] data;
	private int length;
	private HeapType heapType;
	private MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider;
	
	public BinaryHeap(U [] data, int length, HeapType heapType,
			MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		this.data = data;
		this.length = length;
		this.heapType = heapType;
		this.minMaxProvider = minMaxProvider;
		maintainHeapPropertyAll();
	}
	
	private int parent(int i) {
		if(i >= length) {
			return -1;
		}
		return i!=0 ? (i-1)/2 : -1;
	}
	
	private int leftChild(int i) {
		int res = 2*i + 1;
		return res < length ? res : -1;
	}
	
	private int rightChild(int i) {
		int res = 2*i + 2;
		return res < length ? res : -1;
	}
	
	public U[] getData() {
		return data;
	}
	
	@Override
	public int getSize() {
		return length;
	}
	
	private void maintainHeapProperty(int i) {
		int leftI = leftChild(i);
		int rightI = rightChild(i);
		
		int optimalI = i;
		if(leftI != -1 && (HeapType.MAX == heapType && data[leftI].getKey().compareTo(data[optimalI].getKey()) > 0
				|| HeapType.MIN == heapType && data[leftI].getKey().compareTo(data[optimalI].getKey()) < 0)) {
			optimalI = leftI;
		} 
		
		if(rightI != -1 && (HeapType.MAX == heapType && data[rightI].getKey().compareTo(data[optimalI].getKey()) > 0
				|| HeapType.MIN == heapType && data[rightI].getKey().compareTo(data[optimalI].getKey()) < 0)) {
			optimalI = rightI;
		}
		if(i != optimalI) {
			swap(i, optimalI);
			maintainHeapProperty(optimalI);
		}
	}
	
	private void maintainHeapPropertyAll() {
		if(length == 0) {
			return;
		}
		
		for(int i=0; i<length; i++) {
			setBackingElement(i);
		}
		
		int startI = length/2 - 1;
		
		for(int i=startI; i>=0; i--) {
			maintainHeapProperty(i);
		}
	}
	
	@Override
	public U getOptimalElement() {
		if(length == 0) {
			return null;
		}
		return data[0];
	}
	
	@Override
	public U extractOptimalElement() {
		if(length == 0) {
			return null;
		}
		
		U res = data[0];
		if(res instanceof HeapContext) {
			((HeapContext)res).setBackingElement(null);
		}
		
		data[0] = data[length - 1];
		setBackingElement(0);
		
		length--;
		maintainHeapProperty(0);
		
		return res;
	}
	
	@Override
	public void updateKey(U element, T key) {
		if(!(element instanceof HeapContext)) {
			throw new IllegalArgumentException("updateKey not supported for element thjat does not implement HeapContext");
		}
		
		HeapContext context = (HeapContext)element;
		updateKey((Integer)context.getBackingElement(), key);
	}
	
	private void updateKey(int i, T key) {
		if(key.compareTo(data[i].getKey())<0 && heapType == HeapType.MAX) {
			throw new UnsupportedOperationException("Cannot decrease key of a max heap");
		} else if(key.compareTo(data[i].getKey())>0 && heapType == HeapType.MIN) {
			throw new UnsupportedOperationException("Cannot increase key of a min heap");
		}
		data[i].setKey(key);
		
		while(i > 0 && (data[i].getKey().compareTo(data[parent(i)].getKey()) > 0 && heapType == HeapType.MAX
					|| data[i].getKey().compareTo(data[parent(i)].getKey()) < 0 && heapType == HeapType.MIN)) {
			int parentI = parent(i);
			swap(i, parentI);
			i = parent(i);
		}
	}
	
	@Override
	public void insert(U element) {
		length++;
		T oldKey = element.getKey();
		element.setKey(heapType == HeapType.MAX ? minMaxProvider.getMinKey() : minMaxProvider.getMaxKey());
		data[length-1] = element;
		setBackingElement(length-1);
		updateKey(length-1, oldKey);
	}
	
	private void swap(int i, int j) {
		Util.swap(data, i, j);
		setBackingElement(i);
		setBackingElement(j);
	}
	
	private void setBackingElement(int i) {
		if(data[i] instanceof HeapContext) {
			((HeapContext)data[i]).setBackingElement(i);
		}
	}
}
