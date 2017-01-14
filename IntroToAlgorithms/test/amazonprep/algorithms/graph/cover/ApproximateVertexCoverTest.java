package amazonprep.algorithms.graph.cover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;
import amazonprep.algorithms.graph.search.dfs.DFSEdge;
import amazonprep.algorithms.graph.search.dfs.DFSVertex;
import amazonprep.datastructures.list.LinkedList;

public class ApproximateVertexCoverTest {
	
	Graph<Character, Vertex<Character>, Edge<Character>> graph;
	DFSVertex<Character> vertexA;
	DFSVertex<Character> vertexB;
	DFSVertex<Character> vertexC;
	DFSVertex<Character> vertexD;
	DFSVertex<Character> vertexE;
	DFSVertex<Character> vertexF;
	DFSVertex<Character> vertexG;
	
	@Before
	public void setup() {
		graph = new Graph<>(); 
		
		vertexA = new DFSVertex<Character>('a');
		vertexB = new DFSVertex<Character>('b');
		vertexC = new DFSVertex<Character>('c');
		vertexD = new DFSVertex<Character>('d');
		vertexE = new DFSVertex<Character>('e');
		vertexF = new DFSVertex<Character>('f');
		vertexG = new DFSVertex<Character>('g');
		
		graph.getEdges().insertData(connectVertices(vertexA, vertexB));
		graph.getEdges().insertData(connectVertices(vertexB, vertexC));
		graph.getEdges().insertData(connectVertices(vertexC, vertexE));
		graph.getEdges().insertData(connectVertices(vertexC, vertexD));
		graph.getEdges().insertData(connectVertices(vertexD, vertexE));
		graph.getEdges().insertData(connectVertices(vertexD, vertexF));
		graph.getEdges().insertData(connectVertices(vertexD, vertexG));
		graph.getEdges().insertData(connectVertices(vertexE, vertexF));
		
		graph.getVertices().insertData(vertexA);
		graph.getVertices().insertData(vertexB);
		graph.getVertices().insertData(vertexC);
		graph.getVertices().insertData(vertexD);
		graph.getVertices().insertData(vertexE);
		graph.getVertices().insertData(vertexF);
	}

	@Test
	public void testGetCoverSimple() {
		graph.getVertices().insertData(vertexG);
		
		ApproximateVertexCover<Character> approximateVertexCover = new ApproximateVertexCover<Character>();
		LinkedList<Vertex<Character>> cover = approximateVertexCover.getCover(graph, new SimpleEdgeSelectionStrategy<Character>());
		
		System.out.println(cover);
	}
	
	@Test
	public void testGetCoverGreedy() {
		graph.getVertices().insertData(vertexG);
		
		ApproximateVertexCover<Character> approximateVertexCover = new ApproximateVertexCover<Character>();
		LinkedList<Vertex<Character>> cover = approximateVertexCover.getCover(graph, new GreedyEdgeSelectionStrategy<Character>());
		
		System.out.println(cover);
	}

	private DFSEdge<Character> connectVertices(DFSVertex<Character> vertex1, DFSVertex<Character> vertex2) {
		DFSEdge<Character> edge = new DFSEdge<Character>(vertex1, vertex2);
		vertex1.getOutgoingEdges().insertData(edge);
		vertex2.getOutgoingEdges().insertData(edge);
		return edge;
	}
}
