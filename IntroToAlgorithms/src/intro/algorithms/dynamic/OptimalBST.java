package intro.algorithms.dynamic;

import intro.algorithms.sort.StringKeyedData;
import intro.algorithms.tree.BinarySearchTree;
import intro.algorithms.tree.BinaryTreeNode;

public class OptimalBST {
	
	public BinarySearchTree<String, StringKeyedData> calculate(String [] keys, double [] p, double [] q, int num) {
		
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
		
		BinaryTreeNode<String, StringKeyedData> rootNode = new BinaryTreeNode<String, StringKeyedData>();
		addKey(keys, root, 1, num, rootNode);
		
		BinarySearchTree<String, StringKeyedData> bst = new BinarySearchTree<String, StringKeyedData>();
		bst.setRoot(rootNode);
		
		return bst;
	}
	
	private void addKey(String [] keys, int [][] root, int i, int j, BinaryTreeNode<String, StringKeyedData> node) {
		if(j < i) {
			node.setData(new StringKeyedData("q"+j));
			return;
		}
		
		int r = root[i][j];
		node.setData(new StringKeyedData(keys[r]));
		
		if(r >= i) {
			BinaryTreeNode<String, StringKeyedData> nodeL = new BinaryTreeNode<String, StringKeyedData>();
			node.setLeft(nodeL);
			nodeL.setParent(node);
			addKey(keys, root, i, r-1, nodeL);
		}
		
		if(r <= j) {
			BinaryTreeNode<String, StringKeyedData> nodeR= new BinaryTreeNode<String, StringKeyedData>();
			node.setRight(nodeR);
			nodeR.setParent(node);
			addKey(keys, root, r+1, j, nodeR);
		}
	}
}
