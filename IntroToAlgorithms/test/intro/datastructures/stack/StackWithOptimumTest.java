package amazonprep.datastructures.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;
import amazonprep.datastructures.stack.StackWithOptimum.StackWithOptimumType;

public class StackWithOptimumTest {

	@Test
	public void test() {
		StackWithOptimum<Integer, SimpleSortable> stack = new StackWithOptimum<Integer, SimpleSortable>(20, StackWithOptimumType.MIN);
		stack.push(new SimpleSortable(2));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(5));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(8));
		assertEquals(2, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(-1));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(11));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(4));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(-1));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(3));
		assertEquals(-1, stack.optimum().getKey().intValue());
		stack.push(new SimpleSortable(2));
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
