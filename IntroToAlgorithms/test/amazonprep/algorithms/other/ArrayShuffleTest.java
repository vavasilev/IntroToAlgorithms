package amazonprep.algorithms.other;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayShuffleTest {

	@Test
	public void test() {
		int [] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ArrayShuffle shuffle = new ArrayShuffle();
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
		shuffle.fisherYatesShuffle(A);
		System.out.println(Arrays.toString(A));
	}

}
