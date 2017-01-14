package intro.algorithms.graph;

import intro.algorithms.sort.KeyedData;

public class WeightedEdge<T extends Comparable<T>, U> extends Edge<U> implements KeyedData<T> {
	private T weight;
	
	public WeightedEdge(Vertex<U> start, Vertex<U> end, T weight) {
		super(start, end);
		this.weight = weight;
	}

	public T getWeight() {
		return weight;
	}

	@Override
	public T getKey() {
		return weight;
	}

	@Override
	public void setKey(T key) {
		this.weight = key;
	}
}
