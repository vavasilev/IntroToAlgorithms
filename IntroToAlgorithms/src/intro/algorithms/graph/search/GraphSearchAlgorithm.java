package intro.algorithms.graph.search;

public class GraphSearchAlgorithm<T> {
	
	protected boolean getPathReq(SearchVertex<T> start, SearchVertex<T> end, StringBuilder sb) {
		boolean pathExists = true;
		if(end == start) {
			sb.append(end.getData().toString()+" ");
			return true;
		}
		if(end.getParent() != null) {
			pathExists = getPathReq(start, end.getParent(), sb);
		} else if(end != start) {
			sb.append("No path between start: "+start.getData().toString()+" and end: "+end.getData().toString());
			return false;
		}
		if(pathExists) {
			sb.append(end.getData().toString()+" ");
		}
		return pathExists;
	}
}
