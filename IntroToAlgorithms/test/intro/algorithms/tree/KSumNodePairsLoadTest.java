package intro.algorithms.tree;

import org.junit.BeforeClass;
import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;
import intro.algorithms.sort.SortingAlgorithmTest;
import intro.algorithms.tree.KSumNodePairs.NodePair;
import intro.datastructures.list.LinkedList;

public class KSumNodePairsLoadTest {
	
	static BinarySearchTree<Integer, IntKeyedData> loadTreeS;
	static BinarySearchTree<Integer, IntKeyedData> loadTreeM;
	static BinarySearchTree<Integer, IntKeyedData> loadTreeL;
	static BinarySearchTree<Integer, IntKeyedData> loadTreeXL;
	
	static IntKeyedData [] sizeS = null;
	static IntKeyedData [] sizeM = null;
	static IntKeyedData [] sizeL = null;
	static IntKeyedData [] sizeXL = null;
	
	@BeforeClass
	public static void setupClass() {
		sizeS = SortingAlgorithmTest.setupEvenlyDistributedData(10000);
		System.out.println("S data prepared");
		sizeM = SortingAlgorithmTest.setupEvenlyDistributedData(100000);
		System.out.println("M data prepared");
		sizeL = SortingAlgorithmTest.setupEvenlyDistributedData(1000000);
		System.out.println("L data prepared");
		sizeXL = SortingAlgorithmTest.setupEvenlyDistributedData(10000000);
		System.out.println("XL data prepared");
		
		loadTreeS = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData b: sizeS) {
			loadTreeS.insertData(b);
		}
		
		System.out.println("S tree prepared");
		
		loadTreeM = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData b: sizeM) {
			loadTreeM.insertData(b);
		}
		
		System.out.println("M tree prepared");
		
		loadTreeL = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData b: sizeL) {
			loadTreeL.insertData(b);
		}
		
		System.out.println("L tree prepared");
		
		loadTreeXL = new BinarySearchTree<Integer, IntKeyedData>();
		for(IntKeyedData b: sizeXL) {
			loadTreeXL.insertData(b);
		}
		
		System.out.println("XL tree prepared");
	}
	
	@Test
	public void testNearLinearLoad() {
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		long start = System.currentTimeMillis();
		LinkedList<NodePair<IntKeyedData>> pairs = kSumNodePairs.findKSumNodePairsNearLinear(8000, loadTreeS);
		long end = System.currentTimeMillis();
		System.out.println("Algoritm NearLinear (Size S): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsNearLinear(80000, loadTreeM);
		end = System.currentTimeMillis();
		System.out.println("Algoritm NearLinear (Size M): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsNearLinear(800000, loadTreeL);
		end = System.currentTimeMillis();
		System.out.println("Algoritm NearLinear (Size L): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsNearLinear(8000000, loadTreeXL);
		end = System.currentTimeMillis();
		System.out.println("Algoritm NearLinear (Size XL): pairs: "+pairs.getSize()+", time: "+(end-start));
	}
	
	@Test
	public void testLinearLoad() {
		KSumNodePairs kSumNodePairs = new KSumNodePairs();
		long start = System.currentTimeMillis();
		LinkedList<NodePair<IntKeyedData>> pairs = kSumNodePairs.findKSumNodePairsLinear(8000, loadTreeS);
		long end = System.currentTimeMillis();
		System.out.println("Algoritm Linear (Size S): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsLinear(80000, loadTreeM);
		end = System.currentTimeMillis();
		System.out.println("Algoritm Linear (Size M): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsLinear(800000, loadTreeL);
		end = System.currentTimeMillis();
		System.out.println("Algoritm Linear (Size L): pairs: "+pairs.getSize()+", time: "+(end-start));
		
		start = System.currentTimeMillis();
		pairs = kSumNodePairs.findKSumNodePairsLinear(8000000, loadTreeXL);
		end = System.currentTimeMillis();
		System.out.println("Algoritm Linear (Size XL): pairs: "+pairs.getSize()+", time: "+(end-start));
	}
}
