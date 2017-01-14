package amazonprep.algorithms.tree;

import amazonprep.algorithms.sort.Sortable;

public class BinaryTreeNodeAndLevel<T extends Comparable<T>, U extends Sortable<T>> {
	private BinaryTreeNode<T,U> node;
	private int level;
	
	public BinaryTreeNodeAndLevel(BinaryTreeNode<T,U> node, int level) {
		super();
		this.node = node;
		this.level = level;
	}

	public BinaryTreeNode<T,U> getNode() {
		return node;
	}

	public int getLevel() {
		return level;
	}
}
