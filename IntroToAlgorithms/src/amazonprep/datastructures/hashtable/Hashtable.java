package amazonprep.datastructures.hashtable;

import amazonprep.algorithms.sort.Sortable;

public abstract class Hashtable<T extends Sortable<Integer>> {

	protected int capacity;
	protected HashFunction hashFunction;
	
	public Hashtable(int capacity) {
		this(capacity, new MultiplicationFunction());
	}
	
	public Hashtable(int capacity, HashFunction hashFunction) {
		this.capacity = capacity;
		this.hashFunction = hashFunction;
	}
	
	public abstract void insertData(T data);
	
	public abstract T getData(int key);
	
	public abstract void deleteData(int key);
}
