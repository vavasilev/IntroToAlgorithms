package intro.algorithms.graph.mst;

import org.junit.Test;

import intro.algorithms.graph.Graph;
import intro.algorithms.graph.WeightedEdge;
import intro.algorithms.sort.QuickSort;
import intro.datastructures.set.DisjointSetFactory;
import intro.datastructures.set.LinkedListDisjointSetFactory;

public class KruskalTest {

	@Test
	public void testKruskal() {
		Graph<Character, KruskalVertex<Character>, WeightedEdge<Double, Character>> graph = buildGraph();
		
		Kruskal<Double, Character> algo = new Kruskal<Double, Character>(new QuickSort<Double, WeightedEdge<Double, Character>>());
		
		AssertResults.assertResults(algo.buildMinimumSpanningTree(graph));
	}
	
	private Graph<Character, KruskalVertex<Character>, WeightedEdge<Double, Character>> buildGraph() {
		DisjointSetFactory<KruskalVertex<Character>> factory = new LinkedListDisjointSetFactory<KruskalVertex<Character>>();
		Graph<Character, KruskalVertex<Character>, WeightedEdge<Double, Character>> graph = 
				new Graph<Character, KruskalVertex<Character>, WeightedEdge<Double, Character>>();
		
		KruskalVertex<Character> vertexA = new KruskalVertex<Character>('a', factory);
		graph.getVertices().insertData(vertexA);
		KruskalVertex<Character> vertexB = new KruskalVertex<Character>('b', factory);
		graph.getVertices().insertData(vertexB);
		connectVertices(vertexA, vertexB, 4, graph);
		
		KruskalVertex<Character> vertexH = new KruskalVertex<Character>('h', factory);
		graph.getVertices().insertData(vertexH);
		connectVertices(vertexA, vertexH, 8, graph);
		connectVertices(vertexB, vertexH, 11, graph);
		
		KruskalVertex<Character> vertexC = new KruskalVertex<Character>('c', factory);
		graph.getVertices().insertData(vertexC);
		connectVertices(vertexB, vertexC, 8, graph);
		
		KruskalVertex<Character> vertexI = new KruskalVertex<Character>('i', factory);
		graph.getVertices().insertData(vertexI);
		connectVertices(vertexH, vertexI, 7, graph);
		
		KruskalVertex<Character> vertexG = new KruskalVertex<Character>('g', factory);
		graph.getVertices().insertData(vertexG);
		connectVertices(vertexH, vertexG, 1, graph);
		
		connectVertices(vertexI, vertexC, 2, graph);
		connectVertices(vertexI, vertexG, 6, graph);
		
		KruskalVertex<Character> vertexD = new KruskalVertex<Character>('d', factory);
		graph.getVertices().insertData(vertexD);
		connectVertices(vertexC, vertexD, 7, graph);
		
		KruskalVertex<Character> vertexF = new KruskalVertex<Character>('f', factory);
		graph.getVertices().insertData(vertexF);
		connectVertices(vertexC, vertexF, 4, graph);
		
		connectVertices(vertexG, vertexF, 2, graph);
		
		KruskalVertex<Character> vertexE = new KruskalVertex<Character>('e', factory);
		graph.getVertices().insertData(vertexE);
		connectVertices(vertexD, vertexE, 9, graph);
		connectVertices(vertexD, vertexF, 14, graph);
		
		connectVertices(vertexF, vertexE, 10, graph);
		
		return graph;
	}

	private void connectVertices(KruskalVertex<Character> vertex1, KruskalVertex<Character> vertex2, double weight, 
			Graph<Character, KruskalVertex<Character>, WeightedEdge<Double, Character>> graph) {
		WeightedEdge<Double, Character> edge = new WeightedEdge<Double, Character>(vertex1, vertex2, weight);
		graph.getEdges().insertData(edge);
		vertex1.getOutgoingEdges().insertData(edge);
	}
}
