package intro.algorithms.graph.mst;

import java.util.Arrays;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.WeightedEdge;
import intro.algorithms.sort.SortingAlgorithm;
import intro.datastructures.list.LinkedList;
import intro.datastructures.list.ListElement;
import intro.datastructures.set.DisjointSet;
import intro.datastructures.set.DisjointSetBound;
import intro.datastructures.set.LinkedListDisjointSet;

public class Kruskal<T extends Comparable<T>, U> {
	
	private final SortingAlgorithm<T, WeightedEdge<T, U>> algo;
	
	public Kruskal(SortingAlgorithm<T, WeightedEdge<T, U>> algo) {
		this.algo = algo;
	}

	public Edge<U>[] buildMinimumSpanningTree(Graph<U, KruskalVertex<U>, WeightedEdge<T, U>> g) {
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
		
		// Union the vertex sets based on nondecreasing order of edges
		WeightedEdge<T, U>[] resultEdges = new  WeightedEdge[edgesArray.length];
		int i=0;
		for(WeightedEdge<T, U> anEdge: edgesArray) {
			KruskalVertex<U> start = (KruskalVertex<U>)anEdge.getStart();
			KruskalVertex<U> end = (KruskalVertex<U>)anEdge.getEnd();
			
			if(start.getDisjointSet() != end.getDisjointSet()) {
				start.getDisjointSet().union(end.getDisjointSet());
				resultEdges[i] = anEdge;
				i++;
			}
		}
		
		return Arrays.copyOf(resultEdges, i);
	}
}
