package DFSAndBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Number: #51. N-Queens
 * @Descpription: The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * #52. N-Queens II
 * 任两个皇后都不能处于同一条横行、纵行或斜线上
 * @Author: Created by xucheng.
 */
public class NQueens {
    /**
     * 51
     * from left up tp right bottom: 16 diagonals in total, same with from right up tp left bottom
     */
    List<List<String>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        //2*n-1个斜对角线
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];

        fun(n, new ArrayList<String>(), cols, dia1, dia2, 0);

        return solutions;
    }

    private void fun(int n, List<String> solution, boolean[] cols, boolean[] dia1, boolean[] dia2, int rowIndex) {
        // find one solution, return
        if (rowIndex == n) {
            solutions.add(new ArrayList<String>(solution));
            return;
        }

        // try to put 'Q' on each point on the current row
        for (int i = 0; i < n; i++) {
            //剪枝：这一行、正对角线、反对角线都不能再放了，如果发现是true，停止本次循环
            if (cols[i] || dia1[rowIndex + i] || dia2[rowIndex - i + n - 1])
                continue;

            //init一个长度为n的一维数组，里面初始化为'.'
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');

            charArray[i] = 'Q';
            String stringArray = new String(charArray);
            solution.add(stringArray);
            cols[i] = true;
            dia1[rowIndex + i] = true;
            dia2[rowIndex - i + n - 1] = true;

            fun(n, solution, cols, dia1, dia2, rowIndex + 1);

            //reset 不影响回溯的下个目标 backtracking
            solution.remove(solution.size() - 1);
            charArray[i] = '.';
            cols[i] = false;
            dia1[rowIndex + i] = false;
            dia2[rowIndex - i + n - 1] = false;
        }
    }


    /**
     * 52
     *
     * @param n
     * @return
     */
    int nums = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        //2*n-1个斜对角线
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];

        fun2(n, cols, dia1, dia2, 0);

        return nums;
    }

    private void fun2(int n, boolean[] cols, boolean[] dia1, boolean[] dia2, int rowIndex) {
        // find one solution, return
        if (rowIndex == n) {
            nums++;
            return;
        }

        // try to put 'Q' on each point on the current row
        for (int i = 0; i < n; i++) {
            //剪枝：这一行、正对角线、反对角线都不能再放了，如果发现是true，停止本次循环
            if (cols[i] || dia1[rowIndex + i] || dia2[rowIndex - i + n - 1])
                continue;

            cols[i] = true;
            dia1[rowIndex + i] = true;
            dia2[rowIndex - i + n - 1] = true;

            fun2(n, cols, dia1, dia2, rowIndex + 1);

            //reset 不影响回溯的下个目标 backtracking
            cols[i] = false;
            dia1[rowIndex + i] = false;
            dia2[rowIndex - i + n - 1] = false;
        }
    }
}

