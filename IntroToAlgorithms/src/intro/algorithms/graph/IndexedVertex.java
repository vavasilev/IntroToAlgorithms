package intro.algorithms.graph;

public class IndexedVertex<T> extends Vertex<T> {
	private Integer index;

	public IndexedVertex(T data) {
		super(data);
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
