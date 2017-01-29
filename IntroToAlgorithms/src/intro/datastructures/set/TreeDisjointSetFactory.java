package intro.datastructures.set;

public class TreeDisjointSetFactory<T extends DisjointSetBound> implements DisjointSetFactory<T> {

	@Override
	public DisjointSet<T> createDisjointSet(T data) {
		return new TreeDisjointSet<>();
	}

}
