package intro.datastructures.heap;

import intro.datastructures.list.ListElement;

public class FibonacciElement<T> extends ListElement<T> {
	private ListElement<T> parent;
	private ListElement<T> child;
	private int degree;
	private boolean mark;
	
	public ListElement<T> getParent() {
		return parent;
	}
	public void setParent(ListElement<T> parent) {
		this.parent = parent;
	}
	public ListElement<T> getChild() {
		return child;
	}
	public void setChild(ListElement<T> child) {
		this.child = child;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public boolean isMark() {
		return mark;
	}
	public void setMark(boolean mark) {
		this.mark = mark;
	}
}
