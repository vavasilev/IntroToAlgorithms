package intro.algorithms.graph.search.bfs;

import intro.algorithms.graph.search.SearchVertex;

public class BFSVertex<T> extends SearchVertex<T> {

	private int depth = Integer.MAX_VALUE;
	
	public BFSVertex(T data) {
		super(data);
	}
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
