package Clutter;

import java.util.*;

/**
 * Link: https://leetcode.com/discuss/interview-question/299983/clutter-oa-2019-travel-between-cities
 * @Number: The number of questions
 * @Descpription:
 * You need to travel between cities, but some roads may have been blocked by a recent storm.
 * You want to check before you travel to make sure you avoid them. Given a map of the cities and their bidirectional roads,
 * determine which roads are along any shortest path so you can check that they are not blocked.
 * The roads or edges are named using their 1-based index within the input arrays.
 * For example, given a map of g_nodes = 5 nodes, the starting nodes, ending nodes and road lengths are:

    Road from/to/weight
    1 (1, 2, 1)
    2 (2, 3, 1)
    3 (3, 4, 1)
    4 (4, 5, 1)
    5 (5, 1, 3)
    6 (1, 3, 2)
    7 (5, 3, 1)

    You always need to go from node 1 to node g_nodes, so from node 1 to node 5 in this case. The shortest path is 3, and there are three paths of that length: 1 → 5, 1 → 2 → 3 → 5, and 1 → 3 → 5. We create an array of strings, one for each road in order, where the value is YES if a road is along a shortest path or NO if it is not.
    In this case, the resulting array is [YES, YES, NO, NO, YES, YES, YES].

    Function Description

    Complete the function classifyEdges in the editor below. The function must return an array of g_edges strings where the value at ith index is YES if the ith edge is a part of a shortest path from vertex 1 to vertex g_nodes. Otherwise it should contain NO.
    classifyEdges has the following parameter(s):

    g_nodes: an integer, the number of nodes
    g_from[g_from[1],...g_from[g_nodes]]: an array of integers, the start g_nodes for each road
    g_to[to[1],...g_to[g_nodes]]: an array of integers, the end g_nodes for each road
    g_weight[g_weight[1],...g_weight[g_nodes]]: an array of integers, the lengths of each road
    Constraints

    2 ≤ g_nodes ≤ 3000
    1 ≤ g_edges ≤ min(105, (g_nodes x g_nodes - 1)/2)
    1 ≤ g_weight[i] ≤ 105
    1 ≤ g_from[i], g_to[i] ≤ g_nodes
    There is at most one edge between any pair of g_nodes
    The given graph is connected

    Sample Input 1
    4 5
    1 2 1
    2 4 1
    1 3 1
    3 4 2
    1 4 2

    Sample Output 1
    YES
    YES
    NO
    NO
    YES

    Sample Input 2
    5 7
    1 2 1
    2 3 1
    3 5 1
    1 4 1
    4 5 2
    3 4 2
    2 4 4

    Sample Output 2
    YES
    YES
    YES
    YES
    YES
    NO
    NO

    Sample Input 3
    4 5
    1 2 1
    1 3 1
    1 4 1
    2 3 1
    2 4 1

    Sample Output 3
    NO
    NO
    YES
    NO
    NO
 * @Author: Created by xucheng.
 */

public class TravelBetweenCities {
    private static final int INF = 1_000_000;

    public boolean[] classifyEdges(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        Set<Integer>[] cameFrom = shortestPath(n, graph, edges); // set of edge indices
        boolean[] result = new boolean[edges.length];
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(n));
        while (!q.isEmpty()) {
            for (int i : cameFrom[q.poll()]) {
                result[i] = true;
                q.add(edges[i][0]);
            }
        }
        return result;
    }

    private Set<Integer>[] shortestPath(int n, List<Integer>[] graph, int[][] edges) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        Set<Integer>[] cameFrom = new Set[n + 1]; // nodes are 1 based
        Arrays.setAll(cameFrom, (i) -> new HashSet<>());

        int[] costSoFar = new int[n + 1];
        Arrays.fill(costSoFar, 2, n + 1, INF);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int from = curr.id;
            for (int idx : graph[from]) {
                int[] edge = edges[idx];
                int to = edge[1];
                int newCost = costSoFar[from] + edge[2];
                if (newCost <= costSoFar[to]) {
                    costSoFar[to] = newCost;
                    cameFrom[to].add(idx);
                    if (!visited[to]) {
                        visited[to] = true;
                        pq.add(new Node(to, newCost));
                    }
                }
            }
        }
        return cameFrom;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, (i) -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(i);
        }
        return graph;
    }

    private static class Node implements Comparable<Node> {
        int id, cost;
        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        public int compareTo(Node that) {
            return Integer.compare(this.cost, that.cost);
        }
    }

    public static void main(String[] args) {
        test(4,
                new int[][] {{1, 2, 1}, {2, 4, 1}, {1, 3, 1}, {3, 4, 2}, {1, 4, 2}},
                new boolean[] {true, true, false, false, true});
        test(5,
                new int[][] {{1, 2, 1}, {2, 3, 1}, {3, 5, 1}, {1, 4, 1}, {4, 5, 2}, {3, 4, 2}, {2, 4, 4}},
                new boolean[] {true, true, true, true, true, false, false});
        test(4,
                new int[][] {{1, 2, 1}, {1, 3, 1}, {1, 4, 1}, {2, 3, 1}, {2, 4, 1}},
                new boolean[] {false, false, true, false, false});
    }

    private static void test(int n, int[][] edges, boolean[] expected) {
        TravelBetweenCities t = new TravelBetweenCities();
        boolean[] actual = t.classifyEdges(n, edges);
        if (Arrays.equals(actual, expected)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("Failed! Expected: " + Arrays.toString(expected) + ", but actual: " + Arrays.toString(actual));
        }
    }
}
