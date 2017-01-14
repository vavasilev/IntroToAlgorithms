package amazonprep.algorithms.graph.cover;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;
import amazonprep.datastructures.list.ListElement;

public class SimpleEdgeSelectionStrategy<T> implements EdgeSelectionStrategy<T> {

	@Override
	public Edge<T> selectEdge(Graph<T, Vertex<T>, Edge<T>> graph) {
		ListElement<Edge<T>> elm = graph.getEdges().getFirst();
		return elm == null ? null : elm.getData();
	}

}
