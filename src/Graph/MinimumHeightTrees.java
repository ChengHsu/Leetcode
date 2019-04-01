package Graph;

import java.util.*;

/**
 * @Number: #310. Minimum Height Trees
 * @Descpription: For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * @Author: Created by xucheng.
 */
public class MinimumHeightTrees {
    /**
     * BFS
     * time: O(n)
     * space: O(n)
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0)
            return res;
        if (n == 1) {
            res.add(0);
            return res;
        }

        List<Set<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adjList.add(new HashSet<>());

        // create adjacency list : add edges
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // get initial leaves list
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (adjList.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            // remove leaves level by level, what's left eventually are the roots
            for (int leave : leaves) {
                int adj = adjList.get(leave).iterator().next();
                adjList.get(adj).remove(leave);
                if (adjList.get(adj).size() == 1)
                    newLeaves.add(adj);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
