package intro.algorithms.graph;

import intro.datastructures.list.LinkedList;

public class Graph<T, V extends Vertex<T>, E extends Edge<T>> {

	private LinkedList<E> edges = new LinkedList<E>();
	private LinkedList<V> vertices = new LinkedList<V>();
	public LinkedList<E> getEdges() {
		return edges;
	}
	public void setEdges(LinkedList<E> edges) {
		this.edges = edges;
	}
	public LinkedList<V> getVertices() {
		return vertices;
	}
	public void setVertices(LinkedList<V> vertices) {
		this.vertices = vertices;
	}
}
