package amazonprep.algorithms.sort;

import amazonprep.algorithms.tree.BinarySearchTree;
import amazonprep.datastructures.list.LinkedList;

public class BSTSort<T extends Comparable<T>, U extends Sortable<T>> implements SortingAlgorithm<T,U> {

	@Override
	public U[] sort(U[] A) {
		BinarySearchTree<T,U> tree = new BinarySearchTree<T,U>();
		for(U a : A) {
			tree.insertData(a);
		}
		LinkedList<U> sortedSequence = tree.getSortedSequence();
		int i=A.length-1;
		for(U a : sortedSequence) {
			A[i] = a;
			i--;
		}
		return A;
	}

	@Override
	public String getName() {
		return "Binary Search Tree sort";
	}

}
