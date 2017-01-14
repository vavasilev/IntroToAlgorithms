package intro.datastructures.hashtable;

import intro.algorithms.sort.IntKeyedData;
import intro.algorithms.sort.KeyedData;

public class OpenAddressingHashtable<T extends KeyedData<Integer>> extends Hashtable<T> {

	private KeyedData<Integer> [] slots;
	
	private IntKeyedData deleted = new IntKeyedData(-1);

	public OpenAddressingHashtable(int capacity) {
		super(capacity, new DivisionFunction());
		
		slots = new KeyedData[capacity];
	}
	
	private int getHash(int key, int i) {
		return hashFunction.getHash(hashFunction.getHash(key, capacity) + i*(hashFunction.getHash(key, capacity-1)+1), capacity);
	}

	@Override
	public void insertData(T data) {
		int i=0;
		for(i=0; i<capacity; i++) {
			int hash = getHash(data.getKey(), i);
			if(slots[hash] == null || slots[hash] == deleted) {
				slots[hash] = data;
				break;
			}
		}
		if(i == capacity) {
			throw new ArrayIndexOutOfBoundsException("No free space left in hashtable");
		}
	}

	@Override
	public T getData(int key) {
		for(int i=0; i<capacity; i++) {
			int hash = getHash(key, i);
			if(slots[hash] != null && slots[hash] != deleted) {
				if(slots[hash].getKey() == key) {
					return (T)slots[hash];
				}
			} else if(slots[hash] == null) {
				break;
			}
		}
		return null;
	}

	@Override
	public void deleteData(int key) {
		for(int i=0; i<capacity; i++) {
			int hash = getHash(key, i);
			if(slots[hash] != null && slots[hash] != deleted) {
				if(slots[hash].getKey() == key) {
					slots[hash] = deleted;
					break;
				}
			} else if(slots[hash] == null) {
				break;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<capacity; i++) {
			sb.append(slots[i]+", ");
		}
		if(sb.length() > 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		return sb.toString();
	}
}
