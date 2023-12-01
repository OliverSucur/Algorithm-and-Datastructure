package models;

import java.util.LinkedList;

public class Graph {

	private int v;
	
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public int getNumberOfVertices() {
		return v;
	}
	
	public LinkedList<Integer>[] getAdjacencyLists() {
		return adj;
	}

	public int[] getNeighbors(int n) {
		int[] neighbors = new int[adj[n].size()];
		
		for(int i = 0; i < adj[n].size(); i++) {
			neighbors[i] = adj[n].get(i);
		}
		
		return neighbors;
	}
}
