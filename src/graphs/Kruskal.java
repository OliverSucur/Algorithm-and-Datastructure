package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kruskal {
    public class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public List<Edge> kruskal(int[] source, int[] dest, int[] weight, int n, int m) {
        Edge[] edges = new Edge[m];

        for(int i = 0; i < m; i++) {
            E[i] = new Edge(source[i], dest[i], weight[i]);
        }

        Arrays.sort(edges);

        
    }
}