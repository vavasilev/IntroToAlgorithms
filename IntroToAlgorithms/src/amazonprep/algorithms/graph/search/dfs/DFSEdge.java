package amazonprep.algorithms.graph.search.dfs;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Vertex;

public class DFSEdge<T> extends Edge<T> {
	
	private EdgeType edgeType = EdgeType.NORMAL;
	
	public DFSEdge(Vertex<T> start, Vertex<T> end) {
		super(start, end);
	}

	public EdgeType getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}
}
