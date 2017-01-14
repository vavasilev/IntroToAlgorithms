package amazonprep.datastructures.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import amazonprep.algorithms.sort.SimpleSortable;

public class LinkedListTest {

	@Test
	public void test() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		SearchableLinkedList<Integer, SimpleSortable> list = new SearchableLinkedList<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			list.insertData(a);
		}
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list.toString());
		
		ListElement<SimpleSortable> elm = list.searchFirstElement(95);
		list.deleteElement(elm);
		
		assertEquals("84, 32, 72, 84, 83, 54, 57, 1, 85", list.toString());
	}
	
	@Test
	public void testUnion() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		SimpleSortable [] B = SimpleSortable.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		SearchableLinkedList<Integer, SimpleSortable> list1 = new SearchableLinkedList<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			list1.insertData(a);
		}
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list1.toString());
		
		SearchableLinkedList<Integer, SimpleSortable> list2 = new SearchableLinkedList<Integer, SimpleSortable>();
		for(SimpleSortable b: B) {
			list2.insertData(b);
		}
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list2.toString());
		
		list1.union(list2);
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85, 84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list1.toString());
	}
	
	@Test
	public void testReverseKElements3() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {8, 7, 6, 5, 4, 3, 2, 1});
		
		SearchableLinkedList<Integer, SimpleSortable> list = new SearchableLinkedList<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			list.insertData(a);
		}
		
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8", list.toString());
		list.reverseKElements(3);
		assertEquals("3, 2, 1, 6, 5, 4, 8, 7", list.toString());
	}
	
	@Test
	public void testReverseKElements5() {
		SimpleSortable [] A = SimpleSortable.toSimpleSortableArray(new int [] {8, 7, 6, 5, 4, 3, 2, 1});
		
		SearchableLinkedList<Integer, SimpleSortable> list = new SearchableLinkedList<Integer, SimpleSortable>();
		for(SimpleSortable a: A) {
			list.insertData(a);
		}
		
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8", list.toString());
		list.reverseKElements(5);
		assertEquals("5, 4, 3, 2, 1, 8, 7, 6", list.toString());
	}
}
