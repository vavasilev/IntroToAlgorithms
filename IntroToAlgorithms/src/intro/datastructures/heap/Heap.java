package intro.datastructures.heap;

import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.Util;

public class Heap<T extends Comparable<T>, U extends KeyedData<T>> {
	
	public static enum HeapType {
		MIN, MAX
	}

	private U [] data;
	private int length;
	private HeapType heapType;
	
	public Heap(U [] data, int length, HeapType heapType) {
		this.data = data;
		this.length = length;
		this.heapType = heapType;
	}
	
	int parent(int i) {
		if(i >= length) {
			return -1;
		}
		return i!=0 ? (i-1)/2 : -1;
	}
	
	int leftChild(int i) {
		int res = 2*i + 1;
		return res < length ? res : -1;
	}
	
	int rightChild(int i) {
		int res = 2*i + 2;
		return res < length ? res : -1;
	}
	
	public U[] getData() {
		return data;
	}
	
	public int getSize() {
		return length;
	}
	
	public void maintainHeapProperty(int i) {
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
			Util.swap(data, i, optimalI);
			maintainHeapProperty(optimalI);
		}
	}
	
	public void maintainHeapPropertyAll() {
		if(length == 0) {
			return;
		}
		int startI = length/2 - 1;
		
		for(int i=startI; i>=0; i--) {
			maintainHeapProperty(i);
		}
	}
	
	public U getOptimalElement() {
		if(length == 0) {
			return null;
		}
		return data[0];
	}
	
	public U extractOptimalElement() {
		if(length == 0) {
			return null;
		}
		
		U res = data[0];
		data[0] = data[length - 1];
		length--;
		maintainHeapProperty(0);
		
		return res;
	}
	
	public void updateKey(U elm, T key) {
		for(int i=0; i< length; i++) {
			if(data[i] == elm) {
				updateKey(i, key);
			}
		}
	}
	
	public boolean containsElement(U elm) {
		for(int i=0; i< length; i++) {
			if(data[i] == elm) {
				return true;
			}
		}
		
		return false;
	}
	
	public void updateKey(int i, T key) {
		if(key.compareTo(data[i].getKey())<0 && heapType == HeapType.MAX) {
			throw new UnsupportedOperationException("Cannot decrease key of a max heap");
		} else if(key.compareTo(data[i].getKey())>0 && heapType == HeapType.MIN) {
			throw new UnsupportedOperationException("Cannot increase key of a min heap");
		}
		data[i].setKey(key);
		
		while(i > 0 && (data[i].getKey().compareTo(data[parent(i)].getKey()) > 0 && heapType == HeapType.MAX
					|| data[i].getKey().compareTo(data[parent(i)].getKey()) < 0 && heapType == HeapType.MIN)) {
			Util.swap(data, i, parent(i));
			i = parent(i);
		}
	}
	
	public void insert(U element, MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		length++;
		T oldKey = element.getKey();
		element.setKey(heapType == HeapType.MAX ? minMaxProvider.getMinKey() : minMaxProvider.getMaxKey());
		data[length-1] = element;
		updateKey(length-1, oldKey);
	}
}
