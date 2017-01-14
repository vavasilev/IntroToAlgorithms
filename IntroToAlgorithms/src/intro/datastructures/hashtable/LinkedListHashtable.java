package intro.datastructures.hashtable;

import intro.algorithms.sort.KeyedData;
import intro.datastructures.list.ListElement;
import intro.datastructures.list.SearchableLinkedList;

public class LinkedListHashtable<T extends KeyedData<Integer>> extends Hashtable<T> {

	private SearchableLinkedList<Integer, T> [] slots;
	
	public LinkedListHashtable(int capacity, HashFunction hashFunction) {
		super(capacity, hashFunction);
		
		slots = new SearchableLinkedList[capacity];
	}

	public LinkedListHashtable(int capacity) {
		super(capacity);
		
		slots = new SearchableLinkedList[capacity];
	}

	@Override
	public void insertData(T data) {
		int hash = hashFunction.getHash(data.getKey(), capacity);
		if(slots[hash] == null) {
			slots[hash] = new SearchableLinkedList<Integer, T>();
		}
		slots[hash].insertData(data);
	}
	
	@Override
	public T getData(int key) {
		int hash = hashFunction.getHash(key, capacity);
		if(slots[hash] == null) {
			return null;
		} else {
			ListElement<T> elm = slots[hash].searchFirstElement(key);
			return elm != null ? elm.getData() : null;
		}
	}
	
	@Override
	public void deleteData(int key) {
		int hash = hashFunction.getHash(key, capacity);
		if(slots[hash] != null) {
			ListElement<T> elm = slots[hash].searchFirstElement(key);
			if(elm != null) {
				slots[hash].deleteElement(elm);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<capacity; i++) {
			if(slots[i] != null) {
				sb.append(i+":["+slots[i]+"], ");
			}
		}
		if(sb.length() > 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		return sb.toString();
	}
}
