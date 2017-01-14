package intro.algorithms.graph.search.dfs;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;
import intro.algorithms.graph.search.VertexColor;
import intro.datastructures.list.LinkedList;
import intro.datastructures.list.ListElement;

public class StronglyConnectedComponents<T> extends DepthFirstSearch<T> {

	public LinkedList<LinkedList<Vertex<T>>> findStronglyConnectedComponents(
			Graph<T, Vertex<T>, Edge<T>> graph) {
		LinkedList<Vertex<T>> vertices = topologicallySort(graph);
		
		// reset colors
		for(Vertex<T> vertex : vertices) {
			DFSVertex<T> dfsVertex = (DFSVertex<T>)vertex;
			dfsVertex.setColor(VertexColor.WHITE);
			dfsVertex.setParent(null);
		}
		
		// Change edges direction
		for(Edge<T> edge : graph.getEdges()) {
			Vertex<T> start = edge.getStart();
			ListElement<Edge<T>> listElement = start.getOutgoingEdges().searchFirstElement(edge);
			start.getOutgoingEdges().deleteElement(listElement);
			edge.getEnd().getOutgoingEdges().insertData(edge);
			edge.setStart(edge.getEnd());
			edge.setEnd(start);
			
		}
		
		LinkedList<LinkedList<Vertex<T>>> sccs = new LinkedList<LinkedList<Vertex<T>>>();
		
		for(Vertex<T> vertex : vertices) {
			DFSVertex<T> dfsVertex = (DFSVertex<T>)vertex;
			if(dfsVertex.getColor() == VertexColor.WHITE) {
				LinkedList<Vertex<T>> scc = new LinkedList<Vertex<T>>();
				dfsReq(dfsVertex, scc);
				sccs.insertData(scc);
			}
		}
		return sccs;
	}
	
	public LinkedList<Vertex<T>> topologicallySort(Graph<T, Vertex<T>, Edge<T>> graph) {
		LinkedList<Vertex<T>> vertices = new LinkedList<Vertex<T>>();
		dfs(graph, vertices);
		return vertices;
	}
}
