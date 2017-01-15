package intro.datastructures.set;

public class LinkedListDisjointSetFactory<T extends DisjointSetBound> implements DisjointSetFactory<T> {

	@Override
	public DisjointSet<T> createDisjointSet(T data) {
		return new LinkedListDisjointSet<T>(data);
	}

}
