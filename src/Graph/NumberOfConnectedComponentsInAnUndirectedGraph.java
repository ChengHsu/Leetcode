package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Number: #323. Number of Connected Components in an Undirected Graph
 * @Descpription: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * @Author: Created by xucheng.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {

    /**
     * DFS
     * time: O(E + n)
     * space: O(E + n)
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents_dfs(int n, int[][] edges) {
        if (n <= 1)
            return n;
        // build adjancency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        // if node i is visited, visited[i] = true
        boolean[] visited = new boolean[n];
        int count = 0;
        // iterate every node and its neighbour, compute the # of connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        // mark current node as visited
        visited[index] = true;
        // visit all of its neighbours
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }


    /**
     * BFS
     * time: O(E + n) where E is # of edges and n is # of nodes
     * space: O(E + n). E for extra space used to represent the graph. n for BFS(in the worst case: all nodes are connected)
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents_bfs(int n, int[][] edges) {
        if (n <= 1)
            return n;

        // build adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    for (int next : adjList.get(index)) {
                        if (!visited[next]) {
                            // mark the node as visited here rather than when it's poped
                            // to avoid adding a node duplicate times
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return count;
    }


}
