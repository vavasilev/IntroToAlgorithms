package intro.algorithms.graph.mst;

import intro.algorithms.graph.IndexedVertex;
import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.KeyedData;

public class PrimVertex<T extends Comparable<T>, U> extends IndexedVertex<U> implements KeyedData<T> {
	private T weight;
	private PrimVertex<T, U> parent;
	
	public PrimVertex(U data, MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
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
