package intro.datastructures.set;

import java.util.Iterator;

import intro.datastructures.list.LinkedList;
import intro.datastructures.list.ListElement;

public class LinkedListDisjointSet<T extends DisjointSetBound> implements DisjointSet<T> {
	private LinkedList<T> list;
	
	public LinkedListDisjointSet(T data) {
		list = new LinkedList<T>();
		list.insertData(data);
	}
	
	public void union(DisjointSet<T> other) {
		if(other == this) {
			return;
		}
		
		LinkedListDisjointSet<T> otherLinked = (LinkedListDisjointSet<T>)other;
		
		// Weighted union heuristic - O(log(n)) amortized time instead of O(n)
		LinkedListDisjointSet<T> first = list.getSize() >= otherLinked.list.getSize() ? this : otherLinked;
		LinkedListDisjointSet<T> second = list.getSize() >= otherLinked.list.getSize() ? otherLinked : this;
		
		// Set representative
		Iterator<ListElement<T>> secondIterator = second.list.elementsIterator();
		while(secondIterator.hasNext()) {
			ListElement<T> elm = secondIterator.next();
			elm.getData().setDisjointSet(first);
		}
		
		first.list.union(second.list);
	}
}
