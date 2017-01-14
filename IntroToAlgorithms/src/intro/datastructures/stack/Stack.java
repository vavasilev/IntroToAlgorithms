package intro.datastructures.stack;


public class Stack<T> {
	private T[] data;
	private int top;
	private int size;

	public Stack(int size) {
		this.size = size;
		this.data = (T[]) new Object[size];
	}

	public void push(T elm) {
		if (top == size - 1) {
			throw new ArrayIndexOutOfBoundsException("Stack overflow");
		}
		data[top] = elm;
		top++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Stack underflow");
		}
		top--;
		return data[top];
	}
	
	public T top() {
		if (isEmpty()) {
			return null;
		}
		return data[top-1];
	}
	
	public boolean isEmpty() {
		return (top == 0);
	}
}