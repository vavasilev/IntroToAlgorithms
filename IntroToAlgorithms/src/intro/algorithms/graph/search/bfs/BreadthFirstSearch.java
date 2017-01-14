package amazonprep.algorithms.graph.search.bfs;

import amazonprep.algorithms.graph.Edge;
import amazonprep.algorithms.graph.search.GraphSearchAlgorithm;
import amazonprep.algorithms.graph.search.VertexColor;
import amazonprep.datastructures.queue.Queue;

public class BreadthFirstSearch<T> extends GraphSearchAlgorithm<T> {

	public void bfs(BFSVertex<T> start, int verticesNum) {
		Queue<BFSVertex<T>> queue = new Queue<BFSVertex<T>>(verticesNum);
		start.setColor(VertexColor.GRAY);
		start.setDepth(0);
		queue.enqueue(start);
		
		while(!queue.isEmpty()) {
			BFSVertex<T> vertex = queue.dequeue();
			
			for(Edge<T> edge : vertex.getOutgoingEdges()) {
				BFSVertex<T> adjVertex = (BFSVertex<T>)edge.getEnd();
				if(adjVertex.getColor() == VertexColor.WHITE) {
					adjVertex.setColor(VertexColor.GRAY);
					adjVertex.setDepth(vertex.getDepth() + 1);
					adjVertex.setParent(vertex);
					queue.enqueue(adjVertex);
				}
			}
			vertex.setColor(VertexColor.BLACK);
		}
	}
	
	public String getPath(BFSVertex<T> start, BFSVertex<T> end) {
		StringBuilder sb = new StringBuilder();
		sb.append("Distance: "+end.getDepth()+", Path: ");
		getPathReq(start, end, sb);
		return sb.toString().trim();
	}
}
