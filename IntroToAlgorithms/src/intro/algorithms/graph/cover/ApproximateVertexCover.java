package amazonprep.algorithms.graph.cover;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;
import amazonprep.datastructures.list.LinkedList;

public class ApproximateVertexCover<T> {

	public LinkedList<Vertex<T>> getCover(Graph<T, Vertex<T>, Edge<T>> graph, EdgeSelectionStrategy<T> strategy) {
		Edge<T> edge = strategy.selectEdge(graph);
		
		LinkedList<Vertex<T>> cover = new LinkedList<Vertex<T>>();
		
		while(edge != null) {
			// Heuristic for improving number of edges
			if(edge.getStart().getOutgoingEdges().getSize() > 1) {
				cover.insertData(edge.getStart());
			}
			if(edge.getEnd().getOutgoingEdges().getSize() > 1) {
				cover.insertData(edge.getEnd());
			}
			if(edge.getStart().getOutgoingEdges().getSize() == 1 && edge.getEnd().getOutgoingEdges().getSize() == 1) {
				cover.insertData(edge.getStart());
			}
			
			graph.getVertices().deleteElement(graph.getVertices().searchFirstElement(edge.getEnd()));
			graph.getVertices().deleteElement(graph.getVertices().searchFirstElement(edge.getStart()));

			for(Edge<T> outgoingEdge : edge.getStart().getOutgoingEdges()) {
				if(edge != outgoingEdge) {
					graph.getEdges().deleteElement(graph.getEdges().searchFirstElement(outgoingEdge));
					Vertex<T> otherVertex = outgoingEdge.getStart() == edge.getStart() ? outgoingEdge.getEnd() : outgoingEdge.getStart();
					otherVertex.getOutgoingEdges().deleteElement(otherVertex.getOutgoingEdges().searchFirstElement(outgoingEdge));
				}
			}
			
			for(Edge<T> outgoingEdge : edge.getEnd().getOutgoingEdges()) {
				if(edge != outgoingEdge) {
					graph.getEdges().deleteElement(graph.getEdges().searchFirstElement(outgoingEdge));
					Vertex<T> otherVertex = outgoingEdge.getStart() == edge.getEnd() ? outgoingEdge.getEnd() : outgoingEdge.getStart();
					otherVertex.getOutgoingEdges().deleteElement(otherVertex.getOutgoingEdges().searchFirstElement(outgoingEdge));
				}
			}
			graph.getEdges().deleteElement(graph.getEdges().searchFirstElement(edge));
			edge = strategy.selectEdge(graph);
		}
		
		return cover;
	}
}
