package intro.datastructures.set;

public interface DisjointSet<T extends DisjointSetBound> {
	void union(DisjointSet<T> other);
	void findAndSetDisjointSet(T bound);
}
