package intro.algorithms.tree;

import intro.algorithms.sort.IntKeyedData;
import intro.datastructures.list.LinkedList;

public class KSumNodePairs {
	
	public LinkedList<NodePair<IntKeyedData>> findKSumNodePairsNearLinear(int k, BinarySearchTree<Integer, IntKeyedData> bst) {
		LinkedList<NodePair<IntKeyedData>> pairs = new LinkedList<NodePair<IntKeyedData>>();
		
		BinaryTreeNode<Integer, IntKeyedData> elm1 = bst.getMinimumElement();
		BinaryTreeNode<Integer, IntKeyedData> elm2 = bst.getMaximumElement();
		
		while(elm1 != elm2) {
			int elm1Key = elm1.getData().getKey();
			int elm2Key = elm2.getData().getKey();
			if(elm1Key + elm2Key == k) {
				pairs.insertData(new NodePair<IntKeyedData>(elm1.getData(), elm2.getData()));
				
				BinaryTreeNode<Integer, IntKeyedData> elm1Succ = bst.getSuccessorElement(elm1);
				BinaryTreeNode<Integer, IntKeyedData> elm2Pred = bst.getPredecessorElement(elm2);
				
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
	
	public LinkedList<NodePair<IntKeyedData>> findKSumNodePairsLinear(int k, BinarySearchTree<Integer, IntKeyedData> bst) {
		LinkedList<NodePair<IntKeyedData>> pairs = new LinkedList<NodePair<IntKeyedData>>();
		
		bst.converToDLL(WalkOrder.IN);
		
		BinaryTreeNode<Integer, IntKeyedData> elm1 = bst.getRoot();
		BinaryTreeNode<Integer, IntKeyedData> elm2 = bst.getMinimumElement();
		
		while(elm1 != elm2) {
			int elm1Key = elm1.getData().getKey();
			int elm2Key = elm2.getData().getKey();
			if(elm1Key + elm2Key == k) {
				pairs.insertData(new NodePair<IntKeyedData>(elm1.getData(), elm2.getData()));
				
				BinaryTreeNode<Integer, IntKeyedData> elm1Succ = elm1.getLeft();
				BinaryTreeNode<Integer, IntKeyedData> elm2Pred = elm2.getParent();
				
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
