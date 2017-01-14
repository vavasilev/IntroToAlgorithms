package intro.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;

public class BinarySearchTreeTest {

	BinarySearchTree<Integer, IntKeyedData> tree;
	
	@Before
	public void prepareTree() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 82, 32, 84});
		
		tree = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			tree.insertData(a);
		}
	}
	
	@Test
	public void test() {
		assertEquals("85(1(,57(54(32,),83(72(,82),84(,84)))),95)", tree.toString());
		assertEquals(95, tree.getMaximumElement().getData().getKey().intValue());
		assertEquals(1, tree.getMinimumElement().getData().getKey().intValue());
		
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(57);
		assertEquals(72, tree.getSuccessorElement(element).getData().getKey().intValue());
		element = tree.searchFirstElement(54);
		assertEquals(57, tree.getSuccessorElement(element).getData().getKey().intValue());
		
		element = tree.searchFirstElement(85);
		assertEquals(84, tree.getPredecessorElement(element).getData().getKey().intValue());
		element = tree.searchFirstElement(32);
		assertEquals(1, tree.getPredecessorElement(element).getData().getKey().intValue());
		
		assertEquals("95, 85, 84, 84, 83, 82, 72, 57, 54, 32, 1", tree.getSortedSequence().toString());
		assertEquals("85, 95, 1, 57, 83, 84, 84, 72, 82, 54, 32", tree.getPostOrderSequence().toString());
	}
	
	@Test
	public void testDeleteCase1() {
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(32);
		tree.deleteElement(element);
		assertEquals("85(1(,57(54,83(72(,82),84(,84)))),95)", tree.toString());
	}
	
	@Test
	public void testDeleteCase2() {
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(54);
		tree.deleteElement(element);
		assertEquals("85(1(,57(32,83(72(,82),84(,84)))),95)", tree.toString());
	}
	
	@Test
	public void testDeleteCase3() {
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(72);
		tree.deleteElement(element);
		assertEquals("85(1(,57(54(32,),83(82,84(,84)))),95)", tree.toString());
	}
	
	@Test
	public void testDeleteCase4() {
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(83);
		tree.deleteElement(element);
		assertEquals("85(1(,57(54(32,),84(72(,82),84))),95)", tree.toString());
	}
	
	@Test
	public void testDeleteCase5() {
		BinaryTreeNode<Integer, IntKeyedData> element = tree.searchFirstElement(57);
		tree.deleteElement(element);
		assertEquals("85(1(,72(54(32,),83(82,84(,84)))),95)", tree.toString());
	}
	
	@Test
	public void testConvertToPostOrderDDL() {
		tree.converToDLL(WalkOrder.POST);
		assertEquals("32(54(82(72(84(84(83(57(1(95(85,),),),),),),),),),)", tree.toString());
	}
	
	@Test
	public void testConvertToInOrderDDL() {
		tree.converToDLL(WalkOrder.IN);
		assertEquals("1(32(54(57(72(82(83(84(84(85(95,),),),),),),),),),)", tree.toString());
	}
}
