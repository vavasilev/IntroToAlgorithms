package amazonprep.datastructures.list;


public class ListElement<T> {

	private T data;
	private ListElement<T> next;
	private ListElement<T> prev;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ListElement<T> getNext() {
		return next;
	}
	public void setNext(ListElement<T> next) {
		this.next = next;
	}
	public ListElement<T> getPrev() {
		return prev;
	}
	public void setPrev(ListElement<T> prev) {
		this.prev = prev;
	}
	@Override
	public String toString() {
		return data == null ? super.toString() : data.toString();
	}
}
