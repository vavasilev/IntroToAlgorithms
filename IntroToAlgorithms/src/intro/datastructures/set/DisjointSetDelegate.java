package intro.datastructures.set;

public class DisjointSetDelegate<T extends DisjointSetBound> implements DisjointSetBound {

	private DisjointSet<T> disjointSet;
	private T bound;
	
	public DisjointSetDelegate(T bound, DisjointSetFactory<T> factory) {
		super();
		this.bound = bound;
		this.disjointSet = factory.createDisjointSet(bound);
	}
	
	@Override
	public DisjointSet<T> getDisjointSet() {
		disjointSet.findAndSetDisjointSet(bound);
		return disjointSet;
	}

	@Override
	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet) {
		this.disjointSet = (DisjointSet<T>)disjointSet;
	}

}
