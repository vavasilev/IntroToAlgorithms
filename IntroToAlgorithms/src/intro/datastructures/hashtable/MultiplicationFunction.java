package amazonprep.datastructures.hashtable;

public class MultiplicationFunction implements HashFunction {
	
	private static final double SEED = (Math.sqrt(5.0) - 1.0)/2.0;

	@Override
	public int getHash(int key, int capacity) {
		double number = ((double)key)*SEED;
		number -= (double)((int)number);
		return (int)(number*(double)capacity);
	}

}
