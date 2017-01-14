package intro.algorithms.graph.mst;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;
import intro.algorithms.graph.WeightedEdge;
import intro.algorithms.sort.SortingAlgorithm;
import intro.datastructures.list.LinkedList;
import intro.datastructures.list.ListElement;
import intro.datastructures.set.DisjointSet;

public class Kruskal<T extends Comparable<T>, U> {
	
	private final SortingAlgorithm<T, WeightedEdge<T, U>> algo;
	
	public Kruskal(SortingAlgorithm<T, WeightedEdge<T, U>> algo) {
		this.algo = algo;
	}

	public Edge<U>[] buildMinimumSpanningTree(Graph<U, Vertex<U>, WeightedEdge<T, U>> g) {
		LinkedList<WeightedEdge<T, U>> edges = g.getEdges();
		if(edges.getSize() == 0) {
			return null;
		}
		
		/// Convert edges into array
		WeightedEdge<T, U> [] edgesArray = new WeightedEdge[edges.getSize()];
		ListElement<WeightedEdge<T, U>> edge = edges.getFirst();
		for(int i=0; i<edges.getSize(); i++) {
			edgesArray[i] = edge.getData();
			edge = edge.getNext();
		}
		
		// Sort edges by weight
		edgesArray = algo.sort(edgesArray);
		
		// Create sets for all vertices
		Map<Vertex<U>, DisjointSet<Vertex<U>>> vertexSetsTable = new HashMap<>(g.getVertices().getSize());
		for(Vertex<U> vertex : g.getVertices()) {
			DisjointSet<Vertex<U>> set = new DisjointSet<Vertex<U>>();
			set.setData(vertex);
			vertexSetsTable.put(vertex, set);
		}
		
		// Union the vertex sets based on nondecreasing order of edges
		WeightedEdge<T, U>[] resultEdges = new  WeightedEdge[edgesArray.length];
		int i=0;
		for(WeightedEdge<T, U> anEdge: edgesArray) {
			DisjointSet<Vertex<U>> u = vertexSetsTable.get(anEdge.getStart());
			DisjointSet<Vertex<U>> v = vertexSetsTable.get(anEdge.getEnd());
			
			if(u.getRepresentative() != v.getRepresentative()) {
				u.union(v);
				resultEdges[i] = anEdge;
				i++;
			}
		}
		
		return Arrays.copyOf(resultEdges, i);
	}
}
