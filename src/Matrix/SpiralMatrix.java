package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Number: #54. Spiral Matrix
 * @Descpription: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * #59. Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * @Author: Created by xucheng.
 */
public class SpiralMatrix {
    /**
     * 54
     * simulation
     * time: O(n)
     * space: O(n)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // edge case
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return list;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] seen = new boolean[row][column];
        int[] dirRow = {0, 1, 0, -1};
        int[] dirColumn = {1, 0, -1, 0};
        int r = 0, c = 0, dirI = 0;

        for (int i = 0; i < row * column; i++) {
            list.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dirRow[dirI];
            int cc = c + dirColumn[dirI];

            if (0 <= cr && cr < row && 0 <= cc && cc < column && !seen[cr][cc]) {
                r = cr;
                c = cc;
            }
            // [cr,cc]坐标越界，需要change direction, direction cursor(dirI) + 1
            else {
                dirI = (dirI + 1) % 4;
                r += dirRow[dirI];
                c += dirColumn[dirI];
            }
        }
        return list;
    }

    /**
     * time:  O(m * n)
     * @param matrix
     * @return
     */
//    public List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> list = new ArrayList<>();
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return list;
//
//        int rowStart = 0;
//        int rowEnd = matrix.length - 1;
//        int colStart = 0;
//        int colEnd = matrix[0].length - 1;
//
//        while (rowStart <= rowEnd && colStart <= colEnd) {
//            // 1st row
//            for (int i = colStart; i <= colEnd; i++)
//                list.add(matrix[rowStart][i]);
//
//            rowStart++;
//            for (int i = rowStart; i <= rowEnd; i++)
//                list.add(matrix[i][colEnd]);
//
//            colEnd--;
//            if (rowStart <= rowEnd)
//                for (int i = colEnd; i >= colStart; i--)
//                    list.add(matrix[rowEnd][i]);
//
//            rowEnd--;
//            if (colStart <= colEnd)
//                for (int i = rowEnd; i >= rowStart; i--)
//                    list.add(matrix[i][colStart]);
//
//            colStart++;
//        }
//        return list;
//    }

    /**
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // edge case
        if (n == 0)
            return res;

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++)
                res[rowStart][i] = num++;
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++)
                res[i][colEnd] = num++;
            colEnd--;

            if (rowStart <= rowEnd)
                for (int i = colEnd; i >= colStart; i--)
                    res[rowEnd][i] = num++;
            rowEnd--;

            if (colStart <= colEnd)
                for (int i = rowEnd; i >= rowStart; i--)
                    res[i][colStart] = num++;

            colStart++;
        }
        return res;
    }

}
