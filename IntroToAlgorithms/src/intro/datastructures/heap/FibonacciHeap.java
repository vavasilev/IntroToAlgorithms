package intro.datastructures.heap;

import java.util.Iterator;

import intro.algorithms.sort.KeyedData;
import intro.algorithms.sort.MinMaxProvider;

public class FibonacciHeap<T extends Comparable<T>, U extends KeyedData<T>>
		implements Heap<T, U> {
	
	private HeapType heapType;
	
	private FibonacciElement<U> optElement;
	private int size;
	private MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider;
	
	public FibonacciHeap(HeapType heapType,
			MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		this.heapType = heapType;
		this.minMaxProvider = minMaxProvider;
	}

	@Override
	public U extractOptimalElement() {
		if(optElement == null) {
			return null;
		}
		
		FibonacciElement<U> child = (FibonacciElement<U>)optElement.getChild();
		if(child != null) {
			iterable(child).forEach(elm -> elm.setParent(null));
			transplantList(optElement, child);
		}
		
		U retData = optElement.getData();
		setBackingElement(retData, null);
		
		size--;
		
		if(optElement.getNext() == optElement) {
			optElement = null;
		} else {
			// Remove current opt element
			FibonacciElement<U> nextOptElement = (FibonacciElement<U>)optElement.getNext();
			nextOptElement.setPrev(optElement.getPrev());
			optElement.getPrev().setNext(nextOptElement);
			
			optElement = nextOptElement;
			
			consolidate();
		}
		
		return retData;
	}

	private void consolidate() {
		int D = maxDegree();
		if(D == 0) {
			return;
		}
		
		FibonacciElement<U>[] rootRefs = new FibonacciElement[D];
		iterable(optElement).forEach(elm -> {
			FibonacciElement<U> rootRefX = elm;
			int degree = rootRefX.getDegree();
			while(rootRefs[degree] != null) {
				FibonacciElement<U> tmp = (rootRefX.getData().getKey().compareTo(rootRefs[degree].getData().getKey()) < 0 && heapType == HeapType.MAX || rootRefX.getData().getKey().compareTo(rootRefs[degree].getData().getKey()) > 0 && heapType == HeapType.MIN) ? rootRefs[degree] : rootRefX;
				FibonacciElement<U> rootRefY = (rootRefX.getData().getKey().compareTo(rootRefs[degree].getData().getKey()) < 0 && heapType == HeapType.MAX || rootRefX.getData().getKey().compareTo(rootRefs[degree].getData().getKey()) > 0 && heapType == HeapType.MIN) ? rootRefX : rootRefs[degree];
				rootRefX = tmp;
				link(rootRefY, rootRefX);
				rootRefs[degree] = null;
				degree++;
			}
			rootRefs[degree] = rootRefX;
		});
		
		optElement = null;
		
		for(FibonacciElement<U> elm : rootRefs) {
			if(elm == null) {
				continue;
			}
			
			if(optElement == null) {
				optElement = elm;
				continue;
			}
			
			if(optElement.getData().getKey().compareTo(elm.getData().getKey())<0 && heapType == HeapType.MAX
					|| optElement.getData().getKey().compareTo(elm.getData().getKey())>0 && heapType == HeapType.MIN) {
				optElement = elm;
			}
		}
		
	}
	
	private void link(FibonacciElement<U> rootRefY, FibonacciElement<U> rootRefX) {
		// Remove Y from root list
		FibonacciElement<U> nextRootRefY = (FibonacciElement<U>)rootRefY.getNext();
		nextRootRefY.setPrev(rootRefY.getPrev());
		rootRefY.getPrev().setNext(nextRootRefY);
		
		// Make Y child of X
		rootRefY.setParent(rootRefX);
		if(rootRefX.getChild() == null) {
			rootRefX.setChild(rootRefY);
			rootRefY.setNext(rootRefY);
			rootRefY.setPrev(rootRefY);
		} else {
			FibonacciElement<U> child = (FibonacciElement<U>)rootRefX.getChild();
			rootRefY.setNext(child.getNext());
			child.getNext().setPrev(rootRefY);
			child.setNext(rootRefY);
			rootRefY.setPrev(child);
		}
		rootRefY.setMark(false);
		rootRefX.setDegree(rootRefX.getDegree() + 1);
	}
	
	private int maxDegree() {
		// It should be log +1, we set it +2 for the case when
		// you update keys - it mighty happen that node with degree for example
		// 2 has less than 4 nodes (3 nodes)
		return (int) (Math.log(size) / Math.log(2)) + 2;
	}

	@Override
	public U getOptimalElement() {
		return optElement == null ? null : optElement.getData();
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
			size++;
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
			transplantList(optElement, other.optElement);
			
			FibonacciElement<U> otherOptElement = other.optElement;			
			if(optElement.getData().getKey().compareTo(otherOptElement.getData().getKey())<0 && heapType == HeapType.MAX
					|| optElement.getData().getKey().compareTo(otherOptElement.getData().getKey())>0 && heapType == HeapType.MIN) {
				optElement = otherOptElement;
			}
		}
		
		size += other.size;
		other.optElement = null;
		other.size = 0;
	}
	
	private void transplantList(FibonacciElement<U> elm, FibonacciElement<U> otherElm) {
		FibonacciElement<U> lastElm = (FibonacciElement<U>)elm.getPrev();
		FibonacciElement<U> lastOtherElm = (FibonacciElement<U>)otherElm.getPrev();
		lastElm.setNext(otherElm);
		otherElm.setPrev(lastElm);
		lastOtherElm.setNext(elm);
		elm.setPrev(lastOtherElm);
	}
	
	private Iterable<FibonacciElement<U>> iterable(FibonacciElement<U> elm) {
		return new Iterable<FibonacciElement<U>>() {

			@Override
			public Iterator<FibonacciElement<U>> iterator() {
				return new Iterator<FibonacciElement<U>>() {

					FibonacciElement<U> nextElm = null;
					FibonacciElement<U> lastElm = elm != null ? (FibonacciElement<U>)elm.getPrev() : null;
					boolean lastElmSent = false;
					
					@Override
					public boolean hasNext() {
						return elm != null && (nextElm != lastElm || (lastElm != elm && !lastElmSent));
					}

					@Override
					public FibonacciElement<U> next() {
						FibonacciElement<U> elmToReturn = nextElm == null ? elm : nextElm;
						if(nextElm == lastElm) {
							lastElmSent = true;
						} else {
							nextElm = nextElm == null ? (FibonacciElement<U>)elm.getNext() : (FibonacciElement<U>)nextElm.getNext();
						}
						return elmToReturn;
					}
					
				};
			}
			
		};
	}

	@Override
	public void updateKey(U element, T key) {
		if(!(element instanceof HeapContext)) {
			throw new IllegalArgumentException("updateKey not supported for element that does not implement HeapContext");
		}
		
		HeapContext context = (HeapContext)element;
		updateKey((FibonacciElement<U>)context.getBackingElement(), key);
	}
	
	private void updateKey(FibonacciElement<U> x, T key) {
		if(key.compareTo(x.getData().getKey())<0 && heapType == HeapType.MAX) {
			throw new UnsupportedOperationException("Cannot decrease key of a max heap");
		} else if(key.compareTo(x.getData().getKey())>0 && heapType == HeapType.MIN) {
			throw new UnsupportedOperationException("Cannot increase key of a min heap");
		}
		x.getData().setKey(key);
		
		FibonacciElement<U> y = (FibonacciElement<U>)x.getParent();
		
		if(y != null) {
			if(key.compareTo(y.getData().getKey())<0 && heapType == HeapType.MIN ||
					key.compareTo(y.getData().getKey())>0 && heapType == HeapType.MAX) {
				cut(x, y);
				cascadingCut(y);
			}
		}
		
		if(key.compareTo(optElement.getData().getKey())<0 && heapType == HeapType.MIN ||
				key.compareTo(optElement.getData().getKey())>0 && heapType == HeapType.MAX) {
			optElement = x;
		}
	}
	
	private void cut(FibonacciElement<U> child, FibonacciElement<U> parent) {
		if(child.getNext() == child) {
			parent.setChild(null);
		} else {
			if(parent.getChild() == child) {
				parent.setChild(child.getNext());
			}
			FibonacciElement<U> prevChild = (FibonacciElement<U>)child.getPrev();
			FibonacciElement<U> nextChild = (FibonacciElement<U>)child.getNext();
			prevChild.setNext(nextChild);
			nextChild.setPrev(prevChild);
		}
		parent.setDegree(parent.getDegree() - 1);
		child.setParent(null);
		child.setMark(false);
		
		// Add child to root list of the heap
		FibonacciElement<U> nextOptElement = (FibonacciElement<U>)optElement.getNext();
		optElement.setNext(child);
		child.setPrev(optElement);
		child.setNext(nextOptElement);
		nextOptElement.setPrev(child);
	}
	
	public U delete(U element) {
		if(!(element instanceof HeapContext)) {
			throw new IllegalArgumentException("updateKey not supported for element that does not implement HeapContext");
		}
		HeapContext context = (HeapContext)element;
		FibonacciElement<U> x = (FibonacciElement<U>)context.getBackingElement();
		
		if(heapType == HeapType.MAX) {
			updateKey(x, minMaxProvider.getMaxKey());
		} else if(heapType == HeapType.MIN) {
			updateKey(x, minMaxProvider.getMinKey());
		}
		
		return extractOptimalElement();
	}
	
	private void cascadingCut(FibonacciElement<U> y) {
		FibonacciElement<U> z = (FibonacciElement<U>)y.getParent();
		if(z != null) {
			if(y.isMark()) {
				cut(y, z);
				cascadingCut(z);
			} else {
				y.setMark(true);
			}
		}
	}

	private void setBackingElement(U element, FibonacciElement<U> fibElement) {
		if(element instanceof HeapContext) {
			((HeapContext)element).setBackingElement(fibElement);
		}
	}
}
