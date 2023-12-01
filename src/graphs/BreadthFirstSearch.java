package graphs;

import java.util.LinkedList;
import models.Graph;

/**
 * The Breadth First Search (BFS) algorithm is used to search a graph data
 * structure for a node that meets a set of criteria. It starts at the root of
 * the graph and visits all nodes at the current depth level before moving on to
 * the nodes at the next depth level. In a nutshell, it finds all the nodes and
 * traverses them.
 * 
 * Time complexity: O(V + E)
 * 
 * Tutorial: https://www.youtube.com/watch?v=oDqjPvD54Ss
 **/
public class BreadthFirstSearch {

	public void BFS(int startVertex, Graph graph) {
		int numberOfVertices = graph.getNumberOfVertices();
		boolean[] visited = new boolean[numberOfVertices];

		LinkedList<Integer> queue = new LinkedList<>();
		visited[startVertex] = true;
		queue.add(startVertex);

		while (!queue.isEmpty()) {
			// Retrieves and removes the head (first element) of this list.
			int currentVertex = queue.pollFirst();
			System.out.print(currentVertex + " ");

			for (int neighbor : graph.getAdjacencyLists()[currentVertex]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
}
