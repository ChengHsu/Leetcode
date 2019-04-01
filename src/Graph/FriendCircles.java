package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Number: #547. Friend Circles
 * @Descpription: There are N students in a class.
 * Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 * @Author: Created by xucheng.
 */
public class FriendCircles {
    /**
     * Own version
     * DFS
     * finding the number of connected components in an undirected graph
     * time: O(n ^ 2 + n)
     *
     * @param M
     * @return
     */
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return 0;

        // create adjancency list
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    if (!adj.containsKey(i))
                        adj.put(i, new ArrayList<>());
                    adj.get(i).add(j);
                    if (!adj.containsKey(j))
                        adj.put(j, new ArrayList<>());
                    adj.get(j).add(i);
                }
            }
        }

        int[][] visited = new int[M.length][M[0].length];
        int num = 0;
        // dfs
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1 && visited[i][j] != 1) {
                    dfs(M, i, j, visited);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(int[][] M, int i, int j, int[][] visited) {
        if (visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        visited[j][i] = 1;
        for (int neighbor : adj.get(j)) {
            dfs(M, j, neighbor, visited);
        }
    }


    /**
     * DFS:
     * Adjacency matrix is symmetric, so visit i-th row = visit i-th column
     * time: O(n^2)
     * space: O(n)
     * @param M
     * @return
     */
//    public int findCircleNum(int[][] M) {
//        if (M.length == 0 || M[0].length == 0)
//            return 0;
//
//        int[] visited = new int[M.length];
//        int num = 0;
//        for (int i = 0; i < M.length; i++) {
//            if (visited[i] == 0) {
//                dfs(M, visited, i);
//                num++;
//            }
//        }
//        return num;
//    }
//
//    private void dfs(int[][] M, int[] visited, int i) {
//        for (int j = 0; j < M[0].length; j++) {
//            if (M[i][j] == 1 && visited[j] == 0) {
//                visited[j] = 1;
//                dfs(M, visited, j);
//            }
//        }
//    }
}
