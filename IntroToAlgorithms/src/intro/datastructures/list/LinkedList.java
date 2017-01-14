package amazonprep.datastructures.list;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

	protected ListElement<T> head = new ListElement<T>();
	private int size = 0;
	
	public LinkedList() {
		head.setNext(head);
		head.setPrev(head);
	}
	
	public ListElement<T> insertData(T data) {
		ListElement<T> wrapper = new ListElement<T>();
		wrapper.setData(data);
		insertElement(wrapper);
		return wrapper;
	}
	
	public void insertElement(ListElement<T> element) {
		head.getNext().setPrev(element);
		element.setNext(head.getNext());
		element.setPrev(head);
		head.setNext(element);
		size++;
	}
	
	public void union(LinkedList<T> other) {
		if(other.head.getNext() != other.head) {
			head.getPrev().setNext(other.head.getNext());
			other.head.getNext().setPrev(head.getPrev());
			
			other.head.getPrev().setNext(head);
			head.setPrev(other.head.getPrev());
			
			other.head.setNext(other.head);
			other.head.setPrev(other.head);
		}
	}
	
	public void deleteElement(ListElement<T> element) {
		if(element == head) {
			return;
		}
		element.getPrev().setNext(element.getNext());
		element.getNext().setPrev(element.getPrev());
		element.setNext(null);
		element.setPrev(null);
		size--;
	}
	
	public ListElement<T> getFirst() {
		ListElement<T> elm = head.getNext();
		return elm != head ? elm : null;
	}
	
	public ListElement<T> searchFirstElement(T data) {
		ListElement<T> elm = head.getNext();
		while(elm != head && data!= elm.getData()) {
			elm = elm.getNext();
		}
		
		return elm != head ? elm : null;
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			ListElement<T> elm = head;
			@Override
			public boolean hasNext() {
				return elm.getNext() != head;
			}

			@Override
			public T next() {
				elm = elm.getNext();
				return elm.getData();
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}};
	}
	
	public void reverseKElements(int k) {
		ListElement<T> startElm = null;
		ListElement<T> currentElm = head.getNext();
		
		for(int i=0; currentElm != head; i++) {
			if(i%k == 0) {
				startElm = currentElm.getPrev();
				currentElm=currentElm.getNext();
			} else {
				ListElement<T> prev = currentElm.getPrev();
				ListElement<T> next = currentElm.getNext();
				prev.setNext(next);
				next.setPrev(prev);
				startElm.getNext().setPrev(currentElm);
				currentElm.setNext(startElm.getNext());
				startElm.setNext(currentElm);
				currentElm.setPrev(startElm);
				currentElm=next;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListElement<T> elm = head.getNext();
		while(elm != head) {
			sb.append(elm.toString()+", ");
			elm = elm.getNext();
		}
		if(sb.length() > 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		return sb.toString();
	}
}
