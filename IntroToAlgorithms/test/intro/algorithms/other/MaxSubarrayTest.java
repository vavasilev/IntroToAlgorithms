package amazonprep.algorithms.other;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSubarrayTest {

	@Test
	public void testMaxSubarrayRec() {
		int [] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		MaxSubarray.Subarray subarray = new MaxSubarray().maxSubarrayRec(A);
		assertEquals(7, subarray.getStart());
		assertEquals(10, subarray.getEnd());
		assertEquals(43, subarray.getMax());
	}

	@Test
	public void testMaxSubarrayKadane() {
		int [] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		MaxSubarray.Subarray subarray = new MaxSubarray().maxSubarrayKadane(A);
		assertEquals(7, subarray.getStart());
		assertEquals(10, subarray.getEnd());
		assertEquals(43, subarray.getMax());
	}
	
	@Test
	public void testMaxSubarray2D() {
		int [][] A = {{1, 2, -1, -4, -20}, {-8, -3, 4, 2, 1}, {3, 8, 10, 1, 3}, {-4, -1, 1, 7, -6}};
		
		MaxSubarray.Subarray2D subarray2D = new MaxSubarray().max2DSubarray(A);
		assertEquals(1, subarray2D.getStart());
		assertEquals(3, subarray2D.getEnd());
		assertEquals(1, subarray2D.getStart2());
		assertEquals(3, subarray2D.getEnd2());
		assertEquals(29, subarray2D.getMax());
	}
}
