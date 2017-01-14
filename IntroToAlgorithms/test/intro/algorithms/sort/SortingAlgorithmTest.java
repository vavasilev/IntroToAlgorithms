package intro.algorithms.sort;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortingAlgorithmTest {
	
	private static List<IntKeyedData[]> evenlyDistributedDataList;
	private static List<IntKeyedData[]> sortedAscDataList;
	private static List<IntKeyedData[]> sortedDescDataList;
	
	private List<IntKeyedData[]> dataList;
	
	@BeforeClass
	public static void setupClass() {
		evenlyDistributedDataList = new ArrayList<IntKeyedData[]>();
		evenlyDistributedDataList.add(setupEvenlyDistributedData(10));
		evenlyDistributedDataList.add(setupEvenlyDistributedData(10000));
		evenlyDistributedDataList.add(setupEvenlyDistributedData(100000));
		evenlyDistributedDataList.add(setupEvenlyDistributedData(1000000));
		evenlyDistributedDataList.add(setupEvenlyDistributedData(10000000));
		
		sortedAscDataList = new ArrayList<IntKeyedData[]>();
		sortedAscDataList.add(setupSortedData(10, true));
		sortedAscDataList.add(setupSortedData(10000, true));
		sortedAscDataList.add(setupSortedData(100000, true));
		sortedAscDataList.add(setupSortedData(1000000, true));
		sortedAscDataList.add(setupSortedData(10000000, true));
		
		sortedDescDataList = new ArrayList<IntKeyedData[]>();
		sortedDescDataList.add(setupSortedData(10, false));
		sortedDescDataList.add(setupSortedData(10000, false));
		sortedDescDataList.add(setupSortedData(100000, false));
		sortedDescDataList.add(setupSortedData(1000000, false));
		sortedDescDataList.add(setupSortedData(10000000, false));
	}
	
	@Before
	public void setup() {
		dataList = evenlyDistributedDataList;
	}
	
	@Test
	public void testBSTSort() {
		SortingAlgorithm<Integer, IntKeyedData> algorithm = new BSTSort<Integer, IntKeyedData>();
		IntKeyedData [] data = Arrays.copyOf(dataList.get(0), dataList.get(0).length);
		System.out.print("Array before: ");
		printArray(data);
		System.out.println();
		testSortingAlgorithm(algorithm, data);
		System.out.print("Array after: ");
		printArray(data);
		System.out.println();
		
		data = Arrays.copyOf(dataList.get(2), dataList.get(2).length);
		testSortingAlgorithm(algorithm, data);
		data = Arrays.copyOf(dataList.get(3), dataList.get(3).length);
		testSortingAlgorithm(algorithm, data);
//		data = Arrays.copyOf(dataList.get(4), dataList.get(4).length);
//		testSortingAlgorithm(algorithm, data);
		
		System.out.println();
	}
	
	@Test
	public void testQuickSort() {
		SortingAlgorithm<Integer, IntKeyedData> algorithm = new QuickSort<Integer, IntKeyedData>();
		IntKeyedData [] data = Arrays.copyOf(dataList.get(0), dataList.get(0).length);
		System.out.print("Array before: ");
		printArray(data);
		System.out.println();
		testSortingAlgorithm(algorithm, data);
		System.out.print("Array after: ");
		printArray(data);
		System.out.println();
		
		data = Arrays.copyOf(dataList.get(2), dataList.get(2).length);
		testSortingAlgorithm(algorithm, data);
		data = Arrays.copyOf(dataList.get(3), dataList.get(3).length);
		testSortingAlgorithm(algorithm, data);
//		data = Arrays.copyOf(dataList.get(4), dataList.get(4).length);
//		testSortingAlgorithm(algorithm, data);
		
		System.out.println();
	}
	
	@Test
	public void testHeapSort() {
		SortingAlgorithm<Integer, IntKeyedData> algorithm = new HeapSort<Integer, IntKeyedData>();
		IntKeyedData [] data = Arrays.copyOf(dataList.get(0), dataList.get(0).length);
		System.out.print("Array before: ");
		printArray(data);
		System.out.println();
		testSortingAlgorithm(algorithm, data);
		System.out.print("Array after: ");
		printArray(data);
		System.out.println();
		
		data = Arrays.copyOf(dataList.get(2), dataList.get(2).length);
		testSortingAlgorithm(algorithm, data);
		data = Arrays.copyOf(dataList.get(3), dataList.get(3).length);
		testSortingAlgorithm(algorithm, data);
//		data = Arrays.copyOf(dataList.get(4), dataList.get(4).length);
//		testSortingAlgorithm(algorithm, data);
		
		System.out.println();
	}
	
	@Test
	public void testMergeSort() {
		SortingAlgorithm<Integer, IntKeyedData> algorithm = 
				new MergeSort<Integer, IntKeyedData>(new IntMinMaxProvider());
		IntKeyedData [] data = Arrays.copyOf(dataList.get(0), dataList.get(0).length);
		System.out.print("Array before: ");
		printArray(data);
		System.out.println();
		testSortingAlgorithm(algorithm, data);
		System.out.print("Array after: ");
		printArray(data);
		System.out.println();
		
		data = Arrays.copyOf(dataList.get(2), dataList.get(2).length);
		testSortingAlgorithm(algorithm, data);
		data = Arrays.copyOf(dataList.get(3), dataList.get(3).length);
		testSortingAlgorithm(algorithm, data);
//		data = Arrays.copyOf(dataList.get(4), dataList.get(4).length);
//		testSortingAlgorithm(algorithm, data);
		
		System.out.println();
	}
	
	@Test
	public void testInsertionSort() {
		SortingAlgorithm<Integer, IntKeyedData> algorithm = new InsertionSort<Integer, IntKeyedData>();
		IntKeyedData [] data = Arrays.copyOf(dataList.get(0), dataList.get(0).length);
		System.out.print("Array before: ");
		printArray(data);
		System.out.println();
		testSortingAlgorithm(algorithm, data);
		System.out.print("Array after: ");
		printArray(data);
		System.out.println();
		
		data = Arrays.copyOf(dataList.get(1), dataList.get(1).length);
		testSortingAlgorithm(algorithm, data);
//		data = Arrays.copyOf(dataList.get(2), dataList.get(2).length);
//		testSortingAlgorithm(algorithm, data);
		
		System.out.println();
	}
	
	private void testSortingAlgorithm(SortingAlgorithm<Integer, IntKeyedData> algorithm, IntKeyedData [] data) {
		long start = System.currentTimeMillis();
		data = algorithm.sort(data);
		long end = System.currentTimeMillis();
		System.out.println("Algoritm "+algorithm.getName()+": records: "+data.length+", time: "+(end-start));
		for(int i = 0; i< data.length-1; i++) {
			if(data[i].getKey().compareTo(data[i+1].getKey()) > 0) {
				fail("Array is not sorted: data["+i+"] = "+data[i]+", data["+(i+1)+"] = "+data[i+1]);
			}
		}
	}

	public static IntKeyedData [] setupEvenlyDistributedData(int length) {
		IntKeyedData [] result = new IntKeyedData [length];
		
		for(int i = 0; i<length; i++) {
			result[i] = new IntKeyedData((int)((double)length*Math.random()*10.0));
		}
		
		return result;
	}
	
	private static IntKeyedData [] setupSortedData(int length, boolean asc) {
		IntKeyedData [] result = new IntKeyedData [length];
		
		for(int i = 0; i<length; i++) {
			result[i] = new IntKeyedData(asc ? i : length - i - 1);
		}
		
		return result;
	}
	
	private void printArray(IntKeyedData [] data) {
		for(int i=0; i<data.length-1; i++) {
			System.out.print(data[i]+", ");
		}
		System.out.print(data[data.length-1]);
	}
}
