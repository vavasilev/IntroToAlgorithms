package intro.algorithms.graph.search.dfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.Graph;
import intro.algorithms.graph.Vertex;

public class DepthFirstSearchTest {

	@Test
	public void test() {
		Graph<Character, Vertex<Character>, Edge<Character>> graph = new Graph<>(); 
		
		DFSVertex<Character> vertexS = new DFSVertex<Character>('s');
		DFSVertex<Character> vertexZ = new DFSVertex<Character>('z');
		DFSVertex<Character> vertexW = new DFSVertex<Character>('w');
		DFSVertex<Character> vertexY = new DFSVertex<Character>('y');
		DFSVertex<Character> vertexX = new DFSVertex<Character>('x');
		DFSVertex<Character> vertexV = new DFSVertex<Character>('v');
		DFSVertex<Character> vertexU = new DFSVertex<Character>('u');
		DFSVertex<Character> vertexT = new DFSVertex<Character>('t');
		
		graph.getEdges().insertData(connectVertices(vertexU, vertexU));
		graph.getEdges().insertData(connectVertices(vertexU, vertexT));
		graph.getEdges().insertData(connectVertices(vertexT, vertexU));
		graph.getEdges().insertData(connectVertices(vertexT, vertexV));
		graph.getEdges().insertData(connectVertices(vertexU, vertexV));
		graph.getEdges().insertData(connectVertices(vertexV, vertexW));
		graph.getEdges().insertData(connectVertices(vertexV, vertexS));
		graph.getEdges().insertData(connectVertices(vertexX, vertexZ));
		graph.getEdges().insertData(connectVertices(vertexY, vertexX));
		graph.getEdges().insertData(connectVertices(vertexW, vertexX));
		graph.getEdges().insertData(connectVertices(vertexZ, vertexW));
		graph.getEdges().insertData(connectVertices(vertexZ, vertexY));
		graph.getEdges().insertData(connectVertices(vertexS, vertexW));
		graph.getEdges().insertData(connectVertices(vertexS, vertexZ));
		
		graph.getVertices().insertData(vertexU);
		graph.getVertices().insertData(vertexV);
		graph.getVertices().insertData(vertexT);
		graph.getVertices().insertData(vertexX);
		graph.getVertices().insertData(vertexY);
		graph.getVertices().insertData(vertexW);
		graph.getVertices().insertData(vertexZ);
		graph.getVertices().insertData(vertexS);
		
		DepthFirstSearch<Character> dfs = new DepthFirstSearch<Character>();
		dfs.dfs(graph);
		
		assertEquals("Path: s z y x", dfs.getPath(vertexS, vertexX));
		assertEquals("Path: z y x", dfs.getPath(vertexZ, vertexX));
		assertEquals("Path: s z w", dfs.getPath(vertexS, vertexW));
		assertEquals("Path: t v", dfs.getPath(vertexT, vertexV));
		assertEquals("Path: t u", dfs.getPath(vertexT, vertexU));
		
		for(Edge<Character> edge : graph.getEdges()) {
			DFSEdge<Character> dfsEdge = (DFSEdge<Character>)edge;
			System.out.println("Edge("+dfsEdge.getStart().getData().toString()+","+dfsEdge.getEnd().getData().toString()+"): "+dfsEdge.getEdgeType());
		}
		
		for(Vertex<Character> vertex : graph.getVertices()) {
			DFSVertex<Character> dfsVertex = (DFSVertex<Character>)vertex;
			System.out.println("Vertex("+dfsVertex.getData().toString()+"): "+dfsVertex.getStart()+"/"+dfsVertex.getEnd());
		}
	}

	private DFSEdge<Character> connectVertices(DFSVertex<Character> vertex1, DFSVertex<Character> vertex2) {
		DFSEdge<Character> edge = new DFSEdge<Character>(vertex1, vertex2);
		vertex1.getOutgoingEdges().insertData(edge);
		return edge;
	}
}
