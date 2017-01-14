package amazonprep.datastructures.heap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import amazonprep.algorithms.sort.IntMinMaxProvider;
import amazonprep.algorithms.sort.MinMaxProvider;
import amazonprep.algorithms.sort.SimpleSortable;
import amazonprep.datastructures.heap.Heap.HeapType;

public class HeapTest {
	
	MinMaxProvider<Integer, SimpleSortable> minMaxProvider = new IntMinMaxProvider();

	@Test
	public void testMaxHeap() {
		SimpleSortable [] data = SimpleSortable.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		Heap<Integer, SimpleSortable> h = new Heap<Integer, SimpleSortable>(Arrays.copyOf(data, data.length), data.length, HeapType.MAX);
		h.maintainHeapPropertyAll();
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
		
		for(SimpleSortable element : data) {
			h.insert(element, minMaxProvider);
		}
		checkMaxHeapProperty(h.getData());
	}

	private void checkMaxHeapProperty(SimpleSortable [] data) {
		for(int i=0; i<data.length/2; i++) {
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			assertTrue(data[i].getKey() > data[leftChild].getKey() && (rightChild >= data.length || data[i].getKey() > data[rightChild].getKey()));
		}
	}
	
	@Test
	public void testMinHeap() {
		SimpleSortable [] data = SimpleSortable.toSimpleSortableArray(new int [] {14, 47, 83, 99, 24, 29, 14, 0, 41, 93});
		
		Heap<Integer, SimpleSortable> h = new Heap<>(Arrays.copyOf(data, data.length), data.length, HeapType.MIN);
		h.maintainHeapPropertyAll();
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
		
		for(SimpleSortable element : data) {
			h.insert(element, minMaxProvider);
		}
		checkMinHeapProperty(h.getData());
	}
	
	private void checkMinHeapProperty(SimpleSortable [] data) {
		for(int i=0; i<data.length/2; i++) {
			int leftChild = 2*i+1;
			int rightChild = 2*i+2;
			assertTrue(data[i].getKey() < data[leftChild].getKey() && (rightChild >= data.length || data[i].getKey() < data[rightChild].getKey()));
		}
	}
}
