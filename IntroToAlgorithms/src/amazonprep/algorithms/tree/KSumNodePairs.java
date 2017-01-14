package amazonprep.algorithms.tree;

import amazonprep.algorithms.sort.SimpleSortable;
import amazonprep.datastructures.list.LinkedList;

public class KSumNodePairs {
	
	public LinkedList<NodePair<SimpleSortable>> findKSumNodePairsNearLinear(int k, BinarySearchTree<Integer, SimpleSortable> bst) {
		LinkedList<NodePair<SimpleSortable>> pairs = new LinkedList<NodePair<SimpleSortable>>();
		
		BinaryTreeNode<Integer, SimpleSortable> elm1 = bst.getMinimumElement();
		BinaryTreeNode<Integer, SimpleSortable> elm2 = bst.getMaximumElement();
		
		while(elm1 != elm2) {
			int elm1Key = elm1.getData().getKey();
			int elm2Key = elm2.getData().getKey();
			if(elm1Key + elm2Key == k) {
				pairs.insertData(new NodePair<SimpleSortable>(elm1.getData(), elm2.getData()));
				
				BinaryTreeNode<Integer, SimpleSortable> elm1Succ = bst.getSuccessorElement(elm1);
				BinaryTreeNode<Integer, SimpleSortable> elm2Pred = bst.getPredecessorElement(elm2);
				
				while(elm1Succ.getData().getKey() == elm1.getData().getKey() && elm1Succ != elm2) {
					elm1Succ = bst.getSuccessorElement(elm1Succ);
				}
				
				elm1 = elm1Succ;
				
				if(elm1 == elm2) {
					continue;
				}
				
				while(elm2Pred.getData().getKey() == elm2.getData().getKey() && elm2Pred != elm1) {
					elm2Pred = bst.getPredecessorElement(elm2Pred);
				}
				
				if(elm1 == elm2) {
					continue;
				}
			} else if(elm1Key + elm2Key > k) {
				elm2 = bst.getPredecessorElement(elm2);
			} else if(elm1Key + elm2Key < k) {
				elm1 = bst.getSuccessorElement(elm1);
			}
		}
		return pairs;
	}
	
	public LinkedList<NodePair<SimpleSortable>> findKSumNodePairsLinear(int k, BinarySearchTree<Integer, SimpleSortable> bst) {
		LinkedList<NodePair<SimpleSortable>> pairs = new LinkedList<NodePair<SimpleSortable>>();
		
		bst.converToDLL(WalkOrder.IN);
		
		BinaryTreeNode<Integer, SimpleSortable> elm1 = bst.getRoot();
		BinaryTreeNode<Integer, SimpleSortable> elm2 = bst.getMinimumElement();
		
		while(elm1 != elm2) {
			int elm1Key = elm1.getData().getKey();
			int elm2Key = elm2.getData().getKey();
			if(elm1Key + elm2Key == k) {
				pairs.insertData(new NodePair<SimpleSortable>(elm1.getData(), elm2.getData()));
				
				BinaryTreeNode<Integer, SimpleSortable> elm1Succ = elm1.getLeft();
				BinaryTreeNode<Integer, SimpleSortable> elm2Pred = elm2.getParent();
				
				while(elm1Succ.getData().getKey() == elm1.getData().getKey() && elm1Succ != elm2) {
					elm1Succ = elm1Succ.getLeft();
				}
				
				elm1 = elm1Succ;
				
				if(elm1 == elm2) {
					continue;
				}
				
				while(elm2Pred.getData().getKey() == elm2.getData().getKey() && elm2Pred != elm1) {
					elm2Pred = elm2Pred.getParent();
				}
				
				if(elm1 == elm2) {
					continue;
				}
			} else if(elm1Key + elm2Key > k) {
				elm2 = elm2.getParent();
			} else if(elm1Key + elm2Key < k) {
				elm1 = elm1.getLeft();
			}
		}
		return pairs;
	}

	public static class NodePair<T> {
		private T node1;
		private T node2;
		
		public NodePair(T node1, T node2) {
			super();
			this.node1 = node1;
			this.node2 = node2;
		}
		
		public T getNode1() {
			return node1;
		}
		public T getNode2() {
			return node2;
		}

		@Override
		public String toString() {
			return "("+node1.toString()+", "+node2.toString()+")";
		}
	}
}
