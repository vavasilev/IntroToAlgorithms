package intro.algorithms.tree;

import java.util.Set;

import intro.algorithms.sort.KeyedData;

public class BinaryTreeNode<T extends Comparable<T>, U extends KeyedData<T>> implements 
		KeyedData<T> {

	private BinaryTreeNode<T,U> parent;
	private BinaryTreeNode<T,U> left;
	private BinaryTreeNode<T,U> right;
	private U data;
	
	public BinaryTreeNode() {}
	public BinaryTreeNode(U data) { this.data = data; }
	
	public BinaryTreeNode<T,U> getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode<T,U> left) {
		this.left = left;
	}
	public BinaryTreeNode<T,U> getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode<T,U> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T,U> getParent() {
		return parent;
	}
	public void setParent(BinaryTreeNode<T,U> parent) {
		this.parent = parent;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	public U getData() {
		return data;
	}
	public void setData(U data) {
		this.data = data;
	}
	public void accept(BinaryTreeVisitor<T,U> visitor, Set<WalkOrder> walkOrders) {
		if(walkOrders.contains(WalkOrder.PRE)) {
			visitor.visit(this, WalkOrder.PRE, null);
		}
		if(left != null) {
			left.accept(visitor, walkOrders);
		}
		if(walkOrders.contains(WalkOrder.IN)) {
			visitor.visit(this, WalkOrder.IN, null);
		}
		if(right != null) {
			right.accept(visitor, walkOrders);
		}
		if(walkOrders.contains(WalkOrder.POST)) {
			visitor.visit(this, WalkOrder.POST, null);
		}
	}
	
	@Override
	public T getKey() {
		return getData().getKey();
	}
	@Override
	public void setKey(T key) {
		getData().setKey(key);
	}
}
