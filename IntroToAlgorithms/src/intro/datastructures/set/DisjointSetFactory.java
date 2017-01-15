package intro.datastructures.set;

public interface DisjointSetFactory<T extends DisjointSetBound> {
	DisjointSet<T> createDisjointSet(T data);
}
