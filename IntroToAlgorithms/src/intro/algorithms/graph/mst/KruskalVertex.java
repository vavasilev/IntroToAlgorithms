package intro.algorithms.graph.mst;

import intro.algorithms.graph.Vertex;
import intro.datastructures.set.DisjointSet;
import intro.datastructures.set.DisjointSetBound;
import intro.datastructures.set.DisjointSetFactory;

public class KruskalVertex<T> extends Vertex<T>
		implements DisjointSetBound {
	DisjointSet<KruskalVertex<T>> disjointSet;
	
	public KruskalVertex(T data, DisjointSetFactory<KruskalVertex<T>> factory) {
		super(data);
		disjointSet = factory.createDisjointSet(this);
	}

	public DisjointSet<KruskalVertex<T>> getDisjointSet() {
		return disjointSet;
	}

	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet) {
		this.disjointSet = (DisjointSet<KruskalVertex<T>>)disjointSet;
	}
}
