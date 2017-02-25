package intro.datastructures.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;
import intro.algorithms.sort.IntMinMaxProvider;
import intro.algorithms.sort.MinMaxProvider;
import intro.datastructures.heap.Heap.HeapType;

public class FibonacciHeapTest {
	
	MinMaxProvider<Integer, IntKeyedData> minMaxProvider = new IntMinMaxProvider();

	@Test
	public void testMaxHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		FibonacciHeap<Integer, IntKeyedData> h = new FibonacciHeap<Integer, IntKeyedData>(
				HeapType.MAX,
				minMaxProvider);
		for(int i=0; i<data.length/2; i++) {
			h.insert(data[i]);
		}
		
		FibonacciHeap<Integer, IntKeyedData> h2 = new FibonacciHeap<Integer, IntKeyedData>(
				HeapType.MAX,
				minMaxProvider);
		for(int i=data.length/2; i<data.length; i++) {
			h2.insert(data[i]);
		}
		
		h.union(h2);
		
		assertEquals(99, h.extractOptimalElement().getKey().intValue());
		
		h.updateKey(data[6], 96);
		
		assertEquals(96, h.extractOptimalElement().getKey().intValue());
		assertEquals(93, h.extractOptimalElement().getKey().intValue());
		assertEquals(83, h.extractOptimalElement().getKey().intValue());
		assertEquals(47, h.extractOptimalElement().getKey().intValue());
		assertEquals(41, h.extractOptimalElement().getKey().intValue());
		assertEquals(29, h.extractOptimalElement().getKey().intValue());
		assertEquals(24, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.getSize());
	}
	
	@Test
	public void testMinHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		FibonacciHeap<Integer, IntKeyedData> h = new FibonacciHeap<Integer, IntKeyedData>(
				HeapType.MIN,
				minMaxProvider);
		for(int i=0; i<data.length/2; i++) {
			h.insert(data[i]);
		}
		
		FibonacciHeap<Integer, IntKeyedData> h2 = new FibonacciHeap<Integer, IntKeyedData>(
				HeapType.MIN,
				minMaxProvider);
		for(int i=data.length/2; i<data.length; i++) {
			h2.insert(data[i]);
		}
		
		h.union(h2);
		
		assertEquals(0, h.extractOptimalElement().getKey().intValue());
		
		h.updateKey(data[9], 11);
		
		assertEquals(11, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(14, h.extractOptimalElement().getKey().intValue());
		assertEquals(24, h.extractOptimalElement().getKey().intValue());
		assertEquals(29, h.extractOptimalElement().getKey().intValue());
		assertEquals(41, h.extractOptimalElement().getKey().intValue());
		assertEquals(47, h.extractOptimalElement().getKey().intValue());
		assertEquals(83, h.extractOptimalElement().getKey().intValue());
		assertEquals(99, h.extractOptimalElement().getKey().intValue());
		assertEquals(0, h.getSize());
	}

}
