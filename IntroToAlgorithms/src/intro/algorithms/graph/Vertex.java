package intro.algorithms.graph;

import intro.datastructures.list.LinkedList;

public class Vertex<T> {

	private T data;
	private LinkedList<Edge<T>> outgoingEdges = new LinkedList<Edge<T>>();
	
	public Vertex(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedList<Edge<T>> getOutgoingEdges() {
		return outgoingEdges;
	}

	public void setOutgoingEdges(LinkedList<Edge<T>> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
