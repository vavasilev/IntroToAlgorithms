package amazonprep.datastructures.queue;


public class Queue<T> {

	private T[] data;
	private int start;
	private int end;
	private int size;
	private boolean overflow;

	public Queue(int size) {
		this.size = size;
		this.data = (T[]) new Object[size];
	}

	public void enqueue(T elm) {
		if (overflow) {
			throw new ArrayIndexOutOfBoundsException("Queue overflow");
		}
		data[end] = elm;
		end = (end + 1) % size;

		if (end == start) {
			overflow = true;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Queue underflow");
		}
		overflow = false;
		T elm = data[start];
		start = (start + 1) % size;
		return elm;
	}
	
	public boolean isEmpty() {
		return (start == end && !overflow);
	}
}