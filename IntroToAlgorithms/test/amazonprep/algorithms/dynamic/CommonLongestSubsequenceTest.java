package amazonprep.algorithms.dynamic;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommonLongestSubsequenceTest {

	@Test
	public void test() {
		String A = "ABCBDAB";
		String B = "BDCABA";
		
		CommonLongestSubsequence calculator = new CommonLongestSubsequence();
		
		String[] result = calculator.calculate(A, B);
		
		assertEquals(3, result.length);
		assertEquals("BCBA", result[0]);
		assertEquals("BCAB", result[1]);
		assertEquals("BDAB", result[2]);
	}

}
