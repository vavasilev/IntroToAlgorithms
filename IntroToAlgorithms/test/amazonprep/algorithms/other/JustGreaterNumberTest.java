package amazonprep.algorithms.other;

import static org.junit.Assert.*;

import org.junit.Test;

public class JustGreaterNumberTest {

	@Test
	public void testFindGreaterNumber() {
		JustGreaterNumber algo = new JustGreaterNumber();
		assertEquals(38627, algo.findGreaterNumber(38276));
		assertEquals(123456785123446789l, algo.findGreaterNumber(123456784987654321l));
	}

}
