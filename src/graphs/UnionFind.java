package graphs;

public class UnionFind {

	private int[] parent;
	private int[] rank;
	private int n;

	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		this.n = n;
	}

	// Creates n sets with a single item in each
	private void makeSet() {
		for (int i = 0; i < n; i++) {
			// Initially, all elements are in their own set
			parent[i] = i;
		}
	}

	// Returns representative of x's set
	int find(int x) {
		// Finds the representative of the set that x is an element of
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
			// Recursively call find on its parent and move i's node directly under the
			// representative of this set
		}

		return parent[x];
	}
	
	void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) {
			return;
		}
		
		if (rank[xRoot] < rank[yRoot]) {
			parent[xRoot] = yRoot;
		} else if (rank[yRoot] < rank[xRoot]) {
			parent[yRoot] = xRoot;
			
			rank[xRoot] = rank[xRoot] + 1;
		}
	}
}
