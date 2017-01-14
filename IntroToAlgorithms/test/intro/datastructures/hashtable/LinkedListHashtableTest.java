package intro.datastructures.hashtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;

public class LinkedListHashtableTest {

	@Test
	public void test() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		Hashtable<IntKeyedData> hashtable = new LinkedListHashtable<IntKeyedData>(20);
		for(IntKeyedData a: A) {
			hashtable.insertData(a);
		}
		
		assertEquals("4:[57], 5:[83], 7:[54], 9:[72], 10:[85], 12:[1], 14:[95], 15:[32], 18:[84, 84]", hashtable.toString());
		
		IntKeyedData elm = hashtable.getData(95);
		assertSame(A[4], elm);
		hashtable.deleteData(95);
		
		assertEquals("4:[57], 5:[83], 7:[54], 9:[72], 10:[85], 12:[1], 14:[], 15:[32], 18:[84, 84]", hashtable.toString());
	}

}
