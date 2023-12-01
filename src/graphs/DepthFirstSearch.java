package graphs;

import models.Graph;

public class DepthFirstSearch {

	public static void DFS(int n, Graph g) {
		dfsRecursively(n, g, new boolean[g.getNumberOfVertices()]);
	}
	
	public static void dfsRecursively(int n, Graph g, boolean[] visited) {
		if(visited[n]) {
			System.out.println("Already marked: " + n);
			return;
		}
		
		System.out.println("Has been visited: " + n);
		visited[n] = true;
		
		int[] neighbors = g.getNeighbors(n);
		
		for(int neighbor : neighbors) {
			dfsRecursively(neighbor, g, visited);
		}
	}
}
