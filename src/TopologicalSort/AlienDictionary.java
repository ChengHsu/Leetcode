package TopologicalSort;

import java.util.*;

/**
 * @Number: #269. Alien Dictionary
 * @Descpription: There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * @Author: Created by xucheng.
 */
public class AlienDictionary {
    /**
     * time: O(n+e)
     * https://zhuhan0.blogspot.com/2017/06/leetcode-269-alien-dictionary.html
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);

        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    // initialize the Adjancency List
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }
        // create InDegree list and Adjancency List
        for (int i = 1; i < words.length; i++) {
            String curr = words[i - 1];
            String next = words[i];
            int length = Math.min(curr.length(), next.length());
            // find the first pair of chars that r different
            // add an edge u -> v
            // add in-degree of v by 1
            for (int j = 0; j < length; j++) {
                char u = curr.charAt(j);
                char v = next.charAt(j);
                if (u != v) {
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        inDegree[v - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        // initialize: put all points whose in-degree = 0
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        // delete points while decreasing the in-degree of other points that connected to it
        // check if the in-degree of these points = 0, if so, add them to queue
        // repeat til queue is empty
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }
}
