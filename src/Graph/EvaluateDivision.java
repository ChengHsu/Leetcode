package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Number: #399. Evaluate Division
 * @Descpription: Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * @Author: Created by xucheng.
 */
public class EvaluateDivision {
    /**
     * DFS:
     * 1. create graph : g[a][b] = k, g[b][a] = 1.0 / k
     * 2. dfs: if query a / c
     * for every neighbor of a, eg.b: (a / b is known)
     * do dfs: if d = b / c exists, a / c = a / b * d
     * time: O(e + q * e)
     * space: O(e)
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // 1. create graph
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            Double k = values[i];
            if (!graph.containsKey(a))
                graph.put(a, new HashMap<>());
            graph.get(a).put(b, k);
            if (!graph.containsKey(b))
                graph.put(b, new HashMap<>());
            graph.get(b).put(a, 1.0 / k);
        }

        double[] results = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            if (!graph.containsKey(a) || !graph.containsKey(b))
                results[i] = -1.0;
            else
                results[i] = divide(a, b, new HashSet<>());
        }
        return results;
    }

    private double divide(String a, String b, HashSet<String> visited) {
        if (a.equals(b))
            return 1.0;

        visited.add(a);
        if (!graph.containsKey(a))
            return -1.0;
        for (String neighbor : graph.get(a).keySet()) {
            if (visited.contains(neighbor))
                continue;
            visited.add(neighbor);
            double d = divide(neighbor, b, visited);
            if (d > 0)
                return graph.get(a).get(neighbor) * d;
        }
        return -1.0;
    }
}
