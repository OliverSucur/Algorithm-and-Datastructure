package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

	public int[] dijkstra(ArrayList<ArrayList<Edge>> G, int n, int start) {
		
		// Store predecessors of nodes
		int[] P = new int[n];
		
		// Store distance from start to nodes
		int[] D = new int[n];
		
		for(int i = 0; i < n; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		D[start] = 0;
		
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(start, 0));
		
		while(!priorityQueue.isEmpty()) {
			// Fetch and remove the first element of the queue
			Node u = priorityQueue.poll();
			
			if (D[u.key] < u.dist) {
				continue;
			}
			
			for(Edge edge : G.get(u.key)) {
				int v = edge.to;
				int d = D[u.key] + edge.weight;
				
				if (d < D[v]) {
					D[v] = d;
					P[v] = u.key;
					
					priorityQueue.add(new Node(v, D[v]));
				}
			}
		}
		
		return D;
	}
}

class Node {
	int key;
	int dist;
	
	public Node(int key, int dist) {
		this.key = key;
		this.dist = dist;
	}
}

class Edge {
	int from;
	int to; 
	int weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}