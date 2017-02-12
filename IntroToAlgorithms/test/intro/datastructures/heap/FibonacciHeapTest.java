package intro.datastructures.heap;

import static org.junit.Assert.*;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;
import intro.datastructures.heap.Heap.HeapType;

public class FibonacciHeapTest {

	@Test
	public void testMaxHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		FibonacciHeap<Integer, IntKeyedData> h = new FibonacciHeap<Integer, IntKeyedData>(HeapType.MAX);
		for(int i=0; i<data.length/2; i++) {
			h.insert(data[i]);
		}
		
		FibonacciHeap<Integer, IntKeyedData> h2 = new FibonacciHeap<Integer, IntKeyedData>(HeapType.MAX);
		for(int i=data.length/2; i<data.length; i++) {
			h2.insert(data[i]);
		}
		
		h.union(h2);
		
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
	}
	
	@Test
	public void testMinHeap() {
		IntKeyedData [] data = IntKeyedData.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		FibonacciHeap<Integer, IntKeyedData> h = new FibonacciHeap<Integer, IntKeyedData>(HeapType.MIN);
		for(int i=0; i<data.length/2; i++) {
			h.insert(data[i]);
		}
		
		FibonacciHeap<Integer, IntKeyedData> h2 = new FibonacciHeap<Integer, IntKeyedData>(HeapType.MIN);
		for(int i=data.length/2; i<data.length; i++) {
			h2.insert(data[i]);
		}
		
		h.union(h2);
		
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
	}

}
