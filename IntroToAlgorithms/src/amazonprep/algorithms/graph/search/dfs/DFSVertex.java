package amazonprep.algorithms.graph.search.dfs;

import amazonprep.algorithms.graph.search.SearchVertex;

public class DFSVertex<T> extends SearchVertex<T> {
	
	private int start = Integer.MAX_VALUE;
	private int end = Integer.MAX_VALUE;
	
	public DFSVertex(T data) {
		super(data);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
