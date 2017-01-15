package intro.datastructures.set;

public interface DisjointSetBound {
	public DisjointSet<? extends DisjointSetBound> getDisjointSet();
	public void setDisjointSet(DisjointSet<? extends DisjointSetBound> disjointSet);
}
