package amazonprep.algorithms.graph.mst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import amazonprep.algorithms.graph.Edge;

public class AssertResults {
	public static final void assertResults(Edge<Character> [] edges) {
		List<String> edgeList = new ArrayList<String>();
		for(Edge<Character> edge : edges) {
			edgeList.add(edge.getStart().getData()+" - "+edge.getEnd().getData());
		}
		
		assertEquals(8, edgeList.size());
		assertTrue(assertEdge(edgeList,'g', 'h'));
		assertTrue(assertEdge(edgeList,'f', 'g'));
		assertTrue(assertEdge(edgeList,'c', 'i'));
		assertTrue(assertEdge(edgeList,'f', 'c'));
		assertTrue(assertEdge(edgeList,'b', 'a'));
		assertTrue(assertEdge(edgeList,'d', 'c'));
		assertTrue(assertEdge(edgeList,'c', 'b') && !assertEdge(edgeList,'a', 'h') || assertEdge(edgeList,'a', 'h') && !assertEdge(edgeList,'c', 'b'));
		assertTrue(assertEdge(edgeList,'e', 'd'));
	}
	
	private static final boolean assertEdge(List<String> edgeList, Character char1, Character char2) {
		return edgeList.contains(char1+" - "+char2) && !edgeList.contains(char2+" - "+char1)
				|| edgeList.contains(char2+" - "+char1) && !edgeList.contains(char1+" - "+char2);
	}
}
