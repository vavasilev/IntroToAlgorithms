package amazonprep.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;
import amazonprep.algorithms.tree.KSumNodePairs.NodePair;
import amazonprep.datastructures.list.LinkedList;

public class KSumNodePairsTest {
	
	BinarySearchTree<Integer, SimpleSortable> tree;
	
	@Before
	public void prepareTree() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {13, 5, 9, 9, 9, 23, -5});
		
		tree = new BinarySearchTree<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			tree.insertData(a);
		}
	}

	@Test
	public void testNearLinear() {
		assertEquals("13(5(-5,9(,9(,9))),23)", tree.toString());
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		
		LinkedList<NodePair<SimpleSortable>> pairs = kSumNodePairs.findKSumNodePairsNearLinear(18, tree);
		
		assertEquals("(9, 9), (5, 13), (-5, 23)", pairs.toString());
	}

	@Test
	public void testLinear() {
		assertEquals("13(5(-5,9(,9(,9))),23)", tree.toString());
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		
		LinkedList<NodePair<SimpleSortable>> pairs = kSumNodePairs.findKSumNodePairsLinear(18, tree);
		
		assertEquals("(9, 9), (5, 13), (-5, 23)", pairs.toString());
	}
}
