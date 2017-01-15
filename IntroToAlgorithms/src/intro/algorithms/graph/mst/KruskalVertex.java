package intro.algorithms.graph.mst;

import intro.algorithms.graph.Vertex;
import intro.datastructures.set.DisjointSet;

public class KruskalVertex<T> extends Vertex<T> {
	DisjointSet<KruskalVertex<T>> disjointSet;
	
	public KruskalVertex(T data) {
		super(data);
	}

	public DisjointSet<KruskalVertex<T>> getDisjointSet() {
		return disjointSet;
	}

	public void setDisjointSet(DisjointSet<KruskalVertex<T>> disjointSet) {
		this.disjointSet = disjointSet;
	}
}
