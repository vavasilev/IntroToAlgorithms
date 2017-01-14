package amazonprep.datastructures.hashtable;

public class DivisionFunction implements HashFunction {

	@Override
	public int getHash(int key, int capacity) {
		return key % capacity;
	}

}
