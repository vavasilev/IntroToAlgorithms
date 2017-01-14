package intro.algorithms.tree;

import intro.algorithms.sort.KeyedData;

public interface BinaryTreeVisitor<T extends Comparable<T>, U extends KeyedData<T>> {

	void visit(BinaryTreeNode<T,U> node, WalkOrder order, WalkOrderData data);
}
