package graphs;

import models.Graph;

public class Main {

	public static void main(String[] args) {
		bfs(2, generateGraph());
		System.out.println("\n------------------------------");
		dfs(0, generateDirectedGraph());
	}

	private static Graph generateGraph() {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		return g;
	}

	private static Graph generateDirectedGraph() {
		Graph g = new Graph(12);
		
		g.addEdge(0, 1);
		g.addEdge(0, 9);
		g.addEdge(9, 8);
		g.addEdge(1, 8);
		g.addEdge(8, 7);
		g.addEdge(7, 10);
		g.addEdge(10, 11);
		g.addEdge(11, 7);
		g.addEdge(7, 6);
		g.addEdge(7, 3);
		g.addEdge(6, 5);
		g.addEdge(5, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 2);
		
		return g;
		
	}
	
	private static void bfs(int n, Graph g) {
		System.out.println("Following Breadth First Traversal (starting from vertex n)");
	
		new BreadthFirstSearch().BFS(n, g);
	}
	
	private static void dfs(int n, Graph g) {
		System.out.println("Following Depth First Traversal (starting from vertex n)");

		DepthFirstSearch.DFS(n, g);
	}
	
	
}
