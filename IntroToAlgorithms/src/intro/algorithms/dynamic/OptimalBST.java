package amazonprep.algorithms.dynamic;

import amazonprep.algorithms.sort.StringSortable;
import amazonprep.algorithms.tree.BinarySearchTree;
import amazonprep.algorithms.tree.BinaryTreeNode;

public class OptimalBST {
	
	public BinarySearchTree<String, StringSortable> calculate(String [] keys, double [] p, double [] q, int num) {
		
		double [][] e = new double [num+2][num+2];
		double [][] w = new double [num+2][num+2];
		int [][] root = new int [num+1][num+1];
		
		for(int i=1; i <= num+1; i++) {
			e[i][i-1] = q[i-1];
			w[i][i-1] = q[i-1];
		}
		
		for(int l=1; l<=num; l++) {
			for(int i = 1; i <= num - l + 1; i++) {
				int j = i + l - 1;
				w[i][j] = w[i][j-1] + p[j] + q[j];
				e[i][j] = Double.MAX_VALUE;
				
				for(int r = i; r<=j; r++) {
					double t = e[i][r-1] + e[r+1][j] + w[i][j];
					if(t < e[i][j]) {
						e[i][j] = t;
						root[i][j] = r;
					}
				}
			}
		}
		
		BinaryTreeNode<String, StringSortable> rootNode = new BinaryTreeNode<String, StringSortable>();
		addKey(keys, root, 1, num, rootNode);
		
		BinarySearchTree<String, StringSortable> bst = new BinarySearchTree<String, StringSortable>();
		bst.setRoot(rootNode);
		
		return bst;
	}
	
	private void addKey(String [] keys, int [][] root, int i, int j, BinaryTreeNode<String, StringSortable> node) {
		if(j < i) {
			node.setData(new StringSortable("q"+j));
			return;
		}
		
		int r = root[i][j];
		node.setData(new StringSortable(keys[r]));
		
		if(r >= i) {
			BinaryTreeNode<String, StringSortable> nodeL = new BinaryTreeNode<String, StringSortable>();
			node.setLeft(nodeL);
			nodeL.setParent(node);
			addKey(keys, root, i, r-1, nodeL);
		}
		
		if(r <= j) {
			BinaryTreeNode<String, StringSortable> nodeR= new BinaryTreeNode<String, StringSortable>();
			node.setRight(nodeR);
			nodeR.setParent(node);
			addKey(keys, root, r+1, j, nodeR);
		}
	}
}
