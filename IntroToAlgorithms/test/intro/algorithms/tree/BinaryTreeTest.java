package amazonprep.algorithms.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;

public class BinaryTreeTest {
	StringBuilder sb = new StringBuilder();
	
	BinaryTreeVisitor<Integer, SimpleSortable> visitor = new BinaryTreeVisitor<Integer, SimpleSortable>() {
		int level = 0;
		@Override
		public void visit(BinaryTreeNode<Integer, SimpleSortable> node, WalkOrder order,
				WalkOrderData data) {
			if(level != ((LevelWalkOrderData)data).getLevel()) {
				level = ((LevelWalkOrderData)data).getLevel();
				sb.append("/"+level+": ");
			}
			sb.append(node.getData().toString()+" ");
		}};

	BinarySearchTree<Integer, SimpleSortable> tree;
	
	@Before
	public void prepareTree() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 82, 32, 84});
		
		tree = new BinarySearchTree<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			tree.insertData(a);
		}
	}
	
	@Test
	public void testLevelWalkOrderReq() {
		tree.accept(visitor, WalkOrder.LEVEL_REQ);
		assertEquals("/1: 85 /2: 1 95 /3: 57 /4: 54 83 /5: 32 72 84 /6: 82 84 ", sb.toString());
	}
	
	@Test
	public void testLevelWalkOrderIter() {
		tree.accept(visitor, WalkOrder.LEVEL_ITER);
		assertEquals("/1: 85 /2: 1 95 /3: 57 /4: 54 83 /5: 32 72 84 /6: 82 84 ", sb.toString());
	}

	@Test
	public void testSpiralWalkOrderReq() {
		tree.accept(visitor, WalkOrder.SPIRAL_REQ);
		assertEquals("/1: 85 /2: 1 95 /3: 57 /4: 54 83 /5: 84 72 32 /6: 82 84 ", sb.toString());
	}
	
	@Test
	public void testSpiralWalkOrderIter() {
		tree.accept(visitor, WalkOrder.SPIRAL_ITER);
		assertEquals("/1: 85 /2: 1 95 /3: 57 /4: 54 83 /5: 84 72 32 /6: 82 84 ", sb.toString());
	}
}
