package amazonprep.algorithms.tree;

import amazonprep.algorithms.sort.Sortable;

public interface BinaryTreeVisitor<T extends Comparable<T>, U extends Sortable<T>> {

	void visit(BinaryTreeNode<T,U> node, WalkOrder order, WalkOrderData data);
}
