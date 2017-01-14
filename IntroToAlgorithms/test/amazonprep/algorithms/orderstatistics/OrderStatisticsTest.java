package amazonprep.algorithms.orderstatistics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;

public class OrderStatisticsTest {

	@Test
	public void test() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		OrderStatistics<Integer, SimpleSortable> os = new OrderStatistics<Integer, SimpleSortable>();
		assertEquals(1, (int)os.find(A, 0).getKey());
		assertEquals(32, (int)os.find(A, 1).getKey());
		assertEquals(54, (int)os.find(A, 2).getKey());
		assertEquals(57, (int)os.find(A, 3).getKey());
		assertEquals(72, (int)os.find(A, 4).getKey());
		assertEquals(83, (int)os.find(A, 5).getKey());
		assertEquals(84, (int)os.find(A, 6).getKey());
		assertEquals(84, (int)os.find(A, 7).getKey());
		assertEquals(85, (int)os.find(A, 8).getKey());
		assertEquals(95, (int)os.find(A, 9).getKey());
	}

}
