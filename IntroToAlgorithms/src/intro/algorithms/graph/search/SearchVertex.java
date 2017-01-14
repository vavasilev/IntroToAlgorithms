package amazonprep.algorithms.graph.search;

import amazonprep.algorithms.graph.Vertex;

public class SearchVertex<T> extends Vertex<T> {

	private SearchVertex<T> parent;
	private VertexColor color = VertexColor.WHITE;
	
	public SearchVertex(T data) {
		super(data);
	}
	
	public SearchVertex<T> getParent() {
		return parent;
	}

	public void setParent(SearchVertex<T> parent) {
		this.parent = parent;
	}

	public VertexColor getColor() {
		return color;
	}

	public void setColor(VertexColor color) {
		this.color = color;
	}
}
