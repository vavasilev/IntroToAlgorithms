package amazonprep.algorithms.sort;

public class Util {

	public static <T>void swap(T [] A, int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
