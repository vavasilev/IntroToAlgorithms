package amazonprep.algorithms.graph.mst;

import org.junit.Test;

import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;
import amazonprep.algorithms.graph.WeightedEdge;
import amazonprep.algorithms.sort.QuickSort;

public class KruskalTest {

	@Test
	public void testKruskal() {
		Graph<Character, Vertex<Character>, WeightedEdge<Double, Character>> graph = buildGraph();
		
		Kruskal<Double, Character> algo = new Kruskal<Double, Character>(new QuickSort<Double, WeightedEdge<Double, Character>>());
		
		AssertResults.assertResults(algo.buildMinimumSpanningTree(graph));
	}
	
	private Graph<Character, Vertex<Character>, WeightedEdge<Double, Character>> buildGraph() {
		Graph<Character, Vertex<Character>, WeightedEdge<Double, Character>> graph = 
				new Graph<Character, Vertex<Character>, WeightedEdge<Double, Character>>();
		
		Vertex<Character> vertexA = new Vertex<Character>('a');
		graph.getVertices().insertData(vertexA);
		Vertex<Character> vertexB = new Vertex<Character>('b');
		graph.getVertices().insertData(vertexB);
		connectVertices(vertexA, vertexB, 4, graph);
		
		Vertex<Character> vertexH = new Vertex<Character>('h');
		graph.getVertices().insertData(vertexH);
		connectVertices(vertexA, vertexH, 8, graph);
		connectVertices(vertexB, vertexH, 11, graph);
		
		Vertex<Character> vertexC = new Vertex<Character>('c');
		graph.getVertices().insertData(vertexC);
		connectVertices(vertexB, vertexC, 8, graph);
		
		Vertex<Character> vertexI = new Vertex<Character>('i');
		graph.getVertices().insertData(vertexI);
		connectVertices(vertexH, vertexI, 7, graph);
		
		Vertex<Character> vertexG = new Vertex<Character>('g');
		graph.getVertices().insertData(vertexG);
		connectVertices(vertexH, vertexG, 1, graph);
		
		connectVertices(vertexI, vertexC, 2, graph);
		connectVertices(vertexI, vertexG, 6, graph);
		
		Vertex<Character> vertexD = new Vertex<Character>('d');
		graph.getVertices().insertData(vertexD);
		connectVertices(vertexC, vertexD, 7, graph);
		
		Vertex<Character> vertexF = new Vertex<Character>('f');
		graph.getVertices().insertData(vertexF);
		connectVertices(vertexC, vertexF, 4, graph);
		
		connectVertices(vertexG, vertexF, 2, graph);
		
		Vertex<Character> vertexE = new Vertex<Character>('e');
		graph.getVertices().insertData(vertexE);
		connectVertices(vertexD, vertexE, 9, graph);
		connectVertices(vertexD, vertexF, 14, graph);
		
		connectVertices(vertexF, vertexE, 10, graph);
		
		return graph;
	}

	private void connectVertices(Vertex<Character> vertex1, Vertex<Character> vertex2, double weight, 
			Graph<Character, Vertex<Character>, WeightedEdge<Double, Character>> graph) {
		WeightedEdge<Double, Character> edge1 = new WeightedEdge<Double, Character>(vertex1, vertex2, weight);
		graph.getEdges().insertData(edge1);
		WeightedEdge<Double, Character> edge2 = new WeightedEdge<Double, Character>(vertex2, vertex1, weight);
		graph.getEdges().insertData(edge2);
		vertex1.getOutgoingEdges().insertData(edge1);
		vertex2.getOutgoingEdges().insertData(edge2);
	}
}
