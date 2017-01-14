package intro.datastructures.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;
import intro.datastructures.stack.StackWithOptimum.StackWithOptimumType;

public class StackWithOptimumTest {

	@Test
	public void test() {
		StackWithOptimum<Integer, IntKeyedData> stack = new StackWithOptimum<Integer, IntKeyedData>(20, StackWithOptimumType.MIN);
		stack.push(new IntKeyedData(2));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(5));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(8));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(-1));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(11));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(4));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(-1));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(3));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new IntKeyedData(2));
		assertEquals(-1, stack.optimum().getKey().intValue());
		
		stack.pop();
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.pop();
		assertEquals(null, stack.optimum());
	}

}
