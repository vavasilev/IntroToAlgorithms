package intro.algorithms.graph.mst;

import intro.algorithms.graph.Vertex;
import intro.datastructures.set.DisjointSet;
import intro.datastructures.set.DisjointSetBound;
import intro.datastructures.set.DisjointSetDelegate;
import intro.datastructures.set.DisjointSetFactory;

public class KruskalVertex<T> extends Vertex<T>
		implements DisjointSetBound {
	private DisjointSetDelegate<KruskalVertex<T>> delegate;
	
	public KruskalVertex(T data, DisjointSetFactory<KruskalVertex<T>> factory) {
		super(data);
		this.delegate = new DisjointSetDelegate<KruskalVertex<T>>(this, factory);
	}

	public DisjointSet<KruskalVertex<T>> getDisjointSet() {
		return delegate.getDisjointSet();
	}

	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet) {
		delegate.setDisjointSet(disjointSet);
	}
}
