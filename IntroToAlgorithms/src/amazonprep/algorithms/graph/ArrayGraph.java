package amazonprep.algorithms.graph;

import amazonprep.algorithms.sort.MinMaxProvider;
import amazonprep.algorithms.sort.Sortable;

public class ArrayGraph<T extends Comparable<T>, U, V extends IndexedVertex<U>> {

	private final int capacity;
	
	private final T edges[][];
	private final V vertices[];
	
	private int verticesCount;

	public ArrayGraph(T edges[][], V vertices[], int capacity, MinMaxProvider<T, ? extends Sortable<T>> minMaxProvider) {
		this.capacity = capacity;
		this.edges = edges;
		for(int i=0; i<capacity; i++) {
			for(int j=0; j<capacity; j++) {
				edges[i][j] = minMaxProvider.getMaxKey();
			}
		}
		this.vertices = vertices;
	}

	public int getCapacity() {
		return capacity;
	}

	public T[] getOutgoingEdges(V vertex) {
		return edges[vertex.getIndex()];
	}

	public V[] getVertices() {
		return vertices;
	}
	
	public int getVerticesCount() {
		return verticesCount;
	}
	
	public void insertVertex(V vertex) {
		vertex.setIndex(verticesCount);
		vertices[verticesCount] = vertex;
		verticesCount++;
	}
	
	public void insertEdge(V vertex1, V vertex2, T weight) {
		edges[vertex1.getIndex()][vertex2.getIndex()] = weight;
	}
}
