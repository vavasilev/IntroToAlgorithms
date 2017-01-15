package intro.datastructures.set;

public class BoundInteger implements DisjointSetBound {

	private DisjointSet<BoundInteger> disjointSet;
	private final Integer data;
	
	public BoundInteger(Integer data, DisjointSetFactory<BoundInteger> factory) {
		super();
		this.data = data;
		this.disjointSet = factory.createDisjointSet(this);
	}

	@Override
	public DisjointSet<BoundInteger> getDisjointSet() {
		return disjointSet;
	}

	@Override
	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet) {
		this.disjointSet = (DisjointSet<BoundInteger>)disjointSet;
	}

	public Integer getData() {
		return data;
	}
}
