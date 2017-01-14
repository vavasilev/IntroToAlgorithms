package intro.algorithms.dynamic;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperatorsExecutionStrategyTest {

	@Test
	public void test() {
		OperatorsExecutionStrategy strategy = new OperatorsExecutionStrategy();
		String result = strategy.calculate("3*16+20");
		assertEquals("(3.0 * (16.0 + 20.0)) = 108.0", result);
		
		result = strategy.calculate("3*16+20-66*45*76+23-44-23+11*14");
		assertEquals("((((((3.0 * (16.0 + 20.0)) - 66.0) * (45.0 * (76.0 + 23.0))) - (44.0 - 23.0)) + 11.0) * 14.0) = 2619400.0", result);
	}

}
