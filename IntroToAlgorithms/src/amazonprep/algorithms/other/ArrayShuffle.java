package amazonprep.algorithms.other;


public class ArrayShuffle {

	public void fisherYatesShuffle(int [] A) {
		for(int i=0; i<A.length-1; i++) {
			int j = i+(int)(Math.random()*(A.length-i));
			int a1 = A[i];
			A[i] = A[j];
			A[j] = a1;
		}
	}
}
