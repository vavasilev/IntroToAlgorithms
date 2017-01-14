package amazonprep.algorithms.graph.cover;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;

public class GreedyEdgeSelectionStrategy<T> implements EdgeSelectionStrategy<T> {

	@Override
	public Edge<T> selectEdge(Graph<T, Vertex<T>, Edge<T>> graph) {
		int maxEdgesSize = 0;
		Vertex<T> maxEdgesVertex = null;
		for(Vertex<T> vertex : graph.getVertices()) {
			if(vertex.getOutgoingEdges().getSize() > maxEdgesSize) {
				maxEdgesSize = vertex.getOutgoingEdges().getSize();
				maxEdgesVertex = vertex;
			}
		}
		
		if(maxEdgesVertex != null) {
			int maxEdgesNeighborSize = 0;
			Edge<T> maxEdgesNeighborVertexEdge = null;
			for(Edge<T> edge : maxEdgesVertex.getOutgoingEdges()) {
				Vertex<T> vertex = edge.getStart() == maxEdgesVertex ? edge.getEnd() : edge.getStart();
				if(vertex.getOutgoingEdges().getSize() > maxEdgesNeighborSize) {
					maxEdgesNeighborSize = vertex.getOutgoingEdges().getSize();
					maxEdgesNeighborVertexEdge = edge;
				}
			}
			
			if(maxEdgesNeighborVertexEdge != null) {
				return maxEdgesNeighborVertexEdge;
			}
		}
		return null;
	}
}
