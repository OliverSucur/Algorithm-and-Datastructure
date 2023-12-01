package exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise10point2 {

	static int time;

	public static void main(String[] args) {
		boolean[] visited = new boolean[9];

		int[] pre = new int[9];
		int[] post = new int[9];

		dfs(visited, 0, getGraph(), pre, post);

		for (int i = 0; i < 8; i++) {
			System.out.println("Node " + i + " has as Pre: " + pre[i] + " and as Post: " + post[i]);
		}
	}

	public static List<List<Integer>> getGraph() {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			graph.add(new LinkedList<Integer>());
		}

		graph.get(0).add(2);
		graph.get(0).add(5);
		graph.get(0).add(6);
		graph.get(1).add(0);
		graph.get(2).add(3);
		graph.get(2).add(4);
		graph.get(2).add(6);
		graph.get(2).add(7);
		graph.get(3).add(4);
		graph.get(4).add(1);
		graph.get(6).add(1);
		graph.get(6).add(7);
		graph.get(7).add(1);
		graph.get(7).add(4);
		graph.get(8).add(1);
		graph.get(8).add(2);
		graph.get(8).add(6);

		return graph;
	}

	public static void dfs(boolean visited[], int v, List<List<Integer>> graph, int[] pre, int[] post) {
		if (visited[v])
			return;

		pre[v] = time++;

		visited[v] = true;
		System.out.println("Visited: " + v);

		for (int u : graph.get(v)) {
			dfs(visited, u, graph, pre, post);
		}

		post[v] = time++;
	}
}
