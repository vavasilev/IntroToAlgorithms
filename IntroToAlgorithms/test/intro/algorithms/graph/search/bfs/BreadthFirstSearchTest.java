package intro.algorithms.graph.search.bfs;

import static org.junit.Assert.*;

import org.junit.Test;

import intro.algorithms.graph.Edge;
import intro.algorithms.graph.search.bfs.BFSVertex;
import intro.algorithms.graph.search.bfs.BreadthFirstSearch;

public class BreadthFirstSearchTest {

	@Test
	public void test() {
		BFSVertex<Character> vertexS = new BFSVertex<Character>('s');
		BFSVertex<Character> vertexR = new BFSVertex<Character>('r');
		connectVertices(vertexS, vertexR);
		
		BFSVertex<Character> vertexV = new BFSVertex<Character>('v');
		connectVertices(vertexR, vertexV);
		
		BFSVertex<Character> vertexW = new BFSVertex<Character>('w');
		connectVertices(vertexS, vertexW);
		
		BFSVertex<Character> vertexX = new BFSVertex<Character>('x');
		connectVertices(vertexW, vertexX);
		
		BFSVertex<Character> vertexT = new BFSVertex<Character>('t');
		connectVertices(vertexW, vertexT);
		connectVertices(vertexT, vertexX);
		
		BFSVertex<Character> vertexU = new BFSVertex<Character>('u');
		connectVertices(vertexU, vertexT);
		connectVertices(vertexX, vertexU);
		
		BFSVertex<Character> vertexY = new BFSVertex<Character>('y');
		connectVertices(vertexU, vertexY);
		connectVertices(vertexX, vertexY);
		
		BreadthFirstSearch<Character> bfs = new BreadthFirstSearch<Character>();
		bfs.bfs(vertexS, 8);
		assertEquals("Distance: 0, Path: s", bfs.getPath(vertexS, vertexS));
		assertEquals("Distance: 1, Path: s r", bfs.getPath(vertexS, vertexR));
		assertEquals("Distance: 2, Path: s r v", bfs.getPath(vertexS, vertexV));
		assertEquals("Distance: 1, Path: s w", bfs.getPath(vertexS, vertexW));
		assertEquals("Distance: 2, Path: s w t", bfs.getPath(vertexS, vertexT));
		assertEquals("Distance: 2, Path: s w x", bfs.getPath(vertexS, vertexX));
		assertEquals("Distance: 3, Path: s w t u", bfs.getPath(vertexS, vertexU));
		assertEquals("Distance: 3, Path: s w x y", bfs.getPath(vertexS, vertexY));
		
	}

	private void connectVertices(BFSVertex<Character> vertex1, BFSVertex<Character> vertex2) {
		Edge<Character> edge1 = new Edge<Character>(vertex1, vertex2);
		Edge<Character> edge2 = new Edge<Character>(vertex2, vertex1);
		vertex1.getOutgoingEdges().insertData(edge1);
		vertex2.getOutgoingEdges().insertData(edge2);
	}
}
