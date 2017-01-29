package intro.datastructures.set;

public class BoundInteger implements DisjointSetBound {

	private DisjointSetDelegate<BoundInteger> delegate;
	private final Integer data;
	
	public BoundInteger(Integer data, DisjointSetFactory<BoundInteger> factory) {
		super();
		this.data = data;
		this.delegate = new DisjointSetDelegate<BoundInteger>(this, factory);
	}

	@Override
	public DisjointSet<BoundInteger> getDisjointSet() {
		return delegate.getDisjointSet();
	}

	@Override
	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet) {
		delegate.setDisjointSet(disjointSet);
	}

	public Integer getData() {
		return data;
	}
}
