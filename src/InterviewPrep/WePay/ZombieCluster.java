package InterviewPrep.WePay;

/**
 * @Number: The number of questions
 * @Descpription: Zombiism is transitive.
 * if 0 knows 1 and 1 knows 2 then 0 knows 2. A zombie cluster is a group of zombies who are
 * directly or indirectly linked through other zombies they know.
 * Given the matrix of connectedness, determine the number of clusters
 * 1 1 0
 * 1 1 0
 * 0 0 1
 * @Author: Created by xucheng.
 */
public class ZombieCluster {

    /**
     * DFS
     * time: O(m * n) where m = M.length && n = M[0].length()
     * space: O(m * n)
     * @param M
     * @return
     */
    public int zombieCluster_dfs(String[] M) {
        if (M == null || M.length == 0)
            return 0;
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, M);
                count++;
            }
        }
        return count;
    }

    private void dfs(int index, boolean[] visited, String[] M) {
        visited[index] = true;
        for (int i = 0; i < M[index].length(); i++) {
            if (M[index].charAt(i) == '1' && !visited[i]) {
                dfs(i, visited, M);
            }
        }
    }
}
