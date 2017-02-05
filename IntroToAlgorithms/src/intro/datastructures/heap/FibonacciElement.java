package intro.datastructures.heap;

import intro.datastructures.list.ListElement;

public class FibonacciElement<T> extends ListElement<T> {
	private ListElement<T> parent;
	private ListElement<T> child;
	private int degree;
	private boolean mark;
}
