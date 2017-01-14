package intro.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;
import intro.algorithms.tree.KSumNodePairs.NodePair;
import intro.datastructures.list.LinkedList;

public class KSumNodePairsTest {
	
	BinarySearchTree<Integer, IntKeyedData> tree;
	
	@Before
	public void prepareTree() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {13, 5, 9, 9, 9, 23, -5});
		
		tree = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			tree.insertData(a);
		}
	}

	@Test
	public void testNearLinear() {
		assertEquals("13(5(-5,9(,9(,9))),23)", tree.toString());
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		
		LinkedList<NodePair<IntKeyedData>> pairs = kSumNodePairs.findKSumNodePairsNearLinear(18, tree);
		
		assertEquals("(9, 9), (5, 13), (-5, 23)", pairs.toString());
	}

	@Test
	public void testLinear() {
		assertEquals("13(5(-5,9(,9(,9))),23)", tree.toString());
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		
		LinkedList<NodePair<IntKeyedData>> pairs = kSumNodePairs.findKSumNodePairsLinear(18, tree);
		
		assertEquals("(9, 9), (5, 13), (-5, 23)", pairs.toString());
	}
}
