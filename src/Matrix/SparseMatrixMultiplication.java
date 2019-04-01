package Matrix;

/**
 * @Number: #311. Sparse Matrix Multiplication
 * @Descpription: Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * @Author: Created by xucheng.
 */
public class SparseMatrixMultiplication {
    /**
     * naive
     * @param A
     * @param B
     * @return
     */
//    public int[][] multiply(int[][] A, int[][] B) {
//        int[][] res = new int[A.length][B[0].length];
//        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
//            return res;
//
//        int ARowLen = A.length;
//        int AColLen = A[0].length;
//        int BColLen = B[0].length;
//
//        for (int aRow = 0; aRow < ARowLen; aRow++) {
//            for (int bCol = 0; bCol < BColLen; bCol++) {
//                int sum = 0;
//                int aCol = 0;
//               // aCol == bRow
//                while (aCol < AColLen ) {
//                    if (A[aRow][aCol] != 0 && B[aCol][bCol] != 0)
//                        sum += A[aRow][aCol] * B[aCol][bCol];
//                    aCol++;
//                }
//                res[aRow][bCol] = sum;
//            }
//        }
//        return res;
//    }


    /**
     * faster
     * https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76151/54ms-Detailed-Summary-of-Easiest-JAVA-solutions-Beating-99.9
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0)
            return res;

        int ARowLen = A.length;
        int AColLen = A[0].length;
        int BColLen = B[0].length;

        for (int aRow = 0; aRow < ARowLen; aRow++) {
            for (int aCol = 0; aCol < AColLen; aCol++) {
                int bCol = 0;
                // skip one loop if == 0
                if (A[aRow][aCol] != 0)
                    while (bCol < BColLen ) {
                        if (B[aCol][bCol] != 0)
                            res[aRow][bCol] += A[aRow][aCol] * B[aCol][bCol];
                        bCol++;
                    }

            }
        }
        return res;
    }
}
