package amazonprep.algorithms.tree;

import amazonprep.algorithms.sort.Sortable;
import amazonprep.algorithms.tree.WalkOrder;
import amazonprep.datastructures.list.LinkedList;

public class BinarySearchTree<T extends Comparable<T>, U extends Sortable<T>> extends BinaryTree<T,U> {

	private DataMerger<U> dataMerger;
	
	public DataMerger<U> getDataMerger() {
		return dataMerger;
	}
	public void setDataMerger(DataMerger<U> dataMerger) {
		this.dataMerger = dataMerger;
	}
	
	public BinaryTreeNode<T,U> insertData(U data) {
		return insertOrUpdateData(data, false);
	}
	public BinaryTreeNode<T,U> insertOrUpdateData(U data, boolean update) {
		BinaryTreeNode<T,U> node = new BinaryTreeNode<T,U>(data);
		if(getRoot() == null) {
			setRoot(node);
		} else {
			BinaryTreeNode<T,U> temp = getRoot();
			BinaryTreeNode<T,U> parent = null;
			while(temp != null) {
				parent = temp;
				if(node.getKey().compareTo(temp.getKey()) < 0) {
					temp = temp.getLeft();
				} else {
					if(update && node.getKey().compareTo(temp.getKey()) == 0) {
						if(dataMerger != null) {
							temp.setData(dataMerger.mergeData(temp.getData(), data));
						}
						return temp;
					}
					temp = temp.getRight();
				}
			}
			
			node.setParent(parent);
			if(node.getKey().compareTo(parent.getKey()) < 0) {
				parent.setLeft(node);
			} else {
				parent.setRight(node);
			}
		}
		return node;
	}
	
	public void deleteElement(BinaryTreeNode<T,U> node) {
		if(node.getLeft() == null) {
			transplant(node, node.getRight());
		} else if(node.getRight() == null) {
			transplant(node, node.getLeft());
		} else {
			BinaryTreeNode<T,U> minSubnode = getMinimumElement(node.getRight());
			if(node.getRight() != minSubnode) {
				transplant(minSubnode, minSubnode.getRight());
				minSubnode.setRight(node.getRight());
				node.getRight().setParent(minSubnode);
			}
			transplant(node, minSubnode);
			minSubnode.setLeft(node.getLeft());
			node.getLeft().setParent(minSubnode);
		}
	}
	
	private void transplant(BinaryTreeNode<T,U> node1, BinaryTreeNode<T,U> node2) {
		BinaryTreeNode<T,U> parent = node1.getParent();
		if(parent == null) {
			setRoot(node2);
		} else {
			if(node2 != null) {
				node2.setParent(parent);
			}
			if(parent.getLeft() == node1) {
				parent.setLeft(node2);
			} else {
				parent.setRight(node2);
			}
		}
		
		node1.setParent(null);
	}
	
	public BinaryTreeNode<T,U> searchFirstElement(T key) {
		BinaryTreeNode<T,U> temp = getRoot();
		
		while(temp != null) {
			if(key.compareTo(temp.getKey()) == 0) {
				return temp;
			}
			else if(key.compareTo(temp.getKey()) < 0) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		
		return null;
	}
	
	public BinaryTreeNode<T,U> getMinimumElement() {
		return getMinimumElement(getRoot());
	}
	
	public BinaryTreeNode<T,U> getMinimumElement(BinaryTreeNode<T,U> node) {
		BinaryTreeNode<T,U> temp = node;
		BinaryTreeNode<T,U> parent = null; 
		while(temp != null) {
			parent = temp;
			temp = temp.getLeft();
		}
		
		return parent;
	}
	
	public BinaryTreeNode<T,U> getMaximumElement() {
		return getMaximumElement(getRoot());
	}
	
	public BinaryTreeNode<T,U> getMaximumElement(BinaryTreeNode<T,U> node) {
		BinaryTreeNode<T,U> temp = node;
		BinaryTreeNode<T,U> parent = null; 
		while(temp != null) {
			parent = temp;
			temp = temp.getRight();
		}
		
		return parent;
	}
	
	public BinaryTreeNode<T,U> getSuccessorElement(BinaryTreeNode<T,U> node) {
		BinaryTreeNode<T,U> successor = null;
		if(node.getRight() != null) {
			successor = getMinimumElement(node.getRight());
		} else {
			while(node.getParent() != null && node == node.getParent().getRight()) {
				node = node.getParent();
			}
			successor = node.getParent();
		}
		
		return successor;
	}
	
	public BinaryTreeNode<T,U> getPredecessorElement(BinaryTreeNode<T,U> node) {
		BinaryTreeNode<T,U> predecessor = null;
		if(node.getLeft() != null) {
			predecessor = getMaximumElement(node.getLeft());
		} else {
			while(node.getParent() != null && node == node.getParent().getLeft()) {
				node = node.getParent();
			}
			predecessor = node.getParent();
		}
		
		return predecessor;
	}
	
	public LinkedList<U> getSortedSequence() {
		final LinkedList<U> list = new LinkedList<U>();
		
		this.accept(new BinaryTreeVisitor<T,U>() {
			@Override
			public void visit(BinaryTreeNode<T,U> node, WalkOrder walkOrder, WalkOrderData data) {
				list.insertData(node.getData());
			}
		}, WalkOrder.IN);
		
		return list;
	}
	
	public LinkedList<U> getPostOrderSequence() {
		final LinkedList<U> list = new LinkedList<U>();
		
		this.accept(new BinaryTreeVisitor<T,U>() {
			@Override
			public void visit(BinaryTreeNode<T,U> node, WalkOrder walkOrder, WalkOrderData data) {
				list.insertData(node.getData());
			}
		}, WalkOrder.POST);
		
		return list;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		this.accept(new BinaryTreeVisitor<T,U>() {
			@Override
			public void visit(BinaryTreeNode<T,U> node, WalkOrder walkOrder, WalkOrderData data) {
				if(node.isLeaf()) {
					if(walkOrder == WalkOrder.PRE) {
						sb.append(node.getData().toString());
					}
				} else {
					if(walkOrder == WalkOrder.PRE) {
						sb.append(node.getData().toString()+"(");
					} else if(walkOrder == WalkOrder.IN) {
						sb.append(",");
					} else if(walkOrder == WalkOrder.POST) {
						sb.append(")");
					}
				}
			}}, WalkOrder.PRE, WalkOrder.IN, WalkOrder.POST);
		return sb.toString();
	}
}
