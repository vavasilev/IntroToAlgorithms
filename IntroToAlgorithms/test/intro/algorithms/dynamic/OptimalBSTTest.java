package amazonprep.algorithms.dynamic;

import static org.junit.Assert.*;

import org.junit.Test;

import amazonprep.algorithms.sort.StringSortable;
import amazonprep.algorithms.tree.BinarySearchTree;

public class OptimalBSTTest {

	@Test
	public void test() {
		String [] keys = new String [] {null, "k1", "k2", "k3", "k4", "k5"};
		double [] p = new double[] {0, 0.15, 0.1, 0.05, 0.1, 0.2};
		double [] q = new double[] {0.05, 0.1, 0.05, 0.05, 0.05, 0.1};
		
		OptimalBST optimalBST = new OptimalBST();
		
		BinarySearchTree<String, StringSortable> bst = optimalBST.calculate(keys, p, q, 5);
		
		assertEquals("k2(k1(q0,q1),k5(k4(k3(q2,q3),q4),q5))", bst.toString());
	}

}
