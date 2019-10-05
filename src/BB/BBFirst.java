package BB;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Number: The number of questions
 * @Descpription: Describe the function of class
 * @Author: Created by xucheng.
 */
public class BBFirst {
    // Only works if the size of input is fixed
    public static int buildingsFacingSun(int[] heights) {
        int maxHeight = heights[heights.length - 1];
        List<Integer> res = new ArrayList<>();
        res.add(maxHeight);
        for(int i = heights.length - 1; i >= 0; i--) {
            if(heights[i] > maxHeight) {
                maxHeight = heights[i];
                res.add(heights[i]);

            }
        }
        for(int i = 0; i < res.size(); i++)
            System.out.println(res.get(i));
        return res.size();
    }


    // If input is from data stream, this aglo works
    public static int buildingsFacingSunDataStream(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            if(!st.isEmpty() && st.peek() <= heights[i])
                st.pop();
            st.push(heights[i]);
        }

        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
            System.out.println("height: " + res[i]);
        }

        return res.length;
    }


    private static int sizeOfIsland(int[][] grid, int rowIdx, int colIdx) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, visited, rowIdx, colIdx);
    }

    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int dfs(int[][] grid, boolean[][] visited, int rowIdx, int colIdx) {
        if(rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length || visited[rowIdx][colIdx] || grid[rowIdx][colIdx] != 1)
            return 0;

        visited[rowIdx][colIdx] = true;
        int size = 1;
        for(int[] dir: dirs) {
            int nRowIdx = rowIdx + dir[0];
            int nColIdx = colIdx + dir[1];
            size += dfs(grid, visited, nRowIdx, nColIdx);
        }
        return size;
    }


    private static int sizeOfIsland2(int[][] grid, int rowIdx, int colIdx) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;
        return dfsNoSpace(grid, rowIdx, colIdx);
    }


    private static int dfsNoSpace(int[][] grid, int rowIdx, int colIdx) {
        if(rowIdx < 0 || rowIdx >= grid.length || colIdx < 0 || colIdx >= grid[0].length || grid[rowIdx][colIdx] != 1)
            return 0;

        grid[rowIdx][colIdx] = -1;
        int size = 1;
        for(int[] dir: dirs) {
            int nRowIdx = rowIdx + dir[0];
            int nColIdx = colIdx + dir[1];
            size += dfsNoSpace(grid, nRowIdx, nColIdx);
        }
        return size;
    }


    public static boolean isPalindrome(int x, int base) {
        // if(x < 0) return false;
        if(x != 0 && x % base == 0) return false;

        int reversedX = 0;
        while(reversedX < x) {
            reversedX  = reversedX * base + x % base;
            x /= base;
        }
        return reversedX == x || (reversedX / base) == x;
    }

    private static void generatePalindromeLessThanN(int N) {
        if(N < 0) return;
        for(int i = 0; i <= N; i++) {
            if(isPalindrome(i, 10) && isPalindrome(i, 8))
                System.out.println(i);
        }
    }




}
