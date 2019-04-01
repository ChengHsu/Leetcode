package UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #261. Graph Valid Tree
 * @Descpription: Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * @Author: Created by xucheng.
 */
public class GraphValidTree {

    /**
     * Union Find
     */
    class UnionFindSet {
        private int[] parents;
        private int[] sizes;

        public UnionFindSet(int n) {
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU == rootV)
                return false;

            // merge small tree to large one
            if (sizes[rootV] < sizes[rootU])
                parents[rootV] = rootU;
            else if (sizes[rootV] > sizes[rootU])
                parents[rootU] = rootV;
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
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFindSet ufs = new UnionFindSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!ufs.union(u, v)) {
                return false;
            }
        }
        // check if the graph is a forest(at least 2 connected components)
        return (edges.length == n - 1) ? true: false;
    }
}
