package UnionFind;

/**
 * @Number: #323. Number of Connected Components in an Undirected Graph
 * @Descpription: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * @Author: Created by xucheng.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    /**
     * Union Find: the number of roots == the number of connect components)
     */
    private int[] parents;
    private int[] sizes;

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV)
            return false;
        if (sizes[rootV] > sizes[rootU])
            parents[rootU] = rootV;
        else if (sizes[rootV] < sizes[rootU])
            parents[rootV] = rootU;
        else {
            parents[rootV] = rootU;
            sizes[rootU] += 1;
        }
        return true;
    }

    private int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        sizes = new int[n];
        // initialize
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
        // union
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }
        // count the number of roots(= the number of connect components)
        int nums = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i)
                nums++;
        }
        return nums;
    }
}
