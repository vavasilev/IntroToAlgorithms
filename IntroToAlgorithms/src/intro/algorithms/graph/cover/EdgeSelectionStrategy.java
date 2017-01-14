package intro.algorithms.graph.cover;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;

public interface EdgeSelectionStrategy<T> {

	Edge<T> selectEdge(Graph<T, Vertex<T>, Edge<T>> graph);
}
