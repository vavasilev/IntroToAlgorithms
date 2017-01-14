package amazonprep.algorithms.graph.mst;

import org.junit.Test;

import amazonprep.algorithms.graph.ArrayGraph;
import amazonprep.algorithms.sort.DoubleMinMaxProvider;

public class PrimTest {
	
	DoubleMinMaxProvider minMaxProvider = new DoubleMinMaxProvider();

	@Test
	public void test() {
		ArrayGraph<Double, Character, PrimVertex<Double, Character>> graph = buildGraph();
		
		Prim<Double, Character> algo = new Prim<Double, Character>(minMaxProvider);
		
		AssertResults.assertResults(algo.buildMinimumSpanningTree(graph, graph.getVertices()[0]));
	}

	private ArrayGraph<Double, Character, PrimVertex<Double, Character>> buildGraph() {
		int capacity = 9;
		Double edges[][] = new Double[capacity][capacity];
		PrimVertex<Double, Character> vertices[] = new PrimVertex[capacity];
		ArrayGraph<Double, Character, PrimVertex<Double, Character>> graph = 
				new ArrayGraph<>(edges, vertices, capacity, minMaxProvider);
		
		PrimVertex<Double, Character> vertexA = new PrimVertex<>('a', minMaxProvider);
		graph.insertVertex(vertexA);
		PrimVertex<Double, Character> vertexB = new PrimVertex<>('b', minMaxProvider);
		graph.insertVertex(vertexB);
		connectVertices(vertexA, vertexB, 4, graph);
		
		PrimVertex<Double, Character> vertexH = new PrimVertex<>('h', minMaxProvider);
		graph.insertVertex(vertexH);
		connectVertices(vertexA, vertexH, 8, graph);
		connectVertices(vertexB, vertexH, 11, graph);
		
		PrimVertex<Double, Character> vertexC = new PrimVertex<>('c', minMaxProvider);
		graph.insertVertex(vertexC);
		connectVertices(vertexB, vertexC, 8, graph);
		
		PrimVertex<Double, Character> vertexI = new PrimVertex<>('i', minMaxProvider);
		graph.insertVertex(vertexI);
		connectVertices(vertexH, vertexI, 7, graph);
		
		PrimVertex<Double, Character> vertexG = new PrimVertex<>('g', minMaxProvider);
		graph.insertVertex(vertexG);
		connectVertices(vertexH, vertexG, 1, graph);
		
		connectVertices(vertexI, vertexC, 2, graph);
		connectVertices(vertexI, vertexG, 6, graph);
		
		PrimVertex<Double, Character> vertexD = new PrimVertex<>('d', minMaxProvider);
		graph.insertVertex(vertexD);
		connectVertices(vertexC, vertexD, 7, graph);
		
		PrimVertex<Double, Character> vertexF = new PrimVertex<>('f', minMaxProvider);
		graph.insertVertex(vertexF);
		connectVertices(vertexC, vertexF, 4, graph);
		
		connectVertices(vertexG, vertexF, 2, graph);
		
		PrimVertex<Double, Character> vertexE = new PrimVertex<>('e', minMaxProvider);
		graph.insertVertex(vertexE);
		connectVertices(vertexD, vertexE, 9, graph);
		connectVertices(vertexD, vertexF, 14, graph);
		
		connectVertices(vertexF, vertexE, 10, graph);
		
		return graph;
	}

	private void connectVertices(PrimVertex<Double, Character> vertex1, PrimVertex<Double, Character> vertex2, double weight, 
			ArrayGraph<Double, Character, PrimVertex<Double, Character>> graph) {
		graph.insertEdge(vertex1, vertex2, weight);
		graph.insertEdge(vertex2, vertex1, weight);
	}
}
