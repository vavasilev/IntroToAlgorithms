package intro.algorithms.graph.mst;

import java.util.Arrays;

import intro.algorithms.graph.ArrayGraph;
import intro.algorithms.graph.Edge;
import intro.algorithms.sort.MinMaxProvider;
import intro.algorithms.sort.KeyedData;
import intro.datastructures.heap.BinaryHeap;
import intro.datastructures.heap.Heap.HeapType;

public class Prim<T extends Comparable<T>, U> {
	
	private MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider;
	
	public Prim(MinMaxProvider<T, ? extends KeyedData<T>> minMaxProvider) {
		this.minMaxProvider = minMaxProvider;
	}

	public Edge<U>[] buildMinimumSpanningTree(ArrayGraph<T, U, PrimVertex<T, U>> g, PrimVertex<T, U> start) {
		start.setKey(minMaxProvider.getMinKey());
		PrimVertex<T, U>[] vertices = Arrays.copyOf(g.getVertices(), g.getVerticesCount());
		BinaryHeap<T, PrimVertex<T, U>> heap = new BinaryHeap<>(
				vertices, 
				vertices.length, 
				HeapType.MIN,
				null);
		
		PrimVertex<T, U> vertex = null;

		while((vertex = heap.extractOptimalElement()) != null) {
			T[] outgoingEdges = g.getOutgoingEdges(vertex);
			for(int i=0; i<outgoingEdges.length; i++) {
				PrimVertex<T, U> otherVertex = g.getVertices()[i];
				// We have reached the maximum vertex
				if(otherVertex == null) {
					break;
				}
				
				T weight = outgoingEdges[i];
				
				// If backing element is not null, this means the heap contains this
				// vertex
				if(otherVertex.getBackingElement() != null && otherVertex.getKey().compareTo(weight) > 0) {
					heap.updateKey(otherVertex, weight);
					otherVertex.setParent(vertex);
				}
			}
		}
		
		Edge<U>[] result = new Edge[g.getVerticesCount()-1];
		
		int j = 0;
		for(int i=0; i<g.getVerticesCount(); i++) {
			PrimVertex<T, U> vrt = g.getVertices()[i];
			if(vrt.getParent() != null) {
				result[j++] = new Edge<U>(vrt.getParent(), vrt);
			}
		}
		
		return result;
	}
}
