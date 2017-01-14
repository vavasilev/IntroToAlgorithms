package amazonprep.algorithms.graph.cover;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;

public interface EdgeSelectionStrategy<T> {

	Edge<T> selectEdge(Graph<T, Vertex<T>, Edge<T>> graph);
}
