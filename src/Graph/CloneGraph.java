package Graph;

import java.util.*;

/**
 * @Number: The number of questions
 * @Descpription: Given the head of a graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors.
 * There is an edge between the given node and each of the nodes in its neighbors.
 * @Author: Created by xucheng.
 */
public class CloneGraph {

    // Definition for undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }


    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    /**
     * DFS
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    /**
     * BFS
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null)
            return null;

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            // clone neighbors
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return newNode;
    }
}
