package intro.datastructures.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import intro.algorithms.sort.IntKeyedData;

public class LinkedListTest {

	@Test
	public void test() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		SearchableLinkedList<Integer, IntKeyedData> list = new SearchableLinkedList<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			list.insertData(a);
		}
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list.toString());
		
		ListElement<IntKeyedData> elm = list.searchFirstElement(95);
		list.deleteElement(elm);
		
		assertEquals("84, 32, 72, 84, 83, 54, 57, 1, 85", list.toString());
	}
	
	@Test
	public void testUnion() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		IntKeyedData [] B = IntKeyedData.toSimpleSortableArray(new int [] {85, 1, 57, 54, 95, 83, 84, 72, 32, 84});
		
		SearchableLinkedList<Integer, IntKeyedData> list1 = new SearchableLinkedList<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			list1.insertData(a);
		}
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list1.toString());
		
		SearchableLinkedList<Integer, IntKeyedData> list2 = new SearchableLinkedList<Integer, IntKeyedData>();
		for(IntKeyedData b: B) {
			list2.insertData(b);
		}
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list2.toString());
		
		list1.union(list2);
		
		assertEquals("84, 32, 72, 84, 83, 95, 54, 57, 1, 85, 84, 32, 72, 84, 83, 95, 54, 57, 1, 85", list1.toString());
	}
	
	@Test
	public void testReverseKElements3() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {8, 7, 6, 5, 4, 3, 2, 1});
		
		SearchableLinkedList<Integer, IntKeyedData> list = new SearchableLinkedList<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			list.insertData(a);
		}
		
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8", list.toString());
		list.reverseKElements(3);
		assertEquals("3, 2, 1, 6, 5, 4, 8, 7", list.toString());
	}
	
	@Test
	public void testReverseKElements5() {
		IntKeyedData [] A = IntKeyedData.toSimpleSortableArray(new int [] {8, 7, 6, 5, 4, 3, 2, 1});
		
		SearchableLinkedList<Integer, IntKeyedData> list = new SearchableLinkedList<Integer, IntKeyedData>();
		for(IntKeyedData a: A) {
			list.insertData(a);
		}
		
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8", list.toString());
		list.reverseKElements(5);
		assertEquals("5, 4, 3, 2, 1, 8, 7, 6", list.toString());
	}
}
