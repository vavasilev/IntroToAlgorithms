package amazonprep.datastructures.set;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisjointSetTest {

	@Test
	public void test() {
		DisjointSet<Integer> set1 = new DisjointSet<Integer>();
		set1.setData(5);
		DisjointSet<Integer> set2 = new DisjointSet<Integer>();
		set2.setData(8);
		assertNotEquals(set1.getRepresentative(), set2.getRepresentative());
		
		set1.union(set2);
		assertEquals(set1.getRepresentative(), set2.getRepresentative());
		
		DisjointSet<Integer> set3 = new DisjointSet<Integer>();
		set3.setData(18);
		assertNotEquals(set1.getRepresentative(), set3.getRepresentative());
		assertNotEquals(set2.getRepresentative(), set3.getRepresentative());
		
		set1.union(set3);
		assertEquals(set1.getRepresentative(), set3.getRepresentative());
		assertEquals(set2.getRepresentative(), set3.getRepresentative());
		
		DisjointSet<Integer> set4 = new DisjointSet<Integer>();
		set4.setData(28);
		assertNotEquals(set1.getRepresentative(), set4.getRepresentative());
		assertNotEquals(set2.getRepresentative(), set4.getRepresentative());
		assertNotEquals(set3.getRepresentative(), set4.getRepresentative());
		
		set3.union(set4);
		assertEquals(set1.getRepresentative(), set4.getRepresentative());
		assertEquals(set2.getRepresentative(), set4.getRepresentative());
		assertEquals(set3.getRepresentative(), set4.getRepresentative());
	}

}
