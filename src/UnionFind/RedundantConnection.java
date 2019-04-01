package UnionFind;

/**
 * @Number: #684. Redundant Connection
 * @Descpription: In this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
 * The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges.
 * Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes.
 * If there are multiple answers, return the answer that occurs last in the given 2D-array.
 * The answer edge [u, v] should be in the same format, with u < v.
 * @Author: Created by xucheng.
 */
public class RedundantConnection {
    /**
     * DFS
     * time: O(n ^ 2)
     *
     * @param edges
     * @return
     */
//    public int[] findRedundantConnection(int[][] edges) {
//        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0)
//            return new int[0];
//
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int[] edge : edges) {
//            // two ends of one edge
//            int u = edge[0];
//            int v = edge[1];
//            Set<Integer> visited = new HashSet<>();
//
//            // for every edge (u,v) in the graph, try to find whether there is a path from u to v (edge(u,v) excluded))
//            // if so, edge(u,v) with that path could form a circle, which means edge(u,v) is redundant
//            if (hasPath(u, v, graph, visited))
//                return edge;
//            // if not, add neighbors to each end
//            if (!graph.containsKey(u))
//                graph.put(u, new ArrayList<>());
//            graph.get(u).add(v);
//            if (!graph.containsKey(v))
//                graph.put(v, new ArrayList<>());
//            graph.get(v).add(u);
//        }
//        return new int[0];
//    }
//
//    private boolean hasPath(int curr, int goal, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
//        if (curr == goal)
//            return true;
//
//        visited.add(curr);
//        if (!graph.containsKey(curr) || !graph.containsKey(goal))
//            return false;
//        // try to find if there is path between (each neighbor of curr) and the goal
//        for (int neighbor : graph.get(curr)) {
//            if (visited.contains(neighbor))
//                continue;
//            if (hasPath(neighbor, goal, graph, visited))
//                return true;
//        }
//        return false;
//    }


    /**
     * Union Find
     * time: O(log * n)
     *
     * @param
     * @return
     */
    class UnionFindSet {
        private int[] parents;
        private int[] sizes;

        public UnionFindSet(int n) {
            parents = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        /**
         * return the root
         */
        private int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]]; // path compression
                node = parents[node];
            }
            return node;
        }

        private boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            // u and v are already connected, which means a circle is formed
            if (rootU == rootV)
                return false;

            // Union, always merge smaller set to larger set, the size of new one doesn't change
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
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet ufs = new UnionFindSet(edges.length);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!ufs.union(u, v))
                return edge;
        }
        return null;
    }

}
