package intro.algorithms.graph.search.dfs;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;
import intro.algorithms.graph.search.GraphSearchAlgorithm;
import intro.algorithms.graph.search.VertexColor;
import intro.datastructures.list.LinkedList;

public class DepthFirstSearch<T> extends GraphSearchAlgorithm<T> {
	
	private int time = 1;

	public void dfs(Graph<T, Vertex<T>, Edge<T>> graph) {
		dfs(graph, null);
	}
	public void dfs(Graph<T, Vertex<T>, Edge<T>> graph, LinkedList<Vertex<T>> verticesByFinishTime) {
		for(Vertex<T> vertex : graph.getVertices()) {
			DFSVertex<T> dfsVertex = (DFSVertex<T>)vertex;
			if(dfsVertex.getColor() == VertexColor.WHITE) {
				dfsReq(dfsVertex, verticesByFinishTime);
			}
		}
	}
	
	protected void dfsReq(DFSVertex<T> vertex, LinkedList<Vertex<T>> verticesByFinishTime) {
		vertex.setStart(time++);
		vertex.setColor(VertexColor.GRAY);
		for(Edge<T> edge : vertex.getOutgoingEdges()) {
			DFSEdge<T> dfsEdge = (DFSEdge<T>)edge; 
			DFSVertex<T> adjVertex = (DFSVertex<T>)dfsEdge.getEnd();
			if(adjVertex.getColor() == VertexColor.WHITE) {
				adjVertex.setParent(vertex);
				dfsReq(adjVertex, verticesByFinishTime);
			} else if(adjVertex.getColor() == VertexColor.GRAY) {
				dfsEdge.setEdgeType(EdgeType.BACKWARD);
			} else if(adjVertex.getColor() == VertexColor.BLACK) {
				// the vertex was reached via my children
				if(adjVertex.getStart() > vertex.getStart()) {
					dfsEdge.setEdgeType(EdgeType.FORWARD);
				} else { // The vertex was reached in another path
					dfsEdge.setEdgeType(EdgeType.CROSS);
				}
			}
		}
		vertex.setEnd(time++);
		vertex.setColor(VertexColor.BLACK);
		if(verticesByFinishTime != null) {
			verticesByFinishTime.insertData(vertex);
		}
	}
	
	public String getPath(DFSVertex<T> start, DFSVertex<T> end) {
		StringBuilder sb = new StringBuilder();
		sb.append("Path: ");
		getPathReq(start, end, sb);
		return sb.toString().trim();
	}
}
