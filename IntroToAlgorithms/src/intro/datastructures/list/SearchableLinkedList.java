package intro.datastructures.list;

import intro.algorithms.sort.KeyedData;

public class SearchableLinkedList<T extends Comparable<T>, U extends KeyedData<T>> extends LinkedList<U> {
	public ListElement<U> searchFirstElement(T key) {
		ListElement<U> elm = head.getNext();
		while(elm != head && key.compareTo(elm.getData().getKey()) != 0) {
			elm = elm.getNext();
		}
		
		return elm != head ? elm : null;
	}
}
