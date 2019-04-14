package InterviewPrep.MSSuzhou;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class MinimumOilCost {
    /**
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + oil[i][j]
     *
     * @param oil
     * @return
     */
    public int minOilCost(int[][] oil) {
        if (oil == null || oil.length == 0 || oil[0] == null || oil[0].length == 0)
            return 0;

        int[][] dp = new int[oil.length][oil[0].length];
        dp[0][0] = oil[0][0];

        // first column
        for (int i = 1; i < oil.length; i++) {
            dp[i][0] = dp[i - 1][0] + oil[i][0];
        }

        // first row
        for (int i = 1; i < oil[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + oil[0][i];
        }

        // general
        for (int i = 1; i < oil.length; i++) {
            for (int j = 1; j < oil[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + oil[i][j];
            }
        }

        int[] minPath = findMinPath(oil, dp);
        for (int i = 0; i < minPath.length; i++) {
            if (i == minPath.length - 1)
                System.out.println(minPath[i]);
            else
                System.out.print(minPath[i] + "->");
        }
        // return min oil cost
        return dp[oil.length - 1][oil[0].length - 1];
    }


    public int[] findMinPath(int[][] oil, int[][] dp) {
        int len = oil.length + oil[0].length - 1;
        int[] minPath = new int[len];
        int x = oil.length - 1;
        int y = oil[0].length - 1;


        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1)
                minPath[i] = oil[x][y];
            else {
                int tmp = dp[x][y] - oil[x][y];

                if (x - 1 >= 0 && tmp == dp[x - 1][y]) {
                    minPath[i] = oil[x - 1][y];
                    x--;
                } else if (y - 1 >= 0 && tmp == dp[x][y - 1]) {
                    minPath[i] = oil[x][y - 1];
                    y--;
                }
            }

        }
        return minPath;
    }


    public static void main(String[] args) {
        int[][] oil = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        MinimumOilCost minimumOilCost = new MinimumOilCost();
        System.out.println("min cost:" + minimumOilCost.minOilCost(oil));
    }
}
