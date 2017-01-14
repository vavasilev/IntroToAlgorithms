package amazonprep.algorithms.graph.mst;

import amazonprep.algorithms.graph.IndexedVertex;
import amazonprep.algorithms.sort.MinMaxProvider;
import amazonprep.algorithms.sort.Sortable;

public class PrimVertex<T extends Comparable<T>, U> extends IndexedVertex<U> implements Sortable<T> {
	private T weight;
	private PrimVertex<T, U> parent;
	
	public PrimVertex(U data, MinMaxProvider<T, ? extends Sortable<T>> minMaxProvider) {
		super(data);
		weight = minMaxProvider.getMaxKey();
	}

	@Override
	public T getKey() {
		return weight;
	}

	@Override
	public void setKey(T key) {
		this.weight = key;
	}

	public PrimVertex<T, U> getParent() {
		return parent;
	}

	public void setParent(PrimVertex<T, U> parent) {
		this.parent = parent;
	}
}
