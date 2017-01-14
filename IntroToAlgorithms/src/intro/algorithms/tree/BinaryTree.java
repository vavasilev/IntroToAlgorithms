package intro.algorithms.tree;

import java.util.HashSet;
import java.util.Set;

import intro.algorithms.sort.KeyedData;
import intro.algorithms.tree.WalkOrder;
import intro.datastructures.queue.Queue;
import intro.datastructures.stack.Stack;

public class BinaryTree<T extends Comparable<T>, U extends KeyedData<T>> {

	private BinaryTreeNode<T,U> root;

	public BinaryTreeNode<T,U> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T,U> root) {
		this.root = root;
	}
	
	public void accept(BinaryTreeVisitor<T,U> visitor, WalkOrder ...walkOrders) {
		if(root != null) {
			Set<WalkOrder> walkOrdersSet = new HashSet<WalkOrder>();
			for(WalkOrder walkOrder : walkOrders) {
				walkOrdersSet.add(walkOrder);
			}
			
			if(walkOrdersSet.contains(WalkOrder.LEVEL_REQ)) {
				acceptLevelsReq(visitor, getHeight());
			} if(walkOrdersSet.contains(WalkOrder.LEVEL_ITER)) {
				acceptLevelsIter(visitor, getHeight());
			} else if(walkOrdersSet.contains(WalkOrder.SPIRAL_REQ)) {
				acceptSpiralsReq(visitor, getHeight());
			} else if(walkOrdersSet.contains(WalkOrder.SPIRAL_ITER)) {
				acceptSpiralsIter(visitor, getHeight());
			} else {
				root.accept(visitor, walkOrdersSet);
			}
		}
	}

	public int getHeight() {
		final int [] height = new int[1];
		accept(new BinaryTreeVisitor<T,U>() {
			int currentHeight = 0;
			public void visit(BinaryTreeNode<T,U> node, WalkOrder order, WalkOrderData data) {
				if(order == WalkOrder.PRE) {
					currentHeight++;
					if(height[0] < currentHeight) {
						height[0] = currentHeight;
					}
				} else if(order == WalkOrder.POST) {
					currentHeight--;
				}
			}
		}, WalkOrder.PRE, WalkOrder.POST);

		return height[0];
	}
	
	public void acceptLevelsIter(BinaryTreeVisitor<T,U> visitor, int height) {
		Queue<BinaryTreeNodeAndLevel<T,U>> queue = new Queue<BinaryTreeNodeAndLevel<T,U>>((int)Math.pow(2.0, (double)height)-1);
		queue.enqueue(new BinaryTreeNodeAndLevel<T,U>(root, 1));
		
		while(!queue.isEmpty()) {
			BinaryTreeNodeAndLevel<T,U> btl = queue.dequeue();
			BinaryTreeNode<T,U> node = btl.getNode();
			int level = btl.getLevel();
			LevelWalkOrderData data = new LevelWalkOrderData();
			data.setLevel(level);
			visitor.visit(node, WalkOrder.LEVEL_ITER, data);
			
			if(node.getLeft() != null) {
				queue.enqueue(new BinaryTreeNodeAndLevel<T,U>(node.getLeft(), level + 1));
			}
			if(node.getRight() != null) {
				queue.enqueue(new BinaryTreeNodeAndLevel<T,U>(node.getRight(), level + 1));
			}
		}
	}
	
	public void acceptLevelsReq(BinaryTreeVisitor<T,U> visitor, int height) {
		for(int i=1; i<=height; i++) {
			acceptLevelReq(root, visitor, i, i);
		}
	}

	public void acceptLevelReq(BinaryTreeNode<T,U> node, BinaryTreeVisitor<T,U> visitor, int level, int actualLevel) {
		if(level == 1) {
			LevelWalkOrderData data = new LevelWalkOrderData();
			data.setLevel(actualLevel);
			visitor.visit(node, WalkOrder.LEVEL_REQ, data);
		} else {
			if(node.getLeft() != null) {
				acceptLevelReq(node.getLeft(), visitor, level - 1, actualLevel);
			}
			if(node.getRight() != null) {
				acceptLevelReq(node.getRight(), visitor, level - 1, actualLevel);
			}
		}
	}
	
	public void acceptSpiralsReq(BinaryTreeVisitor<T,U> visitor, int height) {
		boolean rightToLeft = true;
		for(int i=1; i<=height; i++) {
			acceptSpiralReq(root, visitor, i, i, rightToLeft);
			rightToLeft = !rightToLeft;
		}
	}

	public void acceptSpiralReq(BinaryTreeNode<T,U> node, BinaryTreeVisitor<T,U> visitor, int level, int actualLevel, boolean rightToLeft) {
		if(level == 1) {
			LevelWalkOrderData data = new LevelWalkOrderData();
			data.setLevel(actualLevel);
			visitor.visit(node, WalkOrder.SPIRAL_REQ, data);
		} else {
			BinaryTreeNode<T,U> first = rightToLeft ? node.getRight() : node.getLeft();
			BinaryTreeNode<T,U> second = rightToLeft ? node.getLeft() : node.getRight();
			if(first != null) {
				acceptSpiralReq(first, visitor, level - 1, actualLevel, rightToLeft);
			}
			if(second != null) {
				acceptSpiralReq(second, visitor, level - 1, actualLevel, rightToLeft);
			}
		}
	}
	
	public void acceptSpiralsIter(BinaryTreeVisitor<T,U> visitor, int height) {
		Stack<BinaryTreeNodeAndLevel<T,U>> stack1 = new Stack<BinaryTreeNodeAndLevel<T,U>>((int)Math.pow(2.0, (double)height)-1);
		Stack<BinaryTreeNodeAndLevel<T,U>> stack2 = new Stack<BinaryTreeNodeAndLevel<T,U>>((int)Math.pow(2.0, (double)height)-1);
		stack1.push(new BinaryTreeNodeAndLevel<T,U>(root, 1));
		
		while(!stack1.isEmpty()) {
			while(!stack1.isEmpty()) {
				BinaryTreeNodeAndLevel<T,U> btl = stack1.pop();
				BinaryTreeNode<T,U> node = btl.getNode();
				int level = btl.getLevel();
				LevelWalkOrderData data = new LevelWalkOrderData();
				data.setLevel(level);
				visitor.visit(node, WalkOrder.SPIRAL_ITER, data);
				
				if(node.getRight() != null) {
					stack2.push(new BinaryTreeNodeAndLevel<T,U>(node.getRight(), level + 1));
				}
				if(node.getLeft() != null) {
					stack2.push(new BinaryTreeNodeAndLevel<T,U>(node.getLeft(), level + 1));
				}
			}
			
			while(!stack2.isEmpty()) {
				BinaryTreeNodeAndLevel<T,U> btl = stack2.pop();
				BinaryTreeNode<T,U> node = btl.getNode();
				int level = btl.getLevel();
				LevelWalkOrderData data = new LevelWalkOrderData();
				data.setLevel(level);
				visitor.visit(node, WalkOrder.SPIRAL_ITER, data);
				
				if(node.getLeft() != null) {
					stack1.push(new BinaryTreeNodeAndLevel<T,U>(node.getLeft(), level + 1));
				}
				if(node.getRight() != null) {
					stack1.push(new BinaryTreeNodeAndLevel<T,U>(node.getRight(), level + 1));
				}
			}
		}
	}
	
	public void converToDLL(WalkOrder order) {
		this.accept(new BinaryTreeVisitor<T,U>() {
			BinaryTreeNode<T,U> lastNode = null;
			@Override
			public void visit(BinaryTreeNode<T,U> node, WalkOrder order,
					WalkOrderData data) {
				if(lastNode == null) {
					lastNode = node;
					node.setParent(null);
					node.setLeft(null);
					BinaryTree.this.setRoot(node);
					return;
				} else {
					lastNode.setLeft(node);
					node.setParent(lastNode);
					node.setLeft(null);
					lastNode = node;
				}
			}
		}, order);
		// Fix right
		BinaryTreeNode<T,U> node = root;
		if(node == null) {
			return;
		}
		node.setRight(null);
		while(node.getLeft() != null) {
			node = node.getLeft();
			node.setRight(null);
		}
	}
}
