package intro.datastructures.heap;

import intro.algorithms.sort.KeyedData;

public class FibonacciHeap<T extends Comparable<T>, U extends KeyedData<T>>
		implements Heap<T, U> {
	
	private HeapType heapType;
	
	private FibonacciElement<U> optElement;
	private int size;
	
	public FibonacciHeap(HeapType heapType) {
		this.heapType = heapType;
	}

	@Override
	public U extractOptimalElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public U getOptimalElement() {
		return optElement.getData();
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void insert(U element) {
		FibonacciElement<U> fibElement = new FibonacciElement<U>();
		fibElement.setData(element);
		setBackingElement(element, fibElement);
		
		if(optElement == null) {
			optElement = fibElement;
			optElement.setNext(optElement);
			optElement.setPrev(optElement);
			return;
		}
		
		optElement.getNext().setPrev(fibElement);
		fibElement.setNext(optElement.getNext());
		fibElement.setPrev(optElement);
		optElement.setNext(fibElement);
		size++;
		
		if(optElement.getData().getKey().compareTo(element.getKey())<0 && heapType == HeapType.MAX
				|| optElement.getData().getKey().compareTo(element.getKey())>0 && heapType == HeapType.MIN) {
			optElement = fibElement;
		}
	}
	
	public void union(FibonacciHeap<T, U> other) {
		if(other == this || other.optElement == null) {
			return;
		}
		
		if(optElement == null) {
			optElement = other.optElement;
		} else {
			FibonacciElement<U> otherOptElement = other.optElement;
			FibonacciElement<U> prevOtherOptElement = (FibonacciElement<U>)otherOptElement.getPrev();
			
			optElement.getPrev().setNext(otherOptElement);
			otherOptElement.setPrev(optElement.getPrev());
			prevOtherOptElement.setNext(optElement);
			optElement.setPrev(prevOtherOptElement);
			
			if(optElement.getData().getKey().compareTo(otherOptElement.getData().getKey())<0 && heapType == HeapType.MAX
					|| optElement.getData().getKey().compareTo(otherOptElement.getData().getKey())>0 && heapType == HeapType.MIN) {
				optElement = otherOptElement;
			}
		}
		
		size += other.size;
		other.optElement = null;
		other.size = 0;
	}

	@Override
	public void updateKey(U element, T key) {
		// TODO Auto-generated method stub
		
	}

	private void setBackingElement(U elemen, FibonacciElement<U> fibElement) {
		if(elemen instanceof HeapContext) {
			((HeapContext)elemen).setBackingElement(fibElement);
		}
	}
}
