package amazonprep.algorithms.graph.search.dfs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.Graph;
import amazonprep.algorithms.graph.Vertex;
import amazonprep.datastructures.list.LinkedList;

public class StronglyConnectedComponentsTest {

	@Test
	public void testOrder1() {
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
		
		StronglyConnectedComponents<Character> stronglyConnectedComponents = new StronglyConnectedComponents<Character>();
		LinkedList<LinkedList<Vertex<Character>>> sccs = stronglyConnectedComponents.findStronglyConnectedComponents(graph);
		
		assertEquals("(z x w y )(s )(v )(t u )", getSccsAsString(sccs));
	}
	
	@Test
	public void testOrder2() {
		Graph<Character, Vertex<Character>, Edge<Character>> graph = new Graph<>(); 
		
		DFSVertex<Character> vertexS = new DFSVertex<Character>('s');
		DFSVertex<Character> vertexZ = new DFSVertex<Character>('z');
		DFSVertex<Character> vertexW = new DFSVertex<Character>('w');
		DFSVertex<Character> vertexY = new DFSVertex<Character>('y');
		DFSVertex<Character> vertexX = new DFSVertex<Character>('x');
		DFSVertex<Character> vertexV = new DFSVertex<Character>('v');
		DFSVertex<Character> vertexU = new DFSVertex<Character>('u');
		DFSVertex<Character> vertexT = new DFSVertex<Character>('t');
		
		graph.getEdges().insertData(connectVertices(vertexY, vertexX));
		graph.getEdges().insertData(connectVertices(vertexW, vertexX));
		graph.getEdges().insertData(connectVertices(vertexZ, vertexW));
		graph.getEdges().insertData(connectVertices(vertexZ, vertexY));
		graph.getEdges().insertData(connectVertices(vertexS, vertexW));
		graph.getEdges().insertData(connectVertices(vertexS, vertexZ));
		graph.getEdges().insertData(connectVertices(vertexU, vertexU));
		graph.getEdges().insertData(connectVertices(vertexU, vertexT));
		graph.getEdges().insertData(connectVertices(vertexT, vertexU));
		graph.getEdges().insertData(connectVertices(vertexT, vertexV));
		graph.getEdges().insertData(connectVertices(vertexU, vertexV));
		graph.getEdges().insertData(connectVertices(vertexV, vertexW));
		graph.getEdges().insertData(connectVertices(vertexV, vertexS));
		graph.getEdges().insertData(connectVertices(vertexX, vertexZ));
		
		graph.getVertices().insertData(vertexX);
		graph.getVertices().insertData(vertexY);
		graph.getVertices().insertData(vertexW);
		graph.getVertices().insertData(vertexZ);
		graph.getVertices().insertData(vertexS);
		
		graph.getVertices().insertData(vertexU);
		graph.getVertices().insertData(vertexV);
		graph.getVertices().insertData(vertexT);
		
		StronglyConnectedComponents<Character> stronglyConnectedComponents = new StronglyConnectedComponents<Character>();
		LinkedList<LinkedList<Vertex<Character>>> sccs = stronglyConnectedComponents.findStronglyConnectedComponents(graph);
		
		assertEquals("(z x w y )(s )(v )(t u )", getSccsAsString(sccs));
	}
	
	private String getSccsAsString(LinkedList<LinkedList<Vertex<Character>>> sccs) {
		StringBuilder sb = new StringBuilder();
		
		for(LinkedList<Vertex<Character>> scc : sccs) {
			sb.append("(");
			for(Vertex<Character> vertex : scc) {
				sb.append(vertex.getData().toString()+" ");
			}
			sb.append(")");
		}
		return sb.toString();
	}

	private DFSEdge<Character> connectVertices(DFSVertex<Character> vertex1, DFSVertex<Character> vertex2) {
		DFSEdge<Character> edge = new DFSEdge<Character>(vertex1, vertex2);
		vertex1.getOutgoingEdges().insertData(edge);
		return edge;
	}
}
