package intro.datastructures.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import intro.algorithms.sort.IntMinMaxProvider;
import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.IntKeyedData;
import intro.datastructures.heap.Heap.HeapType;

public class HeapTest {
	
	MinMaxProvider<Integer, IntKeyedData> minMaxProvider = new IntMinMaxProvider();

	@Test
	public void testMaxHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		BinaryHeap<Integer, IntKeyedData> h = new BinaryHeap<Integer, IntKeyedData>(
				Arrays.copyOf(data, data.length), 
				data.length, 
				HeapType.MAX,
				minMaxProvider);
		checkMaxHeapProperty(h.getData());
		assertEquals(99, h.extractOptimalElement().getKey().intValue());
		assertEquals(93, h.extractOptimalElement().getKey().intValue());
		assertEquals(83, h.extractOptimalElement().getKey().intValue());
		assertEquals(47, h.extractOptimalElement().getKey().intValue());
		assertEquals(41, h.extractOptimalElement().getKey().intValue());
		assertEquals(29, h.extractOptimalElement().getKey().intValue());
		assertEquals(24, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.getSize());
		
		for(IntKeyedData element : data) {
			h.insert(element);
		}
		checkMaxHeapProperty(h.getData());
	}

	private void checkMaxHeapProperty(IntKeyedData [] data) {
		for(int i=0; i<data.length/2; i++) {
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			assertTrue(data[i].getKey() > data[leftChild].getKey() && (rightChild >= data.length || data[i].getKey() > data[rightChild].getKey()));
		}
	}
	
	@Test
	public void testMinHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		BinaryHeap<Integer, IntKeyedData> h = new BinaryHeap<>(
				Arrays.copyOf(data, data.length), 
				data.length, 
				HeapType.MIN,
				minMaxProvider);
		checkMinHeapProperty(h.getData());
		assertEquals(0, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(24, h.extractOptimalElement().getKey().intValue());
		assertEquals(29, h.extractOptimalElement().getKey().intValue());
		assertEquals(41, h.extractOptimalElement().getKey().intValue());
		assertEquals(47, h.extractOptimalElement().getKey().intValue());
		assertEquals(83, h.extractOptimalElement().getKey().intValue());
		assertEquals(93, h.extractOptimalElement().getKey().intValue());
		assertEquals(99, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.getSize());
		
		for(IntKeyedData element : data) {
			h.insert(element);
		}
		checkMinHeapProperty(h.getData());
	}
	
	private void checkMinHeapProperty(IntKeyedData [] data) {
		for(int i=0; i<data.length/2; i++) {
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			assertTrue(data[i].getKey() < data[leftChild].getKey() && (rightChild >= data.length || data[i].getKey() < data[rightChild].getKey()));
		}
	}
}
