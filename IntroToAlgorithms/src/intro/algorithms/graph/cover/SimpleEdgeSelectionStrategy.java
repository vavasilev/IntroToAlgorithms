package intro.algorithms.graph.cover;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;
import intro.datastructures.list.ListElement;

public class SimpleEdgeSelectionStrategy<T> implements EdgeSelectionStrategy<T> {

	@Override
	public Edge<T> selectEdge(Graph<T, Vertex<T>, Edge<T>> graph) {
		ListElement<Edge<T>> elm = graph.getEdges().getFirst();
		return elm == null ? null : elm.getData();
	}

}
