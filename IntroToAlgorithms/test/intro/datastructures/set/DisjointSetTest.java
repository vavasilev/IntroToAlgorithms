package intro.datastructures.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class DisjointSetTest {

	@Test
	public void test() {
		DisjointSetFactory<BoundInteger> factory = new LinkedListDisjointSetFactory<BoundInteger>();
		
		BoundInteger int1 = new BoundInteger(5, factory);
		BoundInteger int2 = new BoundInteger(8, factory);
		int1.getDisjointSet().union(int2.getDisjointSet());
		assertEquals(int1.getDisjointSet(), int2.getDisjointSet());
		
		BoundInteger int3 = new BoundInteger(5, factory);
		assertNotEquals(int1.getDisjointSet(), int3.getDisjointSet());
		assertNotEquals(int2.getDisjointSet(), int3.getDisjointSet());
		
		int1.getDisjointSet().union(int3.getDisjointSet());
		assertEquals(int1.getDisjointSet(), int3.getDisjointSet());
		assertEquals(int2.getDisjointSet(), int3.getDisjointSet());
		
		BoundInteger int4 = new BoundInteger(28, factory);
		assertNotEquals(int1.getDisjointSet(), int4.getDisjointSet());
		assertNotEquals(int2.getDisjointSet(), int4.getDisjointSet());
		assertNotEquals(int3.getDisjointSet(), int4.getDisjointSet());
		
		BoundInteger int5 = new BoundInteger(40, factory);
		int4.getDisjointSet().union(int5.getDisjointSet());
		int5.getDisjointSet().union(int3.getDisjointSet());

		assertEquals(int1.getDisjointSet(), int4.getDisjointSet());
		assertEquals(int2.getDisjointSet(), int4.getDisjointSet());
		assertEquals(int3.getDisjointSet(), int4.getDisjointSet());
		assertEquals(int1.getDisjointSet(), int5.getDisjointSet());
		assertEquals(int2.getDisjointSet(), int5.getDisjointSet());
		assertEquals(int3.getDisjointSet(), int5.getDisjointSet());
		assertEquals(int4.getDisjointSet(), int5.getDisjointSet());
	}

}
