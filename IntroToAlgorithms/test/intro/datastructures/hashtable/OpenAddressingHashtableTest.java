package amazonprep.datastructures.hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;

public class OpenAddressingHashtableTest {

	@Test
	public void test() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84, 43});
		
		Hashtable<SimpleSortable> hashtable = new OpenAddressingHashtable<SimpleSortable>(21);
		for(SimpleSortable a: A) {
			hashtable.insertData(a);
		}
		assertEquals("84, 85, null, 1, null, 84, null, null, null, 72, null, 95, 54, 43, null, 57, 32, null, null, null, 83", hashtable.toString());
		
		SimpleSortable elm = hashtable.getData(95);
		assertSame(A[4], elm);
		hashtable.deleteData(95);
		
		assertEquals("84, 85, null, 1, null, 84, null, null, null, 72, null, -1, 54, 43, null, 57, 32, null, null, null, 83", hashtable.toString());
	}

}
