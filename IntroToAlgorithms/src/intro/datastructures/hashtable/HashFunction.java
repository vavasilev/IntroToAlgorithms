package amazonprep.datastructures.hashtable;

public interface HashFunction {

	int getHash(int key, int capacity);
}
